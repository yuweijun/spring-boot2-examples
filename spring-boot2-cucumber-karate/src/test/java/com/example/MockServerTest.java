package com.example;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

/**
 * https://www.mock-server.com/mock_server/running_mock_server.html
 *
 * @author Weijun Yu
 * @since 2020-02-16
 */
public class MockServerTest {

  private ClientAndServer mockServer;

  private String body = "response body";

  @Before
  public void startMockServer() {
    mockServer = startClientAndServer(8080);

    mockServer.when(request()
        .withPath("/hello/world")
        .withMethod("GET")
    ).respond(response()
        .withStatusCode(200)
        .withBody(body)
    );

    mockServer.when(request()
        .withPath("/hello/world")
        .withMethod("POST")
        .withHeader(new Header("Accept", MediaType.TEXT_PLAIN.toString()))
        .withBody("username=foo&password=123456")
    ).respond(response()
        .withStatusCode(200)
        .withBody(body)
    );
  }

  @Test
  public void test() throws IOException {
    boolean running = mockServer.isRunning();
    System.out.println(running);

    HttpGet httpGet = new HttpGet("http://localhost:8080/hello/world");
    try (
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpGet);
        InputStream content = response.getEntity().getContent();
        InputStreamReader inputStreamReader = new InputStreamReader(content);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
      String responseText = bufferedReader.readLine();
      assertEquals(body, responseText);
    }

    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
    nameValuePairs.add(new BasicNameValuePair("username", "foo"));
    nameValuePairs.add(new BasicNameValuePair("password", "123456"));
    HttpPost httpPost = new HttpPost("http://localhost:8080/hello/world");
    httpPost.addHeader("Accept", "text/plain");
    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    try (
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = client.execute(httpPost);
        InputStream content = response.getEntity().getContent();
        InputStreamReader inputStreamReader = new InputStreamReader(content);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
      String responseText = bufferedReader.readLine();
      assertEquals(body, responseText);
    }
  }

  @After
  public void stopMockServer() {
    mockServer.stop();
  }
}
