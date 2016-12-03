package com.rc.portal.webapp.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by ws on 2015/7/20.
 */
public class GetImageFile {

    public static void saveImgFile( String imgUrl, String imageSavePath )
    {
        try {
            URL url = new URL( imgUrl );
            BufferedInputStream bis = new BufferedInputStream(url.openStream());
            byte[] bytes = new byte[1024];
            File file = new File( imageSavePath );
            OutputStream bos = new FileOutputStream( file );
            int len = 0;
            while ( (len = bis.read(bytes)) > 0) {
                bos.write(bytes, 0, len);
            }
            bis.close();
            bos.flush();
            bos.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static  void main( String args[] )
    {
        String imageSavePath = "E:\\MyWork\\给运营\\甘肃德生堂场景二维码\\images\\lz8179_东方解放桥超市.jpg";;
        String imgUrl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQH_8ToAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0dIVXE0SVRsUEFkRklnNlZaRjFoAAIEn62sVQMEAAAAAA%3D%3D";
        GetImageFile.saveImgFile( imgUrl, imageSavePath );
    }
}
