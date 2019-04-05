package com.mx.testvideo.mvp.contract

import com.mx.testvideo.base.IBaseView
import com.mx.testvideo.base.IPresenter
import com.mx.testvideo.mvp.model.bean.CategoryBean

/**
 * desc: 分类 契约类
 */
interface CategoryContract {

    interface View : IBaseView {
        /**
         * 显示分类的信息
         */
        fun showCategory(categoryList: ArrayList<CategoryBean>)

        /**
         * 显示错误信息
         */
        fun showError(errorMsg: String, errorCode: Int)
    }

    interface Presenter : IPresenter<View> {
        /**
         * 获取分类的信息
         */
        fun getCategoryData()
    }
}