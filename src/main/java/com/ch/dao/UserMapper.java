package com.ch.dao;

import java.util.List;
import java.util.Map;

import com.ch.bean.User;
import com.ch.bean.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer uid);

	int insert(User record);

	int insertSelective(User record);

	User findUserByName(String uname);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer uid);

	int updateByExampleSelective(@Param("record") User record,
                                 @Param("example") UserExample example);

	int updateByExample(@Param("record") User record,
                        @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);
}