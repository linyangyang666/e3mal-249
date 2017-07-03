package cn.e3mall.fastdfs;

import static org.junit.Assert.*;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import cn.e3mall.common.utils.FastDFSClient;

public class FastDFsTest {

	@Test
	public void uploadFile() throws Exception{
		//1.添加对客户端jar包的依赖
		//2.创建一个配置文件，配置文件中需要Tracker服务器的地址
		//3.加载配置文件(反斜杠在java里面是转义的意思，所有要替换成斜杠)
		ClientGlobal.init("D:/workspace/javaEE249/04/git-repo/e3-manager-web/src/main/resources/conf/client.conf");
		// 2、创建一个TrackerClient对象。直接new一个。
		TrackerClient trackerClient = new TrackerClient();
		// 3、使用TrackerClient对象创建连接，获得一个TrackerServer对象。
		TrackerServer trackerServer = trackerClient.getConnection();
		// 4、创建一个StorageServer的引用，值为null
		StorageServer storageServer = null;
		// 5、创建一个StorageClient对象，需要两个参数TrackerServer对象、StorageServer的引用
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		// 6、使用StorageClient对象上传图片。
		//扩展名不带“.”
		String[] strings = storageClient.upload_file("C:/Users/Public/Pictures/Sample Pictures/cs20002.jpg", "jpg", null);
		// 7、返回数组。包含组名和图片的路径。
		for (String string : strings) {
			System.out.println(string);
		}
	}	
	@Test
	public void testFastDfasClient() throws Exception {
		//创建FastDFSClient的对象，构造参数配置文件的路径
		FastDFSClient fastDFSClent=new FastDFSClient("D:/workspace/javaEE249/04/git-repo/e3-manager-web/src/main/resources/conf/client.conf");
		//实现文件上传，返回文件的路径
		String string = fastDFSClent.uploadFile("C:/Users/Public/Pictures/Sample Pictures/女神_cs1.jpg");
		//打印结果
		System.out.println(string);
	}
}
