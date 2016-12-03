package com.rc.portal.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {
	/**
	 * 
	 * @Title: Shrink
	 * @Description: TODO 将图片进行缩放
	 * @param srcImageFilePath
	 *            原图片路径，例如：E:/image/a3.jpg
	 * @param resultFilePath
	 *            生成缩放图片的路径，例如：E:/image/a3-1.jpg
	 * @param width
	 *            需要生成图片的宽
	 * @param height
	 *            需要生成图片的高
	 */
	public static void ShrinkImage(String srcImageFilePath,
			String resultFilePath, int width, int height) {
		File srcFile = new File(srcImageFilePath);
		try {
			BufferedImage bfImage = ImageIO.read(srcFile);
			double radioW = 0.5;
			double radioH = 0.5;
			if (width > 0 && height > 0) {
				double bfwith = bfImage.getWidth();
				double bfheight = bfImage.getHeight();
				radioW = new Integer(width).doubleValue() / bfwith;
				radioH = new Integer(height).doubleValue() / bfheight;
			}
			AffineTransform at = new AffineTransform();
			at.scale(radioW, radioH);// 设置图片比例
			AffineTransformOp op = new AffineTransformOp(at, null);
			BufferedImage bfImage1 = op.filter(bfImage, null);
			ImageIO.write(bfImage1, "jpg", new File(resultFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(srcImageFilePath + "指定的图片目录不存在");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: addStrToImage
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param srcImageFilePath
	 * @param resultFilePath
	 * @param content
	 * @param offsetX
	 *            水印X轴坐标/图片宽度
	 * @param offsetY
	 *            水印Y轴坐标/图片高度
	 * @param font
	 *            :水印字体的样式
	 * @param color
	 *            ：添加水印字体的颜色
	 * @param alpha
	 *            ：设置字体透明度参数范围 0-1
	 */
	public static void addStrToImage(String srcImageFilePath,
			String resultFilePath, String content, float offsetX,
			float offsetY, Font font, Color color, float alpha) {
		File srcFile = new File(srcImageFilePath);
		try {
			BufferedImage bfImage = ImageIO.read(srcFile);
			Graphics2D g2d = bfImage.createGraphics();
			if (null == font) {
				font = new Font("楷体", Font.BOLD, 24);
			}
			if (null == color) {
				color = Color.WHITE;
			}
			if (alpha > 1) {
				alpha = 1f;
			} else if (alpha < 0) {
				alpha = 0f;
			}
			g2d.setFont(font);
			g2d.setColor(color);
			AlphaComposite ac = AlphaComposite.getInstance(
					AlphaComposite.SRC_ATOP, alpha);// 设置图片透明度
			g2d.setComposite(ac);
			if (offsetX >= 0 && offsetX <= 1 && offsetY >= 0 && offsetY <= 1) {
				float X = offsetX * bfImage.getWidth();
				float Y = offsetY * bfImage.getHeight();
				g2d.drawString(content, X, Y);
			}
			bfImage.flush();
			g2d.dispose();// 释放图片资源
			ImageIO.write(bfImage, "jpg", new File(resultFilePath));
		} catch (IOException e) {
			System.out.println(srcImageFilePath + "指定的图片目录不存在");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: addImgToImg
	 * @Description: TODO(给图片添加水印)
	 * @param srcImageFilePath原图片的路径
	 * @param waterImageFilePath水印图片的文件
	 * @param resultFilePath
	 *            生成新图片的路径
	 * @param offsetX
	 *            水印图片在x轴的坐标点
	 * @param offsetY
	 *            水印图片在y轴的坐标点
	 * @param alpha水印图片的透明度
	 */
	public static void addImgToImg(String srcImageFilePath,
			String waterImageFilePath, String resultFilePath, int offsetX,
			int offsetY, float alpha) {
		File srcFile = new File(srcImageFilePath);
		File waterFile = new File(waterImageFilePath);
		File resultFile = new File(resultFilePath);

		try {
			BufferedImage srcbfImage = ImageIO.read(srcFile);
			Graphics2D g2d = srcbfImage.createGraphics();
			if (alpha > 1) {
				alpha = 1f;
			} else if (alpha < 0) {
				alpha = 0f;
			}
			AlphaComposite ap = AlphaComposite.getInstance(
					AlphaComposite.SRC_ATOP, alpha);
			BufferedImage waterbfImage = ImageIO.read(waterFile);// 读取水印图片
			int width = waterbfImage.getWidth();
			int height = waterbfImage.getHeight();
			if (offsetX < 0 || offsetX > srcbfImage.getWidth() - width) {
				offsetX = srcbfImage.getWidth() - width;
			}
			if (offsetY < 0 || offsetY > srcbfImage.getHeight() - height) {
				offsetY = srcbfImage.getHeight() - height;
			}

			g2d.setComposite(ap);// 是在图片透明度
			srcbfImage.flush();
			waterbfImage.flush();
			g2d.drawImage(waterbfImage, offsetX, offsetY, width, height, null);
			g2d.dispose();
			ImageIO.write(srcbfImage, "jpg", resultFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 上传保存图片
	 * @param file
	 * @param path
	 * @return
	 */
	public static int uploadImage(File file,String path) {
		int flag=1;
		try {
			File f=new File(path);
			File parent=new File(f.getParent());
			if(!parent.exists()){
				parent.mkdirs();
			}
			
			FileOutputStream outputStream = null;
			if (null != file) {
				outputStream = new FileOutputStream(path);
				FileInputStream fileIn = new FileInputStream(file);
				byte[] buffer = new byte[1024];
				int len;
				while ((len = fileIn.read(buffer)) > 0) {
					outputStream.write(buffer, 0, len);
				}
				fileIn.close();
				outputStream.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			flag=0;
		}
		return flag;
	}
	 public final static void cut(String srcImageFile, String result,
	            int x, int y, int width, int height) {
	        try {
	            // 读取源图像
	            BufferedImage bi = ImageIO.read(new File(srcImageFile));
	            int srcWidth = bi.getHeight(); // 源图宽度
	            int srcHeight = bi.getWidth(); // 源图高度
	            if (srcWidth > 0 && srcHeight > 0) {
	                Image image = bi.getScaledInstance(srcWidth, srcHeight,
	                        Image.SCALE_DEFAULT);
	                // 四个参数分别为图像起点坐标和宽高
	                // 即: CropImageFilter(int x,int y,int width,int height)
	                ImageFilter cropFilter = new CropImageFilter(x, y, width, height);
	                Image img = Toolkit.getDefaultToolkit().createImage(
	                        new FilteredImageSource(image.getSource(),
	                                cropFilter));
	                BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	                Graphics g = tag.getGraphics();
	                g.drawImage(img, 0, 0, width, height, null); // 绘制切割后的图
	                g.dispose();
	                // 输出为文件
	                ImageIO.write(tag, "JPEG", new File(result));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public final static void scale2(String srcImageFile, String result, int height, int width, boolean bb) {
	        try {
	            double ratio = 0.0; // 缩放比例
	            File f = new File(srcImageFile);
	            BufferedImage bi = ImageIO.read(f);
	            Image itemp = bi.getScaledInstance(width, height, bi.SCALE_SMOOTH);
	            // 计算比例
	            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
	                if (bi.getHeight() > bi.getWidth()) {
	                    ratio = (new Integer(height)).doubleValue()
	                            / bi.getHeight();
	                } else {
	                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
	                }
	                AffineTransformOp op = new AffineTransformOp(AffineTransform
	                        .getScaleInstance(ratio, ratio), null);
	                itemp = op.filter(bi, null);
	            }
	            if (bb) {//补白
	                BufferedImage image = new BufferedImage(width, height,
	                        BufferedImage.TYPE_INT_RGB);
	                Graphics2D g = image.createGraphics();
	                g.setColor(Color.white);
	                g.fillRect(0, 0, width, height);
	                if (width == itemp.getWidth(null))
	                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
	                            itemp.getWidth(null), itemp.getHeight(null),
	                            Color.white, null);
	                else
	                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
	                            itemp.getWidth(null), itemp.getHeight(null),
	                            Color.white, null);
	                g.dispose();
	                itemp = image;
	            }
	            ImageIO.write((BufferedImage) itemp, "JPEG", new File(result));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	public static void main(String[] args) {
		//ShrinkImage("C:\\Users\\Bing King\\Pictures\\1378977006391198613.jpg", "C:\\Users\\Bing King\\Pictures\\tt.jpg", 130, 130);
		scale2("C:\\Users\\Bing King\\Pictures\\1378977006391198613.jpg", "C:\\Users\\Bing King\\Pictures\\tt2.jpg", 130, 130,true);
		cut("C:\\Users\\Bing King\\Pictures\\tt.jpg", "C:\\Users\\Bing King\\Pictures\\ttcut.jpg", 36, 27, 30, 30);
		File f=new File("d:/ybbas/dfasdfa/dfasdfa.jpg");
		File parent=new File(f.getParent());
		if(!parent.exists()){
			parent.mkdirs();
		}
	}
}
