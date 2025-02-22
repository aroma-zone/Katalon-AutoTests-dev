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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.click(findTestObject('AZ/Components/New login pages/login/Button_continue_with_email'))

WebUI.click(findTestObject('AZ/Components/New login pages/signin/button_create account'))

String nomUtilisateur = 'User-Random-AZ'

String domaine = 'quality.com'

String partieAleatoire = RandomStringUtils.randomNumeric(5)

String email = (((nomUtilisateur + '+') + partieAleatoire) + '@') + domaine

WebUI.sendKeys(findTestObject('AZ/Components/New login pages/signup/input_email'), email)

WebUI.setEncryptedText(findTestObject('AZ/Components/New login pages/signup/input_password'), 'DaViKV2JRFMQvcOmiggfSw==')

WebUI.setText(findTestObject('AZ/Components/New login pages/signup/input_firstName'), 'Trilex')

WebUI.setText(findTestObject('AZ/Components/New login pages/signup/input_lastName'), 'Quality')

WebUI.click(findTestObject('AZ/Components/New login pages/signup/checkbox_genderMadam'))

WebUI.click(findTestObject('AZ/Components/New login pages/signup/button_submit'))

