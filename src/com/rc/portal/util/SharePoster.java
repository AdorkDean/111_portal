package com.rc.portal.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import com.rc.commons.util.InfoUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 健康领秀海报(只用于生成健康领秀的海报)
 * 
 * @author WWF
 * @createTime 2015-10-23 下午5:20:49
 */
public final class SharePoster {
	private final static String pharmacy_haibao_kuang = InfoUtil.getInstance().getInfo("healthleader", "healthleader.yaofang.haibao.background.kuang");
	
	public SharePoster() {
	}

	public static void pressTextAndImg(String httpHeadFile, File qrCodeFile, String nickName, String httpBackImg,
			String fontName, int fontStyle, int color, int fontSize, int x, int y) {
		try {
			// URL backImgUrl = new URL(httpBackImg);
			File backFile = new File(httpBackImg);
			System.out.println("背景图片生成是否存在:" + backFile.exists());
			Image src = ImageIO.read(backFile);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// 昵称
			g.setColor(Color.white);
			g.setFont(new Font(fontName, fontStyle, fontSize));
//			g.drawString(nickName, 160, 78);// 此处匹配唯一背景图片的位置,
			g.drawString(nickName, 290, 66);//此处匹配唯一背景图片的位置,
			
			// 二维码图片
			// URL qrUrl = new URL(httpQRCodeFile);
			Image src_biao = ImageIO.read(qrCodeFile);
//			g.drawImage(src_biao, 41, 587, 183, 183, null);// 此处匹配唯一背景图片的位置,
			g.drawImage(src_biao, 222, 235, 190, 190, null);//此处匹配唯一背景图片的位置,

			// 头像图片
			URL headUrl = new URL(httpHeadFile);
			Image touxiangFilebiao_src_biao = ImageIO.read(headUrl);
//			g.drawImage(touxiangFilebiao_src_biao, 40, 43, 100, 100, null);// 此处匹配唯一背景图片的位置,
			g.drawImage(touxiangFilebiao_src_biao, 195, 13, 80, 80, null);//此处匹配唯一背景图片的位置,
			
			URL headUrl1 = new URL(pharmacy_haibao_kuang);
			Image kuang = ImageIO.read(headUrl1);
			g.drawImage(kuang, 194, 13, 82, 82, null);// 此处匹配唯一背景图片的位置,
			
			g.dispose();
			FileOutputStream out = new FileOutputStream(httpBackImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void pressTextAndImgHttpQR(String httpHeadFile, String httpQRCode, String nickName,
			String httpBackImg, String fontName, int fontStyle, int color, int fontSize, int x, int y) {
		try {
			// URL backImgUrl = new URL(httpBackImg);
			File backFile = new File(httpBackImg);
			System.out.println("背景图片生成是否存在:" + backFile.exists());
			Image src = ImageIO.read(backFile);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);

			// 昵称
			g.setColor(Color.white);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.drawString(nickName, 160, 78);// 此处匹配唯一背景图片的位置,

			if (httpQRCode != null && !"".equals(httpQRCode)) {
				// 二维码图片
				URL qrUrl = new URL(httpQRCode);
				Image src_biao = ImageIO.read(qrUrl);
				g.drawImage(src_biao, 41, 587, 183, 183, null);// 此处匹配唯一背景图片的位置,
			}
			if (httpQRCode != null && !"".equals(httpQRCode)) {
				// 头像图片
				URL headUrl = new URL(httpHeadFile);
				Image touxiangFilebiao_src_biao = ImageIO.read(headUrl);
				g.drawImage(touxiangFilebiao_src_biao, 40, 43, 100, 100, null);// 此处匹配唯一背景图片的位置,
			}
			g.dispose();
			FileOutputStream out = new FileOutputStream(httpBackImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 把图片印刷到图片上
	 * 
	 * @param pressImg
	 *            -- 水印文件
	 * @param targetImg
	 *            -- 目标文件
	 * @param x
	 *            --x坐标
	 * @param y
	 *            --y坐标
	 */
	public final static void pressImage(String pressImg, String targetImg, int x, int y) {
		try {
			// 目标文件
			File _file = new File(targetImg);
			Image src = ImageIO.read(_file);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height, BufferedImage.TYPE_INT_RGB);
			Graphics g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// 水印文件
			File _filebiao = new File(pressImg);
			Image src_biao = ImageIO.read(_filebiao);
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.drawImage(src_biao, 0, 0, wideth_biao, height_biao, null);
			// 水印文件结束
			g.setColor(Color.RED);
			g.drawString("昵称", 0, 0);
			g.dispose();
			FileOutputStream out = new FileOutputStream(targetImg);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			encoder.encode(image);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// pressImage("E:\\temp\\warn.png", "E:\\temp\\150214211089711.jpg", 20,
		// 10);
		// String pressText, String targetImg, String fontName, int fontStyle,
		// int color,
		// int fontSize, int x, int y

		// pressTextAndImg("http://img.zdfei.com/static/image/head/ee2e9c2c-e915-43bd-8a65-a05f29029cb2.jpg",
		// "http://img.zdfei.com/static/image/leaderQRCode/201510231533573357109312.jpg",
		// "喂死鲤鱼_",
		// "E:\\temp\\111医药馆111医药馆微信推荐.jpg", "宋体", 10, 0, 32, 190, 370);
		// pressImage("E:\\temp\\201510221624332433905665.jpg",
		// "E:\\temp\\大背景图.jpg", 1, 1);

		// URL url = new URL(qrLogoPath);
		// URLConnection uc = url.openConnection();
		// uc.getInputStream();
		// ret = QRCodeZXingUtil.encoderQRCoder_logoUrl(contentString,
		// fileOutputStream, qrLogoPath);

		try {
			String httpUrl = "http://www.nimenhaihaoma.com/images/11%E5%8C%BB%E8%8D%AF%E9%A6%86111%E5%8C%BB%E8%8D%AF%E9%A6%86%E5%BE%AE%E4%BF%A1%E6%8E%A8%E8%8D%90.jpg";
			URL url = new URL(httpUrl);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			// connection.setRequestProperty("referer", u); // 通过这个http头的伪装来反盗链
			BufferedImage image = ImageIO.read(connection.getInputStream());
			FileOutputStream fout = new FileOutputStream("E:\\temp\\海报\\111111.jpg");
			ImageIO.write(image, "jpg", fout);
			fout.flush();
			fout.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("http文件不存在");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 自定义
	 * @param httpHeadFile
	 * @param qrCodeFile
	 * @param nickName
	 * @param httpBackImg
	 * @param fontName
	 * @param fontStyle
	 * @param color
	 * @param fontSize
	 * @param x
	 * @param y
	 */
	public static void pressTextAndImgByCustom(File targetFile,String erweimaUrl,String nickName) {
		
		
		
	}
	
}