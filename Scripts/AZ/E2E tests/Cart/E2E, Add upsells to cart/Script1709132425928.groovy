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

WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Empty cart'), [:], FailureHandling.STOP_ON_FAILURE)

if (!(WebUI.verifyElementPresent(findTestObject('AZ/Components/Cart overlay/div_header'), 1, FailureHandling.OPTIONAL))) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/Header/cart-icon'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/Cart overlay/div_header'), 2, FailureHandling.STOP_ON_FAILURE)
}

WebUI.comment('Add first upsell to cart')

(upsell1Price, upsell1Title) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_ATC upsell'), [('index') : 0], FailureHandling.STOP_ON_FAILURE)

topItemTitle = WebUI.getText(findTestObject('AZ/Components/Cart overlay/items/top_item_title'))

topItemPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/items/top_item_price')))

subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

WebUI.takeScreenshot()

WebUI.verifyMatch(topItemTitle, upsell1Title, false)

WebUI.verifyEqual(topItemPrice, upsell1Price)

WebUI.verifyEqual(subTotal, upsell1Price)

WebUI.comment('Add again first upsell to cart')

WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_ATC upsell'), [('index') : 0], FailureHandling.STOP_ON_FAILURE)

subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

WebUI.takeScreenshot()

WebUI.verifyEqual(subTotal, 2 * upsell1Price)

WebUI.comment('Add second upsell to cart')

//(upsell2Price, upsell2Title) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_ATC upsell'), [('index') : 1], FailureHandling.STOP_ON_FAILURE)

//topItemTitle = WebUI.getText(findTestObject('AZ/Components/Cart overlay/items/top_item_title'))

//topItemPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/items/top_item_price')))

//subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

//WebUI.takeScreenshot()

//WebUI.verifyMatch(topItemTitle, upsell2Title, false)

//WebUI.verifyEqual(topItemPrice, upsell2Price)

//WebUI.verifyEqual(subTotal, (2 * upsell1Price) + upsell2Price)

List<WebElement> items = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/items (list)'), 
    2)

//WebUI.verifyEqual(items.size(), 2)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

