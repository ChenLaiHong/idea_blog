package com.ch.dao;

import java.util.List;
import java.util.Map;

import com.ch.bean.Blog;
import com.ch.bean.BlogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogMapper {
	long countByExample(BlogExample example);

	int deleteByExample(BlogExample example);

	int deleteByPrimaryKey(Integer bid);

	int insert(Blog record);

	int insertSelective(Blog record);

	List<Blog> selectByExample(BlogExample example);

	Blog selectByPrimaryKey(Integer bid);

	List<Blog> selectByExampleWithType(BlogExample example);

	Blog selectByPrimaryKeyWithType(Integer bid);

	int updateByExampleSelective(@Param("record") Blog record,
                                 @Param("example") BlogExample example);

	int updateByExample(@Param("record") Blog record,
                        @Param("example") BlogExample example);

	int updateByPrimaryKeySelective(Blog record);

	int updateByPrimaryKey(Blog record);

	int getBlogByTypeId(Integer typeId);

	int add(Blog blog);

	List<Blog> list(Map<String, Object> map);

	Long getTotal(Map<String, Object> map);

}