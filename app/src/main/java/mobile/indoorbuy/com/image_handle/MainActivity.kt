package mobile.indoorbuy.com.image_handle

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import mobile.indoorbuy.com.image_handle.handle.BitConvertHandle
import mobile.indoorbuy.com.image_handle.handle.GraySetHandle
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

        //GraySetHandle.handleSet(pixels)
        BitConvertHandle.handleSet(pixels,16)

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
