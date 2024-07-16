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

WebUI.comment('Precondition: CheckoutPage with "Credit Card" payment option selected')

WebUI.comment('Input: card {Map} (optional, otherwise default card is used)')

WebUI.verifyElementVisible(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardNumber'))

WebUI.scrollToElement(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardNumber'), 2)

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardNumber'), card.cardNumber)

WebUI.setText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardExpiryDate'), 
    card.expirationDate)

WebUI.setText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardSecurityCode'), 
    card.securityCode)

WebUI.setText(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Payment Method/Credit Card/input_cardHolderName'), 
    card.holderName)

'Entered credit card details, before clicking on Pay button'
//WebUI.takeFullPageScreenshot()

