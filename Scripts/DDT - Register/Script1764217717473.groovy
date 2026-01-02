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

WebUI.openBrowser(GlobalVariable.URL)
WebUI.verifyElementVisible(findTestObject('Object Repository/img', [('alt') : 'ParaBank']))

WebUI.click(findTestObject('Object Repository/href', [('href') : 'register.htm']))
WebUI.verifyTextPresent('Signing up is easy!', false)

WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.firstName']), firstName)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.lastName']), lastName)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.address.street']), address)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.address.city']), city)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.address.state']), state)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.address.zipCode']), zipCode)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.phoneNumber']), phone)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.ssn']), ssn)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.username']), username)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'customer.password']), password)
WebUI.setText(findTestObject('Object Repository/name', [('name') : 'repeatedPassword']), confirm)

WebUI.click(findTestObject('Object Repository/type', [('type') : 'submit', ('value') : 'Register']))

WebUI.verifyTextPresent(expected, false)

WebUI.takeScreenshot()