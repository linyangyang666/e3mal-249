package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.service.ItemService;

/**
 *商品管理Controller
 * @author linyang
 *
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable long itemId){
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public DataGridResult getItemList(@RequestParam(defaultValue="1") int page,@RequestParam(defaultValue="30") int rows){
		DataGridResult result = itemService.getItemList(page, rows);
		return result;
		
	}
	@RequestMapping("/item/save")
	@ResponseBody
	public E3Result addTtem(TbItem item,String desc){
		E3Result result = itemService.addTtem(item, desc);
		return result;
	}
	
	
}
