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

WebUI.comment('Precondition: OrderSuccessPage')

WebUI.comment('Inputs: cartTotalQuantityOfItems {int}, checkoutTotalString {String}, email {String}')

WebUI.waitForPageLoad(0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/OrderSuccessPage/div_thankYou_banner'), 5)

'Order Success Page'
WebUI.takeFullPageScreenshot()

'On first client order, a survey popup is visible (always present on DOM)'
if (WebUI.verifyElementVisible(findTestObject('Object Repository/AZ/Components/Survey popup/button_close'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/Survey popup/button_close'))
}

WebUI.verifyElementPresent(findTestObject('AZ/Pages/OrderSuccessPage/div_orderFollowUp'), 2)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/OrderSuccessPage/div_orderReview'), 2)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/OrderSuccessPage/div_orderInformation'), 2)

followUpEmailSpan = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/OrderSuccessPage/span_orderFollowUp_email (Mobile)'), 
    findTestObject('AZ/Pages/OrderSuccessPage/span_orderFollowUp_email (Desktop)'))

followUpEmail = WebUI.getText(followUpEmailSpan)

WebUI.verifyMatch(followUpEmail, email, false)

List<WebElement> items = WebUI.findWebElements(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/OrderSuccessPage/items (list) (Mobile)'), 
        findTestObject('AZ/Pages/OrderSuccessPage/items (list) (Desktop)')), 2)

List<WebElement> itemQuantities = WebUI.findWebElements(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject(
            'Object Repository/AZ/Pages/OrderSuccessPage/item_quantities (list) (Mobile)'), findTestObject('Object Repository/AZ/Pages/OrderSuccessPage/item_quantities (list) (Desktop)')), 
    2)

totalQuantityOfItems = 0

for (int i = 0; i < items.size(); i++) {
    quantity = ((itemQuantities[i].text) as Integer)

    totalQuantityOfItems += quantity
}

WebUI.verifyEqual(totalQuantityOfItems, cartTotalQuantityOfItems, FailureHandling.STOP_ON_FAILURE)

orderSuccessTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('AZ/Pages/OrderSuccessPage/h4_total (Mobile)'), 
        findTestObject('AZ/Pages/OrderSuccessPage/h4_total (Desktop)')))

//WebUI.verifyMatch(orderSuccessTotalString, checkoutTotalString, false)
WebUI.comment('Possible improvement: Verify address')

