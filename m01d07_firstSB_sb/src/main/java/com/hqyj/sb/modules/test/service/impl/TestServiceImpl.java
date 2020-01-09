package com.hqyj.sb.modules.test.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqyj.sb.modules.test.dao.TestDao;
import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;
import com.hqyj.sb.modules.test.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	private final static int CURRENT_PAGE = 1;
	private final static int PAGE_SIZE = 5;
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

	@Override
	public PageInfo<City> getCitiesByPage(int currentPage, int pageSize) {
		currentPage = currentPage > 0 ? currentPage : CURRENT_PAGE;
		pageSize = pageSize > 0 ? pageSize : PAGE_SIZE;

		PageHelper.startPage(currentPage, pageSize);
		List<City> cities = Optional.ofNullable(testdao.getCitiesByPage()).orElse(Collections.emptyList());

		return new PageInfo<City>(cities);
	}

	@Override
	public void insertCity(City city) {
		testdao.insertCity(city);
	}

	@Override
	@Transactional(noRollbackFor = ArithmeticException.class)
	public void updateCity(City city) {
		int i = 1 / 0;
		testdao.updateCity(city);
	}

	@Override
	public void deleteCity(int cityId) {
		testdao.deleteCity(cityId);
	}

}
