package com.toy.key.cjni;

public class JNIHelper {
    // Used to load the 'JNILibrary' library on application startup.
    //加载到系统 自定义的JNILibrary 库
    static {
        System.loadLibrary("JNILibrary");
    }

    /**
     * A native method that is implemented by the 'JNILibrary' native library,
     * which is packaged with this application.
     * 声明JNILibrary库中获取String的方法
     */
    public static native String stringFromJNI();
    /**
     * 注册NativeListener监听
     */
    public static native void registerListener(NativeListener listener);
}
