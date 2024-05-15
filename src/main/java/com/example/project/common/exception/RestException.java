package com.example.project.common.exception;


import com.example.project.common.response.ResultError;

public class RestException extends RuntimeException {
    private final int code;
    private final ResultError error;

    private RestException(int code, ResultError error, Throwable cause) {
        super("ErrorCode：" + error.getCode() + "，Message：" + error.getMessage() + "，Code：" + code, cause);
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public ResultError getError() {
        return error;
    }

    public static class Builder {
        private final int code;
        private ResultError error;
        private Throwable cause;

        public Builder(int code) {
            this.code = code;
        }

        public Builder withError(ResultError error) {
            this.error = error;
            return this;
        }

        public Builder withCause(Throwable cause) {
            this.cause = cause;
            return this;
        }

        public RestException build() {
            if (error == null) {
                throw new IllegalArgumentException("错误不能为空");
            }
            return new RestException(this.code, this.error, this.cause);
        }

    }
}
