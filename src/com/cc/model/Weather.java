package com.cc.model;


public class Weather {
//	private String qlty="";//质量
	private String city="";//城市名
	private String cnty="";//国家名
	private String update_loc="";//更新时间
	private String now_tmp="";//现在温度
	private String now_txt="";//现在天气状态
	private String now_wind_dir="";//现在风向
	private String suggestion_uv_txt="";//紫外线建议
	
	public Day_weather[] day;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}
	
//	public String getQlty() {
//		return qlty;
//	}
//	public void setQlty(String qlty) {
//		this.qlty = qlty;
//	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCnty() {
		return cnty;
	}
	public void setCnty(String cnty) {
		this.cnty = cnty;
	}
	public String getUpdate_loc() {
		return update_loc;
	}
	public void setUpdate_loc(String update_loc) {
		this.update_loc = update_loc;
	}
	public String getNow_tmp() {
		return now_tmp;
	}
	public void setNow_tmp(String now_tmp) {
		this.now_tmp = now_tmp;
	}
	public String getNow_txt() {
		return now_txt;
	}
	public void setNow_txt(String now_txt) {
		this.now_txt = now_txt;
	}
	public String getNow_wind_dir() {
		return now_wind_dir;
	}
	public void setNow_wind_dir(String now_wind_dir) {
		this.now_wind_dir = now_wind_dir;
	}
	public String getSuggestion_uv_txt() {
		return suggestion_uv_txt;
	}
	public void setSuggestion_uv_txt(String suggestion_uv_txt) {
		this.suggestion_uv_txt = suggestion_uv_txt;
	}
}
