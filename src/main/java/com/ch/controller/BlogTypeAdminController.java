package com.ch.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ch.bean.PageBean;
import com.ch.bean.Type;
import com.ch.service.BlogService;
import com.ch.service.BlogTypeService;
import com.ch.utils.DateUtil;
import com.ch.utils.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	@Autowired
	BlogTypeService blogTypeService;
	@Autowired
	private BlogService blogService;

	// 列表展示
	@RequestMapping("/list")
	public String list(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<Type> blogTypeList = blogTypeService.list(map);
		Long total = blogTypeService.getTotal(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(blogTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}

	// 保存和更新方法
	@RequestMapping("/save")
	public String save(@RequestParam("imageFile") MultipartFile imageFile,
			Type blogType, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int resultTotal = 0; // 操作的记录条数
		if (blogType.getTypeId() == null) {
			if (!imageFile.isEmpty()) {
				String filePath = request.getServletContext().getRealPath("/");
				String imageName = DateUtil.getCurrentDateStr() + "."
						+ imageFile.getOriginalFilename().split("\\.")[1];
				imageFile.transferTo(new File(filePath + "static/userImages/"
						+ imageName));
				//imageFile.transferTo(new File(filePath+ imageName));
				blogType.setImageName(imageName);
			}
			resultTotal = blogTypeService.add(blogType);
			System.out.println("添加操作：" + resultTotal);
		} else {
			if (!imageFile.isEmpty()) {
				String filePath = request.getServletContext().getRealPath("/");
				String imageName = DateUtil.getCurrentDateStr() + "."
						+ imageFile.getOriginalFilename().split("\\.")[1];
				imageFile.transferTo(new File(filePath + "static/userImages/"
					+ imageName));
			//	imageFile.transferTo(new File(filePath+ imageName));
				blogType.setImageName(imageName);
			}
			resultTotal = blogTypeService.update(blogType);
		}
		JSONObject result = new JSONObject();
		if (resultTotal != 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("ids") String ids,
			HttpServletResponse response) throws Exception {
		String idsStr[] = ids.split(",");
		JSONObject result = new JSONObject();
		for (int i = 0; i < idsStr.length; i++) {
			if (blogService.getBlogByTypeId(Integer.parseInt(idsStr[i])) > 0) {
				result.put("exist", "博客类别下有博客，不能删除！");
			} else {
				blogTypeService.delete(Integer.parseInt(idsStr[i]));
			}
		}
		result.put("success", true);
		ResponseUtil.write(response, result);

		return null;
	}

}
