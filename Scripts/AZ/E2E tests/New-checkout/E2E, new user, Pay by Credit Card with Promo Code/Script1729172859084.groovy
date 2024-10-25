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
import org.openqa.selenium.Cookie as Cookie
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Registration/_User Random Registration'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add product to cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Apply promo code'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping address FR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping method'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Enter credit card details'), [('card') : [('has3DS') : false, ('cardNumber') : '2222400070000005'
            , ('expirationDate') : '03/30', ('securityCode') : '737', ('holderName') : 'TEST NAME', ('password') : '']], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(16)

WebUI.verifyTextPresent('Récapitulatif de la commande', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

