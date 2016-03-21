package com.jack.spider.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by jackshi on 16/3/19.
 */
public class ZhiHu {
    private static String title="default";

    public static void main(String[] args){
        fetchZhiHu("https://www.zhihu.com/question/41030642");
    }
    public static void fetchZhiHu(String webUrl){
        Document document;
        try {
            document= Jsoup.connect(webUrl).
                    userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36").get();
            Elements elements=document.select("img[src^=http]");
            title=document.select(".zm-item-title.zm-editable-content").text();
            String url=null;
            int dotIndex=0;
            boolean downloadSuccess=false;
            for (int i=0;i<elements.size();i++){
                url=elements.get(i).attr("data-original");
                dotIndex=url.lastIndexOf(".")+1;
                if (!url.trim().equals("")){
                    downloadSuccess= httpDownload(url,i+"."+url.substring(dotIndex));
                }
                System.out.println("第"+i+"张已下载完成....."+(downloadSuccess==true?"成功":"失败"));
                downloadSuccess=false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean httpDownload(String httpUrl,String saveFile){
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;
        String folder="/Users/jackshi/Desktop/image/"+title;
        File fp = new File(folder);
        // 创建目录
        if (!fp.exists()) {
            fp.mkdirs();// 目录不存在的情况下，创建目录。
            System.out.println("create success");
        }
        saveFile="/Users/jackshi/Desktop/image/"+title+"/"+saveFile;
        URL url = null;
        try {
            url = new URL(httpUrl);
        } catch (MalformedURLException e1) {
            e1.printStackTrace();
            return false;
        }

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(saveFile);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
