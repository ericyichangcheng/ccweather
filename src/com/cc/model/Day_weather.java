package com.cc.model;

public class Day_weather {
	private String date="";//日期
	private String tmp_max="";//最高温度
	private String tmp_min="";//最低温度
	private String wind_dir="";//风向
	private String txt_d="";
	private String txt_n="";
	private String wind_sc="";//风级别
	
	public String getTxt_d() {
		return txt_d;
	}
	public void setTxt_d(String txt_d) {
		this.txt_d = txt_d;
	}
	public String getTxt_n() {
		return txt_n;
	}
	public void setTxt_n(String txt_n) {
		this.txt_n = txt_n;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTmp_max() {
		return tmp_max;
	}
	public void setTmp_max(String tmp_max) {
		this.tmp_max = tmp_max;
	}
	public String getTmp_min() {
		return tmp_min;
	}
	public void setTmp_min(String tmp_min) {
		this.tmp_min = tmp_min;
	}
	public String getWind_dir() {
		return wind_dir;
	}
	public void setWind_dir(String wind_dir) {
		this.wind_dir = wind_dir;
	}
	public String getWind_sc() {
		return wind_sc;
	}
	public void setWind_sc(String wind_sc) {
		this.wind_sc = wind_sc;
	}
}
