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

WebUI.callTestCase(findTestCase('AZ/E2E tests/Registration/_User Random new Registration'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Recettes'), 0)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_FindYourRoutine'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_SerumSurvey'))

WebUI.delay(2)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/Serum Survey/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.delay(5)

WebUI.switchToDefaultContent()

WebUI.delay(1)

String scriptstart = '\n    if (typeof window.dataLayer === "undefined" || !Array.isArray(window.dataLayer)) {\n        return null;\n    }\n    return window.dataLayer.find(event => \n        event.event === "survey_start" && \n        event.event_name === "survey_start" && \n        event.event_label === "survey_serum" && \n        event.event_action === "survey"\n    );\n'

Map event0 = WebUI.executeJavaScript(scriptstart, null)

assert event0 != null : 'L\'événement de tracking \'survey_start\' n\'a pas été trouvé dans dataLayer.'

assert event0.get('event_name') == 'survey_start' : 'L\'événement trouvé n\'est pas \'survey_start\'.'

println('L\'événement \'survey_start\' a été trouvé avec succès : ' + event0)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/Serum Survey/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Input_firstname'), 'Trilex Serum survey')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_next1'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_Age'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonWhoAreYou_man'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairChoice_curly hair'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/CurlyHair_tight curls'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/HairLength_medium'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonMake-up_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonSunlightExpose_frequently'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonDoYouSmoke_regulary'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonConcern_1'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonConcern_2'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext3'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonAllergy_no'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNovice_SayAll'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext4'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext5'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext6'))

WebUI.delay(2)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Input_Email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonNext7'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/Checkbox_validate'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonNext9'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Serum Survey/ButtonResult'))

WebUI.delay(14)

WebUI.verifyTextPresent('Votre routine sérum', false)

// Étape 1 : Récupérer l'URL actuelle
String currentUrl = WebUI.getUrl()

// Étape 2 : Vérifier que l'URL correspond
assert currentUrl == 'https://aroma-zone:avant-premiere@stage.aroma-host.net/surveyresults/serum'

// Exécuter du JavaScript pour récupérer la couche de données
String script = '\n    return window.dataLayer.find(event => \n        event.event === \'survey\' && \n        event.event_name === \'impression_survey_recape\' && \n        event.event_action === \'survey_answer\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event = ((WebUI.executeJavaScript(script, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event != null : 'L\'événement de tracking "survey" avec "impression_survey_recape" n\'a pas été trouvé dans la couche de données.'

assert event.event_name == 'impression_survey_recape' : 'L\'événement trouvé n\'est pas "impression_survey_recape".'

println('L\'événement de tracking \'survey\' avec \'impression_survey_recape\' a été trouvé avec succès dans la couche de données.')

// Exécuter du JavaScript pour récupérer la couche de données
String script2 = '\n    return window.dataLayer.find(event => \n        event.event === \'survey_result\' && \n        event.event_name === \'impression_survey_result_recape_start\' && \n        event.event_action === \'survey_result_start_page\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event2 = ((WebUI.executeJavaScript(script2, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event2 != null : 'L\'événement de tracking "survey_result" avec "impression_skincare_recape" n\'a pas été trouvé dans la couche de données.'

assert event2.event_name == 'impression_survey_result_recape_start' : 'L\'événement trouvé n\'est pas "impression_survey_result_recape_start".'

println('L\'événement de tracking \'survey_result\' avec \'impression_survey_result_recape_start\' a été trouvé avec succès dans la couche de données.')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/Button_Add_Routine_to_card'))

WebUI.delay(3)

String script3 = '\n    return window.dataLayer.find(event => \n        event.event === \'survey_result\' && \n        event.event_name === \'survey_result_add_to_cart\' && \n        event.event_action === \'add\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event3 = ((WebUI.executeJavaScript(script3, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event3 != null : 'L\'événement de tracking "survey_result" avec "survey_result_add_to_cart" n\'a pas été trouvé dans la couche de données.'

assert event3.event_name == 'survey_result_add_to_cart' : 'L\'événement trouvé n\'est pas "survey_result_add_to_cart".'

println('L\'événement de tracking \'survey_result\' avec \'survey_result_add_to_cart\' a été trouvé avec succès dans la couche de données.')

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Components/Cart overlay/button_Checkout'))

WebUI.switchToDefaultContent()

WebUI.delay(5)

//WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_FindYourRoutine'))
String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'survey_result\' && \n        event.event_name === \'impression_survey_result_recape_end\' && \n        event.event_action === \'survey_result_close_page\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event4 != null : 'L\'événement de tracking "survey_result" avec "impression_survey_result_recape_end" n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'impression_survey_result_recape_end' : 'L\'événement trouvé n\'est pas "impression_survey_result_recape_end".'

println('L\'événement de tracking \'survey_result\' avec \'impression_survey_result_recape_end\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

