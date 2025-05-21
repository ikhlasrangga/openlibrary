package com.app.OpenLibrary.model;

import lombok.Data;

@Data
public class Response {

    private String responseCode;
    private String responseDesc;
    private Object data;
}
