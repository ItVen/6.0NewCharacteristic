package com.loacl.other.demo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.github.johnpersano.supertoasts.SuperToast;
import com.loacl.bin.Person;
import com.loacl.ucloud.myrxjavademo.R;


/**
 * Created by Aven on 2017/2/28.
 *
 */

public class TestAidlAct extends AppCompatActivity {

    private IMyAidlInterface iService;
    private boolean bindService;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iService = IMyAidlInterface.Stub.asInterface(service);
            try {
                final String hello = iService.name();
                Log.e("tag","hello::::::::" + hello);
                final Person one = iService.getPerson();
                Log.e("tag",one+"");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        SuperToast.cancelAllSuperToasts();
                        SuperToast.create(getApplicationContext(), hello, SuperToast.Duration.MEDIUM).show();
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iService = null;
            Log.e("tag","iService::::::::" + iService);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_aidltest);
        Log.i("tag","::onCreate:::::");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag","iService::onStart::::::");
        final Intent in = new Intent();
        in.setClassName(this, "com.pythoncat.aidl_libiary.HelloService");
        in.setPackage("com.pythoncat.aidl_libiary");
        in.setAction("com.pythoncat.aidl_libiary.HelloService");
        bindService = bindService(in, conn, Context.BIND_AUTO_CREATE);
        Log.e("tag","bindService=" + bindService);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag","iService::onStop::::::");
        if (conn != null) {
            unbindService(conn);
        }
    }

    public void Test(View v) {
        Log.e("tag","bindService=" + bindService);
        Log.e("tag",iService+"");
        if (iService == null) {
            Log.i("tag","::iService == null::::::");
            SuperToast.cancelAllSuperToasts();
            SuperToast.create(getApplicationContext(), iService + "", SuperToast.Duration.MEDIUM).show();
        } else {
            Log.i("tag","::iService != null::::::");
            SuperToast.cancelAllSuperToasts();
            try {
                SuperToast.create(getApplicationContext(), iService.name(), SuperToast.Duration.MEDIUM).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}