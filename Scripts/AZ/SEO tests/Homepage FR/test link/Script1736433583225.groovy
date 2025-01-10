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
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import java.util.logging.Logger
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil

// Spécifiez le chemin complet de votre chromedriver
System.setProperty("webdriver.chrome.driver", "C:\\Studio\\Katalon_Studio_Windows_64-9.7.1\\configuration\\resources\\drivers\\chromedriver_win32\\chromedriver.exe")

// Créer les options de Chrome
ChromeOptions options = new ChromeOptions()

// Créez un profil temporaire avec JavaScript désactivé
options.addArguments("--start-maximized")
options.addArguments("--disable-javascript")
options.addArguments("--user-data-dir=C:\\Studio\\Katalon_Studio_Windows_64-9.7.1\\configuration\\resources\\drivers\\chromedriver_win32\\chrome-profile")  // Indiquez un répertoire pour le profil

// Lancer Chrome avec ces options
WebDriver driver = new ChromeDriver(options)
DriverFactory.changeWebDriver(driver)

// Charger votre page
String authenticatedURL = "http://aroma-zone:avant-premiere@stage.aroma-host.net/"
driver.get(authenticatedURL)

