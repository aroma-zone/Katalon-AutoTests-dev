import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.comment('Precondition: CheckoutPage')

WebUI.comment('Input: promoCode {String}')

promoInput = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Mobile)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/input_promoCode (Desktop)'))

promoApplyButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Mobile)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_applyPromoCode (Desktop)'))

promoRemoveButton = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Mobile)'), 
    findTestObject('Object Repository/AZ/Pages/CheckoutPage/Cart Preview/Promo Code/button_removePromoCode (Desktop)'))

'Promo code may still be applied if previous checkout didn\'t succeed'
if (WebUI.verifyElementPresent(promoRemoveButton, 1, FailureHandling.OPTIONAL)) {
    WebUI.click(promoRemoveButton)
}

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Input_PromoCode'), '10-PERC-OFF')

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Button_applyPromoCode'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/CheckoutPage/Button_removePromoCode'), 0)

