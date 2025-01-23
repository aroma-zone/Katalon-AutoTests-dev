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

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_skincareSurvey'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), 0)

WebUI.delay(1)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Input_firstname'), 'Trilex Skincare survey')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_next1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_Age'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonWhoAreYou_man'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/SkinChoice_normal'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonBeardChoice_rarely'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext3'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonMake-up_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSunlightExpose_rarely'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSkinQuality_clearskin'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext4'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonDoYouSmoke_regularly'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext5'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonFaceArea_1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonFaceArea_2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonFaceArea_3'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext6'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonConcern_1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonConcern_2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonConcern_3'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext7'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSpotsCauses'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext8'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonPreferenceTexture_cream'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSmell_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonAllergy_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonHomemadeRecipes_no'))

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Input_email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext9'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Checkbox_validate'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext10'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonResult'))

WebUI.delay(3)

WebUI.verifyTextPresent('Trilex Skincare Survey', false)

// Étape 1 : Récupérer l'URL actuelle
String currentUrl = WebUI.getUrl()

// Étape 2 : Vérifier que l'URL correspond
assert currentUrl == 'https://aroma-zone:avant-premiere@stage.aroma-host.net/surveyresults/skincare' : 'L\'URL du résultat survey actuelle est incorrecte : ' + currentUrl

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

