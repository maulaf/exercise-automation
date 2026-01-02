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
		
xpath = "//div[@class='single-products']"
ListProduct = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath)

WebUI.verifyElementPresent(ListProduct, 0)

firstProduct = new TestObject().addProperty("xpath", ConditionType.EQUALS, "(//*[text()='View Product'])[1]") 

WebUI.scrollToElement(firstProduct, 0)

WebUI.click(firstProduct)

url = WebUI.getUrl()
assert url == "https://www.automationexercise.com/product_details/1"


xpath_productName = "//div[@class='product-information']/h2"
xpath_productCategory = "(//div[@class='product-information']/p)[1]"
xpath_price = "(//div[@class='product-information']/span/span)"
xpath_availability = "(//div[@class='product-information']/p)[2]"
xpath_condition = "(//div[@class='product-information']/p)[3]"
xpath_brand = "(//div[@class='product-information']/p)[4]"

//Verify that detail detail is visible: product name, category, price, availability, condition, brand

productName = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_productName]))
assert productName != null

productCategory = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_productCategory]))
assert productCategory != null

price = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_price]))
assert price != null

availbility = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_availability]))
assert availbility != null

condition = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_condition]))
assert condition != null

brand = WebUI.getText(findTestObject('Object Repository/xpath', [('xpath') : xpath_brand]))
assert brand != null
