package IO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;

/**
 * 文件传输server端：
 * server接收client端的请求（阻塞式），每接收到一个client端请求连接后，就新开一个处理文件的线程，开始写入流，将文件到server的指定目录下，并与传输过来的文件同名。
 */
public class FileTransferServer extends ServerSocket  {

    private static final int SERVER_PORT = 8899; // 服务端端口
    private static DecimalFormat df = null;


    static {
        // 设置数字格式，保留一位有效小数
        df = new DecimalFormat("#0.0");
        df.setRoundingMode(RoundingMode.HALF_UP);
        df.setMinimumFractionDigits(1);
        df.setMaximumFractionDigits(1);
    }


    public FileTransferServer() throws Exception {
        super(SERVER_PORT);
    }

    public void load() throws Exception {
        while (true) {
            //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
            Socket socket = this.accept();
            new Thread(new Task(socket)).start();
        }
    }

    /**
     * 处理客户端传输过来的文件线程类
     */
    class Task implements Runnable {

        private Socket socket;
        private DataInputStream dis;
        private FileOutputStream fos;
        public Task(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            try {
                dis = new DataInputStream(socket.getInputStream());

                // 文件名和长度
                String fileName = dis.readUTF();
                long fileLength = dis.readLong();
                File directory = new File("D:\\FTCache");
                if (!directory.exists()) {
                    directory.mkdir();
                }

                File file = new File(directory.getAbsolutePath() + File.separatorChar + fileName);
                fos = new FileOutputStream(file);

                // 开始接收文件
                byte[] bytes = new byte[1024];
                int length = 0;
                while ((length = dis.read(bytes, 0, bytes.length)) != -1) {
                    fos.write(bytes, 0, length);
                    fos.flush();
                }
                System.out.println("======== 文件接收成功 [File Name：" + fileName + "] [Size：" + getFormatFileSize(fileLength) + "] ========");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fos != null)
                        fos.close();
                    if (dis != null)
                        dis.close();
                    socket.close();
                } catch (Exception e) {
                }
            }
        }
    }


    /**
     * 格式化文件大小
     *
     * @param length
     * @return
     */

    private String getFormatFileSize(long length) {
        double size = ((double) length) / (1 << 30);
        if (size >= 1) {
            return df.format(size) + "GB";
        }
        size = ((double) length) / (1 << 20);
        if (size >= 1) {
            return df.format(size) + "MB";
        }
        size = ((double) length) / (1 << 10);
        if (size >= 1) {
            return df.format(size) + "KB";
        }
        return length + "B";
    }


    /**
     * 入口
     * @param args
     */
    public static void main(String[] args) {
        try {
            FileTransferServer server = new FileTransferServer(); // 启动服务端
            server.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
