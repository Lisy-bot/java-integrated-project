package com.lisy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Auto: Lisy
 * @Date: 13
 * @Description:
 * @Version: 1.0
 */

public class NioHtmlReader {
    private Charset charset = Charset.forName("GBK");// 创建GBK字符集
private SocketChannel channel;

public void readHTMLContent(String url, int port) {
try {
InetSocketAddress socketAddress = new InetSocketAddress(url, port);
// 1 打开连接
channel = SocketChannel.open(socketAddress);
// 2 发送请求，使用GBK编码
channel.write(charset.encode("GET" + "/HTTP/1.1" + "\r\n\r\n"));
// 3 读取数据， 创建1024字节的缓冲
ByteBuffer buffer = ByteBuffer.allocate(1024);
while (channel.read(buffer) != -1) {
// flip方法在读缓冲区字节操作之前调用
buffer.flip();
// 使用Charset.decode方法将字节转换为字符串
System.out.println(charset.decode(buffer));
// 清空缓冲
buffer.clear();
}
} catch (Exception e) {
System.err.println(e.toString());
} finally {
if (channel != null) {
try {
channel.close();
} catch (IOException e) {
}
}
}
}

/**
 * @param args
 */
public static void main(String[] args) {
// TODO Auto-generated method stub
new NioHtmlReader().readHTMLContent("14.215.177.39", 80);
}
}
