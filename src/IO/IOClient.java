package IO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * 客户端发送数据 ：连接上服务端8000端口之后，每隔2秒，向服务端写一个带有时间戳的 "hello world"。
 */
public class IOClient {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket socket = new Socket("127.0.0.1", 8000);
                    while (true){
                        socket.getOutputStream().write((new Date()+" hello world").getBytes());
                        socket.getOutputStream().flush();
                        Thread.sleep(2000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}

