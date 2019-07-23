package com.enjoyandroid.base.base.mvvm

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.enjoyandroid.base.base.BaseActivity

open abstract class BaseMVVMActivity<V : ViewDataBinding, VM : ViewModel> : BaseActivity() {


    abstract fun inflateView(): Int;


    protected lateinit var mBinding: V
    protected lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView<V>(this, inflateView());
//        mViewModel = ViewModelProviders.of(this).get(VM::class.java);

    }


}