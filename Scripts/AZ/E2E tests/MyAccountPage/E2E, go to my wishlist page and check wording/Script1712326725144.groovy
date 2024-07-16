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

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Components/Login modal/button_register'))

String nomUtilisateur = 'User-Proximity'

String domaine = 'quality.com'

String partieAleatoire = RandomStringUtils.randomNumeric(4)

String email = (((nomUtilisateur + '+') + partieAleatoire) + '@') + domaine

WebUI.sendKeys(findTestObject('AZ/Components/Registration modal/input_email'), email)

WebUI.setEncryptedText(findTestObject('AZ/Components/Registration modal/input_password'), 'DaViKV2JRFMQvcOmiggfSw==')

WebUI.setEncryptedText(findTestObject('AZ/Components/Registration modal/input_passwordConfirm'), 'DaViKV2JRFMQvcOmiggfSw==')

WebUI.setText(findTestObject('Object Repository/AZ/Components/Registration modal/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/AZ/Components/Registration modal/input_lastName'), lastName)

WebUI.click(findTestObject('Object Repository/AZ/Components/Registration modal/checkbox_genderMadam'))

WebUI.click(findTestObject('Object Repository/AZ/Components/Registration modal/checkbox_TCs'))

WebUI.click(findTestObject('AZ/Components/Registration modal/button_submit'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/MyAccountPage/div_myAccount'), 5)

newUserEmail = WebUI.getAttribute(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_email_(disabled)'), 'value')

//, [('user') : user]
WebUI.click(findTestObject('AZ/Pages/MyAccountPage/a_orderHistory'))

WebUI.verifyTextPresent('Vous n’avez pas encore passé de commandes.', false)

WebUI.verifyTextPresent('Retrouvez le statut de vos commandes ainsi que le détail des factures associées.', false)

WebUI.verifyTextPresent('Mes achats', false)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/MyAccountPage/MyProfile/button_top_of_page'), 0)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

