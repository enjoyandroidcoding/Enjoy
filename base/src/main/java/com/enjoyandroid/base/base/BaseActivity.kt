package com.enjoyandroid.base.base

import android.content.Context
import android.os.Bundle

open class BaseActivity : AutoDisposeActivity() {

    protected lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
    }
}