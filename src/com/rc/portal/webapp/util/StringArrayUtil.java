package com.rc.portal.webapp.util;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: WangSheng
 * Date: 11-11-1
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
public class StringArrayUtil {

    public static boolean isInArray( String s, String[] arr )
    {
        return isInArray( s, arr, true, true );
    }
    public static  boolean isInArray( String s , String[] arr, boolean ignoreCase, boolean trim )
    {

        if( s == null || arr == null )
        {
            return false;
        }

        boolean ret = false;

        int len = arr.length;
        for (int i=0; i < len; i++ )
        {
            String arri = arr[i];
            if( trim )
            {
                if( arri != null )
                {
                    arri = arri.trim();
                }
            }
            if( ignoreCase )
            {
                if( s.equalsIgnoreCase( arri ) )
                {
                    ret = true;
                    break;
                }
            }else{
                if( s.equals( arri ) )
                {
                    ret = true;
                    break;
                }
            }

        }

        return ret;

    }

    /**
     *
     * @param planarArr
     * @return
     */

    public static void nvlArr(String[][] planarArr)
    {
        if(!("".equals(planarArr))&&!(planarArr==null))
        {
            for(int i=0;i<planarArr.length;i++)
            {
                for(int j=0;j<planarArr[i].length;j++)
                {
                    if(planarArr[i][j]==null || "null".equalsIgnoreCase(planarArr[i][j].trim()))
                    {
                        planarArr[i][j]="";
                        System.out.println("\nplanarArr["+i+"]["+j+"]=null!\n");
                    }
                    //System.out.print(planarArr[i][j]);
                }
                //System.out.println("\n");
            }
        }

    }

    /**
     *
     * @param planarArr
     * @return
     */

    public static void nvlArrHtml(String[][] planarArr)
    {
        if(!("".equals(planarArr))&&!(planarArr==null))
        {
            for(int i=0;i<planarArr.length;i++)
            {
                for(int j=0;j<planarArr[i].length;j++)
                {
                    if(planarArr[i][j]==null || "null".equalsIgnoreCase(planarArr[i][j].trim()))
                    {
                        planarArr[i][j]="&nbsp;";
                        System.out.println("\nplanarArr["+i+"]["+j+"]=null!\n");
                    }
                    //System.out.print(planarArr[i][j]);
                }
                //System.out.println("\n");
            }
        }

    }

