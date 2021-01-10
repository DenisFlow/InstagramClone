package com.example.instagramclone;

import android.app.Application;
import android.widget.EditText;

import com.parse.Parse;

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("RXmofNBOuFcmZtMMCfT1wshApqcEzGdPtcVZKcp7")
                // if defined
                .clientKey("05qeJ6gRGD8iWMFpMkgBwog8ve7ey3QHoyCHQA8R")
                .server("https://parseapi.back4app.com/")
                .build()
        );

    }
}
