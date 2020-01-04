package IO;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 * 文件传输client端：
 * client与server创建连接，选择client端文件，先将文件名称和大小等属性发送到server端，再将文件内容以流的形式传输给server端。
 */
public class FileTransferClient extends Socket {

    private static final String SERVER_IP = "127.0.0.1"; // 服务端IP
    private static final int SERVER_PORT = 8899; // 服务端端口

    private Socket client;
    private FileInputStream fis;
    private DataOutputStream dos;

    /**
     * 构造函数
     * 与服务器建立连接
     * @throws Exception
     */
    public FileTransferClient() throws Exception {
        super(SERVER_IP, SERVER_PORT);
        this.client = this;
        System.out.println("Client[port:" + client.getLocalPort() + "] 成功连接服务端");
    }

    /**
     * 向服务器传输文件
     * @throws Exception
     */
    public void sendFile() throws Exception{
        try{
            File file = new File("D:\\百万医疗保险推荐通知(socket测试).pdf");
            if(file.exists()){
                fis = new FileInputStream(file);
                dos = new DataOutputStream(client.getOutputStream());

                //文件名和文件大小
                dos.writeUTF(file.getName());
                dos.flush();
                dos.writeLong(file.length());
                dos.flush();

                //开始传输文件
                System.out.println("=======开始传输文件=======");
                byte[] bytes = new byte[1024];
                int length = 0;
                long progress = 0;
                while((length = fis.read(bytes, 0, bytes.length)) != -1) {
                    dos.write(bytes, 0, length);
                    dos.flush();
                    progress += length;
                    System.out.print("| " + (100*progress/file.length()) + "% |");
                }
                System.out.println();
                System.out.println("======== 文件传输成功 ========");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                fis.close();
            }
            if(dos != null){
                dos.close();
            }
            client.close();
        }
    }


    /**
     * 入口
     * @param args
     */

    public static void main(String[] args) {
        try {
            FileTransferClient client = new FileTransferClient(); // 启动客户端连接
            client.sendFile(); // 传输文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
