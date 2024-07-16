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

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Button_Parameters'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Parameters/Button_Combobox'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Parameters/Italian_Choice'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Parameters/Button_validate'))

WebUI.delay(1)

WebUI.back()

WebUI.waitForPageLoad(0)

WebUI.delay(3)

String script = '\n    return window.dataLayer.find(event => \n        event.event === \'generic_event\' && \n        event.event_name === \'change_language\'\n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "generic_event" avec "change_language" n\'a pas été trouvé dans la couche de données.'

//assert event.event_name == 'change_language' : 'L\'événement trouvé n\'est pas "change_language".'
println('L\'événement de tracking \'generic_event\' avec \'change_language\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

