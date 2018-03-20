package com.atguigu.thread;

public enum SevenCountry {
	
	ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
	
	public static SevenCountry foreachCountryName(Integer id) {
		for (SevenCountry country : values()) {
			if (country.getId()==id) {
				return country;
			}
		}
		return null;
	}
	
	private Integer id;
	private String countryName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	private SevenCountry(Integer id, String countryName) {
		this.id = id;
		this.countryName = countryName;
	}
	
	
}
