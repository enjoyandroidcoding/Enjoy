package com.enjoyandroid.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

open class BaseApplication :Application(){


    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}