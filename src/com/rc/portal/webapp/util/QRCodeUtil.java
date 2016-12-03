package com.rc.portal.webapp.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

/**
 * Created by ws on 2015/4/25.
 */
public class QRCodeUtil {

	public static boolean encoderQRCoder(String content, OutputStream outputStream, int size) {
		boolean ret = false;
		try {
			Qrcode handler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			handler.setQrcodeErrorCorrect('M');
			handler.setQrcodeEncodeMode('B');
			// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
			handler.setQrcodeVersion(size);
			// 图片尺寸
			int imgSize = 67 + 12 * (size - 1);
			byte[] contentBytes = content.getBytes("UTF-8");
			BufferedImage bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);
			// 设定图像颜色：BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量 不设置肯能导致解析出错
			int pixoff = 2;
			// 输出内容：二维码
			if (contentBytes.length > 0 && contentBytes.length < 800) {
				boolean[][] codeOut = handler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,800 ]. ");
			}
			gs.dispose();
			bufImg.flush();
			// 生成二维码QRCode图片
			ret = ImageIO.write(bufImg, "jpg", outputStream);
		} catch (Exception e) {
			e.printStackTrace();
			ret = false;
		}

		return ret;
	}

}
