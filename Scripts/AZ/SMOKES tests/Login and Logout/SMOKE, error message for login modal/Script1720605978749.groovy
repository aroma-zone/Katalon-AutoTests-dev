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

WebUI.click(findTestObject('AZ/Components/Login modal/input_email'))

WebUI.click(findTestObject('AZ/Components/Login modal/input_password'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_email_1'), 0)

WebUI.click(findTestObject('AZ/Components/Login modal/input_email'))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_password_1'), 0)

WebUI.setText(findTestObject('AZ/Components/Login modal/input_email'), 'bademail')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_email_2'), 0)

WebUI.setText(findTestObject('Object Repository/AZ/Components/Login modal/input_password'), '123')

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/error_message_password_2'), 0)

WebUI.sendKeys(findTestObject('AZ/Components/Login modal/input_email'), Keys.chord(Keys.LEFT_CONTROL, 'a'))

WebUI.sendKeys(findTestObject('AZ/Components/Login modal/input_email'), Keys.chord(Keys.DELETE))

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/button_login'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/button_resetPassword'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Login modal/button_register'), 0)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

