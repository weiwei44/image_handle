package mobile.indoorbuy.com.image_handle.utils

import android.graphics.Bitmap

/**
 * Created by BMW on 2018/6/12.
 */
object ImagePixelUtls{

    fun getPixel(bitmap:Bitmap):IntArray{
        val width = bitmap.width
        val height = bitmap.height
        val pixels = IntArray(width*height).apply {
            bitmap.getPixels(this,0,width,0,0,width,height)
            for (index in 0 until size){
                val color = this[index]
                val red = color and 0x00ff0000 shr 16 // 取高两位
                val green = color and 0x0000ff00 shr 8 // 取中两位
                val blue = color and 0x000000ff // 取低两位
            }
        }
        return pixels
    }


}