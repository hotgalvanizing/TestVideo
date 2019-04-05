package com.mx.testvideo.mvp.contract

import com.mx.testvideo.base.IBaseView
import com.mx.testvideo.base.IPresenter
import com.mx.testvideo.mvp.model.bean.TabInfoBean

/**
 * desc: 契约类
 */
interface HotTabContract {

    interface View : IBaseView {
        /**
         * 设置 TabInfo
         */
        fun setTabInfo(tabInfoBean: TabInfoBean)

        fun showError(errorMsg: String, errorCode: Int)
    }


    interface Presenter : IPresenter<View> {
        /**
         * 获取 TabInfo
         */
        fun getTabInfo()
    }
}