package com.rc.portal.webapp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**  
 * @Title: FileUtil.java
 * @Description: 
 * @author yinbinhome@163.com  
 * @date 2011-5-3 下午04:33:27
 * @version V1.0  
 */

public class FileUtil {
	
	public static  String readFileByLines(String fileName) {
        File file = new File(fileName);       
        BufferedReader reader = null;
        StringBuffer sb=new StringBuffer("");
        try {            
        	InputStreamReader read = new InputStreamReader (new FileInputStream(file),"utf-8");

            reader = new BufferedReader(read);
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                line++;
                
                sb.append(tempString);
                
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return sb.toString().replaceAll("(>\\s*<)", "><");
    }
	
	public static void createFile(String content,String fileName){
		File file=new File(fileName);

		String parent=file.getParent();
		File f=new File(parent);		
		if(!f.exists()){
			f.mkdirs();
		}
        try {
        	OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        	outputStream.write(content);
        	outputStream.close();
            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
//            FileWriter writer = new FileWriter(fileName, false);
//            writer.write(content);
//            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}


//	-------------------------------------------- below added by ws -----------------------------------------------

	public static boolean createBlankFile( String filePathName )
    {
        return createBlankFile( filePathName, "utf-8" );
    }
	public static boolean createBlankFile( String filePathName, String charSet )
    {
        if( StringUtil.isNull( charSet ) )
        {
            charSet = "utf-8";
        }
        boolean ret = true;

        OutputStreamWriter outputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            File file = new File( filePathName );

            String parentPath = file.getParent();
            File parentFile = new File( parentPath );

            if( !parentFile.exists() ) {
                parentFile.mkdirs();
            }

            fileOutputStream = new FileOutputStream( file );

            outputStream = new OutputStreamWriter( fileOutputStream, charSet );

            outputStream.write("");

            ret = true;

        } catch (IOException e) {

            e.printStackTrace();
            ret = false;

        }finally {
            try {
                if(fileOutputStream != null){
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(outputStream != null){
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;

    }


    public static boolean resetFile( String filePathName, String s )
    {
        boolean ret = true;

        ret = createBlankFile( filePathName );
        if( ret )
        {
            ret = appendFile( filePathName, s );
        }

        return ret;
    }
    public static boolean appendFile( String filePathName, String s )
    {
        boolean ret = true;
        FileWriter writer = null;
        try{
            File file = new File( filePathName );
            if( !file.exists() )
            {
                createBlankFile( filePathName );
            }

            writer = new FileWriter( filePathName, true );
            writer.write(s);

            ret = true;

        }catch ( Exception e ){

            e.printStackTrace();
            ret = false;

        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return ret;
    }

    public static void mkdirs(String dirPath)
    {
        File file = new File(dirPath);
        //当文件夹不存在时，mkdirs会自动创建多层目录，区别于mkdir．(mkdir如果父目录不存在则会抛出异常)
        if ( !file.exists() && !file.isDirectory() )
        {
            file.mkdirs();
        }
    }

    public static void delete(String filePath)
    {
        File file = new File(filePath);
        if ( file.exists() )
        {
            file.delete();
        }
    }

	public static void main(String[] args) {
//		FileUtil.createFile("1233", "D:/temp/123/123/12.html");
//		FileUtil.createFile("\n1233", "D:/temp/123/123/12.html");

        FileUtil.appendFile( "D:/temp/123/1234/123.html", "ssss\nss");
        FileUtil.appendFile( "D:/temp/123/1234/123.html", "DDD\nB");
//        FileUtil.resetFile("D:/temp/123/12345/wxEventLogFile_111yao.log", "DDD\nB");
        FileUtil.appendFile("D:/temp/123/12345/wxEventLogFile_111yao.log", "DDD\nB");
        FileUtil.appendFile("D:/temp/123/12345/wxEventLogFile_111yao1.log", "DDD\nB");

	}
}
