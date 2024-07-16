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

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_8'))

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/a_AdviceListingPage_beauty'))

WebUI.waitForPageLoad(0)

// Extraction de contenu (CSR)
// navbar
String navbarContentCSR = WebUI.getText(findTestObject('Page_Target/Text_Element'))

// Image (par exemple, l'URL de l'image)
String imageSrcCSR = WebUI.getAttribute(findTestObject('AZ/Pages/ALP/BeautyAdviceBanner'), 'src')

// Bouton (texte du bouton)
String buttonTextCSR = WebUI.getText(findTestObject('Page_Target/Button_Element'))

// Concaténation des contenus
String combinedContentCSR = (navbarContentCSR + imageSrcCSR) + buttonTextCSR

// Actualiser la page pour utiliser SSR
WebUI.refresh()

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

