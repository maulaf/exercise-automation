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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.click(findTestObject('Object Repository/href', [('href') : '/products']))

WebUI.waitForPageLoad(0)

url = WebUI.getUrl()
assert url == "https://www.automationexercise.com/products"

searchProduct = findTestObject('Object Repository/id', [('id') : 'search_product'])

WebUI.verifyElementVisible(searchProduct)

keyword = "shirt"

WebUI.setText(searchProduct, keyword)

btn_Search = findTestObject('Object Repository/id', [('id') : 'submit_search'])

WebUI.click(btn_Search)

xpath_nameProduct = "//div[@class='productinfo text-center']/p"
TestObject nameProduct = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_nameProduct)
List<TestObject> element = WebUI.findWebElements(nameProduct, 30)

int count = element.size()

for (int i=0; i <= count; i++) {
	
	xpath_nameProduct = "(//div[@class='productinfo text-center']/p)[$i]"
	TestObject nameProduct = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath_nameProduct)
	
	nameProduct = WebUI.getText(nameProduct)
	
}
