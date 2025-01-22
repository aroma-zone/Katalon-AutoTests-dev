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

WebUI.comment('Precondition: Address modal')

WebUI.comment('Input: address {MAP}')

WebUI.acceptAlert()

WebUI.setText(findTestObject('AZ/Components/Address modal/input_streetName'), 'Parc de la Tête d\'Or')

// select all text, so it will be overwritten
// clear text using JavaScript (sometimes not working properly)
//WebElement element = WebUI.findWebElement(to, 2)
//WebUI.executeJavaScript("arguments[0].value='';", Arrays.asList(element))
fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_firstName'), address.firstName)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_lastName'), address.lastName)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_additionalAddressInfo'), address.additionalAddressInfo)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_postalCode'), address.postalCode)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_city'), address.city)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_phone'), address.phone)

fillOrUpdateField(findTestObject('Object Repository/AZ/Components/Address modal/input_company'), address.company)

WebUI.click(findTestObject('AZ/Components/Address modal/button_submit'))

def fillOrUpdateField(TestObject to, String newText) {
    currentText = WebUI.getAttribute(to, 'value')

    if (currentText == '') {
        WebUI.setText(to, newText)
    } else {
        WebUI.sendKeys(to, Keys.chord(Keys.SHIFT, Keys.ARROW_UP))

        WebUI.sendKeys(to, newText)
    }
}

