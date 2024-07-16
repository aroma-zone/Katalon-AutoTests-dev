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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

user = GlobalVariable.user1

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

(cartTotalQuantityOfItems, _) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Go to checkout page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Mobile)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_paypal'))

WebUI.waitForElementVisible(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/button_submit'), 2)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/button_submit'))

'Paypal checkout continues in separate window'
WebUI.switchToWindowIndex(1)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/input_email'), 5)

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/input_email'), paypalAccount_email)

if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_next'), 
    1, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_next'), 
        FailureHandling.STOP_ON_FAILURE)
}

WebUI.delay(2)

//WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/input_password'), paypalAccount_password)
try {
    if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_next'), 
        1, FailureHandling.OPTIONAL)) {
        WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/input_email'), paypalAccount_email)

        WebUI.click(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_next'), 
            FailureHandling.STOP_ON_FAILURE)
    }
}
catch (Exception e) {
} // Si l'élément n'est pas visible, continuer le test sans générer d'erreur

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/input_password'), paypalAccount_password)

WebUI.click(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_login'))

paypalTotalString = WebUI.getText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/header_cart_total'))

paypalTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(paypalTotalString)

WebUI.verifyEqual(paypalTotal, checkoutTotal)

WebUI.click(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/radio_successful_payment'))

'PayPal window before clicking on "pay" button'
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Paypal/PayPal window/button_pay'))

WebUI.switchToWindowIndex(0)

WebUI.callTestCase(findTestCase('AZ/E2E tests/OrderSuccessPage/_Check Order Success Page'), [('cartTotalQuantityOfItems') : cartTotalQuantityOfItems
        , ('checkoutTotalString') : checkoutTotalString, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Check amount and paymentState of last user order on CT'), [('checkoutTotal') : checkoutTotal
        , ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

