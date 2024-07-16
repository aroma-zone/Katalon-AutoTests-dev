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
import groovy.transform.Field

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Cart/_Empty cart'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('Add item to cart')

WebUI.callTestCase(findTestCase('AZ/E2E tests/HomePage/_ATC 1st product from recommendations'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/AZ/Components/Header/cart-icon'))

//Define variables scoped to the script
@Field List<WebElement> items
@Field List<WebElement> quantities
@Field List<WebElement> prices
@Field List<WebElement> increaseButtons
@Field List<WebElement> decreaseButtons

updateItems()

WebUI.takeScreenshot()

WebUI.verifyEqual(items.size(), 1)

WebUI.verifyEqual((quantities[0]).getAttribute('value'), 1)

subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

WebUI.verifyEqual(subTotal, CustomKeywords.'az.Parser.amountStringToBigDecimal'(prices[0].text))

WebUI.comment('Increase item quantity')

(increaseButtons[0]).click()

WebUI.delay(1)

WebUI.takeScreenshot()

//WebUI.verifyEqual((quantities[0]).getAttribute('value'), 2)

'Update subtotal'
subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

//WebUI.verifyEqual(subTotal, 2 * CustomKeywords.'az.Parser.amountStringToBigDecimal'(prices[0].text))

WebUI.comment('Decrease item quantity')

(decreaseButtons[0]).click()

WebUI.delay(1)

WebUI.takeScreenshot()

//WebUI.verifyEqual((quantities[0]).getAttribute('value'), 1)

WebUI.comment('Add second item to cart')

List<WebElement> upsellATCButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/upsells/upsell_ATC_buttons (list)'), 2)

(upsellATCButtons[0]).click()

WebUI.delay(1)

WebUI.takeFullPageScreenshot()

updateItems()

//WebUI.verifyEqual(items.size(), 2)

subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

expectedSubTotal = (CustomKeywords.'az.Parser.amountStringToBigDecimal'(prices[0].text) + CustomKeywords.'az.Parser.amountStringToBigDecimal'(
    prices[1].text))

//WebUI.verifyEqual(subTotal, expectedSubTotal, FailureHandling.CONTINUE_ON_FAILURE)
//WebUI.verifyEqual(subTotal, expectedSubTotal)

WebUI.comment('Decrease item with quantity 1, must be removed from cart')

(decreaseButtons[0]).click()

WebUI.delay(1)

WebUI.takeScreenshot()

updateItems()

//WebUI.verifyEqual(items.size(), 1)

subTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

//WebUI.verifyEqual(subTotal, CustomKeywords.'az.Parser.amountStringToBigDecimal'(prices[0].text))

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

void updateItems() {
	items = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/items (list)'), 2)
	
	quantities = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/item_quantity_inputs (list)'), 2)
	
	prices = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/item_prices (list)'), 2)
	
	increaseButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/item_increase_buttons (list)'), 2)
	
	decreaseButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/items/item_decrease_buttons (list)'), 2)
}