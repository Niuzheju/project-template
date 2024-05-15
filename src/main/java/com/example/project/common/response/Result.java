package com.example.project.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@SuppressWarnings("rawtypes")
public class Result<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -6551113102448005912L;

    private int code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ResultError error;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    private Result() {
    }

    private Result(T data) {
        this.data = data;
    }

    private Result(int code, ResultError error) {
        this.code = code;
        this.error = error;
    }

    public static Result success() {
        return new Result();
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(data);
    }

    public static Result fail(int code, ResultError error) {
        return new Result(code, error);
    }

}
