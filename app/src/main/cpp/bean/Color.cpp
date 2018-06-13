#include "Color.h"

//
// Created by BMW on 2018/6/13.
//
Color::Color(u_int color) {
    alpha = (color & 0xff000000) >> 24;
    red = (color & 0x00ff0000) >> 16;
    green = (color & 0x0000ff00) >> 8;
    blue = color & 0x000000ff;
}

Color::Color(int alpha,int red,int green,int blue)
        :alpha(alpha),red(red),green(green),blue(blue){

}

Color::~Color() {}

int Color::argb(){
    int tempAlpha = (alpha << 24) | 0x00ffffff;
    int tempRed = (red << 16) | 0xff00ffff;
    int tempGreen = (green << 8) | 0xffff00ff;
    int tempBlue = alpha | 0xffffff00;

    return tempAlpha & tempRed & tempGreen & tempBlue;
}

int Color::getAlpha() {
    return alpha;
}
int Color::getRed() {
    return red;
}
int Color::getBlue() {
    return blue;
}
int Color::getGreen()  {
    return green;
}

int Color::getGray() {
    int tempAlpha = 0xFF << 24;
    int grey = (int)((float) red * 0.3 + (float)green * 0.59 + (float)blue * 0.11);
    grey = tempAlpha | (grey << 16) | (grey << 8) | grey;
    return grey;
}


