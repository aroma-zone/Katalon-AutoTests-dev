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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

// Precondition: Opened Browser
//WebUI.openBrowser('')
//WebUI.navigateToUrl(GlobalVariable.SEO_HomePage_FR)
WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

//user = GlobalVariable.user1
//WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)
cartBadgeInitialNumber = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Get cart icon badge number'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToPosition(410, 400)

WebUI.click(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_Favoris'))

productPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('Object Repository/AZ/Pages/HomePage/Recommendations/1st_product_price')))

productName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/HomePage/Recommendations/1st_product_name'))

'HomePage before ATC'
WebUI.takeScreenshot()

//WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/Recommendations/1st_product_card'), 2)
WebUI.click(findTestObject('AZ/Pages/HomePage/Recommendations/1st_product_ATC_button'))

WebUI.callTestCase(findTestCase('AZ/E2E tests/ATC overlay/_Select 1st variant and close'), [:], FailureHandling.STOP_ON_FAILURE)

'HomePage after ATC'
WebUI.takeScreenshot()

cartBadgeNumber = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Get cart icon badge number'), [:], FailureHandling.STOP_ON_FAILURE)

'Sometimes we can have a gift also automatically added to cart'
WebUI.verifyGreaterThan(cartBadgeNumber, cartBadgeInitialNumber)

KeywordUtil.logInfo(productPrice.toString())

KeywordUtil.logInfo(productName)

return [productPrice, productName]

