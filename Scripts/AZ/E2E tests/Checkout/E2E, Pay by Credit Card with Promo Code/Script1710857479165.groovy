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

(cartTotalQuantityOfItems, cartSubTotal) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Go to checkout page'), [:], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Apply promo code'), [('promoCode') : GlobalVariable.promoCode.code], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal
        , ('promoCodePercentage') : GlobalVariable.promoCode.percentage], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Remove saved payment method'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Enter credit card details'), [('card') : card], FailureHandling.STOP_ON_FAILURE)

'Entered credit card details, before clicking on Pay button'
WebUI.takeFullPageScreenshot()

checkoutTotalString = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify pay button amount matches checkout total'), [
        ('payButton') : findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay')], FailureHandling.STOP_ON_FAILURE)

checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/OrderSuccessPage/_Check Order Success Page'), [('cartTotalQuantityOfItems') : cartTotalQuantityOfItems
        , ('checkoutTotalString') : checkoutTotalString, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Check amount and paymentState of last user order on CT'), [('checkoutTotal') : checkoutTotal
        , ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

