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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.net.HttpURLConnection
import java.net.URL
import java.io.File
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.util.KeywordUtil

// Étape 1 : Initialisation
WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

// Configurer les options du navigateur pour désactiver JavaScript
ChromeOptions options = new ChromeOptions()
options.addArguments('--disable-javascript')
options.addArguments("--start-maximized") // Optionnel : maximise la fenêtre
options.addArguments("--disable-blink-features=AutomationControlled") // Optionnel : pour éviter certains blocages

// Lancer le navigateur avec les options configurées
WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options)
DriverFactory.changeWebDriver(driver)

// Charger à nouveau la page initiale
String authenticatedURL = "http://aroma-zone:avant-premiere@stage.aroma-host.net/info/fiche-technique/huile-essentielle-tea-tree-arbre-bio-aroma-zone?page=library"
driver.get(authenticatedURL)

// Vérifier que la page est bien rechargée
KeywordUtil.logInfo("Page rechargée avec JavaScript désactivé : ${driver.getCurrentUrl()}")

// Étape 2 : Récupération du contenu de la page
String pageSourceStage = driver.getPageSource()
if (pageSourceStage == null || pageSourceStage.isEmpty()) {
    KeywordUtil.markFailedAndStop("Le contenu de la page est vide ou n'a pas été récupéré.")
}

// Sauvegarder dans un fichier pour analyse
File file = new File("page_source.html")
file.text = pageSourceStage

// Ajouter un log pour afficher les 500 premiers caractères
KeywordUtil.logInfo("Contenu HTML récupéré : ${pageSourceStage.substring(0, Math.min(500, pageSourceStage.length()))}...")

Document document = Jsoup.parse(pageSourceStage)
Element mainContent = document.selectFirst("body > div:not(header):not(footer):not(nav)")

if (mainContent == null) {
	KeywordUtil.markFailedAndStop("Impossible de récupérer le contenu principal. Vérifiez vos sélecteurs CSS.")
}

// Étape 3 : Extraction des liens avec Jsoup
Document documentStage = Jsoup.parse(pageSourceStage)
List<String> links = documentStage.select("div[data-v-0166df25][data-v-43f16b76] a[href]").eachAttr("href")

KeywordUtil.logInfo("Nombre de liens extraits : ${links.size()}")
if (links.isEmpty()) {
    KeywordUtil.markFailedAndStop("Aucun lien n'a été extrait. Vérifiez vos sélecteurs CSS.")
}

// Initialiser un indicateur pour détecter les échecs
boolean testFailed = false


// Étape 4 : Vérification des liens
File file2 = new File("C:\\LINKS SEO FR IT\\verified_links_EODP_FR.txt")
file2.text = "Vérification des liens FR - ${new Date()}\n"

links.each { String link ->
    try {
        String completeURL = link.startsWith("http") ? link : "https://stage.aroma-host.net" + link
        KeywordUtil.logInfo("Traitement du lien : $completeURL")
        
        HttpURLConnection connection = (HttpURLConnection) new URL(completeURL).openConnection()
		String auth = "aroma-zone" + ":" + "avant-premiere"
		String encodedAuth = "Basic " + java.util.Base64.getEncoder().encodeToString(auth.getBytes("UTF-8"))
		connection.setRequestProperty("Authorization", encodedAuth)
        connection.setRequestMethod("GET")
        connection.connect()
		
		
		
        int responseCode = connection.responseCode
        
        if (responseCode == 200) {
            file2.append("Valide : $completeURL (Code $responseCode)\n")
        } else {
            file2.append("Invalide : $completeURL (Code $responseCode)\n")
			testFailed = true // Marquer le test comme échoué si le code est différent de 200
        }
        
        connection.disconnect()
    } catch (Exception e) {
        file2.append("Erreur : $link (${e.message})\n")
		testFailed = true // Marquer le test comme échoué en cas d'exception
    }
}

// Si un échec a été détecté, échouer le test
if (testFailed) {
    KeywordUtil.markFailedAndStop("Le test a échoué car un ou plusieurs liens ont retourné un code non-200.")
} else {
    KeywordUtil.logInfo("Tous les liens ont été vérifiés avec succès.")
}

// Étape 5 : Fin du script
KeywordUtil.logInfo("Vérification des liens terminée. Résultats dans 'verified_links.txt'")

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)