package com.techdiggity.gateway.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.util.EntityUtils;
/**
 * This example shows how to upload files using POST requests 
 * with encoding type "multipart/form-data".
 * For more details please read the full tutorial
 * on https://javatutorial.net/java-file-upload-rest-service
 * @author javatutorial.net
 */
@SuppressWarnings("deprecation")
public class RestClient {
	
	public RestClient() {
		//getInstances();
		//postInstances();
		//postInstances2();
		postInstances3();
	}
	
	private void postInstances3() {
		
		CloseableHttpClient client = null;
				
		try {
			long start = System.currentTimeMillis();
			File inFile = new File("/pacs/GEMS_IMG_TEST/2011_JAN/06/FL161521/B16GJPG0");
		    client = HttpClients.createDefault();
		    HttpPost httpPost = new HttpPost("http://192.168.1.113:8042/instances");
		    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		    String file = "B16GJPG0";
		    String filename = "B16GJPG0";
		    builder.addBinaryBody(file, inFile, ContentType.APPLICATION_OCTET_STREAM, filename);
		    HttpEntity multipart = builder.build();
		    httpPost.setEntity(multipart);
		    CloseableHttpResponse response = client.execute(httpPost);
		    int responseCode = response.getStatusLine().getStatusCode();
		    System.out.println("response code = " + responseCode);
		    long stop = System.currentTimeMillis();
		    System.out.println("Processed 1 file in "+(stop - start)+" milliseconds.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (Exception e) {}
		}
	}

	private void postInstances2() {
		
		File inFile = new File("/pacs/GEMS_IMG_TEST/2011_JAN/06/FL161521/B16GJPG0");
		
		if (inFile.exists()) {
			System.out.println("exists!");
		} else {
			System.out.println("file does not exist! exiting...");
			System.exit(1);
		}
		
		FileInputStream fis = null;
		
		try {
			URL url = new URL("http://localhost:8080/RESTfulExample/json/product/post");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
	
			String input = "{\"qty\":100,\"name\":\"iPad 4\"}";
	
			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();
	
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}
	
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	
			String output;
			System.out.println("Output from Server .... \n");
					
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
	
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void postInstances() {
		// the file we want to upload
		//File inFile = new File("/Users/Jeffery/Documents/GEMS_IMG_TEST/2011_JAN/06/FL161521.dcm");
		File inFile = new File("/pacs/GEMS_IMG_TEST/2011_JAN/06/FL161521/B16GJPG0");
		
		if (inFile.exists()) {
			System.out.println("exists!");
		} else {
			System.out.println("file does not exist! exiting...");
			System.exit(1);
		}
		
		FileInputStream fis = null;
		DefaultHttpClient httpclient = null;
		
		try {
			fis = new FileInputStream(inFile);
			httpclient = new DefaultHttpClient(new BasicHttpParams());
			
			// server back-end URL
			HttpPost httppost = new HttpPost("http://192.168.1.113:8042/instances");
			MultipartEntity entity = new MultipartEntity();
			// set the file input stream and file name as arguments
			entity.addPart("file", new InputStreamBody(fis, inFile.getName()));
			httppost.setEntity(entity);
			// execute the request
			HttpResponse response = httpclient.execute(httppost);
			
			int statusCode = response.getStatusLine().getStatusCode();
			HttpEntity responseEntity = response.getEntity();
			String responseString = EntityUtils.toString(responseEntity, "UTF-8");
			
			System.out.println("[" + statusCode + "] " + responseString);
			
		} catch (ClientProtocolException e) {
			System.err.println("Unable to make connection");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read file");
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) fis.close();
			} catch (Exception e) {}
			
			try {
				httpclient.close();
			} catch (Exception e) {}
		}
	}

	public void getInstances() {
		
		HttpClient client = null;
		HttpGet request = null;
		
		try {
			String url = "http://192.168.1.113:8042/instances";

			client = HttpClientBuilder.create().build();
			request = new HttpGet(url);

			// add request header
			request.addHeader("User-Agent", "Chrome");
			HttpResponse response = client.execute(request);

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(
				new InputStreamReader(response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public static void main(String[] args) {
		new RestClient();
	}
	
}