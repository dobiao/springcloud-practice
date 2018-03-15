package com.caicongyang.springcloudapp.wushuaiping.rpcdemo.client;

import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.api.HelloService;
import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.impl.HelloServiceImpl;
import com.caicongyang.springcloudapp.wushuaiping.rpcdemo.modle.TransportModel;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 *  RPC客户端，这里发起调用请求。
 *   模拟RPC框架调用过程
 * @author wushuaiping
 * @date 2018/3/15 下午12:22
 */
public class ObjectClientSerializ {
        public static void main(String[] args)  {

            try {

                // 使用Socket与指定IP的主机端口进行连接。
                Socket socket = new Socket("localhost", 8081);

                // 创建一个业务对象，模拟客户端发起调用。
                HelloService helloService = new HelloServiceImpl();

                // 该传输模型对象存储了客户端发起调用的业务对象的一些信息。
                TransportModel model = new TransportModel();

                // 设置客户端的调用对象
                model.setObject(helloService);
                // 设置需要调用的方法
                model.setMethodName("sayHello");
                // 获得业务对象的字节码信息
                Class class1 = helloService.getClass();

                // 在业务对象的字节码信息中获取"sayHello"并且方法入参为String的方法
                Method method = class1.getMethod("sayHello",String.class);

                // 设置传输模型对象中的调用信息。
                // 设置方法参数类型
                model.setParameterTypes(method.getParameterTypes());
                // 设置方法参数
                model.setParameters(new Object[]{"The first step of RPC"});

                // 把存储了业务对象信息的数据传输模型对象转为流，也就是序列化对象。方便在网络中传输。
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(model);
                oos.flush();
                byte[] byteArray = bos.toByteArray();

                // 获得一个socket的输出流。通过该流可以将数据传输到服务端。
                OutputStream outputStream = socket.getOutputStream();

                // 往输出流中写入需要进行传输的序列化后的流信息
                outputStream.write(byteArray);
                outputStream.flush();

                // 因为socket建立的是长连接，所以可以获取到将流数据传到服务端后，返回的信息。
                // 所以我们需要通过输入流，来获取服务端返回的流数据信息。
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(inputStream);

                // 将得到的流数据读成Object对象，强转为我们的数据传输模型对象。最后得到服务端返回的结果。
                TransportModel readObject = (TransportModel)ois.readObject();
                System.out.println("调用返回结果="+readObject.getResult());
                socket.close();

                System.out.println("客户端调用结束");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
