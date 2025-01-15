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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.HomePage_IT)

WebUI.delay(2)

'Close Cookies popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Cookies popup/button_accept_v2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Cookies popup/button_accept_v2'), FailureHandling.STOP_ON_FAILURE)
}

'Scroll to bottom so Newsletter popup is shown'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

'Close newsletter popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Newsletter popup/button_close'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Newsletter popup/button_close'), FailureHandling.STOP_ON_FAILURE)
}

