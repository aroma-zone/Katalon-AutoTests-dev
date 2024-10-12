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

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.verifyTextPresent('Nouveau client ?', false)

WebUI.verifyTextPresent('La création d\'un compte vous permet d\'accéder à l\'ensemble de nos services.', false)

WebUI.click(findTestObject('AZ/Components/Login modal/button_resetPassword'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Entrez votre adresse e-mail ci-dessous et vous recevrez un e-mail avec un lien pour réinitialiser votre mot de passe.', 
    false)

WebUI.setText(findTestObject('AZ/Components/Login modal/input_email'), 'alexandre.bluteau1@gmail.com')

WebUI.delay(3)

WebUI.sendKeys(findTestObject('AZ/Components/Login modal/input_email'), Keys.chord(Keys.LEFT_CONTROL, 'a'))

WebUI.sendKeys(findTestObject('AZ/Components/Login modal/input_email'), Keys.chord(Keys.DELETE))

WebUI.setText(findTestObject('AZ/Components/Login modal/input_email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Components/Login modal/button_login'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

// Vérifier la présence du message indiquant qu'il y a un captcha
boolean IncorrectCAPTCHA = WebUI.verifyTextPresent('CAPTCHA incorrect.', false, FailureHandling.OPTIONAL)

if (IncorrectCAPTCHA) {
	// Clôturer le test case avec succès si le message est trouvé
	WebUI.comment('captcha invalide trouvé, le test se termine.')
} else {

WebUI.verifyTextPresent('Si un compte identifié par : alexandre.bluteau@aroma-zone.com existe, vous recevrez un email contenant un lien pour réinitialiser votre mot de passe.', 
    false)

WebUI.verifyTextPresent('Si vous ne recevez pas de mail d’ici 15 minutes, nous vous invitons à créer un nouveau compte client.', 
    false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

}

