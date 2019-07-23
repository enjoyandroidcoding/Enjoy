package com.enjoyandroid.gank

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.enjoyandroid.base.base.BaseActivity
import com.enjoyandroid.base.ext.rx.preventDuplicateClicks
import kotlinx.android.synthetic.main.activity_gank_main.*

/**
 * @author smartsean
 */
@Route(path = "/gank/main")
class GankMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gank_main)
        tv_gank.preventDuplicateClicks()
            .`as`(bindLifecycle(this))
            .subscribe { ARouter.getInstance().build("/wanandroid/main").navigation() }
    }
}
