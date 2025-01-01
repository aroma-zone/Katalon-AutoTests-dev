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

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_Favoris'), 0)

WebUI.scrollToPosition(500, 500)

// Effectuer une action qui doit déclencher un événement de tracking
WebUI.click(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard_without_cat'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.delay(2)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'add_to_cart\' && \n        event.event_name === \'add_to_cart\' && \n        event.ecommerce && \n        event.event_action === \'add\'\n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "add_to_cart" avec "add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'add_to_cart' : 'L\'événement trouvé n\'est pas "add_to_cart".'

println('L\'événement de tracking \'add_to_cart\' avec \'add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

