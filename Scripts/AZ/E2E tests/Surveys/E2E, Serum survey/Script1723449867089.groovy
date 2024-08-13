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

WebUI.delay(1)

WebUI.navigateToUrl('https://dev.aroma-host.net/survey/serum')

WebUI.delay(2)

//WebUI.verifyElementPresent(findTestObject('AZ/Pages/SurveysPages/Serum Survey/TitleSerumSurvey'), 0)
//WebUI.delay(1)
WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/Serum Survey/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonStart'))

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Input_firstname'), 'Trilex Serum survey')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Button_Age'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonWhoAreYou_man'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/SkinChoice_Normal'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/NormalSkin_subjectToImperfactions'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonMake-up_no'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonSunlightExpose_frequently'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonDoYouSmoke_regulary'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonConcern_1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonConcern_2'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext3'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext4'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonAllergy_no'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNovice_SayAll'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext5'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext6'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext7'))

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Input_Email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext8'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Checkbox_validate'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonResult'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonSend'))

WebUI.delay(3)

WebUI.verifyTextPresent('Sérum matin', false)

WebUI.verifyTextPresent('Sérum soir', false)

WebUI.verifyTextPresent('Crème visage', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

