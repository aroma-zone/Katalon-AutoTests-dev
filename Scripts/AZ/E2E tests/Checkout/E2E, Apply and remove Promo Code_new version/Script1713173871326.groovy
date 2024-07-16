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

input = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Desktop)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Desktop)'))

applyButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Desktop)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Desktop)'))

sremoveButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Desktop)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Desktop)'))

//input = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Mobile)'), 
//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Desktop)'))
//applyButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Mobile)'), 
//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Desktop)'))
//removeButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Mobile)'), 
//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Desktop)'))
'Promo code can remain applied if previous checkout didn\'t succeed'
if (WebUI.verifyElementPresent(removeButton, 1, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Desktop)'))
}

WebUI.comment('no promo code and no delivery selected')

'no promo code and no delivery selected'
WebUI.takeScreenshot()

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal, ('promoCodePercentage') : 0], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment('promo code and no delivery selected')

KeywordUtil.logInfo(GlobalVariable.promoCode.percentage.toString())

WebUI.setText(input, GlobalVariable.promoCode.code)

WebUI.click(applyButton)

'promo code and no delivery selected'
WebUI.takeScreenshot()

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal, ('promoCodePercentage') : GlobalVariable.promoCode.percentage], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment('promo code and delivery selected')

'scroll needed on mobile'
WebUI.scrollToElement(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_ExpressDelivery'), 0)

'Selecting \'Express\' delivery because Standard is sometimes set to free on test envs'
WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Desktop)'))

'promo code and delivery selected'
WebUI.takeScreenshot()

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal, ('promoCodePercentage') : GlobalVariable.promoCode.percentage], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.comment('no promo code and delivery selected')

WebUI.click(removeButton)

'no promo code and delivery selected'
WebUI.takeScreenshot()

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify cart preview amounts'), [('cartSubTotal') : cartSubTotal, ('promoCodePercentage') : 0], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

