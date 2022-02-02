package get.next.gen.commonaction;
public class payload {
	public static String Server="https://get.azne.aa.com";
	public static String resource="get-flight-cache/flight/getFlightsForGivenTime";
	public static String getActiveDivertedFlightURL="getng-services/getng/getActiveDivertedFlightReport";
	public static String stationOffset = "getng-services/getng/stationOffset";
	public static String oauthToken="Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImdldGF6ZCIsInBpLmF0bSI6ImtzNnMifQ.eyJzY29wZSI6IiIsImNsaWVudF9pZCI6ImdldF9hemRfc3RhZ2UiLCJpc3MiOiJodHRwczovL2lkcHN0YWdlLmFhLmNvbSIsImF1ZCI6ImdldGF6ZCIsImp0aSI6Im41WTUwWWd1IiwiZXhwIjoxNjE5NzczMDk2fQ.P0YLs-wZh0UmIkYJU9KxJsciWT7vqU06P6eBQGPRv97ivNPOqmFzdgATqd2JteKlWdYj8xcFmkCcC3etmJTcAifoCsOJxCzjUqaVGy3vRmmgUt7D9JIpUXig-rtFyJICLlFsUlcJsZe5fq4gBfEh9LY6FJtyzyJJ_HrYVHHbk0gkJoPc60rLMeIFaSvdfvuGp2zO7Huy_1a8oN-yBh3XnJdczq-J21iJjaCm1GpNLV0iqpbEJkJ0ytxmCUEkk2IAmIyQl5QoEZQewvezhe0wzOQe9OC6bXbUqDiC9zg75PuLTCwP6ibS2dxV2ttSqBlMBQuOtVar76YLUeJNVpo7JA";
	public static String requestBody=getFlightsForGivenTimeRequest();
	//adding Payload request for offset service
	public static String offloadRequest() {
		return "{\"userId\":\"NG_890833\",\"station\":\"DFW\"}";
	}
public static String getFlightsForGivenTimeRequest() {
		return "{\"station\":\"DFW\",\"startTime\":\"2020-12-15T14:31:17.060Z\",\"endTime\":\"2020-12-15T15:31:17.060Z\",\"pastFlights\":false,\"iatacode\":[\"AA\"],\"gates\":[],\"narrowBody\":true,\"wideBody\":true,\"transactionId\":\"UNKNOWN-0.0.00000_BETA00789696_DFW_1507111114808_201\"}";
	//return "{\"station\":\"DFW\",\"pastFlights\":\"true\",\"startTime\":\"2020-12-14T06:17:37.793Z\",\"endTime\":\"2020-12-14T11:17:37.793Z\",\"iatacode\":null,\"gates\":null,\"narrowBody\":true,\"wideBody\":true,\"internationalFlts\":true,\"domesticFlts\":true,\"transactionId\":\"UNKNOWN-0.0.00000_00812339_DFW_1515566607124_201\"}";
	}
	public static String getActiveDivertedFlightRequest() { 
		return "{\"startTime\":\"2021-04-27T06:59:56.383Z\",\"endTime\":\"2021-05-03T06:59:56.383Z\",\"stations\":[],\"includeSwim\":true}";
				//"{\"startTime\":\"2021-04-13T04:06:02.634Z\",\"endTime\":\"2021-04-19T04:06:02.634Z\",\"stations\":[],\"includeSwim\":true}";
	}
}
