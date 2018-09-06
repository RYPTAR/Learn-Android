#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_nyc_scopeweb_data_LoginActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
