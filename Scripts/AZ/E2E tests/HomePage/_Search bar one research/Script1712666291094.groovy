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

WebUI.setText(findTestObject('AZ/Components/Search bar/input_search titem'), 'Huile essentielle Kunzea')

WebUI.delay(4)

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.SPACE))

WebUI.sendKeys(findTestObject('AZ/Components/Search bar/input_search titem'), Keys.chord(Keys.ENTER))

WebUI.delay(2)

WebUI.verifyTextPresent('Vous avez cherché : "Huile essentielle Kunzea "', false)

WebUI.click(findTestObject('AZ/Components/Search bar/a_FirstResult_Kunzea'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Huile essentielle Kunzea', false)

