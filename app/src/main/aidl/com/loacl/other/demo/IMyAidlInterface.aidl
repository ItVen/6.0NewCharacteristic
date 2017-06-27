// IMyAidlInterface.aidl
package com.loacl.other.demo;

// Declare any non-default types here with import statements
import com.loacl.bin.Person;
interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    String name();

    Person getPerson();

    int getPid();

}
