package com.hqyj.sb.modules.test.service;

import java.util.List;

import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;

public interface TestService {
	City getCityByCityId(int cityId);

	Country getCountryByCountryId(int countryId);

	List<City> getCitiesByCountryId(int countryId);

	Country getCountryByCountryName(String countryName);
}
