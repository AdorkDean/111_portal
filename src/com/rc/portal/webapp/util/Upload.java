package com.rc.portal.webapp.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Upload {
	
	public static String uploadImage(File img,String fullpath){
		 
		String suffix = "jpg";
		String rename = new MyRandom().getIPTimeStampRand();
		if(img!=null){
			File tinyImgFile = new File(fullpath+rename+"."+suffix);
			try {
				FileUtils.copyFile(img, tinyImgFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return rename+"."+suffix;
	}

}
