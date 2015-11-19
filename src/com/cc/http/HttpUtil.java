package com.cc.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.cc.myinterface.HttpCallbackListener;

public class HttpUtil {
	public static void sendHttpRequest(String nameString,final String address,final HttpCallbackListener listener){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				String result = null;
				URL url = null;
				HttpURLConnection connection = null;
				InputStreamReader in = null;

				try {
//					String httpUrl = "http://apis.baidu.com/heweather/weather/free";
//					String httpArg = "city="+URLEncoder.encode(nameString, "UTF-8");
//					url = new URL(address + "?" + httpArg);
//					connection.setRequestProperty("apikey",  "ace9fbbb633e4e68a6da0d58a53e5319 ");
					url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					in = new InputStreamReader(connection.getInputStream(),"UTF-8");
					BufferedReader bufferedReader = new BufferedReader(in);
					StringBuffer strBuffer = new StringBuffer();
					String line = null;
					while ((line = bufferedReader.readLine()) != null) {
						strBuffer.append(line);
					}
					result = strBuffer.toString();
					if (listener!=null) {
						listener.onFinish(result);
					}
				} catch (Exception e) {
					e.printStackTrace();
					if (listener!=null) {
						listener.onError(e);
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
	
	//NameValuePair（简单名称值对节点类型）
	public static void sendHttpRequestPost(final String address,final List<NameValuePair> params,final HttpCallbackListener listener){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				/*
				由于HttpClient是一个接口，故无法创建它的实例，通常都会创建一个DefaultHttpClient的实例
				*/
				HttpClient httpClient=new DefaultHttpClient();
				//创建一个HttpPost类
				HttpPost httpPost=new HttpPost(address);
				try {
					//设置提交的参数编码，并传入到UrlEncodedFormEntity中
					UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params, "UTF-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse=httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode()==200) {
						//请求和响应都成功了
						//获取执行后返回的HttpEntity实例
						HttpEntity entity2=httpResponse.getEntity();
						String response=EntityUtils.toString(entity2,"UTF-8");
						if (listener!=null) {
							listener.onFinish(response);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if (listener!=null) {
						listener.onError(e);
					}
				}
				
				
			}
		}).start();
	}
}








