package com.yyc.uploadfileclient.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: yaoyongchao
 * @date: 2016/9/2 13:48
 * @description:
 */
public class Api {
    private static FileUploadService SERVICE;
    private static final String BASE_URL = "http://192.168.1.100:8080/UploadFileServer/";

    public static FileUploadService getDefault() {
        if(SERVICE == null) {

            OkHttpClient client = new OkHttpClient.Builder().build();
            SERVICE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build().create(FileUploadService.class);
        }

        return SERVICE;
    }


}
