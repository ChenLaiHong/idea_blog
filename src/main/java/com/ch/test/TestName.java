package com.ch.test;

import com.ch.bean.User;
import com.ch.bean.UserExample;
import com.ch.dao.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class TestName {
	@Autowired
	UserMapper userMapper;

	@Test
	public void test() {

		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo("赖红");
		User user = (User) userMapper.selectByExample(example);
		System.out.println(user);
	}

}
