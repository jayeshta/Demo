package com.apps.demo.mylibrary;

public class DataModel {

    private int app_id;
    private String app_name, app_package, app_version, app_ads,app_interstitial,app_banner,app_auth,app_status;

    public DataModel(int app_id, String app_name, String app_package, String app_version, String app_ads, String app_interstitial, String app_banner, String app_auth, String app_status) {
        this.app_id = app_id;
        this.app_name = app_name;
        this.app_package = app_package;
        this.app_version = app_version;
        this.app_ads = app_ads;
        this.app_interstitial = app_interstitial;
        this.app_banner = app_banner;
        this.app_auth = app_auth;
        this.app_status = app_status;
    }

    public int getApp_id() {
        return app_id;
    }

    public String getApp_name() {
        return app_name;
    }

    public String getApp_package() {
        return app_package;
    }

    public String getApp_version() {
        return app_version;
    }

    public String getApp_ads() {
        return app_ads;
    }

    public String getApp_interstitial() {
        return app_interstitial;
    }

    public String getApp_banner() {
        return app_banner;
    }

    public String getApp_auth() {
        return app_auth;
    }

    public String getApp_status() {
        return app_status;
    }

}
