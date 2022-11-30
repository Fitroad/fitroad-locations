package com.fitroad.locations.location;

import java.util.Objects;

public class BaseResponse {
    private String errorMessage;

    public BaseResponse() {

    }

    public BaseResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof BaseResponse)) {
            return false;
        }
        BaseResponse that = (BaseResponse) o;
        return Objects.equals(errorMessage, that.errorMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(errorMessage);
    }
}
