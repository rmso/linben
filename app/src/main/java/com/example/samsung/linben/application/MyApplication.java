package com.example.samsung.linben.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Samsung on 10/12/2017.
 */

public class MyApplication extends Application {

    @Override public void onCreate() {
        super.onCreate();
        //LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        LeakCanary.install(this);
        // Normal app init code...

      //  if (BuildConfig.DEBUG) {
       //     AndroidDevMetrics.initWith(this);
      //  }
    }
}
