package com.ch.service;

import java.util.List;
import java.util.Map;


import com.ch.bean.Comment;
import com.ch.dao.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CommentService {

	@Autowired
	CommentMapper commentMapper;

	public List<Comment> list(Map<String, Object> map) {

		return commentMapper.list(map);
	}

	public int add(Comment comment) {

		return commentMapper.add(comment);
	}

	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return commentMapper.getTotal(map);
	}

	public Integer delete(Integer id) {
		return commentMapper.deleteByPrimaryKey(id);
	}

	public void update(Comment comment) {
		commentMapper.updateByPrimaryKeySelective(comment);

	}

	public int deleteByBid(int bid) {

		return commentMapper.deleteByPrimaryKey(bid);

	}

}
