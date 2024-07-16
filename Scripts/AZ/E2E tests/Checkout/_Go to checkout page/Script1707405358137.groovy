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

WebUI.comment('Precondition: Page with cart icon (header) and logged-in user')

'Cart is left open after this call'
WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_ATC upsell'), [('index') : 0], FailureHandling.STOP_ON_FAILURE)

'Cart before checkout'
WebUI.takeScreenshot()

cartTotalQuantityOfItems = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Get number of total items on cart'), [:], 
    FailureHandling.STOP_ON_FAILURE)

cartSubTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/div_checkout_main'), 5)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/li_methodPaiement'), 5)

WebUI.verifyMatch(WebUI.getUrl(), '.*/checkout', true)

'Wait for Adyen module to be loaded in order to avoid errors'
WebUI.waitForElementPresent(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'), 5)

'Checkout Page'
WebUI.takeFullPageScreenshot()

KeywordUtil.logInfo(cartTotalQuantityOfItems.toString())

KeywordUtil.logInfo(cartSubTotal.toString())

return [cartTotalQuantityOfItems, cartSubTotal]

