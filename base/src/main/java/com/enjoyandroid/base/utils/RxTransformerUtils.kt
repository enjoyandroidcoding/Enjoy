package com.enjoyandroid.base.utils

import io.reactivex.ObservableTransformer
import java.util.concurrent.TimeUnit

/**
 * 定义一些常用的 RxTransformer
 */
object RxTransformerUtils {


    /**
     * 防止重复点击的Transformer
     */
    @JvmStatic
    fun <T> auto(
        windowDuration: Long = 500, timeUnit: TimeUnit = TimeUnit.MILLISECONDS
    ): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream -> upstream.throttleFirst(windowDuration, timeUnit) }
    }
}