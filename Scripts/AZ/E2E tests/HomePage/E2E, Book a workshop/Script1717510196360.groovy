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

user = GlobalVariable.userworkshop

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_container book a workshop'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a__bookWorkshop'))

WebUI.delay(2)

WebUI.switchToFrame(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/switch to iframe'), 0)

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/li_Shop_AixPce_choice'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/li_Beauty duo_firstChoice'))

WebUI.delay(2)

//WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Button_NoPreference'))
WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_submit'))

WebUI.delay(2)

// Vérifier la présence du message indiquant qu'il n'y a aucun atelier disponible
boolean noWorkshopMessageVisible = WebUI.verifyTextPresent('Il n\'y a rien de disponible pour ce choix.', false, FailureHandling.OPTIONAL)

if (noWorkshopMessageVisible) {
    // Clôturer le test case avec succès si le message est trouvé
    WebUI.comment('Aucun atelier disponible pour la date sélectionnée, le test se termine.')
} else {
    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/li_event_firstChoice'))

    WebUI.setText(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Input_firstName'), 'AZ_test_to_delete')

    WebUI.setText(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Input_LastName'), 'AZ_test_to_delete')

    WebUI.setText(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Input_emailClient'), 'AZ_test_to_delete@gmail.com')

    WebUI.setText(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Input_mobileClient'), '06 80 62 93 19')

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_submit'))

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Button_emailReminder_no'))

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_yesAdult'))

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Button_notPregnant'))

    WebUI.delay(1)

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_submit'))

    WebUI.delay(3)

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Checkbox_terms_conditions'))

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/Checkbox_cgv'))

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_submit'))

    WebUI.delay(3)

    WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/Book Workshop Modale/button_submit'))

    WebUI.switchToDefaultContent()

    WebUI.delay(3)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add shipping address FR'), [:], FailureHandling.STOP_ON_FAILURE)

    WebUI.delay(4)

    WebUI.callTestCase(findTestCase('AZ/E2E tests/Checkout/_Add paypal method payment'), [('paypalAccount_email') : 'az-test-paypal@personal.example.com'
            , ('paypalAccount_password') : '?J@9!tB{'], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

