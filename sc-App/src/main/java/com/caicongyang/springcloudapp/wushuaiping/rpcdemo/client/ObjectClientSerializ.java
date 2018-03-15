package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.client;

import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.api.HelloService;
import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.impl.HelloServiceImpl;
import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.modle.TransportModel;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 *  RPC客服端
 * @author wushuaiping
 * @date 2018/3/15 下午12:22
 */
public class ObjectClientSerializ {
        public static void main(String[] args)  {

            try {
                Socket socket = new Socket("localhost", 8081);

                HelloService helloService = new HelloServiceImpl();

                TransportModel model = new TransportModel();
                model.setObject(helloService);
                model.setMethodName("sayHello");
                Class<? extends HelloService> class1 = helloService.getClass();
                Method method = class1.getMethod("sayHello",String.class);
                model.setParameterTypes(method.getParameterTypes());
                model.setParameters(new Object[]{"The first step of RPC"});

                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(model);

                oos.flush();

                byte[] byteArray = bos.toByteArray();

                OutputStream outputStream = socket.getOutputStream();

                outputStream.write(byteArray);
                outputStream.flush();
                InputStream inputStream = socket.getInputStream();

                ObjectInputStream ois = new ObjectInputStream(inputStream);
                TransportModel readObject = (TransportModel)ois.readObject();
                System.out.println("调用返回结果="+readObject.getResult());
                socket.close();

                System.out.println("客户端调用结束");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
