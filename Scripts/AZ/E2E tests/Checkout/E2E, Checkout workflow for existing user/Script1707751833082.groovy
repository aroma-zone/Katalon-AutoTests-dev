import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

user = GlobalVariable.user1

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Empty cart'), [:], FailureHandling.STOP_ON_FAILURE)

(productPrice, productName) = WebUI.callTestCase(findTestCase('AZ/E2E tests/HomePage/_ATC 1st product from recommendations'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/AZ/Components/Header/cart-icon'))

WebUI.waitForElementPresent(findTestObject('AZ/Components/Cart overlay/div_header'), 5, FailureHandling.STOP_ON_FAILURE)

'Cart before checkout'
WebUI.takeScreenshot()

cartSubTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

//WebUI.verifyEqual(cartSubTotal, productPrice)
WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.setText(findTestObject('AZ/Components/Login modal/input_email'), user.email)

WebUI.setText(findTestObject('AZ/Components/Login modal/input_password'), user.password)

WebUI.click(findTestObject('AZ/Components/Login modal/button_login'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/CheckoutPage/div_checkout_main'), 5, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/button_ContinueWithSuggestedAddress'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/button_ContinueWithSuggestedAddress'), FailureHandling.STOP_ON_FAILURE)
}

shippingAddress_fullName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Shipping Address/p_fullName'))

shippingAddress_streetName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Shipping Address/p_streetName'))

shippingAddress_postalCodeAndCity = WebUI.getText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Shipping Address/p_postalCodeAndCity'))

shippingAddress_phone = WebUI.getText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Shipping Address/p_phone'))

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal], FailureHandling.STOP_ON_FAILURE)

checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Mobile)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

'CheckoutPage before selecting payment method'
WebUI.takeScreenshot()

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Enter credit card details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay-2'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/OrderSuccessPage/_Check Order Success Page'), [('cartTotalQuantityOfItems') : 1, ('checkoutTotalString') : checkoutTotalString
        , ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

WebUI.click(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/OrderSuccessPage/button_backToShop (Mobile)'), 
        findTestObject('AZ/Pages/OrderSuccessPage/button_backToShop (Desktop)')))

url = WebUI.getUrl()

WebUI.verifyMatch(url, GlobalVariable.HomePage, false)

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/a_orderHistory'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/MyAccountPage/Order History/div_orderList'), 5, FailureHandling.STOP_ON_FAILURE)

'Order List'
WebUI.takeScreenshot()

(_, lastOrderNumber) = WebUI.getText(findTestObject('AZ/Pages/MyAccountPage/Order History/lastOrder_title')).tokenize('#')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/Order History/lastOrder_title'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/OrderSuccessPage/div_orderReview'), 5, FailureHandling.STOP_ON_FAILURE)

'Order Details'
WebUI.takeFullPageScreenshot()

WebUI.verifyMatch(checkoutTotalString, WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/Order History/orderDetail_totalAmount')), 
    false)

jsonResponse = WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Get last user order details from CT'), [('email') : user.email], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyEqual(jsonResponse.orderNumber, lastOrderNumber, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyEqual(jsonResponse.totalPrice.centAmount, checkoutTotal * 100, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(jsonResponse.shippingInfo.shippingMethodName, 'Standard', FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual((jsonResponse.shippingAddress.firstName + ' ') + jsonResponse.shippingAddress.lastName, shippingAddress_fullName, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(jsonResponse.shippingAddress.streetName, shippingAddress_streetName, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual((jsonResponse.shippingAddress.postalCode + ' ') + jsonResponse.shippingAddress.city, shippingAddress_postalCodeAndCity, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(jsonResponse.shippingAddress.phone, shippingAddress_phone, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyEqual(jsonResponse.lineItems[0].name.fr, productName, FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

