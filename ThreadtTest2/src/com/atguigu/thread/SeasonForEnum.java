package com.atguigu.thread;

public enum SeasonForEnum {

	ONE(1,"春"),TWO(2,"夏"),THREE(3,"秋"),FOUR(4,"冬");
	private Integer id;
	private  String season;
	
	private SeasonForEnum(Integer id, String season) {
		this.id = id;
		this.season = season;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}
	
	
	
	
	
}
