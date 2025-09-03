import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import groovy.json.JsonSlurper

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/API/postProduct'))
WS.verifyResponseStatusCode(response, 200)

WS.comment("Got response:\n" + response.getResponseBodyContent())

def jsonResponse = new JsonSlurper().parseText(response.getResponseText())

assert jsonResponse.responseCode == 405
assert jsonResponse.message == "This request method is not supported."