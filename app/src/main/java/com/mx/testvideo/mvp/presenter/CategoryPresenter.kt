package com.mx.testvideo.mvp.presenter

import com.mx.testvide.net.exception.ExceptionHandle
import com.mx.testvideo.base.BasePresenter
import com.mx.testvideo.mvp.contract.CategoryContract
import com.mx.testvideo.mvp.model.CategoryModel

/**
 * desc:分类的 Presenter
 */
class CategoryPresenter : BasePresenter<CategoryContract.View>(), CategoryContract.Presenter {

    private val categoryModel: CategoryModel by lazy {
        CategoryModel()
    }

    /**
     * 获取分类
     */
    override fun getCategoryData() {
        checkViewAttached()
        mRootView?.showLoading()
        val disposable = categoryModel.getCategoryData()
            .subscribe({ categoryList ->
                mRootView?.apply {
                    dismissLoading()
                    showCategory(categoryList)
                }
            }, { t ->
                mRootView?.apply {
                    //处理异常
                    showError(ExceptionHandle.handleException(t), ExceptionHandle.errorCode)
                }

            })

        addSubscription(disposable)
    }
}