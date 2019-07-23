package com.enjoyandroid.base.ext.rx

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.jakewharton.rxbinding3.view.clicks
import com.uber.autodispose.AutoDispose.autoDisposable
import com.uber.autodispose.ObservableSubscribeProxy
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * 防重复点击的扩展函数
 */
fun View.preventDuplicateClicks(): Observable<Unit> {
    return clicks().throttleFirst(500, TimeUnit.MILLISECONDS)
}

/**
 * 避免内存泄漏的 &  防重复点击的扩展函数
 */
fun View.preventDuplicateClicksWithDispose(owner: LifecycleOwner): ObservableSubscribeProxy<Unit>? {
    return preventDuplicateClicks()
        .`as`<ObservableSubscribeProxy<Unit>?>(
            autoDisposable<Unit>(
                (AndroidLifecycleScopeProvider.from(
                    owner,
                    Lifecycle.Event.ON_DESTROY
                ))
            )
        )
}