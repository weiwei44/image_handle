//
// Created by BMW on 2018/6/13.
//

#ifndef IMAGE_HANDLE_COLOR_H
#define IMAGE_HANDLE_COLOR_H

#include <sys/types.h>

class Color{
public:
    Color(u_int);
    Color(int alpha,int red,int green,int blue);
    ~Color();
    int argb();
    int getAlpha();
    int getRed();
    int getGreen();
    int getBlue();
    int getGray();

private:
    int alpha;
    int red;
    int green;
    int blue;
};

#endif //IMAGE_HANDLE_COLOR_H
