package com.modules.gobeyond.module_login;

import android.app.Application;
import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Created by gusta_000 on 9/12/2015.
 */
public class Global extends Application {

    public static final String APP_NAME = "MPApp";

    private static WeakReference<Context> mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = new WeakReference<Context>(this);
    }

    public static Context getContext()  {
        return mContext.get();
    }
}
