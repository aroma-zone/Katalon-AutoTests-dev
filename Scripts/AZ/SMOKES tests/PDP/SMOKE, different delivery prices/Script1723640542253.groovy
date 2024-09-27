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

user = GlobalVariable.user1

WebUI.navigateToUrl('https://stage.aroma-host.net/info/fiche-technique/serum-concentre-collagene-vegan-1-5')

WebUI.delay(1)

WebUI.scrollToPosition(100, 100)

WebUI.verifyTextPresent('Plus que 35,00 € pour la livraison gratuite !', false)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonIncrease'))

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonIncrease'))

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.delay(1)

WebUI.scrollToPosition(150, 150)

WebUI.delay(1)

WebUI.verifyTextPresent('Plus que 5,15 € pour la livraison gratuite !', false)

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonIncrease'))

WebUI.click(findTestObject('AZ/Pages/PDP/ButtonAddToCart'))

WebUI.verifyTextPresent('Vous avez atteint la livraison gratuite !', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

