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
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper

WebUI.comment('Input: email')

response = WS.sendRequest(findTestObject('AZ/API - CT/GET Access Token'))

def slurper = new JsonSlurper()

def jsonResponse = slurper.parseText(response.getResponseBodyContent())

accessToken = jsonResponse.access_token

KeywordUtil.logInfo(accessToken)

response = WS.sendRequest(findTestObject('AZ/API - CT/GET Last User Order ID', [('email') : email, ('accessToken') : accessToken]))

jsonResponse = slurper.parseText(response.getResponseBodyContent())

orderID = jsonResponse.hits[0].id

KeywordUtil.logInfo(orderID)

response = WS.sendRequest(findTestObject('AZ/API - CT/GET Order Details', [('orderID') : orderID, ('accessToken') : accessToken]))

jsonResponse = slurper.parseText(response.getResponseBodyContent())

return jsonResponse
