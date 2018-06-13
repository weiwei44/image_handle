//
// Created by BMW on 2018/6/13.
//

#include "GrayHandle.h"

GrayHandle::GrayHandle(int size,int* pixels)
        :size(size),pixels(pixels){}

void GrayHandle::gray() {
    for (int i = 0; i < size; i++) {
        Color color((u_int) pixels[i]);
        int gray = color.getGray();
        pixels[i] = gray;
    }
}

jintArray GrayHandle::gray(JNIEnv *env) {
    gray();
    return handleResult(env);
}

jintArray GrayHandle::handleResult(JNIEnv *env) {
    jintArray result = env->NewIntArray(size);
    env->SetIntArrayRegion(result, 0, size, pixels);
    return result;
}