package com.hpp.servicehi.dto;

import java.io.Serializable;

/**
 * @作者：胡鹏鹏
 * @创建时间：2018/2/27 8:57
 */
public class WebAuthDTO implements Serializable{
    private String appid;
    private String redirectUrl;
    private String response_type;
    private String scope;
    private String state;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
