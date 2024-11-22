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

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Components/Search bar/input_search titem'), 'Sérum concentré d\'Acide hyaluronique 3,5%')

WebUI.delay(2)

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.SPACE))

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.scrollToPosition(5, 5)

WebUI.verifyTextPresent('Vous avez cherché : "Sérum concentré d\'Acide hyaluronique 3,5% "', false)

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Components/Search bar/card_resultCuticules'))

WebUI.delay(2)

// Vérifiez l'événement dans la couche de données
String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'view_item\' && \n        event.event_name === \'view_item\' && \n        event.event_category === \'ecommerce\' && \n        event.event_action === \'open\' && \n        event.ecommerce.items[0].item_sku === \'04685\'\n    );\n'

Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event4 != null : 'L\'événement de tracking \'view_item\' avec \'view_item\' et event.ecommerce.items.0.item_sku === \'02986\' n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'view_item' : 'L\'événement trouvé n\'est pas \'view_item\'.'

println('L\'événement de tracking \'view_item\' avec \'view_item\' et event.ecommerce.items.0.item_sku === \'02986\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.delay(2)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce.items[0].item_sku === \'04685\' && \n        event.event_action === \'add\'\n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

