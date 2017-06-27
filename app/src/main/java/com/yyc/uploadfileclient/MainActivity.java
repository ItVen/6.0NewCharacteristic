package com.yyc.uploadfileclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.yyc.uploadfileclient.bean.BaseResponse;
import com.yyc.uploadfileclient.http.Api;
import com.yyc.uploadfileclient.http.FileUploadService;
import com.yyc.uploadfileclient.http.MultipartBuilder;

import java.io.File;
import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author yaoyongchao
 * @time 2016/9/9 0:45
 * @description: Retrofit 2.0 单文件、多文件上传demo
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Logger.init(TAG);
    }

    @OnClick({R.id.btn_monofile, R.id.btn_multifile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_monofile:
                String filename = "/sdcard/test/test.txt";
                uploadMonofile(filename);
                break;
            case R.id.btn_multifile:
                ArrayList<File> list = new ArrayList<File>();
                list.add(new File("/sdcard/test/test.jpg"));
                list.add(new File("/sdcard/test/test.png"));
                uploadMultifile(list);
                break;
        }
    }

    private void uploadMonofile(String filename){
        //先创建 service
        FileUploadService service = Api.getDefault();
        //构建要上传的文件
        File file = new File(filename);
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("application/otcet-stream"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("aFile", file.getName(), requestFile);

        String descriptionString = "This is a description";
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);

        Call<BaseResponse<String>> call = service.upload(description, body);
        call.enqueue(new Callback<BaseResponse<String>>() {
            @Override
            public void onResponse(Call<BaseResponse<String>> call,
                                   Response<BaseResponse<String>> response) {
                System.out.println("success");
                Logger.e("success:" + response.body().getResultMessage());
            }

            @Override
            public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                t.printStackTrace();
                Logger.e("error:" + t.getMessage());
            }
        });
    }

    private void uploadMultifile(ArrayList<File> mFileList) {
        MultipartBody body = MultipartBuilder.filesToMultipartBody(mFileList);
        Api.getDefault().uploadFileWithRequestBody(body)
                .enqueue(new Callback<BaseResponse<String>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                        Logger.e("onResponse--" + response.body().getResultMessage());
                        if (response.isSuccessful()) {
                            BaseResponse<String> body = response.body();
                            Logger.e("onResponse----success" );
                        } else {
                            Log.d(TAG,"上传失败");
                            Logger.e("onResponse----fail" );
                        }
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<String>> call, Throwable t) {
                        Logger.e("onResponse----onFailure"+ t.getMessage());
                    }
                });
    }

}
