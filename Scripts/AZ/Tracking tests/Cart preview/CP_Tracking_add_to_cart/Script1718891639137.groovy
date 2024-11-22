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

WebUI.scrollToPosition(400, 400)

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonFavoris'), FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonFavoris'), 0)

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

WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), 0)

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/Arrow_carroussel_selection_right'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/Arrow_carroussel_selection_right'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonProductCard_add6'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonUpsellModule_Add'))

WebUI.delay(2)

String script2 = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event2 = ((WebUI.executeJavaScript(script2, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event2 != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event2.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/Arrow_carroussel_selection_left'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/Arrow_carroussel_selection_left'))

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/Arrow_carroussel_selection_left'))

WebUI.click(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'), FailureHandling.STOP_ON_FAILURE)

String script3 = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event3 = ((WebUI.executeJavaScript(script3, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event3 != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event3.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/HeaderButtonCart'))

WebUI.click(findTestObject('AZ/Pages/Cart/ButtonProductCard_Add'))

WebUI.delay(2)

String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event4 != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Cart/ButtonProductCard_Add'))

WebUI.delay(2)

//autre event a check
String script5 = '\n    return window.dataLayer.find(event => \n\t\tevent.event === \'upsell_click\' &&\n\t\tevent.event_name === \'upsell_click\' &&\n\t\tevent.event_action === \'click\'\n\n    );\n'

Map event5 = ((WebUI.executeJavaScript(script5, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event5 != null : 'L\'événement de tracking "upsell_click" avec "upsell_click" n\'a pas été trouvé dans la couche de données.'

assert event5.event_name == 'upsell_click' : 'L\'événement trouvé n\'est pas "upsell_click".'

///////
String script6 = '\n return window.dataLayer.find(event => \n event.event === \'view_cart\' && \n event.event_name === \'view_cart\' && \n event.event_action === \'checkout\'\n );\n'

Map event6 = ((WebUI.executeJavaScript(script6, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event6 != null : 'L\'événement de tracking "view_cart" avec "view_cart" n\'a pas été trouvé dans la couche de données.'

assert event6.event_name == 'view_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

