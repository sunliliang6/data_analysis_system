package com.wayzim.util;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;

/**
 * @Author sunli
 * @Date 2020/6/24
 * @Version 1.0
 */
public class GetDataHttp {

        public static void main(String[] args) {
            String result = GetDataHttp.get("http://192.168.100.251:3000/prophetapi");

            System.out.println(result);
        }

        public static String get(String url){
            String result = "";
            HttpPost get = new HttpPost(url);
            try{
                CloseableHttpClient httpClient = HttpClients.createDefault();

                HttpResponse response = httpClient.execute(get);
                result = getHttpEntityContent(response);

                if(response.getStatusLine().getStatusCode()!= HttpStatus.SC_OK){
                    result = "服务器异常";
                }
            } catch (Exception e){
                System.out.println("请求异常");
                throw new RuntimeException(e);
            } finally{
                get.abort();
            }
            return result;
        }

        public static String getHttpEntityContent(HttpResponse response) throws UnsupportedOperationException, IOException {
            String result = "";
            HttpEntity entity = response.getEntity();
            if(entity != null){
                InputStream in = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
                StringBuilder strber= new StringBuilder();
                String line = null;
                while((line = br.readLine())!=null){
                    strber.append(line+'\n');
                }
                br.close();
                in.close();
                result = strber.toString();
            }

            return result;

        }

    }



