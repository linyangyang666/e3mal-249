package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;

/**
 * 文件上传处理Controller
 * @author linyang
 *
 */
@Controller
public class PictureController {
	
	@Value("${imageserver.url}")
	private String imageServerUrl;

	@RequestMapping(value="/pic/upload",produces=MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
	@ResponseBody
	public String uploadFile(MultipartFile uploadFile) {
		//1.接收上传的文件内容
		//2.把文件保存到图片接收器
		//1).创建一个FastDFSClient对象
		try {
			FastDFSClient fastDFSClient =new FastDFSClient("classpath:/conf/client.conf");
			//2).取文件扩展名，先取文件原始名称，然后截取扩展名
			String originalFilename = uploadFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			
			//3).文件上传
			String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
			//3.把返回的url拼装成一个完整的url
			url=imageServerUrl+url;
			//4.创建返回结果的Map对象
			Map result=new HashMap<>();
			result.put("error", 0);
			result.put("url", url);
			//5.返回结果
			return  JsonUtils.objectToJson(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Map result=new HashMap<>();
			result.put("error", 1);
			result.put("message", "上传文件失败:"+e.getMessage());
			return  JsonUtils.objectToJson(result);
		}
	}
}
