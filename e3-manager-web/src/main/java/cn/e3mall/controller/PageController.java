package cn.e3mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转Controller
 * @author linyang
 *
 */
@Controller
public class PageController {

	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	/**
	 * 展示左侧选项
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
