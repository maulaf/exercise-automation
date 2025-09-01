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
import com.github.javafaker.Faker

Faker faker = new Faker()

def firstName = faker.name().firstName()
def lastName = faker.name().lastName()
def email = firstName + "_" + lastName + "@mail.com"
def password = "P@ssw0rd"
def title = "Mrs"
def date = '5'
def month = '7'
def year = '1998'
def company = faker.company.name()
def address = faker.address.fullAddress()
def state = faker.country().name()
def city = faker.country.capital()
def zipCode = faker.address().zipCode()
def mobileNumber = faker.phoneNumber().phoneNumber()



WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.verifyElementVisible(findTestObject('Object Repository/img', [('alt') : 'Website for automation practice']))

WebUI.click(findTestObject('Object Repository/href', [('href') : '/login']))

WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'New User Signup!']))

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'signup-name']), firstName)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'signup-email']), email)

WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'signup-button']))

WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Enter Account Information']))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/data-qa', [('data-qa') : 'name']), 'value', firstName, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/data-qa', [('data-qa') : 'email']), 'value', email, 0)

WebUI.check(findTestObject('Object Repository/radio-button', [('value') : title]))

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'password']), password)

WebUI.selectOptionByValue(findTestObject('Object Repository/data-qa', [('data-qa') : 'days']), date, false)

WebUI.selectOptionByValue(findTestObject('Object Repository/data-qa', [('data-qa') : 'months']), month, false)

WebUI.selectOptionByValue(findTestObject('Object Repository/data-qa', [('data-qa') : 'years']), year, false)

WebUI.check(findTestObject('Object Repository/checkbox', [('id') : 'newsletter']))

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'first_name']), firstName)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'last_name']), lastName)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'address']), address)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'state']), state)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'city']), city)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'zipcode']), zipCode)

WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'mobile_number']), mobileNumber)

WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'create-account']))

WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Account Created!']))

WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'continue-button']))

WebUI.click(findTestObject('Object Repository/href', [('href') : '/delete_account']))

WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Account Deleted!']))

WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'continue-button']))