package get.next.gen.commonaction;
import static io.restassured.RestAssured.given;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class API_commonActions {
	public static String response;
	public static JsonPath js = new JsonPath(response);

	public static int extractStatusCode(String Server,String serviceEndpointURL,String requestBody) {
		RestAssured.baseURI=Server;
		int statusCode=given().header("Authorization",payload.oauthToken).contentType("application/json").body(requestBody)
				.when().post(serviceEndpointURL).then().log().all().extract().statusCode();
		return statusCode;
	}
	public static String extractresponse(String Server,String serviceEndpointURL,String requestBody) {
		RestAssured.baseURI=Server;
		response=given().header("Authorization",payload.oauthToken).contentType("application/json").body(requestBody)
				.when().post(serviceEndpointURL).then().log().all().extract().response().asString();
		//System.out.println("Response is: "+ response);
		return response;

	}
	public static String getRequiredFieldPathAsString(String fieldPathWithStringValueReturned) {
		extractresponse(payload.Server,payload.getActiveDivertedFlightURL,payload.getActiveDivertedFlightRequest());
		js = new JsonPath(response);
		String fieldPathValueInString = js.getString(fieldPathWithStringValueReturned);
		System.out.println("fieldPathValueInString"+fieldPathValueInString);
		return fieldPathValueInString;
	}
	public static int getRequiredFieldPathAsInteger(String fieldPathWithIntegerValueReturned) {
		extractresponse(payload.Server,payload.getActiveDivertedFlightURL,payload.getActiveDivertedFlightRequest());
		js = new JsonPath(response);
		//int fieldPathValueInInteger = js.getInt(fieldPathWithIntegerValueReturned);
		return js.getInt(fieldPathWithIntegerValueReturned);

	}
	public static void getFieldPathValueFromApi() {
		extractStatusCode(payload.Server,payload.resource,payload.requestBody);
		extractresponse(payload.Server,payload.resource,payload.requestBody);
		String fieldValue=getRequiredFieldPathAsString("flight[1].assignedTail");
		System.out.println("fieldValue is: "+fieldValue);
	}

	public static String stationOffsetAccessForClassicViewInDiversionReport() {
		extractresponse(payload.Server,payload.stationOffset,payload.offloadRequest());
		return getRequiredFieldPathAsString("access5Users");
	}


	public static int getTotalSizeOfFlightsInPayload() {

		System.out.println("getRequiredFieldPathAsInteger "+getRequiredFieldPathAsInteger("array.size()"));

		System.out.println("Value is"+getRequiredFieldPathAsString("flifo[0].flight[1].fltKey"));
		return getRequiredFieldPathAsInteger("array.size()");
	}
	/*public static void main(String[] args) {
		//extractresponse(payload.Server,payload.getActiveDivertedFlightURL,payload.getActiveDivertedFlightRequest());
		getRequiredFieldPathAsString("flifo[0].addlFlightData[0].isWideBody");
		//getFieldPathValueFromApi();
		//if((extractStatusCode(payload.Server,payload.getActiveDivertedFlightURL,payload.getActiveDivertedFlightRequest())==200)) {
			System.out.println(extractresponse(payload.Server,payload.getActiveDivertedFlightURL,payload.getActiveDivertedFlightRequest()));
			System.out.println("getRequiredFieldPathAsInteger "+getRequiredFieldPathAsInteger("array.size()"));

			System.out.println("Value is"+getRequiredFieldPathAsString("flifo[0].flight[1].fltKey"));
		//}
		//extractresponse(payload.Server,payload.resource,payload.requestBody);

extractresponse(payload.Server,payload.stationOffset,payload.offloadRequest());
		System.out.println("access5Users is "+getRequiredFieldPathAsString("access5Users"));
		if(getRequiredFieldPathAsString("access5Users").contains("890833"))
				 System.out.println("True");
	}*/

}

