package com.rc.portal.webapp.util;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: WangSheng
 * Date: 11-11-1
 * Time: 下午3:59
 * To change this template use File | Settings | File Templates.
 */
public class StringSearchHelper {
    public static final int REPLACE_FIRST = 0;
    public static final int REPLACE_ALL = -1;

    public static boolean find( String s, String regex )
    {
        return find( s, regex, Pattern.CASE_INSENSITIVE );
    }
    public static boolean find( String s, String regex, int patternMode )
    {
        boolean ret = false;

        if ( StringUtil.isNull(s) )
            return false;

        try{

            Pattern pattern = Pattern.compile( regex, patternMode );
            Matcher matcher = pattern.matcher( s );
            if( matcher.find() )
            {
                ret = true;
            }

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;

    }


    public static String search( String s, String regex, int index )
    {
        return search( s, regex, index, Pattern.CASE_INSENSITIVE  );
    }
    /**
     * 如果找到，则返回string； 如果没找到则返回 null； 如果找到空串""，则返回空串""
     * @param s
     * @param regex
     * @param index  从 0 开始
     * @param patternMode
     * @return
     */
    public static String search( String s, String regex, int index, int patternMode )
    {
        String ret = null;

        if ( StringUtil.isNull( s ) )
            return null;

        try{

            Pattern pattern = Pattern.compile( regex, patternMode );
            Matcher matcher = pattern.matcher( s );
            int i = 0;
            while( matcher.find() )
            {
                if( i == index )
                {
                    ret = matcher.group();
                    break;
                }
                i++;
            }

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;

    }

    public static List<String> searchAll( String s, String regex )
    {
        return searchAll( s, regex, Pattern.CASE_INSENSITIVE );
    }
    /**
     * 如果找到，则返回string； 如果没找到则返回 null； 如果找到空串""，则返回空串""
     * @param s
     * @param regex
     * @param patternMode
     * @return
     */
    public static List<String> searchAll( String s, String regex, int patternMode )
    {
        List<String> ret = new ArrayList<String>();

        if ( StringUtil.isNull( s ) )
            return null;

        try{

            Pattern pattern = Pattern.compile(regex, patternMode);
            Matcher matcher = pattern.matcher( s );
            while( matcher.find() )
            {
                String result = matcher.group();
                ret.add( result );
            }

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;

    }

    public static List<Integer> searchAllIndexes( String s, String regex )
    {
        return searchAllIndexes(s, regex, Pattern.CASE_INSENSITIVE);
    }
    /**
     * 如果找到，则返回由index组成的list； 如果没找到则返回 null；
     * @param s
     * @param regex
     * @param patternMode
     * @return
     */
    public static List<Integer> searchAllIndexes( String s, String regex, int patternMode )
    {
        ArrayList ret = new ArrayList();

        if ( StringUtil.isNull( s ) )
            return null;

        try{

            Pattern pattern = Pattern.compile(regex, patternMode);
            Matcher matcher = pattern.matcher( s );
            while( matcher.find() )
            {
               int result = matcher.start();
               ret.add( new Integer( result ) );
            }

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;

    }
    public static String replaceFirst( String s, String regex, String replacement )
    {
        return replaceString( s, regex, replacement, REPLACE_FIRST );
    }
    public static String replaceAll( String s, String regex, String replacement )
    {
        return replaceString( s, regex, replacement, REPLACE_ALL );
    }
    public static String replaceString( String s, String regex, String replacement, int matchIndex )
    {
        return replaceString( s, regex, replacement, matchIndex, Pattern.CASE_INSENSITIVE );
    }
    public static String replaceString( String s, String regex, String replacement, int matchIndex, int patternMode )
    {
        String ret = s;

        if ( StringUtil.isNull(s) )
            return "";

        try{

            Pattern pattern = Pattern.compile( regex, patternMode );
            Matcher matcher = pattern.matcher( ret );
                if( matchIndex == REPLACE_ALL )
                {
                    if( matcher.find() )
                    {
                        ret = matcher.replaceAll( replacement );
                    }
                }else if( matchIndex == REPLACE_FIRST ){

                    if( matcher.find() )
                    {
                        ret = matcher.replaceFirst( replacement );
                    }
                }else {

                    StringBuffer buffer = new StringBuffer();
                    int i = 0;
                    while( matcher.find() )
                    {
                        if( i == matchIndex )
                        {
                            matcher.appendReplacement( buffer, replacement );
                        }
                        i++;
                    }
                    matcher.appendTail( buffer );
                    ret = buffer.toString();
                }

        }catch ( Exception e ){
            e.printStackTrace();
        }


        return ret;

    }

    public static boolean deleteFile( String filePath )
    {
        boolean ret = true;
        try{

            File file = new File( filePath );
            file.delete();

        }catch (Exception e){
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }



    public static void main( String args[] )
    {
        String regex = "(?<=\\s{0,10})limit\\s+\\d+(\\s+offset\\s+\\d+)?(?=\\s*)";

        String sql = " select a,b,c from d limit 1 offset 2 of limit 3 offset 4 of limit 5 offset 6 ";

        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", -2) );
        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", -1) );
        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", 0) );
        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", 1) );
        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", 2) );
        System.out.println( StringSearchHelper.replaceString(sql, regex, "###", 3) );

    }


}
