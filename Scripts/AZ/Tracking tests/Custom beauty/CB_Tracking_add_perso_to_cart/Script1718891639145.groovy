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

WebUI.navigateToUrl('https://stage.aroma-host.net/info/fiche-technique/huile-visage-precieuse-bio-aroma-zone?capacity=50&capacity-unit=ml&capacity-type=standard', 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.refresh()

WebUI.waitForPageLoad(0)

WebUI.delay(2)

// Effectuer une action qui doit déclencher un événement de tracking
WebUI.click(findTestObject('AZ/Pages/PDP/ButtonCustomizableBase'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/SecondStep_FirstChoice'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonSecondStep_next'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ThirdStep_FirstChoice'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonThirdStep_next'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/FourthStep_FirstChoice'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonFourthStep_next'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/FifthStep_FirstChoice'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonFourthStep_next'))

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonAddPersonalizationToCart'))

WebUI.setText(findTestObject('AZ/Pages/PDP/customizable modal base/Input_email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Pages/PDP/customizable modal base/ButtonValidate'))

WebUI.delay(2)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'add_perso_to_cart\' && \n        event.customer_properties[\'$email\'] === \'alexandre.bluteau@aroma-zone.com\'\n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "add_perso_to_cart" avec "alexandre.bluteau@aroma-zone.comt" n\'a pas été trouvé dans la couche de données.'

// Vérifier que l'email dans l'événement de tracking est correct
assert (event.customer_properties['$email']) == 'alexandre.bluteau@aroma-zone.com' : 'L\'événement trouvé n\'est pas "alexandre.bluteau@aroma-zone.com".'

println('L\'événement de tracking \'add_perso_to_cart\' avec \'alexandre.bluteau@aroma-zone.com\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

