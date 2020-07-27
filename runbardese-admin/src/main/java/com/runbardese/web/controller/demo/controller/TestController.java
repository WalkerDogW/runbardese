package com.runbardese.web.controller.demo.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class TestController {

    public static String sendXMLToNC(String url, String xmlStr)
            throws Exception {
        //String testUrl = "http://192.168.1.3/service/XChangeServlet?account=01&receiver=HY";
        //URL realURL = new URL(DBManager.getNC_WBJHPT_URL());
        URL realURL = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) realURL
                .openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-type", "text/xml");
        connection.setRequestMethod("POST");
        // 将Document对象写入连接的输出流中
        // File file = new File("C:/23.xml");
        BufferedOutputStream out = new BufferedOutputStream(
                connection.getOutputStream());
        // BufferedInputStream input = new BufferedInputStream(new
        // FileInputStream(file));
        InputStream is = new ByteArrayInputStream(xmlStr.getBytes("UTF-8"));
        BufferedInputStream input = new BufferedInputStream(is);
        int length;
        byte[] buffer = new byte[1000];
        while ((length = input.read(buffer, 0, 1000)) != -1) {
            out.write(buffer, 0, length);
        }
        input.close();
        out.close();
        // 从连接的输入流中取得回执信息
        InputStream inputStream = connection.getInputStream();
        String rsStr = new String(readInputStream(inputStream), "UTF-8");
        // System.out.println(rsStr);
        return rsStr;
    }

    public static byte[] readInputStream(InputStream inStream)
            throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();// 网页的二进制数据
        outStream.close();
        inStream.close();
        return data;
    }
}

