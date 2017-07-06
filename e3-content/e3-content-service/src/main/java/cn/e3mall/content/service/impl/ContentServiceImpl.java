package cn.e3mall.content.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.DataGridResult;
import cn.e3mall.common.pojo.E3Result;
import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
/**
 * 内容管理service
 * @author linyang
 *
 */
@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;
	

	@Override
	public DataGridResult getConentList(long categoryId, int page, int rows) {
		//1.根据分类id查询内容列表
		//2.需要进行分页处理，可以使用PageHelper实现
		PageHelper.startPage(page, rows);
		//执行查询
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//执行查询
		List<TbContent> contentList = contentMapper.selectByExample(example);
		//3.取分页结果
		PageInfo<TbContent> pageInfo =new PageInfo<>(contentList);
		long total = pageInfo.getTotal();
		//4.创建一个DataGridResult对象，设置属性
		DataGridResult result=new DataGridResult();
		result.setTotal(total);
		result.setRows(contentList);
		//5.返回结果		
		return result;
	}

	
	@Override
	public E3Result addContent(TbContent content) {
		//1.接收参数就
		//2.补全pojo的属性
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//3.插入数据
		contentMapper.insert(content);
		//4.返回结果

		return E3Result.ok();
	}


	@Override
	public List<TbContent> getContentList(long categoryId) {
		//根据分类id查询内容列表
		TbContentExample example=new TbContentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(categoryId);
		//执行查询
		List<TbContent> list = contentMapper.selectByExample(example);
		
		return list;
	}

}
