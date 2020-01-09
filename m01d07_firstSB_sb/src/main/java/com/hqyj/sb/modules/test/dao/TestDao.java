package com.hqyj.sb.modules.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.hqyj.sb.modules.test.entity.City;
import com.hqyj.sb.modules.test.entity.Country;

@Repository
@Mapper
public interface TestDao {
	@Select("select * from m_city where city_id=#{cityId}")
	City getCityByCityId(int cityId);

	// 使用xml文件对数据库进行操作
	City getCityByCityId2(int cityId);

	@Select("select * from m_country where country_id=#{countryId}")
	@Results(id = "countryResult", value = { @Result(column = "country_id", property = "countryId"),
			@Result(column = "country_id", property = "cities", javaType = List.class, many = @Many(select = "com.hqyj.sb.modules.test.dao.TestDao.getCitiesByCountryId")) })
	Country getCountryByCountryId(int countryId);

	@Select("select * from m_city where country_id=#{countryId}")
	List<City> getCitiesByCountryId(int countryId);

	@Select("select * from m_country where country_name=#{countryName}")
	@ResultMap(value = "countryResult")
	Country getCountryByCountryName(String countryName);

	@Select("select * from m_city")
	List<City> getCitiesByPage();

	@Insert("insert into m_city (city_name, local_city_name, country_id, date_created) "
			+ "values(#{cityName}, #{localCityName}, #{countryId}, #{dateCreated})")
	@Options(useGeneratedKeys = true, keyColumn = "city_id", keyProperty = "cityId")
	void insertCity(City city);

	@Update("update m_city set local_city_name = #{localCityName} where city_id = #{cityId}")
	void updateCity(City city);

	@Delete("delete from m_city where city_id = #{cityId}")
	void deleteCity(int cityId);
}
