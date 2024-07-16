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
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('google.fr')

WebUI.click(findTestObject('Google search/button_yes_modal'))

WebUI.setText(findTestObject('Google search/search_bar'), 'Huile essentielle Ravintsara Aroma')

WebUI.sendKeys(findTestObject('Google search/search_bar'), Keys.chord(Keys.ENTER))

WebUI.delay(1)

WebUI.click(findTestObject('Google search/Link_first_sponsored_product'))

WebUI.delay(1)

// Récupérer la liste des identifiants des onglets ouverts
Set<String> handles = DriverFactory.getWebDriver().getWindowHandles()

// Convertir le Set en List
List<String> handlesList = new ArrayList<String>(handles)

// Basculer sur le nouvel onglet (le dernier dans la liste)
String newTab = handlesList[handlesList.size() - 1]
DriverFactory.getWebDriver().switchTo().window(newTab)

// Fermer l'onglet précédent (le premier dans la liste)
String oldTab = handlesList[0]
DriverFactory.getWebDriver().switchTo().window(oldTab)
DriverFactory.getWebDriver().close()

// Basculer à nouveau sur le nouvel onglet
DriverFactory.getWebDriver().switchTo().window(newTab)

'Close Cookies popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Cookies popup/button_accept'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Cookies popup/button_accept'), FailureHandling.STOP_ON_FAILURE)
}

'Scroll to bottom so Newsletter popup is shown'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

'Close newsletter popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Newsletter popup/button_close'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Newsletter popup/button_close'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), 0)

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.delay(1)

WebUI.verifyTextPresent('Retrouvez nos sélections du moment !', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