    public static String toGBK ( String value){
    	if(value==null) return "";
    	String result="";
    	try {
			 result= new String(value.getBytes("ISO-8859-1"),"GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
    }

    public static String[] toStringArray( Object[] objs )
    {
        if( objs == null )
        {
            return null;
        }else{
            int len = objs.length;
            String[] strArr = new String[len];
            for( int i = 0; i < len; i++ )
            {
                if( objs[i] == null )
                {
                    strArr[i] = null;
                }else{
                    strArr[i] = objs[i].toString();
                }
            }
            return strArr;
        }

    }



    /**
     * @param s:  ,,,,,,a,b,c,,d,,,
     * @param c: ,
     * @return ,,,,,,a,b,c,,d
     */
    public static String clearEndChar( String s, String c )
    {
        if( StringUtil.isNull(s) || StringUtil.isNull(c) )
        {
            return s;
        }
        String newStr = s;
        for( ; newStr.endsWith( c ) ; )
        {
            newStr = newStr.substring( 0, newStr.length() - c.length() );
        }

        return newStr;
    }

    /**
     * @param s:  ,,,,,,a,b,c,,d,,,
     * @param c: ,
     * @return a,b,c,,d,,,
     */
    public static String clearStartChar( String s, String c )
    {
        if( StringUtil.isNull(s) || StringUtil.isNull(c) )
        {
            return s;
        }
        String newStr = s;
        for( ; newStr.startsWith( c ) ; )
        {
            newStr = newStr.substring( c.length() , newStr.length() );
        }

        return newStr;
    }

    /**
     * @param s:  ,,,,,,a,b,c,,d,,,
     * @param c: ,
     * @return  a,b,c,,d
     */
    public static String trimWithStr( String s, String c )
    {
        return clearStartChar( clearEndChar( s, c ), c );
    }

    /**
     *
     * @param arr:  [ a, b, c ]
     * @param c: '
     * @return  'a','b','c'
     */
    public static String getString( String[] arr , String c )
    {
        return getString( arr, c, false );
    }

    /**
     *
     * @param arr:  [ a, b, c ]
     * @param c: '
     * @return  'a','b','c'
     */
    public static String getString( String[] arr , String c, boolean removeNull )
    {
        if( StringUtil.isNull(c) )
        {
            c = "";
        }
        String ret = "";
        if( arr == null || arr.length == 0 )
        {
            return "";
        }
        int len = arr.length;
        for( int i = 0; i < len ; i ++ )
        {
            if( removeNull && StringUtil.isNull( arr[i] ) )
            {
                continue;
            }
            if( i > 0 )
            {
                ret += ",";
            }
            ret += c + arr[i] + c;
        }

        return ret;

    }


    public static String[] toStringArray( List list )
    {
        return toStringArray( list, null );
    }

    @SuppressWarnings({"ConstantConditions"})
    public static String[] toStringArray( List list, String fieldName ){
        if( list == null || list.size() <= 0 )
        {
            return null;
        }

        int len = list.size();
        String[] arr = new String[len];
        try{
            for( int i = 0; i < len; i++ )
            {
                Object object = list.get(i);
                if( object != null )
                {
                    Class clazz = object.getClass();
                    if( StringUtil.isNull( fieldName ) )
                    {
                        arr[i] = object.toString();
                    }else{

                        Field field = clazz.getDeclaredField( fieldName );
                        if( field != null )
                        {
                            String fieldTypeName = field.getType().getName();

                            String getMethodName = "get" + fieldName.substring( 0,1 ).toUpperCase() + fieldName.substring(1) ;

                            Method getMethod = clazz.getDeclaredMethod(getMethodName);
                            if( getMethod != null && fieldTypeName.equals(getMethod.getReturnType().getName()) )
                            {
                                if( MethodUtil.isAccessible(getMethod) )
                                {
                                    Object obj = getMethod.invoke( object );
                                    if( obj != null )
                                    {
                                        arr[i] = obj.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return arr;
    }

    public static String getString( List list )
    {
        return getString(list, null, null, null );
    }

    /**
     *
     * @param list
     * @param fieldName
     * @param c: '
     * @return  'a','b','c'
     */
    @SuppressWarnings({"ConstantConditions"})
    public static String getString( List list, String fieldName, String c, String conjoin ){
        if( list == null || list.size() <= 0 )
        {
            return null;
        }
        if( StringUtil.isNull( c ) )
        {
            c = "";
        }
        if( StringUtil.isNull( conjoin ) )
        {
            conjoin = ",";
        }

        int len = list.size();
        StringBuilder builder = new StringBuilder();
        try{
            for( int i = 0; i < len; i++ )
            {
                Object object = list.get(i);
                if( object != null )
                {
                    Class clazz = object.getClass();
                    if( StringUtil.isNull( fieldName ) )
                    {
                        if( i != 0 )
                        {
                            builder.append( conjoin );
                        }
                        builder.append( c );
                        builder.append( object.toString() );
                        builder.append( c );

                    }else{

                        Field field = clazz.getDeclaredField( fieldName );
                        if( field != null )
                        {
                            String fieldTypeName = field.getType().getName();

                            String getMethodName = "get" + fieldName.substring( 0,1 ).toUpperCase() + fieldName.substring(1) ;

                            Method getMethod = clazz.getDeclaredMethod(getMethodName);
                            if( getMethod != null && fieldTypeName.equals(getMethod.getReturnType().getName()) )
                            {
                                if( MethodUtil.isAccessible(getMethod) )
                                {
                                    Object obj = getMethod.invoke( object );
                                    if( obj != null )
                                    {
                                        if( i != 0 )
                                        {
                                            builder.append( conjoin );
                                        }
                                        builder.append( c );
                                        builder.append( obj.toString() );
                                        builder.append( c );
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }catch ( Exception e ){
            e.printStackTrace();
        }
        return builder.toString();
    }

    /**
     * @param stringArr
     * @return
     */
    public static String filterRepeat( String[] stringArr )
    {
        return StringArrayUtil.filterRepeat( stringArr, false );
    }
    /**
     * @param stringArr
     * @param sortAscInEnd
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String filterRepeat( String[] stringArr, boolean sortAscInEnd )
    {
        String ret = "";

        if( stringArr == null || stringArr.length == 0 )
        {
            return "";
        }

        try{

            Set set = new HashSet();
            List list = new ArrayList();

            int len = stringArr.length;
            for( int i = 0; i < len; i++ )
            {
                String str = stringArr[i];
                if( StringUtil.isNull(str) )
                {
                    continue;
                }
                str = str.trim();

                if( set.add( str ) )
                {
                    list.add( str );
                 }
            }

            if( sortAscInEnd )
            {
                Collections.sort(list, new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        if (o1 == null && o2 == null) {
                            return 0;
                        }

                        if (o1 == null && o2 != null) {
                            return -1;
                        }

                        if (o1 != null && o2 == null) {
                            return 1;
                        }

//                        Double double1 = new Double(o1);
//                        Double double2 = new Double(o2);
//                        return double1.compareTo(double2);
                        return o1.compareTo(o2);
                    }
                });
            }

            ret = StringArrayUtil.getString( StringArrayUtil.toStringArray( list ), "" );

        }catch ( Exception e ){
            e.printStackTrace();
        }

        return ret;
    }



}
