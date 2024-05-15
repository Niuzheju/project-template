package com.example.project.common.spring;

import org.apache.hc.core5.http.ClassicHttpRequest;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.NonNull;

import java.net.URI;


public class HttpComponentsClientRestfulHttpRequestFactory extends HttpComponentsClientHttpRequestFactory {

    @Override
    protected ClassicHttpRequest createHttpUriRequest(HttpMethod httpMethod, URI uri) {
        if (httpMethod == HttpMethod.GET) {
            return new HttpGetRequestWithEntity(uri);
        }
        return super.createHttpUriRequest(httpMethod, uri);
    }
}
