package com.example.karate;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.intuit.karate.junit4.Karate;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

@RunWith(Karate.class)
@CucumberOptions(features = "classpath:karate")
public class KarateUnitTest {

  private static WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().port(8097));

  @BeforeClass
  public static void setUp() throws Exception {
    wireMockServer.start();
    configureFor("localhost", 8097);
    stubFor(get(urlEqualTo("/user/get"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("{ \"id\": \"1\", name: \"Test UserName\" }")));

    stubFor(post(urlEqualTo("/user/create"))
        .withHeader("Content-Type", equalTo("application/json; charset=UTF-8"))
        .withRequestBody(containing("id"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("{ \"id\": \"1\", name: \"Test UserName\" }")));

  }

  @AfterClass
  public static void tearDown() throws Exception {
    wireMockServer.stop();
  }
}


