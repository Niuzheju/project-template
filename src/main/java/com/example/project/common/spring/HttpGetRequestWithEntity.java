package com.example.project.common.spring;

import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;

import java.net.URI;


public class HttpGetRequestWithEntity extends HttpUriRequestBase {

    public final static String METHOD_NAME = "GET";

    public HttpGetRequestWithEntity(final URI uri) {
        super(METHOD_NAME, uri);
    }

    public HttpGetRequestWithEntity(final String uri) {
        this(URI.create(uri));
    }


}
