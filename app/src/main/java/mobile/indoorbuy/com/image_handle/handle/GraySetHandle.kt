package mobile.indoorbuy.com.image_handle.handle

import kotlin.math.max

/**
 * Created by BMW on 2018/6/12.
 * 图像灰度集合操作
 */

object GraySetHandle{

    fun handleSet(pixels:IntArray){
        for (index in 0 until pixels.size){
            val color = pixels[index]

            val alpha = (color and -0x1000000) ushr 24  //取无符号最高位
            val newAlpha = alpha shl 24 or 0x00ffffff

            var red = (color and 0x00ff0000) shr 16 // 取高两位  int red = Color.red(pixel)这些函数也能获取具体像素
            red = max(red,255 - red)
            val newRed = red shl 16 or -0xff0001


            var green = (color and 0x0000ff00) shr 8 // 取中两位
            green = max(green,255 - green)
            val newGreen = green shl 8 or -0xff01

            var blue = color and 0x000000ff // 取低两位
            blue = max(blue,255 - blue)
            val newBlue = blue or -0x100

            val newColor = newRed and newGreen and newBlue and newAlpha   //跟此函数同理Color.argb(alpha, red, green, blue)
            pixels[index] = newColor
        }
    }

    //生成灰度图
    fun handleSet1(pixels:IntArray){
        for(index in 0 until pixels.size){

        }
    }

}