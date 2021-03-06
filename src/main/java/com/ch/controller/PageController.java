package com.ch.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.ch.bean.Blog;
import com.ch.bean.Type;
import com.ch.bean.User;
import com.ch.service.BlogService;
import com.ch.service.BlogTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class PageController {
	@Autowired
	BlogTypeService blogTypeService;

	@Autowired
	BlogService blogService;



	// @RequestMapping("/blogs")
	// public String showPage() {
	// return "login";

	// }

	// 去用户主页面
	@RequestMapping("/toMain")
	public String toIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			HttpSession httpSession, Model model) {
		User user = (User) httpSession.getAttribute("currentUser");
		String uname = user.getUname();
		PageHelper.startPage(pn, 2);// 每页2条数据

		List<Blog> selfBlogs = blogService.getAll(uname);
		PageInfo page = new PageInfo(selfBlogs, 2);
		model.addAttribute("selfBlogs", page);
		return "home";
	}

	// 去注册页面
	@RequestMapping("/toRegister")
	public String toRegister() {
		return "register";
	}

	// 去登录页面
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}

	// 去更新页面
	@RequestMapping("/toUpdateUser")
	public String toUpdateUser() {
		return "updateUser";
	}

	// 去后台更新类别页面
	@RequestMapping("/toAdminBlogType")
	public String toAdminBlogType() {
		return "adminBlogType";
	}


	@RequestMapping("/toAdminUser")
	public String toAdminUser() {
		return "adminUser";
	}

	@RequestMapping("/toAdminComment")
	public String toAdminComment() {
		return "adminComment";
	}

	@RequestMapping("/toAdminCommentRead")
	public String toAdminCommentRead() {
		return "adminCommentRead";
	}

	@RequestMapping("/toEmail")
	public String toEmail() {
		return "send_email";
	}

	// 去写博客页面
	@RequestMapping("/toWriter")
	public String toWriter(Model model) {
		List<Type> types = blogTypeService.countList();
		//List<Type> types = blogTypeService.getAll();
		PageInfo page = new PageInfo(types);
		model.addAttribute("pageInfo", page);
		return "writerBlog";

	}

	// 去修改密码页面
	@RequestMapping("/toUpdatePass")
	public String toUpdatePass() {
		return "updatePass";
	}

	// 去后台查看博客列表页面
	@RequestMapping("/toAdminBlogLook")
	public String toAdminBlogLook() {
		return "adminBlogLook";
	}


}