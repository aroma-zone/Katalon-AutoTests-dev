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
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

user = GlobalVariable.user1

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Empty cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.scrollToPosition(0, 0)

WebUI.setText(findTestObject('AZ/Components/Search bar/input_search titem'), 'Huile essentielle Camomille romaine France BIO')

WebUI.delay(4)

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.SPACE))

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('AZ/Pages/PLP/1st_product_ATC_button'), 0)

WebUI.click(findTestObject('AZ/Pages/PLP/1st_product_ATC_button'))

WebUI.delay(5)

WebUI.click(findTestObject('AZ/Components/Header/cart-icon'))

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_creditCard'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Enter credit card details'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/button_pay-2'))

WebUI.waitForPageLoad(0)

WebUI.delay(6)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '''
	console.log('verifdata',event)
    return window.dataLayer.find(event => 
        event.event === 'purchase' && 
        event.event_name === 'purchase' && 
        event.event_label === 'success' && 
        event.total_items === 1 &&
		event.ecommerce.items[0].item_sku === '04029' &&
		event.ecommerce.items[0].quantity === 1 &&
		event.ecommerce.items[0].price === 20.95 &&
        event.ecommerce.currency === 'EUR' &&
		event.ecommerce.items[0].item_name === 'Huile essentielle Camomille romaine France BIO'
   
    );
'''

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "purchase" avec "purchase" n\'a pas été trouvé dans la couche de données.'

println('L\'événement de tracking "purchase" avec "purchase" a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

