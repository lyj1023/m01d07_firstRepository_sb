package com.hqyj.sb.modules.test.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class City {
	private int cityId;
	private String cityName;
	private String localCityName;
	private int countryId;
	private String district;
	private int population;
	@JsonFormat(pattern = "yyyy‐MM‐dd HH:mm:ss", timezone = "GMT+8")
	private Date dateModified;
	@JsonFormat(pattern = "yyyy‐MM‐dd HH:mm:ss", timezone = "GMT+8")
	private Date dateCreated;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLocalCityName() {
		return localCityName;
	}

	public void setLocalCityName(String localCityName) {
		this.localCityName = localCityName;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
