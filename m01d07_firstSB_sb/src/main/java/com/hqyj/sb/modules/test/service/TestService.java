package com.hqyj.sb.modules.test.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;

public interface TestService {
	City getCityByCityId(int cityId);

	Country getCountryByCountryId(int countryId);

	List<City> getCitiesByCountryId(int countryId);

	Country getCountryByCountryName(String countryName);

	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize);

	void insertCity(City city);

	void updateCity(City city);

	void deleteCity(int cityId);
}
