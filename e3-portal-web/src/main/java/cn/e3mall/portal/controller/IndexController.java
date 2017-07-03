package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商城首页展示Controller
 * @author linyang
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/index")
	public String showIndex(){
		return "index";
	}
}
