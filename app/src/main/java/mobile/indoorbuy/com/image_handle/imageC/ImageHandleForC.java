package mobile.indoorbuy.com.image_handle.imageC;

/**
 * Created by BMW on 2018/6/13.
 */

public class ImageHandleForC {
    static {
        System.loadLibrary("imagehandle");
    }

    public static native int[] ImgToGray(int[] buf, int w, int h);
}
