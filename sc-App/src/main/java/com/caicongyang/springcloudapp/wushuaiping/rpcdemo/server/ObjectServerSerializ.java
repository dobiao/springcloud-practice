package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.server;

import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.modle.TransportModel;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  RPC服务端
 * @author wushuaiping
 * @date 2018/3/15 下午12:23
 */
public class ObjectServerSerializ {
    public static void main(String[] args) {

        try {

            // 启动服务端，并监听8081端口
            ServerSocket serverSocket = new ServerSocket(8081);

            // 服务端启动后，等待客户端建立连接
            Socket accept = serverSocket.accept();

            // 获取客户端的输入流，并将流信息读成Object对象。
            // 然后强转为我们的数据传输模型对象，因为我们客户端也是用的该对象进行传输，所以强转没有问题。
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            TransportModel transportModel = (TransportModel) ois.readObject();

            // 因为客户端在把流信息发过来之前，已经把相关的调用信息封装进我们的数据传输模型对象中了
            // 所以这里我们可以直接拿到这些对象的信息，然后通过反射，对方法进行调用。
            Object object = transportModel.getObject();
            String methodName = transportModel.getMethodName();
            Class<?>[] parameterTypes = transportModel.getParameterTypes();
            Object[] parameters = transportModel.getParameters();

            // 通过方法名和方法参数类型，得到一个方法对象
            Method method = object.getClass().getMethod(methodName,parameterTypes);

            // 然后通过这个方法对象去掉用目标方法，返回的是这个方法执行后返回的数据
            Object res = method.invoke(object, parameters);

            System.out.println("提供服务端执行方法返回结果："+res);

            // 获得服务端的输出流
            OutputStream outputStream = accept.getOutputStream();

            // 建立一个字节数组输出流对象。把数据传输模型对象序列化。方便进行网络传输
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            // 创建一个数据传输模型对象，将服务端的返回数据传到客户端。
            TransportModel transportModel1 = new TransportModel();
            transportModel1.setResult(res);
            oos.writeObject(transportModel1);

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
