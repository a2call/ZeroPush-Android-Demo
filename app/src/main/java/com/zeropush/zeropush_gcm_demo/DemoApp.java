package com.zeropush.zeropush_gcm_demo;

import android.app.Application;
import android.util.Log;

import com.zeropush.sdk.ZeroPush;
import com.zeropush.sdk.ZeroPushResponseHandler;

import org.json.JSONObject;

public class DemoApp extends Application {

    private static ZeroPush zeroPush;

    @Override
    public void onCreate() {
        super.onCreate();

        zeroPush = new ZeroPush("zeropush-app-token", "gcm-project-number", this);
        zeroPush.verifyCredentials(new ZeroPushResponseHandler(){
            @Override
            public void handle(JSONObject response, int statusCode, Error error) {
                if(error != null) {
                    Log.e("DemoApp", error.getMessage());
                    return;
                }
                Log.d("DemoApp", response.toString());
            }
        });

        zeroPush.registerForRemoteNotifications();
    }

    public static ZeroPush getZeroPush() {
        return zeroPush;
    }


}
