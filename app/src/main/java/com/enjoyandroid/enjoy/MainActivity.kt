package com.enjoyandroid.enjoy

import android.os.Bundle
import com.alibaba.android.arouter.launcher.ARouter
import com.enjoyandroid.base.base.BaseActivity
import com.enjoyandroid.base.ext.rx.preventDuplicateClicks
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        tv_gank.preventDuplicateClicks()
            .`as`(bindLifecycle(this))
            .subscribe { ARouter.getInstance().build("/gank/main").navigation() }

        tv_wanandroid.preventDuplicateClicks()
            .`as`(bindLifecycle(this))
            .subscribe { ARouter.getInstance().build("/wanandroid/main").navigation() }


    }
}
