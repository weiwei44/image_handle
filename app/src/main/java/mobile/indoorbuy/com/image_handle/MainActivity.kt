package mobile.indoorbuy.com.image_handle

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import mobile.indoorbuy.com.image_handle.utils.Content.TAG
import mobile.indoorbuy.com.image_handle.utils.ImagePixelUtls

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opt = BitmapFactory.Options()
        opt.inPreferredConfig = Bitmap.Config.ARGB_8888
        val bitmap = BitmapFactory.decodeResource(resources,R.mipmap.test)

        // 保存所有的像素的数组，图片宽×高
        val pixels = ImagePixelUtls.getPixel(bitmap)

        for (index in 0 until pixels.size){
            val color = pixels[index]

            val alpha = (color and -0x1000000) ushr 24  //取无符号最高位
            val newAlpha = alpha shl 24 or 0x00ffffff

            var red = (color and 0x00ff0000) shr 16 // 取高两位  int red = Color.red(pixel)这些函数也能获取具体像素
            red = 255 - red
            val newRed = red shl 16 or -0xff0001

            var green = (color and 0x0000ff00) shr 8 // 取中两位
            green = 255 - green
            val newGreen = green shl 8 or -0xff01

            var blue = color and 0x000000ff // 取低两位
            blue = 255 - blue
            val newBlue = blue or -0x100

            val newColor = newRed and newGreen and newBlue and newAlpha   //跟此函数同理Color.argb(alpha, red, green, blue)
            pixels[index] = newColor
        }

        val newBitmap = Bitmap.createBitmap(bitmap.width,bitmap.height,bitmap.config)
        newBitmap.setPixels(pixels,0,bitmap.width,0,0,bitmap.width,bitmap.height)
        iv_show.setImageBitmap(newBitmap)
    }


    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}
