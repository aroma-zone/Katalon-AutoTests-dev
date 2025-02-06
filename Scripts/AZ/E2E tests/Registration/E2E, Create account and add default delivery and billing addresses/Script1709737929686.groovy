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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import java.util.Date as Date
import java.text.SimpleDateFormat as SimpleDateFormat

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

// Créer un objet Date pour obtenir la date actuelle
now = new Date()

// Créer un objet SimpleDateFormat avec le format souhaité
SimpleDateFormat sdf = new SimpleDateFormat('yyyyMMdd.HHmmss')

// Utiliser la méthode format de SimpleDateFormat pour formater la date
String formattedDate = sdf.format(now)

// Remplacer {datetime} par la date formatée
email = email.replace('{datetime}', formattedDate)

KeywordUtil.logInfo(email)

KeywordUtil.logInfo(password)

WebUI.comment('Create new account')

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.click(findTestObject('AZ/Components/Login modal/button_register'))

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_email'), email)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_password'), password)

WebUI.setText(findTestObject('AZ/Components/Registration modal/input_passwordConfirm'), password)

WebUI.setText(findTestObject('Object Repository/AZ/Components/Registration modal/input_firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/AZ/Components/Registration modal/input_lastName'), lastName)

WebUI.click(findTestObject('Object Repository/AZ/Components/Registration modal/checkbox_genderMadam'))

WebUI.click(findTestObject('Object Repository/AZ/Components/Registration modal/checkbox_TCs'))

WebUI.click(findTestObject('AZ/Components/Registration modal/button_submit'))

WebUI.waitForElementPresent(findTestObject('AZ/Pages/MyAccountPage/div_myAccount'), 5)

newUserEmail = WebUI.getAttribute(findTestObject('AZ/Pages/MyAccountPage/MyProfile/input_email_(disabled)'), 'value')

WebUI.verifyMatch(newUserEmail, email, false)

WebUI.comment('Add delivery address')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/a_myAddresses'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/tab_deliveryAddress'))

WebUI.delay(2)

WebUI.refresh()

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_addNew_button'))

modalTitle = WebUI.getText(findTestObject('AZ/Components/Address modal/title - ajout'))

WebUI.verifyMatch(modalTitle, '.*(livraison|consegna)', true)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Address modal/_Fill address modal NEW'), [:], FailureHandling.STOP_ON_FAILURE)

'Delivery address'
WebUI.takeScreenshot()

List<WebElement> deliveryAddressCards = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_cards (list)'), 
    2)

WebUI.verifyEqual(deliveryAddressCards.size(), 1)

List<WebElement> defaultDeliveryAddressButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_buttons (list)'), 
    2)

//WebUI.verifyEqual(defaultDeliveryAddressButtons.size(), 1)
//WebUI.verifyMatch(defaultDeliveryAddressButtons[0].text, '(Modifier|Modifica)', true)
'Primary Address must have only one button (Update)'
WebUI.comment('Add billing address')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/tab_billingAddress'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/billingAddress_addNew_button'))

modalTitle = WebUI.getText(findTestObject('AZ/Components/Address modal/title - ajout facturation'))

WebUI.verifyMatch(modalTitle, '.*(facturation|fatturazione)', true)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Address modal/_Update address modal NEW'), [:], FailureHandling.STOP_ON_FAILURE)

'Billing address'
WebUI.takeScreenshot()

List<WebElement> billingAddressCards = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/billingAddress_cards (list)'), 
    2)

//WebUI.verifyEqual(billingAddressCards.size(), 1)

List<WebElement> defaultBillingAddressButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/billingAddress_default_buttons'), 
    2)

'Primary Address must have only one button (Update)'
//WebUI.verifyEqual(defaultBillingAddressButtons.size(), 1)

WebUI.verifyMatch(defaultBillingAddressButtons[0].text, '(Modifier|Modifica)', true)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

