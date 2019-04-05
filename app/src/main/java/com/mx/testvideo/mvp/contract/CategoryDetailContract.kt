package com.mx.testvideo.mvp.contract

import com.mx.testvideo.base.IBaseView
import com.mx.testvideo.base.IPresenter
import com.mx.testvideo.mvp.model.bean.HomeBean

/**
 * desc: 分类详情契约类
 */
interface CategoryDetailContract {

    interface View : IBaseView {
        /**
         *  设置列表数据
         */
        fun setCateDetailList(itemList: ArrayList<HomeBean.Issue.Item>)

        fun showError(errorMsg: String)


    }

    interface Presenter : IPresenter<View> {

        fun getCategoryDetailList(id: Long)

        fun loadMoreData()
    }
}