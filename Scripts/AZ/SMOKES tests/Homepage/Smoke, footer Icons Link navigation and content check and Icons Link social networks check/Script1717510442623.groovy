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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/ButtonItemReviewed_1'), 0)

WebUI.delay(3)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_faq'))

WebUI.delay(2)

WebUI.delay(2)

WebUI.switchToFrame(findTestObject('AZ/Pages/Header_and_Footer/Footer/SwitchToIframe'), 0)

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQ_verifyText_1'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQ_verifyText_2'), 0)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQDelivery_choice'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQButton_accept'))

WebUI.delay(3)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQBackToHome_choice'))

WebUI.delay(3)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/FAQ_verifyTextBot_1'), 0)

WebUI.delay(3)

WebUI.switchToDefaultContent()

WebUI.scrollToElement(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_freeShippingFees'), 0)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_shippingFees'))

//create variable to check text on page
def content = WebUI.getText(findTestObject('AZ/Pages/Contents Link Pages/feeShippingPage_text'))

//check Frais de port et livraison standard
WebUI.verifyMatch(content, '.*Service de livraison en France métropolitaine.* .*Le Click & Collect est gratuit, les frais de port vous sont offerts dès 39€ de commande en livraison en France.* .*Livraison standard.* .*Colissimo : Livraison dans un délai indicatif de 48h en jours ouvrés après la prise en charge du colis par le transporteur.* .*Livraison dans votre boîte à lettres. En cas d’absence, vous avez le choix, en vous connectant sur le site de La Poste, entre une nouvelle date de livraison dans les 6 jours ouvrés ou un dépôt de votre colis dès le lendemain 15h dans le bureau de poste de votre choix. Par défaut, votre commande est envoyée dans votre bureau de poste de rattachement et est récupérable sous un délai de 15 jours.* .*Vous pouvez suivre à tout moment l’acheminement de votre colis sur www.laposte.fr et vous recevrez un email vous informant de sa livraison.*', 
    true)

WebUI.scrollToPosition(100, 100)

//check Livraison express
//WebUI.verifyMatch(content, '.*Livraison Express.* .*Chronopost : Livraison dans un délai indicatif de 24h en jours ouvrés après la prise en charge du colis par le transporteur.* .*En commandant avant 15h, vos produits sont livrés dès le lendemain.  Vous pouvez suivre à tout moment l’acheminement de votre colis sur www.chonopost.fr et vous recevrez un email vous informant de sa livraison.*', true)
WebUI.scrollToPosition(450, 450)

WebUI.delay(1)

//check Livraison point de retrait standard
WebUI.verifyMatch(content, '.*Livraison dans votre boîte à lettres. En cas d’absence, vous avez le choix, en vous connectant sur le site de La Poste, entre une nouvelle date de livraison dans les 6 jours.* .*ouvrés ou un dépôt de votre colis dès le lendemain 15h dans le bureau de poste de votre choix. Par défaut, votre commande est envoyée dans votre bureau de poste de.* .*Livraison point de retrait standard.* .*Vous pouvez suivre à tout moment l’acheminement de votre colis sur www.laposte.fr et vous recevrez un email vous informant de sa livraison.*', 
    true)

WebUI.delay(1)

WebUI.scrollToPosition(700, 700)

WebUI.delay(2)

//check Retrait en boutique Aroma-Zone
WebUI.verifyMatch(content, '.*Retrait en boutique Aroma-Zone.*', true)

//.*En commandant avant 15h, vos produits sont livrés dès le lendemain.*
WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_securePayment'))

//WebUI.verifyMatch(content, '', true)
WebUI.verifyMatch(content, '.*Paiement sécurisé.*', true)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_customerService'))

WebUI.delay(1)

//create variable to check text on page
def content3 = WebUI.getText(findTestObject('AZ/Pages/Contents Link Pages/feeShippingPage_text'))

//WebUI.verifyMatch(content, '', true)
WebUI.verifyMatch(content3, '.*Contacter le Service Clients.* .* est à votre disposition pour toute question concernant votre compte client, vos commandes, nos boutiques, pour vous.* .*Sur quel sujet pouvons-nous vous aider ?.*', 
    true)

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Footer/reinsurance__item/a_qualityCommitments'))

WebUI.delay(1)

//create variable to check text on page
def content4 = WebUI.getText(findTestObject('AZ/Pages/Contents Link Pages/feeShippingPage_text'))

WebUI.scrollToPosition(450, 450)

//WebUI.verifyMatch(content, '', true)
WebUI.verifyMatch(content4, '.*Qui sommes-nous ?.* .*La passion des huiles essentielles.* .*Au pays des aromatiques.* .*Nos valeurs.*', 
    true)

WebUI.scrollToElement(findTestObject('AZ/Pages/Contents Link Pages/a_instagramIcon'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_facebookIcon'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_tiktokIcon'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/Contents Link Pages/a_youtubeIcone'), 0)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

