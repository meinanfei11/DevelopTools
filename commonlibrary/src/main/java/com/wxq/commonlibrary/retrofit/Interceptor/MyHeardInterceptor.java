package com.wxq.commonlibrary.retrofit.Interceptor;

import android.util.Log;

import com.wxq.commonlibrary.util.TimeUtils;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * author:wxq
 * email:805380422@qq.com
 * time:2018/10/23
 * desc: 处理请求头
 * version:1.0
 */
public class MyHeardInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    @Override
    public Response intercept(Chain chain) throws IOException {
        //请求前
        Request oldRequest = chain.request();
        Headers headers = oldRequest.headers();
        String url = oldRequest.url().toString();
        RequestBody body = oldRequest.body();
        String json = bodyToString(oldRequest);
        Request.Builder builder = oldRequest.newBuilder()
                .header("name", "wxq")
                .header("age", "100");
        long startTime=TimeUtils.getNowMills();
        //请求后
        Log.e("wxq","myheard_startTime"+startTime);
        Response response= chain.proceed(builder.build());
        long endTime=TimeUtils.getNowMills();
        Log.e("wxq","myheard_endTime"+(endTime-startTime));
        Log.e("wxq","myheard_response.body"+response.body().toString());

        return response;
    }

    public static String bodyToString(Request request) {
        try {
            RequestBody body = request.body();
            if (body == null) {
                return "";
            }
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset charset = getCharset(body.contentType());
            return buffer.readString(charset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static Charset getCharset(MediaType contentType) {
        Charset charset = contentType != null ? contentType.charset(UTF8) : UTF8;
        if (charset == null) {
            charset = UTF8;
        }
        return charset;
    }
}