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

user = GlobalVariable.user1

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User new login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl('https://aroma-zone:avant-premiere@stage.aroma-host.net/info/fiche-technique/serum-concentre-collagene-vegan-1-5')

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.click(findTestObject('AZ/Components/Header/cart-icon'))

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(3)

WebUI.verifyTextPresent('9,95 €', false)

WebUI.back()

WebUI.click(findTestObject('AZ/Components/Header/cart-icon'))

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_delete_first_item'))

WebUI.verifyTextNotPresent('Récapitulatif du panier', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

