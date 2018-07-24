package com.south.prefee.http;

import com.south.prefee.bean.BaseListData;
import com.south.prefee.bean.BaseRequestData;
import com.south.prefee.bean.EditProfileBean;
import com.south.prefee.bean.EditProfileCategoryBean;
import com.south.prefee.bean.ProfileSelectionStaffBean;
import com.south.prefee.bean.TaskListBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @Author zhangshuqi
 * @CreateTime 2018/4/10
 * @Describe
 */

public interface ApiServer {

    @GET
    Observable<BaseRequestData<EditProfileBean>> getEditProfileParams(@Url String url);

    @GET("sample/ashx/mobile/backconfig.ashx?STYPE=TB_PHRASE")
    Observable<BaseRequestData<EditProfileCategoryBean>> getEditProfileTypeCategory(@Query("Identity") String Identity);

    @POST()
    Observable<ResponseBody> uploadFileWithRequestBody(@Url String url, @Body MultipartBody multipartBody);

    @GET("sample/ashx/mobile/backconfig.ashx?STYPE=GETRY")
    Observable<BaseRequestData<BaseListData<ProfileSelectionStaffBean>>> getStaffData();

    @FormUrlEncoded
    @POST("sample/ashx/mobile/TaskProcessIf.ashx?Stype=getUserTodoOrDoneTaskList")
    Observable<BaseRequestData<BaseListData<TaskListBean>>> getTaskList(@FieldMap Map<String, Object> map);
}



