package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.TabInfoBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * desc: 热门 Model
 */
class HotTabModel {

    /**
     * 获取 TabInfo
     */
    fun getTabInfo(): Observable<TabInfoBean> {

        return RetrofitManager.service.getRankList()
            .compose(SchedulerUtils.ioToMain())
    }

}
