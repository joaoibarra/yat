package com.joaoibarra.yat.feature;


import android.util.Base64;

public class Constants {
    public static final String API_KEY = "twp_k9ejP88LcuojHjmFkUFuYIUNYalg";
    public static final String API_KEY_BASE64 = Base64.encodeToString(API_KEY.getBytes(), Base64.DEFAULT);
    public static final String API_URL = "https://yat.teamwork.com/";
    public static final String PROJECT_DETAIL = "project_detail";
}
