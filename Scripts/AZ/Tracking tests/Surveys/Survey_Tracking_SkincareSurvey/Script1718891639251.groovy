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

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Recettes'), 0)

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Conseils'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_skincareSurvey'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), 0)

WebUI.delay(5)

String scriptstart = '\n    if (typeof window.dataLayer === "undefined" || !Array.isArray(window.dataLayer)) {\n        return null;\n    }\n    return window.dataLayer.find(event => \n        event.event === "survey_start" && \n        event.event_name === "survey_start" && \n        event.event_label === "survey_skincare" && \n        event.event_action === "survey"\n    );\n'

Map event0 = WebUI.executeJavaScript(scriptstart, null)

assert event0 != null : 'L\'événement de tracking \'survey_start\' n\'a pas été trouvé dans dataLayer.'

assert event0.get('event_name') == 'survey_start' : 'L\'événement trouvé n\'est pas \'survey_start\'.'

println('L\'événement \'survey_start\' a été trouvé avec succès : ' + event0)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Input_firstname'), 'Trilex Skincare survey')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_next1'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_Age'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonWhoAreYou_man'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext2'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/SkinChoice_normal'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonBeardChoice_rarely'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext3'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonMake-up_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSunlightExpose_rarely'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonSkinQuality_clearskin'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext4'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonDoYouSmoke_regularly'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext5'))

WebUI.delay(1)

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

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext9'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Checkbox_validate'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext10'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonResult'))

WebUI.delay(3)

WebUI.verifyTextPresent('Trilex Skincare Survey', false)

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'skincare_diag\' && \n        event.event_name === \'impression_survey_recape\' && \n        event.event_action === \'survey_answer\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "skincare_diag" avec "impression_survey_recape" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'impression_survey_recape' : 'L\'événement trouvé n\'est pas "impression_survey_recape".'

println('L\'événement de tracking \'skincare_diag\' avec \'impression_survey_recape\' a été trouvé avec succès dans la couche de données.')

// Exécuter du JavaScript pour récupérer la couche de données
String script2 = '\n    return window.dataLayer.find(event => \n        event.event === \'skincare_diag\' && \n        event.event_name === \'impression_skincare_recape\' && \n        event.event_action === \'impression\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event2 = ((WebUI.executeJavaScript(script2, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event2 != null : 'L\'événement de tracking "skincare_diag" avec "impression_skincare_recape" n\'a pas été trouvé dans la couche de données.'

assert event2.event_name == 'impression_skincare_recape' : 'L\'événement trouvé n\'est pas "skincare_diag".'

println('L\'événement de tracking \'skincare_diag\' avec \'impression_skincare_recape\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Button_Add_Routine_to_card'))

WebUI.delay(3)

String script3 = '\n    return window.dataLayer.find(event => \n        event.event === \'skincare_diag\' && \n        event.event_name === \'skincare_add_to_cart\' && \n        event.event_action === \'add\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event3 = ((WebUI.executeJavaScript(script3, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event3 != null : 'L\'événement de tracking "skincare_diag" avec "skincare_add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event3.event_name == 'skincare_add_to_cart' : 'L\'événement trouvé n\'est pas "skincare_add_to_cart".'

println('L\'événement de tracking \'skincare_diag\' avec \'skincare_add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/Pages/Cart/button_close'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.delay(6)

String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'skincare_diag\' && \n        event.event_action === \'skincare_recape_close_page\' && \n        event.event_name === \'impression_skincare_recape_end\'\n    );\n'

//event.event === \'skincare_diag\' && \n && \n        event.event_action === \'skincare_recape_close_page\' \n
Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données 
assert event4 != null : 'L\'événement de tracking "skincare_diag" avec "impression_skincare_recape_end" n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'impression_skincare_recape_end' : 'L\'événement trouvé n\'est pas "impression_skincare_recape_end".'

assert event4.event_action == 'skincare_recape_close_page' : 'L\'action de l\'événement n\'est pas "skincare_recape_close_page".'

println('L\'événement de tracking \'skincare_diag\' avec \'impression_skincare_recape_end\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

