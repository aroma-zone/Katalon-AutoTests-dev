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
import org.apache.commons.lang3.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.comment('Precondition: HomePage')

WebUI.comment('Input: user {Map}')

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

String nomUtilisateur = 'User-Proximity'

String domaine = 'quality.com'

String partieAleatoire = RandomStringUtils.randomNumeric(4)

String email = (((nomUtilisateur + '+') + partieAleatoire) + '@') + domaine

WebUI.sendKeys(findTestObject('Object Repository/AZ/Components/Login modal/input_email'), email)

WebUI.setEncryptedText(findTestObject('Object Repository/AZ/Components/Login modal/input_password'), 'DaViKV2JRFMQvcOmiggfSw==')

WebUI.click(findTestObject('AZ/Components/Login modal/button_login'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/MyAccountPage/div_myAccount'), 5)

'On mobile, user email is not displayed at this point (but it\'s already present on HTML).'
userEmail = WebUI.getAttribute(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_email_(disabled)'), 'value')

WebUI.verifyMatch(userEmail, user.email, false)

