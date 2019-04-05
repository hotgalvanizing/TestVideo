package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.HomeBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * desc: 首页精选 model
 */

class HomeModel{

    /**
     * 获取首页 Banner 数据
     */
    fun requestHomeData(num:Int):Observable<HomeBean>{
        return RetrofitManager.service.getFirstHomeData(num)
                .compose(SchedulerUtils.ioToMain())
    }

    /**
     * 加载更多
     */
    fun loadMoreData(url:String):Observable<HomeBean>{

        return RetrofitManager.service.getMoreHomeData(url)
                .compose(SchedulerUtils.ioToMain())
    }



}
