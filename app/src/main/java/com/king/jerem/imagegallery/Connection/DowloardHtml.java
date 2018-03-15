package com.king.jerem.imagegallery.Connection;

import android.os.AsyncTask;

import com.king.jerem.imagegallery.Callback.Listenner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jerem on 14/03/2018.
 */

public class DowloardHtml extends AsyncTask<String,Void,String> {
    OkHttpClient okHttpClient;
    String s="";

    public DowloardHtml() {

        okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
    }

    @Override
    protected void onPostExecute(String s) {

        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(String... strings) {
        Request.Builder builder=new Request.Builder();
        builder.url(Config.ProtocolsURL+strings[0]);
        Request request=builder.build();

        try {
            Response response=okHttpClient.newCall(request).execute();
            s= response.body().string();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
