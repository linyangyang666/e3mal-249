package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.common.pojo.TreeNode;

public interface ContentCategoryService {
	
	List<TreeNode> getContentCategoryList(long parentId);
	/**
	 * 添加内容分类
	 */
	E3Result addContentCategory(long parentId,String name);
	
	
}
