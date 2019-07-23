package com.enjoyandroid.base.ext.rx

import android.view.View
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * 防重复点击的扩展函数
 */
fun View.preventDuplicateClicks(): Observable<Unit> {
    return clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
}

// todo 带自动取消绑定的防重复点击的扩展函数
//fun View.preventDuplicateClicksWithDispose(owner: LifecycleOwner): AutoDisposeConverter<Unit>? {
//    return preventDuplicateClicks()
//        .`as`(AutoDispose.autoDisposable<Unit>(AndroidLifecycleScopeProvider.from(owner)).apply { Unit })
//}