import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.comment("Precondition: page with cart icon on header")

int badgeNumber

if (WebUI.verifyElementVisible(findTestObject('AZ/Components/Header/cart-icon-badge-number'), FailureHandling.OPTIONAL)) {
	badgeNumber = WebUI.getText(findTestObject('AZ/Components/Header/cart-icon-badge-number')).toInteger()
} else {
	badgeNumber = 0
}

KeywordUtil.logInfo(badgeNumber.toString())

return badgeNumber