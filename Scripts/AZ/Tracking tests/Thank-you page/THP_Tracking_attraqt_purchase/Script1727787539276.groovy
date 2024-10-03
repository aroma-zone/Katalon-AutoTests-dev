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

WebUI.callTestCase(findTestCase('AZ/E2E tests/Registration/_User Random Registration'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button4'), 0)

WebUI.click(findTestObject('AZ/Pages/HomePage/Recommendations/1st_product_card'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.click(findTestObject('AZ/Components/Header/cart-icon'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping address FR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping method'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add paypal method payment'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(9)

WebUI.executeJavaScript("document.querySelector('.close').click();", null)

//WebUI.click(findTestObject('AZ/Pages/OrderSuccessPage/button_close_modal'))

WebUI.refresh()

WebUI.delay(1)

WebUI.verifyTextPresent('Avec Aroma-Zone, vous faites le choix d\'une entreprise française !', false)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'attraqt_purchase\' && \n        event.quantity === \'1\' && \n         event.locale === \'fr\'\n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "attraqt_purchase" avec "quantity" n\'a pas été trouvé dans la couche de données.'

assert event.event == 'attraqt_purchase' : 'L\'événement trouvé n\'est pas "attraqt_purchase".'

println('L\'événement de tracking \'attraqt_purchase\' avec \'quantity\' a été trouvé avec succès dans la couche de données.')

WebUI.verifyTextPresent('Récapitulatif de la commande', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)
