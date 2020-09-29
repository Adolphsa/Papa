package com.lucas.architecture.domain.manager;

/**
 * Created by lucas
 * Date: 2020/9/25 12:07
 */
public class NetState {

    private String responseCode;
    private boolean success = true;

    public NetState(String responseCode, boolean success) {
        this.responseCode = responseCode;
        this.success = success;
    }

    public NetState() {
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
