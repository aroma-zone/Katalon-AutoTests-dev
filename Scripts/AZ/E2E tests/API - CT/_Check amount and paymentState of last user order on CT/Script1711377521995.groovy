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

WebUI.comment('ajout cookie ancien checkout')

// Récupérer le driver du navigateur
def driver = DriverFactory.getWebDriver()

// Créer un nouvel objet Cookie avec la nouvelle valeur
Cookie newCookie = new Cookie("new-checkout", "false")

// Ajouter le nouveau cookie au navigateur (cela remplacera l'ancien si il existait)
driver.manage().addCookie(newCookie)

WebUI.comment('Inputs: checkoutTotal, email')

jsonResponse = WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Get last user order details from CT'), [('email') : email], 
    FailureHandling.STOP_ON_FAILURE)

//WebUI.verifyEqual(jsonResponse.totalPrice.centAmount, checkoutTotal * 100, FailureHandling.STOP_ON_FAILURE)

long startTime = System.currentTimeMillis()

timeoutMs = 30000

'\'paymentState\' attribute can take few seconds to be populated on CT'
while ((jsonResponse.paymentState === null) && ((System.currentTimeMillis() - startTime) < timeoutMs)) {
    'delay in seconds'
    WebUI.delay(5)

    jsonResponse = WebUI.callTestCase(findTestCase('AZ/E2E tests/API - CT/_Get last user order details from CT'), [('email') : email], 
        FailureHandling.STOP_ON_FAILURE)
}

//WebUI.verifyEqual(jsonResponse.paymentState, 'Paid', FailureHandling.STOP_ON_FAILURE)

