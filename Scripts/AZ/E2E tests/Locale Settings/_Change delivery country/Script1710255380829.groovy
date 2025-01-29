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

WebUI.comment('Precondition: Opened browser')

WebUI.comment('Input: countryName {String}')

WebUI.navigateToUrl(GlobalVariable.SEO_HomePage_FR)

if (CustomKeywords.'az.MobileOrDesktop.isMobile'()) {

	WebUI.click(findTestObject('Object Repository/AZ/Components/Header/burger-icon (Mobile)'))

	WebUI.click(findTestObject('Object Repository/AZ/Components/Sidebar (Mobile)/button_changeLanguage'))

} else {
		
	WebUI.click(findTestObject('AZ/Components/Header/country-icon'))

}

selectedCountryNameSpan = CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(
	findTestObject('Object Repository/AZ/Components/Locale Settings modal/selectedCountry_name (Mobile)'),
	findTestObject('Object Repository/AZ/Components/Locale Settings modal/selectedCountry_name (Desktop-Tablet)')
)

selectedCountryName = WebUI.getText(selectedCountryNameSpan)

'Change delivery country only if not already selected'
if (!(selectedCountryName ==~ ".*$countryName")) {
	WebUI.click(selectedCountryNameSpan)

	WebUI.click(findTestObject('Object Repository/AZ/Components/Locale Settings modal/country_list_item(countryName)', [
				('countryName') : countryName]))

	selectedCountryName = WebUI.getText(selectedCountryNameSpan)

	WebUI.verifyMatch(selectedCountryName, '.*' + countryName, true)
}


WebUI.click(
	CustomKeywords.'az.MobileOrDesktop.getSuitableObject'(
		findTestObject('Object Repository/AZ/Components/Locale Settings modal/button_confirm (Mobile)'),
		findTestObject('Object Repository/AZ/Components/Locale Settings modal/button_confirm (Desktop-Tablet)')
	)
)

'If just selected country don\'t match computer location, we can have a confirmation popup'
if (WebUI.verifyElementPresent(findTestObject('Object Repository/AZ/Components/Country selection popup/button_close'), 5,
	FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/AZ/Components/Country selection popup/button_close'))
}