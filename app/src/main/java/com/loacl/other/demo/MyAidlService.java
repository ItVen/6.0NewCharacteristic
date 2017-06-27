package com.loacl.other.demo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.loacl.bin.Person;

/**
 * Created by Aven on 2017/2/28.
 */

public class MyAidlService extends Service {
    public MyAidlService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }

    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public String name() throws RemoteException {
            return  "Just Hello World";
        }

        @Override
        public Person getPerson() throws RemoteException {
            return new Person();
        }

        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }
    }

}
