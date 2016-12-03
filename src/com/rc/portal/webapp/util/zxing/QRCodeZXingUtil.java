package com.rc.portal.webapp.util.zxing;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.apache.commons.lang.math.RandomUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.rc.portal.webapp.util.FileUtil;
import com.rc.portal.webapp.util.GetImageFile;
import com.rc.portal.webapp.util.StringUtil;
import com.rc.portal.webapp.util.UUIDTools;

/**
 * Created by ws on 2015/10/8.
 */
public class QRCodeZXingUtil {
    
    private final static int RGB_WHITE = 0xFFFFFFFF;
    private final static int RGB_BLACK = 0xFF000000;
    private final static float defaultLogoScale = 0.14f;
    private final static int defaultQRCodeSize = 600;

    public static boolean encoderQRCoder(String content, OutputStream outputStream, int qrcodeSize)
    {
        return encoderQRCoder( content, outputStream, qrcodeSize, null, 0, 0, false, RGB_BLACK );
    }

    public static boolean encoderQRCoder(String content, OutputStream outputStream, int qrcodeSize, int rgb )
    {
        return encoderQRCoder( content, outputStream, qrcodeSize, null, 0, 0, false, rgb );
    }
    public static boolean encoderQRCoder(  String content, OutputStream outputStream, int qrcodeSize, String logoImgPath )
    {
        return encoderQRCoder( content, outputStream, qrcodeSize, logoImgPath, Math.round( qrcodeSize * defaultLogoScale ) , Math.round( qrcodeSize * defaultLogoScale ), true, RGB_BLACK );
    }

    public static boolean encoderQRCoder(  String content, OutputStream outputStream, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight )
    {
        return encoderQRCoder( content, outputStream, qrcodeSize, logoImgPath, logoWidth, logoHeight, true, RGB_BLACK );
    }
    
    public static boolean encoderQRCoder(  String content, OutputStream outputStream, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight, int rgb )
    {
        return encoderQRCoder( content, outputStream, qrcodeSize, logoImgPath, logoWidth, logoHeight, true, rgb );
    }

    public static boolean encoderQRCoder_logoUrl(  String content, String qrcodeSaveFilePath, int qrcodeSize, String logoImgUrl )
    {
        return  encoderQRCoder_logoUrl( content, qrcodeSaveFilePath, qrcodeSize, logoImgUrl, Math.round( qrcodeSize * defaultLogoScale ) , Math.round( qrcodeSize * defaultLogoScale ), RGB_BLACK );
    }


    public static boolean encoderQRCoder_logoUrl(  String content, String qrcodeSaveFilePath, int qrcodeSize, String logoImgUrl, int logoWidth, int logoHeight  )
    {
        return  encoderQRCoder_logoUrl(  content, qrcodeSaveFilePath, qrcodeSize, logoImgUrl, logoWidth, logoHeight, RGB_BLACK  );
    }

