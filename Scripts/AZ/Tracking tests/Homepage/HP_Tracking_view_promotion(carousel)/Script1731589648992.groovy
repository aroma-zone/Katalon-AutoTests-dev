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

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLinkNews'), 0)

WebUI.delay(1)

WebUI.scrollToPosition(0, 0)

// Effectuer une action qui doit déclencher un événement de tracking
//WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/TrackingButtonCarousel'))

WebUI.delay(8)

// Exécuter du JavaScript pour récupérer la couche de données

String script = """
    return window.dataLayer.find(event => 
        event.event === 'carousel' && 
        event.event_name === 'view_promotion' &&
		event.ecommerce.title === 'Nos baumes à lèvres vegan BIO' 
		
    );
"""

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "carousel" avec "view_promotion" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'view_promotion' : 'L\'événement trouvé n\'est pas "view_promotion".'

println('L\'événement de tracking \'carousel\' avec \'view_promotion\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

