package com.cc.myinterface;

public interface HttpCallbackListener {
	void onFinish(String response);
	void onError(Exception e);
}
