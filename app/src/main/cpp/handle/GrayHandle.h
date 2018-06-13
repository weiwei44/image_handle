//
// Created by BMW on 2018/6/13.
//

#ifndef IMAGE_HANDLE_GRAYHANDLE_H
#define IMAGE_HANDLE_GRAYHANDLE_H

#include <jni.h>
#include "Color.h"
class GrayHandle {

public:
    GrayHandle(int,int*);
    void gray();
    jintArray gray(JNIEnv*);
    jintArray handleResult(JNIEnv*);

private:
    int size;
    int* pixels;
};


#endif //IMAGE_HANDLE_GRAYHANDLE_H
