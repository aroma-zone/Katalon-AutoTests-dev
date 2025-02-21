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

WebUI.comment('Precondition: HomePage')

WebUI.comment('Input: user {Map}')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/login/Button_continue_with_email'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/login/Button_continue_with_google'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/login/button_return'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/login/link_personal_data_charter'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/login/logo_AZ'), 0)

WebUI.click(findTestObject('AZ/Components/New login pages/login/Button_continue_with_email'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/signin/button_forgot password'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/signin/button_return'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/signin/logo_AZ'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Components/New login pages/signin/button_create account'), 0)

WebUI.setText(findTestObject('AZ/Components/New login pages/signin/input_email'), 'wahob39038@logodez.com')

WebUI.setText(findTestObject('AZ/Components/New login pages/signin/input_password'), 'TestPassword721')

WebUI.click(findTestObject('AZ/Components/New login pages/signin/button_login'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/MyAccountPage/div_myAccount'), 5)

'On mobile, user email is not displayed at this point (but it\'s already present on HTML).'
userEmail = WebUI.getAttribute(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_email_(disabled)'), 'value')

