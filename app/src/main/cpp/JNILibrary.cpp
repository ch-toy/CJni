//
// Created by MZJ on 2020-04-22.
//
#include <jni.h>
#include <string>

//声明变量
jobject _listener;//
JNIEnv* _env;
jmethodID  _changeTextMethodID;
jclass _class;
extern "C"
JNIEXPORT jstring JNICALL
Java_com_toy_key_cjni_JNIHelper_stringFromJNI(JNIEnv *env, jobject thiz) {
        //当调用stringFromJNI时调用registerListener中NativeListener的changeText回调函数
        _env->CallVoidMethod(_listener, _changeTextMethodID,  _env->NewStringUTF("你猜我说啥了"));
        //创建变量std并赋值为Hello from C++
        std::string hello = "Hello from C++";
        //返回数据
        return env->NewStringUTF(hello.c_str());
}


extern "C"
JNIEXPORT void JNICALL
Java_com_toy_key_cjni_JNIHelper_registerListener(JNIEnv *env, jclass clazz, jobject listener) {
        // TODO: implement registerListener()
        //将对应的类和方法存放临时变量
        _listener = env->NewGlobalRef(listener);//获取对象类
        _env = env;
        _class = _env->GetObjectClass(_listener);//获取实体类
        _changeTextMethodID = _env->GetMethodID(_class, "changeText", "(Ljava/lang/String;)V");//获取方法
}