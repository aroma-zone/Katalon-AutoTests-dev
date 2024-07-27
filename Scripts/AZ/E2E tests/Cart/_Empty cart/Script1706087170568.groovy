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
import org.openqa.selenium.Cookie
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.comment('Precondition : Page with cart icon (header)')

if (!(WebUI.verifyElementPresent(findTestObject('AZ/Components/Cart overlay/div_header'), 1, FailureHandling.OPTIONAL))) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/Header/cart-icon'))

    WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/Cart overlay/div_header'), 2, FailureHandling.STOP_ON_FAILURE)
}

'Cart before emptying'
WebUI.takeScreenshot()

'Remove all items from cart (if any)'
while (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/Cart overlay/items/top_item_remove_button'), 
    1, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/Cart overlay/items/top_item_remove_button'))

    'wait needed for headless'
    WebUI.delay(1)
}

'Cart after emptying'
WebUI.takeScreenshot()

WebUI.verifyElementPresent(findTestObject('AZ/Components/Cart overlay/div_empty-cart'), 2)

WebUI.comment('ajout cookie ancien checkout')

// Récupérer le driver du navigateur
def driver = DriverFactory.getWebDriver()

// Créer un nouvel objet Cookie avec la nouvelle valeur
Cookie newCookie = new Cookie("new-checkout", "false")

// Ajouter le nouveau cookie au navigateur (cela remplacera l'ancien si il existait)
driver.manage().addCookie(newCookie)

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_close'))

