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
import org.opencv.core.Core as Core
import org.opencv.core.Mat as Mat
import org.opencv.core.CvType as CvType
import org.opencv.imgcodecs.Imgcodecs as Imgcodecs
import org.opencv.imgproc.Imgproc as Imgproc
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

// Ouvrir la première URL
WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.aroma-zone.com/products/favoris-aroma-zone')

// Prendre une capture d'écran
WebUI.takeScreenshot('C:\\Users\\Horizon\\git\\captures écrans tests ui\\capture_prod1')

// Ouvrir la deuxième URL
WebUI.navigateToUrl('https://stage.aroma-host.net/products/favoris-aroma-zone')

// Prendre une autre capture d'écran
WebUI.takeScreenshot('C:\\Users\\Horizon\\git\\captures écrans tests ui\\captures_stage1')

// Charger les images capturées
def img1 = Imgcodecs.imread('C:\\Users\\Horizon\\git\\captures écrans tests ui\\capture_prod1')

def img2 = Imgcodecs.imread('C:\\Users\\Horizon\\git\\captures écrans tests ui\\captures_stage1')

// Convertir les images en niveaux de gris
def grayImg1 = new Mat()

def grayImg2 = new Mat()

Imgproc.cvtColor(img1, grayImg1, Imgproc.COLOR_BGR2GRAY)

Imgproc.cvtColor(img2, grayImg2, Imgproc.COLOR_BGR2GRAY)

// Calculer la différence entre les images
def diffImg = new Mat()

Core.absdiff(grayImg1, grayImg2, diffImg)

// Calculer le pourcentage de différence
def nonZeroPixels = Core.countNonZero(diffImg)

def totalPixels = diffImg.rows() * diffImg.cols()

def differencePercentage = (nonZeroPixels.toDouble() / totalPixels.toDouble()) * 100

println("Pourcentage de différence : $differencePercentage%")

// Comparer les images et prendre des actions en conséquence
if (differencePercentage > 0) {
    println('Les images sont différentes.' // Ajouter des actions à prendre en cas de différence
        ) // Ajouter des actions à prendre en cas de similarité
} else {
    println('Les images sont identiques.')
}

