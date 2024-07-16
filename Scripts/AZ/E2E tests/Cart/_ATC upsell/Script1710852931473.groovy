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

WebUI.comment('Precondition : Page with cart icon (header)')

WebUI.comment('Input: index (optional, otherwise 1st upsell is added)')

WebUI.click(findTestObject('AZ/Components/Header/account-icon'))

WebUI.delay(1)

if (!(WebUI.verifyElementPresent(findTestObject('AZ/Components/Cart overlay/div_header'), 1, FailureHandling.OPTIONAL))) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/Header/cart-icon'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/Cart overlay/div_header'), 2, FailureHandling.STOP_ON_FAILURE)
}

List<WebElement> upsellTitles = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/upsells/upsell_titles (list)'), 
    2)

List<WebElement> upsellPrices = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/upsells/upsell_prices (list)'), 
    2)

List<WebElement> upsellPrices2 = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/upsells/upsell_prices (list) 2'), 
    2)

List<WebElement> upsellATCButtons = WebUI.findWebElements(findTestObject('Object Repository/AZ/Components/Cart overlay/upsells/upsell_ATC_buttons (list)'), 
    2)

if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Cart overlay/span_subTotal'), 2, FailureHandling.OPTIONAL)) {
    cartSubTotalInitial = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))
} else {
    cartSubTotalInitial = 0
}

WebUI.delay(2)

WebUI.waitForElementPresent(findTestObject('AZ/Components/Cart overlay/upsells/upsell_prices (list)'), 0)

upsellPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(upsellPrices[index].text)

upsellTitle = upsellTitles[index].text

WebUI.delay(1)

(upsellATCButtons[index]).click()

////rajout////
//WebUI.click(findTestObject('AZ/Components/Cart overlay/button_delete_first_item'))
////rajout////
cartSubTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(WebUI.getText(findTestObject('AZ/Components/Cart overlay/span_subTotal')))

//TODO: check that upsell title is present on cart items list
//WebUI.verifyEqual(cartSubTotal, cartSubTotalInitial + upsellPrice)
KeywordUtil.logInfo(upsellPrice.toString())

KeywordUtil.logInfo(upsellTitle)

return [upsellPrice, upsellTitle]

