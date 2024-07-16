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

WebUI.comment('Precondition: CheckoutPage')

WebUI.comment('Inputs: cartSubTotal, promoCodePercentage (optional, default 0)')

//checkoutSubTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Mobile)'), 
        //findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

checkoutSubTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)'),
	findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/span_subtotal (Desktop)')))

BigDecimal checkoutSubTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutSubTotalString)

//WebUI.verifyEqual(checkoutSubTotal, cartSubTotal)

BigDecimal selectedDeliveryPrice

if (WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_SelectedDeliveryPrice'), 1, FailureHandling.OPTIONAL)) {
    selectedDeliveryPriceString = WebUI.getText(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_SelectedDeliveryPrice'))

    if (selectedDeliveryPriceString ==~ '.*€') {
        selectedDeliveryPrice = CustomKeywords.'az.Parser.amountStringToBigDecimal'(selectedDeliveryPriceString)
    } else {
        'Free shipping'
        selectedDeliveryPrice = 0
    }
} else {
    'No shipping method selected'
    selectedDeliveryPrice = 0
}

discountFactor = ((100 - promoCodePercentage) / 100)

BigDecimal expectedTotalAmount = (checkoutSubTotal + selectedDeliveryPrice) * discountFactor

'It seems that \'floor\' rounding is used for total amount'
expectedTotalAmount = (Math.floor(100 * expectedTotalAmount) / 100)

KeywordUtil.logInfo('Subtotal = ' + checkoutSubTotal.toString())

KeywordUtil.logInfo('Delivery price = ' + selectedDeliveryPrice.toString())

KeywordUtil.logInfo(('Promo code discount percentage = ' + promoCodePercentage.toString()) + '%')

KeywordUtil.logInfo('Expected total = ' + expectedTotalAmount.toString())

checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)'), 
        findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

//checkoutTotalString = WebUI.getText(CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Mobile)'),
	//findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/h3_total (Desktop)')))

BigDecimal checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

//WebUI.verifyEqual(checkoutTotal, expectedTotalAmount, FailureHandling.STOP_ON_FAILURE)
