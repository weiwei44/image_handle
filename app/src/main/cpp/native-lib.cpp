#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring

JNICALL
Java_mobile_indoorbuy_com_image_1handle_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
