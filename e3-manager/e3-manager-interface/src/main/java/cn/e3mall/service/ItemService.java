package cn.e3mall.service;

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
}
