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

WebUI.setText(findTestObject('AZ/Components/Address modal/input_firstName'), 'FirstName Delivery New')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_lastName'), 'LastName Delivery New')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_streetName'), 'Parc de la Tête d\'Or')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_additionalAddressInfo'), 'Additional info Delivery New')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_postalCode'), '69006')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_city'), 'Lyon')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_phone'), '0155443322')

WebUI.setText(findTestObject('AZ/Components/Address modal/input_company'), 'Test company Delivery New')

WebUI.click(findTestObject('AZ/Components/Address modal/button_submit'))

