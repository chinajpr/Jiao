package com.jpr.jiao.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.jiao.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-01-05 22:10
 * 邮箱：chinajpr@163.com
 */
public class RetrofitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
    }


    public void request() {

        //步骤4:创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        // 步骤5:创建 网络请求接口 的实例
        PostRequest_Interface request = retrofit.create(PostRequest_Interface.class);

        //对 发送请求 进行封装(设置需要翻译的内容)
        Call<Translation> call = request.getCall("I love you");

        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {

            //请求成功时回调
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                // 步骤7：处理返回的数据结果：输出翻译的内容
                System.out.println(response.body().getTranslateResult().get(0).get(0).getTgt());
            }

            //请求失败时回调
            @Override
            public void onFailure(Call<Translation> call, Throwable throwable) {
                System.out.println("请求失败");
                System.out.println(throwable.getMessage());
            }
        });
    }

    public void net(View view) {
        request();
    }

}
