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

WebUI.scrollToPosition(0, 0)

WebUI.delay(2)

//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button1'), 0)
//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button2'), 0)
//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button3'), 0)
//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button4'), 0)
WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide1'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/HeroSlider/Slides/Slide1'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Nos sélections', false)

//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_stock'), 0)
//WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_stock'), FailureHandling.STOP_ON_FAILURE)
//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_promotions'), 0)
//WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_promotions'), FailureHandling.STOP_ON_FAILURE)
//WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_news'), 0, FailureHandling.OPTIONAL)
//WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonTabsFilter_news'), FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('AZ/Pages/HomePage/HeroSlider/Buttons/Button4'), 0)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonSecondProductCard'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonSecondProductCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonIconAddToCart'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonIconAddToCart'), FailureHandling.STOP_ON_FAILURE)

//WebUI.click(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonFirstPruductCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonSecondProductCard'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonSecondProductCard'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/ButtonIconAddToCart'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/ButtonIconAddToCart'), FailureHandling.STOP_ON_FAILURE)

//WebUI.scrollToElement(findTestObject('AZ/TrackingsPages/Homepage/ButtonStock'), 0)
WebUI.verifyTextPresent('Nos catégories du moment', false)

WebUI.verifyTextPresent('Expert naturel en soins et beauté.', false)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/Categories/Categorie_Sérum visage'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/Categories/Categorie_Sérum visage'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_favoris (année)'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_favoris (année)'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/Categories/Catéorie_Soins cheveux'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/Categories/Catéorie_Soins cheveux'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_Personnalisation'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_Personnalisation'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_Huiles essentielles'), 0)

WebUI.verifyElementClickable(findTestObject('AZ/Pages/HomePage/Categories/Catégorie_Huiles essentielles'), FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

