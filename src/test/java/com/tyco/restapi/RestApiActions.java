package com.tyco.restapi;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;

public class RestApiActions {
	private static HttpUriRequest request;
	private static HttpResponse httpResponse;

	public static void requestEndPointForGET(String restURL) {
		try {
			request = new HttpGet(restURL);
			httpResponse = HttpClientBuilder.create().build().execute(request);
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void testStatusCode(int statusCode) {
		Assert.assertEquals(statusCode, httpResponse.getStatusLine().getStatusCode());
	}

	public static void testMimeType(String expectedMimeType) {
		Assert.assertEquals(expectedMimeType, ContentType.getOrDefault(httpResponse.getEntity()).getMimeType());
	}

	public static void testContentJSON(String element, String expectedValue) {

		// Convert the response to a String format
		String result;
		JSONObject jo = null;
		try {
			result = EntityUtils.toString(httpResponse.getEntity());
			jo = new JSONObject(result);
			Assert.assertEquals(expectedValue, jo.getString(element));

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (JSONException ex) {
			ex.printStackTrace();
		}
	}

	public static void requestEndPointForPOST(String restURL, String jsonPayload) {
		try {
			HttpPost request = new HttpPost(restURL);
			StringEntity stringEntity = new StringEntity(jsonPayload);
			request.setEntity(stringEntity);
			request.setHeader("Content-type", "application/json");
			httpResponse = HttpClientBuilder.create().build().execute(request);
		} catch (ClientProtocolException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
