package com.mx.testvideo.mvp.presenter

import com.mx.testvide.net.exception.ExceptionHandle
import com.mx.testvideo.base.BasePresenter
import com.mx.testvideo.mvp.contract.HotTabContract
import com.mx.testvideo.mvp.model.HotTabModel

/**
 * desc: 获取 TabInfo Presenter
 */
class HotTabPresenter : BasePresenter<HotTabContract.View>(), HotTabContract.Presenter {

    private val hotTabModel by lazy { HotTabModel() }


    override fun getTabInfo() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = hotTabModel.getTabInfo()
            .subscribe({ tabInfo ->
                mRootView?.setTabInfo(tabInfo)
            }, { throwable ->
                //处理异常
                mRootView?.showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
            })
        addSubscription(disposable)
    }
}