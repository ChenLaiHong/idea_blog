package com.ch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ch.bean.Blog;
import com.ch.bean.Comment;
import com.ch.bean.User;
import com.ch.service.BlogService;
import com.ch.service.CommentService;
import com.ch.utils.ResponseUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	@Autowired
	BlogService blogService;

	@RequestMapping("/save")
	public String save(Comment comment, HttpServletRequest request,
					   HttpServletResponse response, HttpSession session) throws Exception {

		JSONObject result = new JSONObject();
		int resultTotal = 0; // 操作的记录条数
		User user = (User) session.getAttribute("currentUser");
		if (user != null) {
			String author = user.getUname();

			if (comment.getCid() == null) {
				comment.setAuthor(author);
				resultTotal = commentService.add(comment);
				// 该博客的回复次数加1
				Blog blog = blogService.findByBid(comment.getBlog().getBid());
				blog.setReplyHit(blog.getReplyHit() + 1);
				blogService.update(blog);
			} else {

			}

			if (resultTotal != 0) {
				result.put("success", true);
			} else {
				result.put("success", false);
			}
		} else {
			result.put("success", false);
		}

		ResponseUtil.write(response, result);
		return null;
	}

}
