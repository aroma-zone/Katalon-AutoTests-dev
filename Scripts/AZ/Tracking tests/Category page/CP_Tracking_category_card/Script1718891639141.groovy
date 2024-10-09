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

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_7'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_AdviceListing_AllAdvice'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/ALP/a_FirstCategoryAdvice'))

WebUI.delay(1)

WebUI.back()

WebUI.delay(2)

// Vérifiez l'événement dans la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'category_card\' && \n        event.event_name === \'category_card\' && \n        event.event_category === \'ecommerce\' \n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking \'category_card\' avec \'category_card\' n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'category_card' : 'L\'événement trouvé n\'est pas \'category_card\'.'

println('L\'événement de tracking \'category_card\' avec \'category_card\' a été trouvé avec succès dans la couche de données.')

WebUI.delay(1)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

