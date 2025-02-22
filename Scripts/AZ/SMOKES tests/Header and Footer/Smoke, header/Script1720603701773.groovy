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

WebUI.scrollToPosition(0, 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/a_FindYourRoutine'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/a_FindYourRoutine'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLinkNews'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLinkNews'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Header/favorites-icon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Components/Header/favorites-icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Header/account-icon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Components/Header/account-icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Header/cart-icon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Components/Header/cart-icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Components/Header/country-icon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Components/Header/country-icon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Menu_TopBar'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Nutrition'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Nutrition'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_beauté'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_beauté'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Huiles essentielles'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Huiles essentielles'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Ingrédients DIY'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Ingrédients DIY'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Conseils'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Conseils'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Maison'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Maison'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Recettes'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Recettes'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

