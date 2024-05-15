package com.example.project.common.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResultErrorImpl.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface ResultError {

    String getCode();

    String getMessage();
}
