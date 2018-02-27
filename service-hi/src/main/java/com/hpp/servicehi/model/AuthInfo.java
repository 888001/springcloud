package com.hpp.servicehi.model;

public class AuthInfo {
    private Integer authId;

    private String appid;

    private String appidMd5;

    private String appsecret;

    private String appsecretMd5;

    private String redirectUri;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    public String getAppidMd5() {
        return appidMd5;
    }

    public void setAppidMd5(String appidMd5) {
        this.appidMd5 = appidMd5 == null ? null : appidMd5.trim();
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret == null ? null : appsecret.trim();
    }

    public String getAppsecretMd5() {
        return appsecretMd5;
    }

    public void setAppsecretMd5(String appsecretMd5) {
        this.appsecretMd5 = appsecretMd5 == null ? null : appsecretMd5.trim();
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri == null ? null : redirectUri.trim();
    }
}