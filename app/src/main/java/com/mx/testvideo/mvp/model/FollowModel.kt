package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.HomeBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * desc: 关注Model
 */
class FollowModel {

    /**
     * 获取关注信息
     */
    fun requestFollowList(): Observable<HomeBean.Issue> {

        return RetrofitManager.service.getFollowInfo()
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多
     */
    fun loadMoreData(url:String):Observable<HomeBean.Issue>{
        return RetrofitManager.service.getIssueData(url)
                .compose(SchedulerUtils.ioToMain())
    }


}
