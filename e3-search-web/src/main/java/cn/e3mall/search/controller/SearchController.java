package cn.e3mall.search.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.e3mall.common.pojo.SearchResult;
import cn.e3mall.search.service.SearchService;

/**
 * 商品搜索结果页面展示Controller
 * @author linyang
 *
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@Value("${search.item.rows}")
	private Integer itemRows;
	
	@RequestMapping("/search")
	public String search(String keyword,@RequestParam(defaultValue="1")int page,Model model) throws Exception{
		//把keyword转码
		if(StringUtils.isNotBlank(keyword)){
			keyword=new String(keyword.getBytes("iso8859-1"),"utf-8");
		}
		//调用服务查询商品列表
		SearchResult search = searchService.search(keyword, page, itemRows);
		//取查询结果并传递给jsp
		//查询参数回显
		model.addAttribute("query", keyword);
		model.addAttribute("totalPages", search.getPageCount());
		model.addAttribute("page", page);
		model.addAttribute("recourdCount", search.getRecordCount());
		model.addAttribute("itemList", search.getItemList());
		
		//返回逻辑视图
		return "search";
	
	}
	
}
