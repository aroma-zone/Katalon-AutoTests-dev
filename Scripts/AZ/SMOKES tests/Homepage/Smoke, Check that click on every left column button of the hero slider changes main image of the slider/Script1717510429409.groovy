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

// Basic Auth not working on Firefox
//WebUI.openBrowser('')
//WebUI.authenticate('https://qa.aroma-host.net/', 'aroma-zone', '62efff1c5785f749', 12)  // doesn't work for Chrome nor Firefox
//WebUI.openBrowser('https://admin:admin@the-internet.herokuapp.com/basic_auth')  // works on Chrome and Firefox
//WebUI.openBrowser('https://aroma-zone:62efff1c5785f749@qa.aroma-host.net/')  // works on Chrome but not on Firefox
// Browser is opened on Test Suite setUp()
WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.SEO_HomePage_FR)

WebUI.verifyElementVisible(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide1'))

WebUI.verifyElementVisible(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide2'))

WebUI.verifyElementVisible(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide3'))

WebUI.verifyElementVisible(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide4'))

WebUI.click(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide1'))

WebUI.delay(2)

WebUI.verifyTextPresent('Soins cheveux naturels', false)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.click(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide4'))

WebUI.delay(2)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/Serum Survey/SwitchToIframe'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonStart'), 0)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Icone_close'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.click(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide2'))

WebUI.click(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.click(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide3'))

WebUI.click(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'))

WebUI.verifyTextPresent('Acide hyaluronique - 60 gélules - Complément alimentaire', false)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

