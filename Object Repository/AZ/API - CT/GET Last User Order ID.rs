<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>GET Last User Order ID</name>
   <tag></tag>
   <elementGuidId>2b4399fd-3a80-42ac-815b-41c358b316dd</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <autoUpdateContent>false</autoUpdateContent>
   <connectionTimeout>0</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;query\&quot;: {\n    \&quot;exact\&quot;: {\n      \&quot;field\&quot;: \&quot;customerEmail\&quot;,\n      \&quot;value\&quot;: \&quot;${email}\&quot;\n    }\n  },\n  \&quot;sort\&quot;: [\n    {\n      \&quot;field\&quot;: \&quot;createdAt\&quot;,\n      \&quot;order\&quot;: \&quot;desc\&quot;\n    }\n  ],\n  \&quot;limit\&quot;: 1\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
      <webElementGuid>9067056c-7e51-4b66-b675-96c8f7d8fb05</webElementGuid>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Authorization</name>
      <type>Main</type>
      <value>Bearer ${accessToken}</value>
      <webElementGuid>fbf441c9-3ae0-4755-842e-ea370f2ee74b</webElementGuid>
   </httpHeaderProperties>
   <katalonVersion>9.0.0</katalonVersion>
   <maxResponseSize>0</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>${GlobalVariable.CT_API_URL}/${GlobalVariable.CT_PROJECT_KEY}/orders/search</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>0</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>67e93ab0-b8e9-42ec-9df3-7e14d5661d40</id>
      <masked>false</masked>
      <name>email</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>372a722f-26fb-4b9d-843c-10c38539e152</id>
      <masked>false</masked>
      <name>accessToken</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

assertThat(response.getStatusCode()).isEqualTo(200)
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
