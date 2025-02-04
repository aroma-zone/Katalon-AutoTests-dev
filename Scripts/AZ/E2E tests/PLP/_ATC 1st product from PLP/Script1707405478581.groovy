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

// Precondition: Opened Browser
WebUI.navigateToUrl(GlobalVariable.SEO_PLP)

cartBadgeInitialNumber = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Get cart icon badge number'), [:], FailureHandling.STOP_ON_FAILURE)

productPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Pages/PLP/1st_product_price')))

productName = WebUI.getText(findTestObject('AZ/Pages/PLP/1st_product_name'))

WebUI.click(findTestObject('AZ/Pages/PLP/1st_product_ATC_button'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/ATC overlay/_Select 1st variant and close'), [:], FailureHandling.STOP_ON_FAILURE)

cartBadgeNumber = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Get cart icon badge number'), [:], FailureHandling.STOP_ON_FAILURE)

'Sometimes we can have a gift also automatically added to cart'
WebUI.verifyGreaterThan(cartBadgeNumber, cartBadgeInitialNumber)

KeywordUtil.logInfo(productPrice.toString())

KeywordUtil.logInfo(productName)

return [productPrice, productName]