    public static boolean encoderQRCoder_logoUrl(  String content, String qrcodeSaveFilePath, int qrcodeSize, String logoImgUrl, int logoWidth, int logoHeight, int rgb  )
    {
        boolean ret = false;
        FileUtil.createBlankFile(qrcodeSaveFilePath);
        try {
            OutputStream outputStream = new FileOutputStream(new File(qrcodeSaveFilePath));
            ret = encoderQRCoder_logoUrl(content, outputStream, qrcodeSize, logoImgUrl, logoWidth, logoHeight, rgb );
        }catch ( Exception e ){
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    public static boolean encoderQRCoder_logoUrl(  String content, OutputStream outputStream, String logoImgUrl )
    {
        return encoderQRCoder_logoUrl(  content, outputStream, defaultQRCodeSize, logoImgUrl, Math.round( defaultQRCodeSize * defaultLogoScale ) , Math.round( defaultQRCodeSize * defaultLogoScale ), RGB_BLACK );
    }

    public static boolean encoderQRCoder_logoUrl(  String content, OutputStream outputStream, int qrcodeSize, String logoImgUrl )
    {
        return encoderQRCoder_logoUrl(  content, outputStream, qrcodeSize, logoImgUrl, Math.round( qrcodeSize * defaultLogoScale ) , Math.round( qrcodeSize * defaultLogoScale ), RGB_BLACK );
    }
    public static boolean encoderQRCoder_logoUrl(  String content, OutputStream outputStream, int qrcodeSize, String logoImgUrl, int logoWidth, int logoHeight, int rgb )
    {
        boolean ret = false;

        String logoImgDownloadPath = "/usr/local/temp/pic/" + UUIDTools.getUUID() + ".jpg";
        try {
            FileUtil.createBlankFile(logoImgDownloadPath);
            GetImageFile.saveImgFile(logoImgUrl, logoImgDownloadPath);
            ret = encoderQRCoder(content, outputStream, qrcodeSize, logoImgDownloadPath, logoWidth, logoHeight, true, rgb );
        }catch ( Exception e ){
            e.printStackTrace();
            ret = false;
        }finally {
            FileUtil.delete( logoImgDownloadPath );
        }

        return ret;
    }

    public static boolean encoderQRCoder( String content, OutputStream outputStream, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight, boolean needCompress, int rgb )
    {
        boolean ret = false;
        try {
            BufferedImage bufferedImage = createImage( content, qrcodeSize, logoImgPath, logoWidth, logoHeight, needCompress, rgb );
            ret = ImageIO.write( bufferedImage, "jpg", outputStream );
        } catch (Exception e) {
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }


    public static String decode(String path) throws Exception
    {
        return decode(new File(path));
    }

    /**
     * 解析二维码
     * @param file 二维码图片
     * @return
     * @throws Exception
     */
    public static String decode(File file) throws Exception
    {
        BufferedImage image;
        image = ImageIO.read(file);
        if (image == null)
        {
            return null;
        }
        BufferedImageLuminanceSource source = new BufferedImageLuminanceSource( image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result;
        Hashtable<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();
        hints.put(DecodeHintType.CHARACTER_SET, "utf-8");
        result = new MultiFormatReader().decode(bitmap, hints);
        String resultStr = result.getText();
        return resultStr;
    }


//    --------------------------------------------------- private -----------------------------------------------------------------

    private static BufferedImage createImage(String content, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight, boolean needCompress ) throws Exception
    {
        return createImage( content, qrcodeSize, logoImgPath, logoWidth, logoHeight, needCompress, RGB_BLACK );
    }

    private static BufferedImage createImage(String content, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight, boolean needCompress, int rgb ) throws Exception
    {
        if( rgb < RGB_BLACK || rgb > RGB_WHITE )
        {
            rgb = RGB_BLACK;
        }
        Hashtable<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.MARGIN, 1);
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, qrcodeSize, qrcodeSize, hints);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? rgb : RGB_WHITE);
            }
        }
        if ( StringUtil.isNull(logoImgPath)) {
            return bufferedImage;
        }
        // 插入图片
        insertImage(bufferedImage, qrcodeSize,  logoImgPath, logoWidth, logoHeight, needCompress);
        return bufferedImage;
    }

    /**
     * 插入LOGO
     *
     * @param source       二维码图片
     * @param logoImgPath      LOGO图片地址
     * @param needCompress 是否压缩
     * @throws Exception
     */
    private static void insertImage( BufferedImage source, int qrcodeSize, String logoImgPath, int logoWidth, int logoHeight, boolean needCompress) throws Exception
    {
        File file = new File(logoImgPath);
        if (!file.exists()) {
            System.err.println("" + logoImgPath + "   该文件不存在！");
            return;
        }
        Image src = ImageIO.read(new File(logoImgPath));
        int width = src.getWidth(null);
        int height = src.getHeight(null);
        if (needCompress) { // 压缩LOGO
            if ( width > logoWidth ) {
                width = logoWidth;
            }
            if (height > logoHeight) {
                height = logoHeight;
            }
            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            src = image;
        }
        // 插入LOGO
        Graphics2D graph = source.createGraphics();
        int x = (qrcodeSize - width) / 2;
        int y = (qrcodeSize - height) / 2;
        graph.drawImage(src, x, y, width, height, null);
        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
        graph.setStroke(new BasicStroke(3f));
        graph.draw(shape);
        graph.dispose();
    }


    public static void main(String[] args) throws Exception {
        String text = "ADSADF啊；都是浪费了；可适当加分llf12323";
        for ( int i = 0 ; i < 10; i ++ ) {
            int rgb = RandomUtils.nextInt(RGB_WHITE - RGB_BLACK) + RGB_BLACK ;
            QRCodeZXingUtil.encoderQRCoder_logoUrl(text, "E:\\MyWork\\pic\\" + UUIDTools.getUUID() + ".jpg", 1000, "https://img.alicdn.com/bao/uploaded/i4/TB11990HXXXXXbhaXXXXXXXXXXX_!!0-item_pic.jpg_430x430q90.jpg", 150, 150, rgb);
        }
    }

}
