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

WebUI.comment('Precondition: Click on ATC button')

'Mobile only, on desktop first variant is already selected'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/ATC overlay/li_firstVariant'), 2, FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/ATC overlay/li_firstVariant'))
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/ATC overlay/button_ATC'), 2, FailureHandling.OPTIONAL)) {
    'ATC overlay with selected variant'
    WebUI.takeScreenshot()

    WebUI.click(findTestObject('Object Repository/AZ/Components/ATC overlay/button_ATC'))

    WebUI.verifyElementNotPresent(findTestObject('AZ/Components/ATC overlay/button_ATC'), 2)
}

"On mobile, after ATC, buttons 'see cart' and 'continue shopping' are shown"
if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/ATC overlay/button_ContinueShopping'), 2, 
    FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/AZ/Components/ATC overlay/button_ContinueShopping'))

    WebUI.verifyElementNotPresent(findTestObject('AZ/Components/ATC overlay/button_ContinueShopping'), 2)
}
