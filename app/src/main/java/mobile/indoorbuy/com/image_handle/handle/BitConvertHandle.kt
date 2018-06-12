package mobile.indoorbuy.com.image_handle.handle

import android.graphics.Color
import android.util.Log
import mobile.indoorbuy.com.image_handle.utils.Content.TAG

/**
 * Created by BMW on 2018/6/12.
 */
object BitConvertHandle{
    /**
     * @param pixels 像素数组
     * @param bit 转换为多少比特的图像
     *
     * f1 = f - min(f)   先将图像像素减去最小值
     * f2 = bit*(f1 / max(f1))  在除以最大值，乘以转换的bit
     */
    fun handleSet(pixels:IntArray,bit1 :Int) {
         val bit:Int = Math.pow(2.0,bit1.toDouble()).toInt()-1

        Log.e(TAG,"bit==$bit")
        var minRed = 0
        var maxRed = 0
        var minGreen = 0
        var maxGreen = 0
        var minBlue = 0
        var maxBlue = 0
        //求各个颜色分量的最小值
        for (index in 0 until pixels.size) {
            if(index == 1 ||index == 2 ||index == 3) {
                val alpha1 = Color.alpha(pixels[index])
                val red1 = Color.red(pixels[index])
                val green1 = Color.green(pixels[index])
                val blue1 = Color.blue(pixels[index])
                val result = Color.argb(alpha1,red1,green1,blue1)
                Log.e(TAG,"pixel = ${pixels[index]},alpha1=$alpha1,red = $red1,green = $green1,blue = $blue1,result = $result")
            }

            val red = Color.red(pixels[index]).apply {
                if (index == 0){
                    minRed = this
                }

                if(this < minRed){
                    minRed = this
                }
            }
            val green = Color.green(pixels[index]).apply {
                if (index == 0){
                    minGreen = this
                }
                if(this < minGreen){
                    minGreen = this
                }
            }
            val blue = Color.blue(pixels[index]).apply {
                if (index == 0){
                    minBlue = this
                }
                if(this < minBlue){
                    minBlue = this
                }
            }
        }

        //把每个颜色分量减去对应的最小值
        for (index in 0 until pixels.size) {
            val alpha = Color.alpha(pixels[index])
            val red = Color.red(pixels[index]).run {
               this - minRed
            }
            val green = Color.green(pixels[index]).run {
                this - minGreen
            }
            val blue = Color.blue(pixels[index]).run {
                this - minBlue
            }
            pixels[index] = Color.argb(alpha,red,green,blue)
        }
            //求各个颜色分量的最大值
        for (index in 0 until pixels.size) {
            val red = Color.red(pixels[index]).apply {
                if (index == 0){
                    maxRed = this
                }

                if(this > maxRed){
                    maxRed = this
                }

            }
            val green = Color.green(pixels[index]).apply {
                if (index == 0){
                    maxGreen = this
                }

                if(this > maxGreen){
                    maxGreen = this
                }

            }
            val blue = Color.blue(pixels[index]).apply {
                if (index == 0){
                    maxBlue = this
                }

                if(this > maxBlue){
                    maxBlue = this
                }

            }
        }

        Log.e(TAG,"minred =$minRed,maxred=$maxRed,mingreen=$minGreen,maxgreen=$maxGreen,minblue=$minBlue,maxblue=$maxBlue")
        //把每个颜色分量运算
        for (index in 0 until pixels.size) {
            val alpha = Color.alpha(pixels[index])
            val red = Color.red(pixels[index]).run {
                bit*this/maxRed.toFloat().toInt()
            }
            val green = Color.green(pixels[index]).run {
                bit*this/maxGreen.toFloat().toInt()
            }
            val blue = Color.blue(pixels[index]).run {
                bit*this/maxBlue.toFloat().toInt()
            }

            pixels[index] = Color.argb(alpha,red,green,blue)
        }

    }
}