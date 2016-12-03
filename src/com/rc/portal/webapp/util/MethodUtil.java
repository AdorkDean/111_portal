package com.rc.portal.webapp.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: WangSheng
 * Date: 11-11-1
 * Time: 上午11:06
 * To change this template use File | Settings | File Templates.
 */
public class MethodUtil {


    public static boolean isAccessible(Method method) {

        boolean isAccessible = false;

        if (method != null) {

            String info = method.toGenericString();

            isAccessible = StringSearchHelper.find(info, "^(?!private|protected)(public\\s)\\w+");

            //System.out.println( "isAccessible:" + isAccessible + " ----" + info );

        }

        return isAccessible;

    }


    public static Object getMethodValue(Object object, String fieldName)
    {
        Object value = null;
        try {

            Class clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            if (field != null)
            {
                String fieldTypeName = field.getType().getName();

                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                Method getMethod = clazz.getDeclaredMethod(getMethodName);
                if (getMethod != null && fieldTypeName.equals(getMethod.getReturnType().getName()))
                {
                    if (MethodUtil.isAccessible(getMethod))
                    {
                        value = getMethod.invoke(object);
                    }
                }

            }
        }catch( Exception e ){
            e.printStackTrace();
        }

        return value;

    }


    /**
     * 只支持类似 setValue( Object obj ) 单个参数setMethod
     * @param object
     * @param fieldName
     * @param value
     * @param parameterTypes
     * @return
     */
    public static boolean setMethodValue(Object object, String fieldName, Object value, Class<?>... parameterTypes )
    {
        boolean ret = false;
        try {

            Class clazz = object.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            if (field != null)
            {
                String fieldTypeName = field.getType().getName();

                String setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                Method setMethod = clazz.getDeclaredMethod(setMethodName, parameterTypes );
                if (setMethod != null )
                {
//                    Class[] parameterTypes = setMethod.getParameterTypes();
                    if( parameterTypes == null || parameterTypes.length == 0 )
                    {
                        return false;
                    }

                    Class parameterType = parameterTypes[0];
                    if( parameterType == null )
                    {
                        return false;
                    }

                    if( fieldTypeName.equals(parameterType.getName()) )
                    {
                        if (MethodUtil.isAccessible(setMethod))
                        {
                            setMethod.invoke(object, value);
                        }
                    }

                }

            }
        }catch( Exception e ){
            e.printStackTrace();
        }

        return ret;
    }


}
