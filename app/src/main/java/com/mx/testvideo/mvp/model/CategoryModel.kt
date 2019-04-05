package com.mx.testvideo.mvp.model

import com.mx.testvide.net.RetrofitManager
import com.mx.testvideo.mvp.model.bean.CategoryBean
import com.mx.testvideo.rx.scheduler.SchedulerUtils
import io.reactivex.Observable

/**
 * desc: 分类数据模型
 */
class CategoryModel {


    /**
     * 获取分类信息
     */
    fun getCategoryData(): Observable<ArrayList<CategoryBean>> {
        return RetrofitManager.service.getCategory()
            .compose(SchedulerUtils.ioToMain())
    }
}