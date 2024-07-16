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

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_7'), 0)

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_7'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_hairSurvey'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'), 0)

WebUI.delay(1)

WebUI.switchToFrame(findTestObject('AZ/Pages/SurveysPages/HairRoutine/SwitchToIframe'), 0)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/ButtonStart'))

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Input_firstname'), 'Trilex Hair survey')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/SkinCare Survey/Button_next1'))

WebUI.delay(1)

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

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext5'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonHomemadeRecipes_no'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonSmell_no'))

WebUI.delay(1)

WebUI.setText(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Input_email'), 'alexandre.bluteau@aroma-zone.com')

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext6'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/Checkbox_validate'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonNext7'))

WebUI.click(findTestObject('AZ/Pages/SurveysPages/HairRoutine/ButtonResult'))

WebUI.delay(4)

WebUI.verifyTextPresent('Trilex Hair survey', false)

WebUI.delay(3)

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

WebUI.click(findTestObject('AZ/Pages/Cart/button_close'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_headerLogoAZ'))

WebUI.delay(2)

String script4 = '\n    return window.dataLayer.find(event => \n        event.event === \'survey_result\' && \n        event.event_name === \'impression_survey_result_recape_end\' && \n        event.event_action === \'survey_result_close_page\' \n    );\n'

// event.event === 'recipe' && event.event_label === \'recipe\' && \n        event.event_name === \'generic_event\'\n
Map event4 = ((WebUI.executeJavaScript(script4, null)) as Map)

// Vérifier que l'événement de tracking est présent dans la couche de données
assert event4 != null : 'L\'événement de tracking "survey_result" avec "impression_survey_result_recape_end" n\'a pas été trouvé dans la couche de données.'

assert event4.event_name == 'impression_survey_result_recape_end' : 'L\'événement trouvé n\'est pas "impression_survey_result_recape_end".'

println('L\'événement de tracking \'survey_result\' avec \'impression_survey_result_recape_end\' a été trouvé avec succès dans la couche de données.')

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

