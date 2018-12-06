package com.example.spring.boot2.webflux.webclient;

import com.google.gson.Gson;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author yuweijun
 * @since 2018-12-05
 */
@RestController
@RequestMapping("/httpbin")
public class HttpBinRequest {

    WebClient webClient = WebClient.create("https://httpbin.org");

    @Resource
    private Gson gson;

    @GetMapping("/get")
    public Mono<GetResponse> handleGetUserById() {
        return webClient.get()
                .uri("get")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(GetResponse.class);
    }

    static class GetResponse {

        private Map<String, Object> args;

        private Map<String, Object> headers;

        private String origin;

        private String url;

        public Map<String, Object> getArgs() {
            return args;
        }

        public void setArgs(Map<String, Object> args) {
            this.args = args;
        }

        public Map<String, Object> getHeaders() {
            return headers;
        }

        public void setHeaders(Map<String, Object> headers) {
            this.headers = headers;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}

