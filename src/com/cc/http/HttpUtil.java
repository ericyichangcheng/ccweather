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
	
	//NameValuePair��������ֵ�Խڵ����ͣ�
	public static void sendHttpRequestPost(final String address,final List<NameValuePair> params,final HttpCallbackListener listener){
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				/*
				����HttpClient��һ���ӿڣ����޷���������ʵ����ͨ�����ᴴ��һ��DefaultHttpClient��ʵ��
				*/
				HttpClient httpClient=new DefaultHttpClient();
				//����һ��HttpPost��
				HttpPost httpPost=new HttpPost(address);
				try {
					//�����ύ�Ĳ������룬�����뵽UrlEncodedFormEntity��
					UrlEncodedFormEntity entity=new UrlEncodedFormEntity(params, "UTF-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse=httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode()==200) {
						//�������Ӧ���ɹ���
						//��ȡִ�к󷵻ص�HttpEntityʵ��
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








