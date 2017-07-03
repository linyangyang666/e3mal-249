package cn.e3mall.service;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.pojo.TbItem;

/**
 * 项目的业务层接口
 * @author linyang
 *
 */
public interface ItemService {
	/**
	 * 根据id查询项目
	 * @param itemId
	 * @return
	 */
	TbItem getItemById(long itemId);
	/**
	 * 分页查询
	 */
	DataGridResult getItemList(int page,int rows);
	/**
	 * 商品添加
	 */
	E3Result addTtem(TbItem item,String desc);
	
}
