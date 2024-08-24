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

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/Button_BackToTop'), 0)

WebUI.scrollToPosition(5750, 5750)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_faq'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_faq'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_shippingFees'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_shippingFees'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_securePayment'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_securePayment'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_freeShippingFees'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_freeShippingFees'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_customerService'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_customerService'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_qualityCommitments'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_qualityCommitments'), 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_instagramIcon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Contents Link Pages/a_instagramIcon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_youtubeIcone'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Contents Link Pages/a_youtubeIcone'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_facebookIcon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Contents Link Pages/a_facebookIcon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_tiktokIcon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Contents Link Pages/a_tiktokIcon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_pinterestIcon'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Contents Link Pages/a_pinterestIcon'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/Bloc_SubscribeNewsletters'), 0)

WebUI.setText(findTestObject('AZ/Pages/Header_and_Footer/Footer/input_email_newsletters'), 'Trilex-quality@gmail.com')

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/Button_submit_newsletters'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.verifyTextPresent('Merci pour votre inscription !', false)

WebUI.verifyTextPresent('Vous recevrez prochainement un email de confirmation de la création de votre compte. ', false)

WebUI.scrollToPosition(5900, 5900)

WebUI.verifyTextPresent('Services et conseils', false)

WebUI.verifyTextPresent('Nos engagements', false)

WebUI.verifyTextPresent('Notre identité', false)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_who are us'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_who are us'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_legal notice'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_legal notice'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_site map'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_site map'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_workshop shop'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_workshop shop'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_committed producers'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_committed producers'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_recruitment'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_recruitment'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_website reinvented'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/Header_and_Footer/Footer/footer_columns/a_website reinvented'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

