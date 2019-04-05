package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.HomeBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

class RankModel {

    /**
     * 获取排行榜
     */
    fun requestRankList(apiUrl: String): Observable<HomeBean.Issue> {

        return RetrofitManager.service.getIssueData(apiUrl)
            .compose(SchedulerUtils.ioToMain())
    }

}
