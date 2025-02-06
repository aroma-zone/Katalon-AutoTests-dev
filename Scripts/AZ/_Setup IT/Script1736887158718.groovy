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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebHelper
import org.openqa.selenium.WebElement
import org.openqa.selenium.JavascriptExecutor

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.SEO_HomePage_IT)

WebUI.delay(10)

TestObject buttonSalva = findTestObject('AZ/Components/country selection popup IT/button_salva')
//WebUI.focus(findTestObject('AZ/Components/country selection popup IT/button_salva'))

//if (WebUI.verifyElementPresent(findTestObject('AZ/Components/country selection popup IT/button_salva'), 5, FailureHandling.OPTIONAL)) {
//    WebUI.click(findTestObject('AZ/Components/Delivery country selection popup IT/button_salva'),FailureHandling.CONTINUE_ON_FAILURE)
//}

if (WebUI.verifyElementPresent(buttonSalva, 5, FailureHandling.OPTIONAL)) {
	WebElement element = WebHelper.findWebElement(buttonSalva, 5)
	JavascriptExecutor executor = (JavascriptExecutor) WebUI.getWebDriver()
	executor.executeScript("arguments[0].click();", element)
}

'Close Cookies popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Cookies popup/button_accept_v2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Cookies popup IT/button_accept_v2'), FailureHandling.STOP_ON_FAILURE)
}

'Scroll to bottom so Newsletter popup is shown'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

'Close newsletter popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Newsletter popup/button_close'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Newsletter popup/button_close'), FailureHandling.STOP_ON_FAILURE)
}

