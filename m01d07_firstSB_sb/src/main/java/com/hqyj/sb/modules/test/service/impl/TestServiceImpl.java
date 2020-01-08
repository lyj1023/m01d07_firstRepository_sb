package com.hqyj.sb.modules.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqyj.sb.modules.test.dao.TestDao;
import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;
import com.hqyj.sb.modules.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDao testdao;

	@Override
	public City getCityByCityId(int cityId) {
		return testdao.getCityByCityId(cityId);
	}

	@Override
	public Country getCountryByCountryId(int countryId) {
		return testdao.getCountryByCountryId(countryId);
	}

	@Override
	public List<City> getCitiesByCountryId(int countryId) {
		return testdao.getCitiesByCountryId(countryId);
	}

	@Override
	public Country getCountryByCountryName(String countryName) {
		return testdao.getCountryByCountryName(countryName);
	}

}
