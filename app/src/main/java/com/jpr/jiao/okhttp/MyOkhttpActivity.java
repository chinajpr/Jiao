package com.jpr.jiao.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 类描述：
 * 作者：jiaopeirong on 2019-12-28 10:50
 * 邮箱：chinajpr@163.com
 */
public class MyOkhttpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    private void test() {
        //1.OkHttpClient对象
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new TestInterceptor())
                .dns(new Dns() {
                    @NotNull
                    @Override
                    public List<InetAddress> lookup(@NotNull String s) throws UnknownHostException {
                        return null;
                    }
                })
                .build();

        //2.Request
        Request request = new Request.Builder().
                url("https://www.baidu.com").
                build();
        //3.Call
        Call call = client.newCall(request);
        try {
            //1.同步请求方式
            Response response = call.execute();
            //2.异步请求方式
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    Log.w("cozing", "交易失败");
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    Log.w("cozing", "交易成功");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义拦截器
     * 可以进行URL重定向，body,head，加密，打印日志等
     */
    class TestInterceptor implements Interceptor {
        private String newHost = "127.0.0.1";
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url();
            //http://127.0.0.1/test/upload/img?userName=xiaoming&userPassword=12345
            String scheme = url.scheme();//  http https
            String host = url.host();//   127.0.0.1
            String path = url.encodedPath();//  /test/upload/img
            String query = url.encodedQuery();//  userName=xiaoming&userPassword=12345

            StringBuffer sb = new StringBuffer();
            String newUrl = sb.append(scheme).append(newHost).append(path).append("?").append(query).toString();

            Request.Builder builder = request.newBuilder()
                    .url(newUrl);

            return chain.proceed(builder.build());
        }

    }

}
