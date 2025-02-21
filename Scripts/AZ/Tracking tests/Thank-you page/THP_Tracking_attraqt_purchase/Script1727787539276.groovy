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

WebUI.callTestCase(findTestCase('AZ/E2E tests/Registration/_User Random new Registration'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.delay(1)

WebUI.refresh()

WebUI.click(findTestObject('AZ/Pages/HomePage/Recommendations/1st_product_card'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.click(findTestObject('AZ/Components/Header/cart-icon'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping address FR'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(8)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping method'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add paypal method payment'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(16)

WebUI.switchToWindowIndex(0 // S'assurer que tu es sur la bonne fenêtre
    )

WebUI.waitForPageLoad(10 // Attendre le chargement complet de la page
    )

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'attraqt_purchase\' && \n\t\tevent.quantity === 1 &&\n\t\tevent.locale === \'fr\'\n\n    );\n'

Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "attraqt_purchase" avec "fr" n\'a pas été trouvé dans la couche de données.'

assert event.event == 'attraqt_purchase' : 'L\'événement trouvé n\'est pas "attraqt_purchase".'

println('L\'événement de tracking \'attraqt_purchase\' avec \'fr\' a été trouvé avec succès dans la couche de données.')

// Basculer vers l'iframe contenant la modal
//WebUI.executeJavaScript("window.frames['ExitSurveyFR_VF'].focus();", null)
WebUI.switchToFrame(findTestObject('AZ/Pages/OrderSuccessPage/iframe_modal'), 10)

WebUI.refresh()

// Cliquer sur le bouton de fermeture de la modal
WebUI.executeJavaScript('document.querySelector(\'i.close\').click();', null)

//WebUI.click(findTestObject('Object Repository/AZ/Pages/OrderSuccessPage/button_close_modal'))
// Revenir à la fenêtre principale
WebUI.switchToDefaultContent()

//WebUI.executeJavaScript("document.querySelector('.close').click();", null)
WebUI.delay(7)

WebUI.verifyTextPresent('Avec Aroma-Zone', false)

WebUI.verifyTextPresent('Récapitulatif de la commande', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

