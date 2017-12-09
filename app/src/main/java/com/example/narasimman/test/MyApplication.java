package com.example.narasimman.test;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Narasimman on 09-12-2017.
 */

public class MyApplication extends Application {
    public static MyApplication mInstance;
    public static RequestQueue requestQueue;
    public static String TAG="DEFAULT";
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
    public static MyApplication getmInstance(){
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(this.getApplicationContext());
        }
        return requestQueue;
    }



    public  <T>  void addToRequestQueue(Request<T> request){
        request.setTag(TAG);
        getRequestQueue().add(request);
    }

    public void cancelPendingRequests(Object tag){
        if(requestQueue!=null){
            requestQueue.cancelAll(tag);
        }
    }
}
