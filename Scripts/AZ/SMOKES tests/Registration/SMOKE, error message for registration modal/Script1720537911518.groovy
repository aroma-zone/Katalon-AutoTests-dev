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

WebUI.click(findTestObject('AZ/Components/New login pages/login/Button_continue_with_email'))

WebUI.verifyTextPresent('Vous n’avez pas de compte ?', false)

WebUI.click(findTestObject('AZ/Components/New login pages/signin/button_create account'))

WebUI.verifyTextPresent('Créer un compte', false)

WebUI.verifyTextPresent('Vos informations', false)

WebUI.verifyTextPresent('Date d’anniversaire', false)

WebUI.verifyTextPresent('Adresse mail', false)

WebUI.verifyTextPresent('Mot de passe', false)

WebUI.verifyTextPresent('Prénom', false)

WebUI.verifyTextPresent('Nom', false)

WebUI.verifyTextPresent('Je souhaite être informé des nouvelles recettes, nouveaux produits et offres promotionnelles', 
    false)

WebUI.verifyTextPresent('Je déclare avoir pris connaissance de la charte des données personnelles Aroma-Zone qui m’informe des modalités d’utilisation de mes données personnelles par Aroma-Zone dans le cadre de l’utilisation de l’ensemble des fonctionnalités du site internet (gestion du compte, gestion des commandes...)', 
    false)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_email'))

WebUI.click(findTestObject('AZ/Components/New login pages/signup/input_password'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_email_1'), 0)

WebUI.click(findTestObject('AZ/Components/New login pages/signup/input_email'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_1.1'), 0)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_email'), 'bademail@')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_email_2'), 0)

WebUI.setText(findTestObject('AZ/Components/New login pages/signup/input_password'), '123')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_password_2'), 0)

WebUI.click(findTestObject('AZ/Components/New login pages/signup/input_firstName'))

WebUI.click(findTestObject('AZ/Components/New login pages/signup/input_lastName'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_firstname_1'), 0)

WebUI.click(findTestObject('AZ/Components/Registration modal/input_firstName'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/error_message_lastname_1'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/signup/button_submit'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Registration modal/checkbox_Newsletters'), 0)

WebUI.setText(findTestObject('AZ/Components/New login pages/signup/input_email'), 'gmail.com')

WebUI.click(findTestObject('AZ/Components/New login pages/signup/button_submit'))

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

