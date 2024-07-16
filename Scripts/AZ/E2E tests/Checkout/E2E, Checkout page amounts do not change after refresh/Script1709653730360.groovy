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

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Go to checkout page'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'))

checkoutSubTotalStringInitial = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

checkoutTotalStringInitial = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

//checkoutSubTotalStringInitial = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Mobile)'),
	//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

//checkoutTotalStringInitial = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Mobile)'),
	//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

creditCardPayButtonTextInitial = WebUI.getText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay'))

'Checkout Page before refresh'
WebUI.takeFullPageScreenshot()

WebUI.refresh()

'If there\'s a saved payment method, it will be selected by default after refresh'
WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'))

checkoutSubTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

//checkoutSubTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Mobile)'),
	//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

//checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Mobile)'),
	//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

creditCardPayButtonText = WebUI.getText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay'))

'Checkout Page after refresh'
WebUI.takeFullPageScreenshot()

WebUI.verifyMatch(checkoutSubTotalString, checkoutSubTotalStringInitial, false)

WebUI.verifyMatch(checkoutTotalStringInitial, checkoutTotalString, false)

WebUI.verifyMatch(creditCardPayButtonTextInitial, creditCardPayButtonText, false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

