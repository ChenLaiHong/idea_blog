package com.ch.service;

import com.ch.bean.Type;

import com.ch.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class BlogTypeService {

	@Autowired
	TypeMapper typeMapper;


	// 添加类型
	public int add(Type blogType) {

		return typeMapper.insertSelective(blogType);
	}

	// 修改类型
	public int update(Type blogType) {

		return typeMapper.updateByPrimaryKeySelective(blogType);
	}

	// 查询所有类型
	public List<Type> list(Map<String, Object> map) {

		return typeMapper.list(map);
	}

	// 删除类型
	public int delete(int typeId) {
		return typeMapper.deleteByPrimaryKey(typeId);

	}

	// 主页用到的查询方法
	public List<Type> getAll() {
		System.out.print("调用方法。。。");
		return typeMapper.selectByExample(null);

	}

	public List<Type> countList() {

		return typeMapper.countList();
	}

	public Long getTotal(Map<String, Object> map) {

		return typeMapper.getTotal(map);
	}


}
