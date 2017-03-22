package bilibili.bilibili.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

/**
 * Created by XUERU on 2017/3/12.
 */

public class LoadNet {

    public static void getDataPost(final String url, final LoadFromNet loadFromNet){

        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                        if(loadFromNet != null) {
                            loadFromNet.failure(e.getMessage());
                        }
                    }

                    @Override
                    public void onResponse(String response, int id) {

                        if(loadFromNet != null) {
                            loadFromNet.success(response);
                        }
                    }
                });

    }


}
