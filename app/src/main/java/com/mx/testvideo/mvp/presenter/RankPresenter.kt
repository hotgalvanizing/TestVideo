package com.mx.testvideo.mvp.presenter

import com.mx.testvide.net.exception.ExceptionHandle
import com.mx.testvideo.base.BasePresenter
import com.mx.testvideo.mvp.contract.RankContract
import com.mx.testvideo.mvp.model.RankModel

class RankPresenter : BasePresenter<RankContract.View>(), RankContract.Presenter {

    private val rankModel by lazy { RankModel() }


    /**
     *  请求排行榜数据
     */
    override fun requestRankList(apiUrl: String) {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = rankModel.requestRankList(apiUrl)
            .subscribe({ issue ->
                mRootView?.apply {
                    dismissLoading()
                    setRankList(issue.itemList)
                }
            }, { throwable ->
                mRootView?.apply {
                    //处理异常
                    showError(ExceptionHandle.handleException(throwable), ExceptionHandle.errorCode)
                }
            })
        addSubscription(disposable)
    }
}