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
import java.nio.file.*
import java.util.*
import com.kms.katalon.core.util.KeywordUtil

// Définir les chemins des fichiers générés par les tests
String fileWithJS = "C:\\LINKS SEO FR IT\\verified_links_HP_FR.txt"
String fileWithoutJS = "C:\\LINKS SEO FR IT\\verified_links_HP_FR-without_JS.txt"

// Charger les fichiers sous forme de listes
List<String> linksWithJS = Files.readAllLines(Paths.get(fileWithJS)).drop(1) // Suppression de l'entête CSV si nécessaire
List<String> linksWithoutJS = Files.readAllLines(Paths.get(fileWithoutJS)).drop(1)

// Transformer en Set pour comparaison rapide
Set<String> setWithJS = new HashSet<>(linksWithJS)
Set<String> setWithoutJS = new HashSet<>(linksWithoutJS)

// Trouver les liens manquants dans chaque fichier
Set<String> missingInJS = new HashSet<>(setWithoutJS)
missingInJS.removeAll(setWithJS)

Set<String> missingWithoutJS = new HashSet<>(setWithJS)
missingWithoutJS.removeAll(setWithoutJS)

// Affichage des résultats
if (missingInJS.isEmpty() && missingWithoutJS.isEmpty()) {
	KeywordUtil.logInfo("Les fichiers contiennent le même nombre de liens et les mêmes URLs.")
} else {
	 KeywordUtil.markFailed("⚠️ Différences détectées entre les fichiers SEO !")
	if (!missingInJS.isEmpty()) {
        KeywordUtil.logInfo("❌ Liens présents sans JS mais absents avec JS: \n" + missingInJS)
    }
    if (!missingWithoutJS.isEmpty()) {
        KeywordUtil.logInfo("❌ Liens présents avec JS mais absents sans JS: \n" + missingWithoutJS)
    }
}

