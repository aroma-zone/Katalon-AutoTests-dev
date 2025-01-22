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

WebUI.callTestCase(findTestCase('AZ/_Setup'), [:], FailureHandling.STOP_ON_FAILURE)

'using different user account for address update to reduce impact in case of test break'
user = GlobalVariable.user2

WebUI.delay(3)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Login/_User login'), [('user') : user], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/a_myAddresses'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/tab_deliveryAddress'))

List<WebElement> deliveryAddressCards = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_cards (list)'), 
    2)

initialNumberOfDeliveryAddresses = deliveryAddressCards.size()

'This test needs at least one existing delivery address'
WebUI.verifyGreaterThan(initialNumberOfDeliveryAddresses, 0)

WebUI.comment('Add additional delivery address')

initialDefaultAddressName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_name'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_addNew_button'))

modalTitle = WebUI.getText(findTestObject('AZ/Components/Address modal/title - ajout'))

WebUI.verifyMatch(modalTitle, '.*(livraison|consegna)', true)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Address modal/_Fill address modal NEW'), [:], FailureHandling.STOP_ON_FAILURE)

'Delivery Addresses after adding additional one'
WebUI.takeScreenshot()

deliveryAddressCards = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_cards (list)'), 
    2)

WebUI.verifyEqual(deliveryAddressCards.size(), initialNumberOfDeliveryAddresses + 1)

WebUI.comment('Set new address as default')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_last_setAsDefault_button'))

'Delivery Addresses after changing default address'
WebUI.takeScreenshot()

defaultAddressName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_name'))

WebUI.verifyMatch(defaultAddressName, (newAddress.firstName + ' ') + newAddress.lastName, false)

WebUI.comment('Update details of default address')

WebUI.click(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_update_button'))

modalTitle = WebUI.getText(findTestObject('AZ/Components/Address modal/title'))

WebUI.verifyMatch(modalTitle, '(Éditer|Modifica).*', true)

WebUI.callTestCase(findTestCase('AZ/E2E tests/Address modal/_Update address modal NEW'), [:], FailureHandling.STOP_ON_FAILURE)

'Delivery Addresses after updating details of default address'
WebUI.takeScreenshot()

defaultAddressName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_name'))

WebUI.verifyMatch(defaultAddressName, (updatedAddress.firstName + ' ') + updatedAddress.lastName, false)

WebUI.comment('Reset default address')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_last_setAsDefault_button'))

'Delivery Addresses after resetting default address'
WebUI.takeScreenshot()

defaultAddressName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_name'))

WebUI.verifyMatch(defaultAddressName, initialDefaultAddressName, false)

WebUI.comment('Delete newly added address')

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_last_remove_button'))

WebUI.click(findTestObject('AZ/Pages/MyAccountPage/MyAddresses/removalConfirmationModal_yes_button'))

'Delivery Addresses after deleting newly added address'
WebUI.takeScreenshot()

deliveryAddressCards = WebUI.findWebElements(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_cards (list)'), 
    2)

WebUI.verifyEqual(deliveryAddressCards.size(), initialNumberOfDeliveryAddresses)

defaultAddressName = WebUI.getText(findTestObject('Object Repository/AZ/Pages/MyAccountPage/MyAddresses/deliveryAddress_default_name'))

WebUI.verifyMatch(defaultAddressName, initialDefaultAddressName, false)

WebUI.callTestCase(findTestCase('AZ/_TearDown'), [:], FailureHandling.STOP_ON_FAILURE)

