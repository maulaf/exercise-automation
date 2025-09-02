package exerciseAutomation

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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.github.javafaker.Faker

public class userFlow {

	Faker faker = new Faker()

	String firstName
	String lastName
	String email
	String password = "P@ssw0rd"
	String title = "Mrs"
	String date = '5'
	String month = '7'
	String year = '1998'
	String company
	String address
	String state
	String city
	String zipCode
	String mobileNumber

	private void generateTestData() {
		firstName = faker.name().firstName()
		lastName = faker.name().lastName()
		email = firstName + "_" + lastName + "@mail.com"
		company = faker.company().name()
		address = faker.address().fullAddress()
		state = faker.country().name()
		city = faker.country().capital()
		zipCode = faker.address().zipCode()
		mobileNumber = faker.phoneNumber().phoneNumber()
	}

	@Keyword
	def registerUser() {
		generateTestData()

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

		GlobalVariable.email = email
		GlobalVariable.password = password
		GlobalVariable.userName = firstName
	}

	@Keyword
	def loginUser() {
		Boolean isLogoutPresent = WebUI.verifyElementPresent(findTestObject('Object Repository/href', [('href') : '/logout']), 0, FailureHandling.OPTIONAL)


		if (isLogoutPresent) {
			WebUI.click(findTestObject('Object Repository/href', [('href') : '/logout']))
		}else{
			WebUI.click(findTestObject('Object Repository/href', [('href') : '/login']))
		}

		WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Login to your account']))

		WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'login-email']), GlobalVariable.email)
		WebUI.setText(findTestObject('Object Repository/data-qa', [('data-qa') : 'login-password']), GlobalVariable.password)
		WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'login-button']))

		def xpath = "//i[@class='fa fa-user']/following-sibling::text()[contains(., 'Logged in as')]/following-sibling::b[text()='$GlobalVariable.userName']"
		TestObject loggedInAs = new TestObject().addProperty("xpath", ConditionType.EQUALS, xpath)

		WebUI.verifyElementVisible(loggedInAs)
	}
	
	@Keyword
	def logoutUser() {
		WebUI.click(findTestObject('Object Repository/href', [('href') : '/logout']))
		WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Login to your account']))
		
	}

	@Keyword
	def deleteUser() {
		WebUI.click(findTestObject('Object Repository/href', [('href') : '/delete_account']))
		WebUI.verifyElementVisible(findTestObject('Object Repository/text', [('text') : 'Account Deleted!']))
		WebUI.click(findTestObject('Object Repository/data-qa', [('data-qa') : 'continue-button']))
		WebUI.closeBrowser()
	}
}
