package cn.hlq.common.utils;

import javafx.beans.binding.ObjectExpression;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
    public static byte[] serializeObject(Object obj){
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null!=objectOutputStream){
                try{
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Object deserializeObject(byte[] bytes) {
        ByteArrayInputStream byteInputStream = null;
        ObjectInputStream objectInputStream = null;

        try{
            byteInputStream = new ByteArrayInputStream(bytes);
            objectInputStream = new ObjectInputStream(byteInputStream);

            return objectInputStream.readObject();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(null != objectInputStream){
                try{
                    objectInputStream.close();
                    byteInputStream.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
