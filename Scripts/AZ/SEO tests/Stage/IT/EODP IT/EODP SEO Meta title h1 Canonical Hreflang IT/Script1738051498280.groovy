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
//import static com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import org.jsoup.Jsoup as Jsoup

// Récupérer l'URL canonical depuis le profil
String stageURLcanonical = GlobalVariable.SEO_Canonical_EODP_IT

String stageURL = GlobalVariable.SEO_EODP_IT

// Désactiver JavaScript
WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.executeJavaScript('navigator.webdriver=false;', null // Simule la désactivation de JS
    )

WebUI.navigateToUrl(stageURL)

WebUI.delay(2)

'Close Cookies popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Cookies popup/button_accept_v2'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Cookies popup/button_accept_v2'), FailureHandling.STOP_ON_FAILURE)
}

'Scroll to bottom so Newsletter popup is shown'
WebUI.executeJavaScript('window.scrollTo(0, document.body.scrollHeight);', [])

'Close newsletter popup'
if (WebUI.verifyElementPresent(findTestObject('AZ/Components/Newsletter popup/button_close'), 5, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('AZ/Components/Newsletter popup/button_close'), FailureHandling.STOP_ON_FAILURE)
}

// Récupération du contenu de la page
String pageSourceStage = WebUI.executeJavaScript('return document.documentElement.outerHTML;', null)

org.jsoup.nodes.Document documentStage = Jsoup.parse(pageSourceStage)

// Vérifier Metatitle
String metaTitleStage = documentStage.select('title').text()

if (metaTitleStage.length() < 12) {
    KeywordUtil.markFailedAndStop('Metatitle est trop court: ' + metaTitleStage)
} else {
    KeywordUtil.logInfo('Metatitle détecté: ' + metaTitleStage)
}

// Vérifier Metadescription
String metaDescriptionStage = documentStage.select('meta[name=description]').attr('content')

if (metaDescriptionStage.isEmpty()) {
    KeywordUtil.markFailedAndStop('Metadescription absente sur Stage')
} else {
    KeywordUtil.logInfo('Metadescription détectée: ' + metaDescriptionStage)
}

// Vérifier Hreflang
List<String> hreflangs = documentStage.select('link[rel=alternate]').eachAttr('hreflang')

// Hreflangs qui doivent être présents
List<String> expectedHreflangs = ['fr', 'x-default', 'it']
// Hreflangs qui ne doivent pas être présents
List<String> forbiddenHreflangs = ['de', 'en', 'es',]

// Vérifier que tous les hreflangs attendus sont présents
if (!hreflangs.containsAll(expectedHreflangs)) {
	KeywordUtil.markFailedAndStop('Hreflang manquants : ' + (expectedHreflangs - hreflangs))
} else if (!Collections.disjoint(hreflangs, forbiddenHreflangs)) {
	// Vérifier qu'aucun hreflang interdit n'est présent
	KeywordUtil.markFailedAndStop('Hreflang(s) interdit(s) trouvé(s) : ' + hreflangs.intersect(forbiddenHreflangs))
} else {
	KeywordUtil.logInfo('Tous les hreflangs sont corrects : ' + hreflangs)
}

// Vérifier Canonical
String canonicalStage = documentStage.select('link[rel=canonical]').attr('href')

if (!(canonicalStage.equals(stageURLcanonical))) {
    KeywordUtil.markFailedAndStop((('Canonical incorrect. Attendue: ' + stageURL) + ', Trouvée: ') + canonicalStage)
} else {
    KeywordUtil.logInfo('Canonical correcte: ' + canonicalStage)
}

// Vérifier H1
//warning: ajouter la vérification suivante: il ne faut pas qu'il y ai marqué undefined
String h1Stage = documentStage.select('h1').text()

if (h1Stage.isEmpty()) {
    KeywordUtil.markFailedAndStop('H1 manquant sur Stage')
} else if (h1Stage.equalsIgnoreCase('undefined')) {
    KeywordUtil.markFailedAndStop('H1 contient une valeur incorrecte: "undefined"')
} else {
    KeywordUtil.logInfo('H1 détecté: ' + h1Stage)
}

// Vérification du contenu des modules en SSR
List<String> ssrModules = ["Olio essenziale di Tea tree (Albero del tè BIO)", "Caratteristiche", "Indicazioni per l\\'uso", "Proprietà e utilizzo", "Precauzioni", "Maggiori informazioni", "Recensioni", "Ricette associate", "Consigli associati", "Bibliografia"]


// Liste pour stocker les modules manquants
List<String> missingModules = []

// Parcourir et vérifier chaque module
ssrModules.each({ def moduleName ->
        boolean isModuleVisible = !(documentStage.select(":containsOwn($moduleName)").isEmpty())

        if (!(isModuleVisible)) {
            // Ajouter le module manquant à la liste
            missingModules.add(moduleName)

            KeywordUtil.logInfo('Module SSR manquant : ' + moduleName // Ajout dans les logs
                // Log des modules détectés
                )
        } else {
            KeywordUtil.logInfo('Module SSR détecté : ' + moduleName)
        }
    })

// Vérifier s'il y a des modules manquants après la boucle
if (!(missingModules.isEmpty())) {
    // Signaler une erreur avec la liste des modules manquants
    KeywordUtil.markFailed('Les modules SSR suivants sont manquants : ' + missingModules.join(', '))
} else {
    KeywordUtil.logInfo('Tous les modules SSR sont présents.')
}

WebUI.scrollToElement(findTestObject('AZ/SEO/PDP/Reviews_Block'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/SEO/PDP/Reviews_Block'), 2)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

