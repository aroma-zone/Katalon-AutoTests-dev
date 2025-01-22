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

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Conseils'), 0)

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Conseils'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_hairSurvey'))

WebUI.delay(1)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/HairRoutine/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Input_firstname'), 'Trilex Hair survey')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_next1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_Age'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonWhoAreYou_man'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairChoice_curly hair'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/CurlyHair_tight curls'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairLength_medium'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairWashingFrequency_3atWeek'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairAfterShampooing_greasy'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonConcern_1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonConcern_2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonConcern_3'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext3'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext4'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonPreferenceTexture_cream'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonAllergy_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/CheckBox_FirstApplication'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext5'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonHomemadeRecipes_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonSmell_no'))

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Input_email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext6'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Checkbox_validate'))

WebUI.delay(3)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext7'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonResult'))

WebUI.delay(4)

WebUI.verifyTextPresent('Trilex Hair survey', false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

