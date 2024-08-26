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

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button4'), 0)

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), 0)

// Effectuer une action qui doit déclencher un événement de tracking
WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonProductCard_add1'))

WebUI.delay(2)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button4'), 0)

WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), 0)

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonProductCard_add3'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonUpsellModule_Add'))

WebUI.delay(2)

String script2 = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event2 = ((WebUI.executeJavaScript(script2, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event2 != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event2.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/HeaderButtonCart'))

WebUI.click(findTestObject('AZ/Pages/Cart/ButtonProductCard_Add'))

WebUI.waitForPageLoad(0)

WebUI.delay(2)

String script3 = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event3 = ((WebUI.executeJavaScript(script3, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event3 != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event3.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.navigateToUrl('https://aroma-zone:avant-premiere@stage.aroma-host.net/info/fiche-technique/creme-mains-acide-hyaluronique-pain-d-epices')

WebUI.scrollToElement(findTestObject('AZ/Pages/PDP/LinkTitleProductPresentation'), 0)

// Supprimer l'attribut href ou onclick du bouton pour empêcher la redirection
String removeLinkScript = '\n    var button = document.evaluate("(//button[@class=\'add-to-cart color-secondary sf-button\'])[1]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n    if (button) {\n        button.removeAttribute(\'href\'); // Si c\'est un lien\n        button.removeAttribute(\'onclick\'); // Si l\'action est dans onclick\n    }\n'

WebUI.executeJavaScript(removeLinkScript, null)

// Cliquez sur le bouton via JavaScript
String clickButtonScript = '\n    var button = document.evaluate("(//button[@class=\'add-to-cart color-secondary sf-button\'])[1]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;\n    if (button) {\n        button.click();\n    }\n'

WebUI.executeJavaScript(clickButtonScript, null)

// Ajoutez un délai pour voir l'effet
WebUI.delay(1)

// Vérifiez l'événement dans la couche de données
String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'upsell_click\' && \n        event.event_name === \'upsell_click\' && \n        event.event_category === \'upsell\' && \n        event.event_action === \'click\' && \n        event.widget_id === \'64b650e2e8b9eebd1eb3e0bc\'\n    );\n'

Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event4 != null : 'L\'événement de tracking \'upsell_click\' avec \'upsell_click\' et widget_id \'64b650e2e8b9eebd1eb3e0bc\' n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'upsell_click' : 'L\'événement trouvé n\'est pas \'upsell_click\'.'

println('L\'événement de tracking \'upsell_click\' avec \'upsell_click\' et widget_id \'64b650e2e8b9eebd1eb3e0bc\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

