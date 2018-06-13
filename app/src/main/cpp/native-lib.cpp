#include <jni.h>
#include <string>

#include "AndroidLog.h"
#include "GrayHandle.h"

extern "C" {
JNIEXPORT jintArray JNICALL
Java_mobile_indoorbuy_com_image_1handle_imageC_ImageHandleForC_ImgToGray(JNIEnv *env, jclass type,
                                                                         jintArray buf_, jint w,
                                                                         jint h) {
    jint *buf = env->GetIntArrayElements(buf_, NULL);
    if (buf == NULL) {
        LOGE("输入像素为空");
        return 0;
    }

    int size = w * h;

    GrayHandle handle(size,buf);
    jintArray result = handle.gray(env);

    env->ReleaseIntArrayElements(buf_, buf, 0);
    return result;
}
}