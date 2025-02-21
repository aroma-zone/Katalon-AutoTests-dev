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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

'using different user account for address update to reduce impact in case of test break'
user = GlobalVariable.user2

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User new login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_first_name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_first_name'), Keys.chord(Keys.LEFT_CONTROL, 'a', Keys.DELETE))

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_first_name'), 'Automated Trilex modified')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_last_name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_last_name'), Keys.chord(Keys.LEFT_CONTROL, 'a', Keys.DELETE))

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_last_name'), 'Tests Quality')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_civility'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_civility'), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_nickname'), Keys.chord(Keys.LEFT_CONTROL, 'a', Keys.DELETE))

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_nickname'), 'Informations modified')

'add newsletter'
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/checkbox_newsletter'), FailureHandling.STOP_ON_FAILURE)

'remove newsletter'
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/checkbox_newsletter'), FailureHandling.STOP_ON_FAILURE)

'add date of birth'
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_date_of_birth'), FailureHandling.STOP_ON_FAILURE)

'add date of birth'
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_date_of_birth'), FailureHandling.STOP_ON_FAILURE)

'add date of birth'
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_date_of_birth'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_date_of_birth'), '07081992')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_save'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_top_of_page'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_change_pasword'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_current_password'), 'TestPassword721')

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_new_password'), 'TestPassword721')

WebUI.setText(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_repeat_password'), 'TestPassword721')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_save_password'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_personal_informations'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

