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

WebUI.click(findTestObject('AZ/Components/Login modal/button_register'))

WebUI.verifyTextPresent('Création de compte', false)

WebUI.verifyTextPresent('Données de connexion', false)

WebUI.verifyTextPresent('Au moins 6 caractères', false)

WebUI.verifyTextPresent('Aucun espace', false)

WebUI.verifyTextPresent('Vos informations', false)

WebUI.verifyTextPresent('Je souhaite être informé des nouvelles recettes, nouveaux produits et offres promotionnelles', 
    false)

WebUI.verifyTextPresent('J\'ai lu la Charte des données personnelles Aroma-Zone et donne mon accord pour que les données que je soumets soient utilisées pour la gestion de mon compte et de mes commandes.', 
    false)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_email'))

WebUI.click(findTestObject('AZ/Components/Registration modal/input_password'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_email_1'), 0)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_passwordConfirm'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_1'), 0)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_email'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_1.1'), 0)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_email'), 'bademail@')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_email_2'), 0)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_password'), '123')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_2'), 0)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_passwordConfirm'), '12')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_2.2'), 0)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_firstName'))

WebUI.click(findTestObject('AZ/Components/Registration modal/input_lastName'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_firstname_1'), 0)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_firstName'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_lastname_1'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/button_submit'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/checkbox_Newsletters'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/checkbox_TCs'), 0)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_email'), 'gmail.com')

WebUI.click(findTestObject('AZ/Components/Registration modal/button_submit'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_checkboxTCs_1'), 0)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

