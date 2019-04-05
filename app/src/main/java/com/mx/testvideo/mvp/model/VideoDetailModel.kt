package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.HomeBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable


class VideoDetailModel {

    fun requestRelatedData(id: Long): Observable<HomeBean.Issue> {

        return RetrofitManager.service.getRelatedData(id)
            .compose(SchedulerUtils.ioToMain())
    }

}