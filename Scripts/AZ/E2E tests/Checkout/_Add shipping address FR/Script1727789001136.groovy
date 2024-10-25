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


// Vérifier si le champ d'adresse (ex. champ "addressLine1") est pré-rempli
String addressValue = WebUI.getAttribute(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/input_StreetName'), 'value')

// Si le champ est pré-rempli (c'est-à-dire que sa valeur n'est pas vide)
if (addressValue != null && addressValue.trim() != '') {
	// Continuer en cliquant sur le bouton (ex. bouton "Continuer" ou "Suivant")
	WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/button_submit'))
} else {
	// Appeler le test case qui remplit le formulaire
	WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/input_StreetName'), '40 rue Floralia')

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/input_PostalCode'), '13009')

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/input_city'), 'Marseille')

WebUI.setText(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/input_phone'), '0680629319')

WebUI.click(findTestObject('AZ/Pages/CheckoutPage/Shipping Address/button_submit'), FailureHandling.STOP_ON_FAILURE)
}


