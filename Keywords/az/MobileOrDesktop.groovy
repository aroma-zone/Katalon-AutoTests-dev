package az

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class MobileOrDesktop {

	static final int MOBILE_VIEWPORT_WIDTH_LIMIT = 1024

	@Keyword
	def Boolean isMobile() {
		if (WebUI.getViewportWidth() < MOBILE_VIEWPORT_WIDTH_LIMIT) {
			return true
		} else {
			return false
		}
	}

	/** 
	 * Returns suitable test object based on viewport width
	 * @param mobileObject
	 * @param desktopObject
	 * @return suitableTestObject
	 */
	@Keyword
	def TestObject getSuitableObject(TestObject mobileObject, TestObject desktopObject) {
		if (isMobile()) {
			return mobileObject
		} else {
			return desktopObject
		}
	}
}
