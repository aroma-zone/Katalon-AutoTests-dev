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

WebUI.delay(3)

WebUI.mouseOver(findTestObject('AZ/Pages/Header_and_Footer/Header/Navigation banner_Recettes'))

WebUI.click(findTestObject('AZ/Pages/Header_and_Footer/Header/a_RecipeListingPage'))

WebUI.delay(2)

WebUI.click(findTestObject('AZ/Pages/RLP/ButtonWishlistRecipe_1'))

WebUI.delay(1)

user = GlobalVariable.user1

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User new login short'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_addNotebook'))

WebUI.setText(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_InputNotebookName'), 'Test autom')

WebUI.click(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_ButtonCreateNotebook'))

WebUI.click(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_NotebookSelector'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/RLP/ButtonWishlistRecipe_2'))

WebUI.click(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_NotebookSelector'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/RLP/ButtonWishlistRecipe_3'))

WebUI.click(findTestObject('AZ/Pages/RLP/RecipeModalWishlist_NotebookSelector'))

WebUI.click(findTestObject('AZ/Components/Header/favorites-icon'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/a_myNotebooks'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/FirstNotebook'))

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonWishlistRecipe_3'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonWishlistRecipe_2'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonWishlistRecipe_1'))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(1)

WebUI.verifyTextPresent('Ce carnet est vide, Vous n’avez pas encore ajouté de recettes', false)

WebUI.delay(1)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonModifyNotebook'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonDeleteNotebook'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonConfirmDeleteNotebook'))

WebUI.delay(1)

WebUI.verifyTextPresent('Vous n’avez pas encore de carnet', false)

WebUI.verifyElementPresent(findTestObject('AZ/Pages/MyAccountPage/MyNotebooks/ButtonCreateNotebook'), 0)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

