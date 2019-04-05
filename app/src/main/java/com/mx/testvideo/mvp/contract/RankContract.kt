package com.mx.testvideo.mvp.contract

import com.mx.testvideo.base.IBaseView
import com.mx.testvideo.base.IPresenter
import com.mx.testvideo.mvp.model.bean.HomeBean

/**
 * desc: 契约类
 */
interface RankContract {

    interface View : IBaseView {
        /**
         * 设置排行榜的数据
         */
        fun setRankList(itemList: ArrayList<HomeBean.Issue.Item>)

        fun showError(errorMsg: String, errorCode: Int)
    }


    interface Presenter : IPresenter<View> {
        /**
         * 获取 TabInfo
         */
        fun requestRankList(apiUrl: String)
    }
}