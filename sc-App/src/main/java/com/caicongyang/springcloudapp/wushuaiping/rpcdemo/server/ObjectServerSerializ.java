package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.server;

import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.modle.TransportModel;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wushuaiping
 * @date 2018/3/15 下午12:23
 */
public class ObjectServerSerializ {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            Socket accept = serverSocket.accept();

            InputStream inputStream = accept.getInputStream();

            ObjectInputStream ois = new ObjectInputStream(inputStream);

            TransportModel transportModel = (TransportModel) ois.readObject();

            Object object = transportModel.getObject();
            String methodName = transportModel.getMethodName();
            Class<?>[] parameterTypes = transportModel.getParameterTypes();
            Object[] parameters = transportModel.getParameters();

            Method method = object.getClass().getMethod(methodName,parameterTypes);

            Object invoke = method.invoke(object, parameters);

            System.out.println("提供服务端执行方法返回结果："+invoke);

            OutputStream outputStream = accept.getOutputStream();

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            TransportModel resultModel = new TransportModel();
            resultModel.setResult(invoke);
            oos.writeObject(resultModel);

            outputStream.write(bos.toByteArray());
            outputStream.flush();
            bos.close();
            outputStream.close();
            serverSocket.close();
            System.out.println("服务端关闭");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
