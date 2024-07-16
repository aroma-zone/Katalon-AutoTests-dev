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

WebUI.scrollToPosition(0, 0)

// Effectuer une action qui doit déclencher un événement de tracking
WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_1'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_ProductsAromathérapie'))

WebUI.waitForPageLoad(10)

WebUI.click(findTestObject('AZ/Pages/PLP/Filters_Wrappers_1'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/PLP/Wrapper1_Choice_1'))

WebUI.delay(4)

// Exécuter du JavaScript pour récupérer la couche de données
String script = """
    return window.dataLayer.find(event => 
        event.event === 'filter'
    );
"""

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "filter" n\'a pas été trouvé dans la couche de données.'

//assert event.EventFilterValues.event_name == 'select_item' : 'L\'événement trouvé n\'est pas "select_item".'
println('L\'événement de tracking \'filter\'  a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

