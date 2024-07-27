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
import org.openqa.selenium.Cookie
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

'User must have billing address in Belgium'
user = GlobalVariable.user3

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.comment('ajout cookie ancien checkout')

// Récupérer le driver du navigateur
def driver = DriverFactory.getWebDriver()

// Créer un nouvel objet Cookie avec la nouvelle valeur
Cookie newCookie = new Cookie("new-checkout", "false")

// Ajouter le nouveau cookie au navigateur (cela remplacera l'ancien si il existait)
driver.manage().addCookie(newCookie)

'We select same country as default delivery address, so the address will be directly set on CheckoutPage'
WebUI.callTestCase(findTestCase('AZ/E2E tests/Locale Settings/_Change delivery country'), [('countryName') : 'Belgique'], FailureHandling.STOP_ON_FAILURE)

paymentWithNewCard(card)

paymentWithSavedBancontact(card)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

def paymentWithNewCard(Map card) {
    (cartTotalQuantityOfItems, _) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Go to checkout page'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

    WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Remove saved payment method'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_bancontactCard'))

    enterBancontactCardDetails(card)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/checkbox_save'))

    'Entered credit card details, before clicking on Pay button'
    WebUI.takeFullPageScreenshot()

    checkoutTotalString = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify pay button amount matches checkout total'), 
        [('payButton') : findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/button_pay')], FailureHandling.STOP_ON_FAILURE)

    checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/button_pay'))

    WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Submit 3DS password'), [('password') : card.password], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/OrderSuccessPage/_Check Order Success Page'), [('cartTotalQuantityOfItems') : cartTotalQuantityOfItems
            , ('checkoutTotalString') : checkoutTotalString, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Check amount and paymentState of last user order on CT'), [('checkoutTotal') : checkoutTotal, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

}

def paymentWithSavedBancontact(Map card) {
    (cartTotalQuantityOfItems, _) = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Go to checkout page'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Method/div_StandardDelivery'))

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/span_TCs_checkbox'))

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/radio_savedPaymentMethod'))

    checkoutTotalString = WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Verify pay button amount matches checkout total'), 
        [('payButton') : findTestObject('AZ/Pages/CheckoutPage/Payment Method/Saved Payment Method/button_pay')], FailureHandling.STOP_ON_FAILURE)

    checkoutTotal = CustomKeywords.'az.Parser.amountStringToBigDecimal'(checkoutTotalString)

    WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Saved Payment Method/button_pay'))

    WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Submit 3DS password'), [('password') : card.password], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/OrderSuccessPage/_Check Order Success Page'), [('cartTotalQuantityOfItems') : cartTotalQuantityOfItems
            , ('checkoutTotalString') : checkoutTotalString, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Check amount and paymentState of last user order on CT'), [('checkoutTotal') : checkoutTotal, ('email') : user.email], FailureHandling.STOP_ON_FAILURE)
}

def enterBancontactCardDetails(Map card) {
	WebUI.verifyElementVisible(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/input_cardNumber'))

	WebUI.scrollToElement(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/input_cardNumber'), 2)

	WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/input_cardNumber'), card.cardNumber)

	WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Payment Method/Bancontact/input_cardExpiryDate'), card.expirationDate)
}
