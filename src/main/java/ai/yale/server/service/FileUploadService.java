package ai.yale.server.service;

import org.apache.tomcat.jni.File;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import ai.yale.server.utils.RespMessage;

@Service
public class FileUploadService {

	public RespMessage fileUpload(File file) {
		
		Configuration cfg = new Configuration(Zone.zone2());
		// ...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		// ...生成上传凭证，然后准备上传
		String accessKey = "sSQvardFGUEYXQEoDgstVqnR0JqwA4cTT2lR-rGh";
		String secretKey = "e-hiyeOBJHxD3BS5Y2GM9CMCJl1mQ7a6pYE6Y35l";
		String bucket = "bucket01";
		// 如果是Windows情况下，格式是 D:\\qiniu\\test.png
		String localFilePath = "C:\\title.jpg";
		// 默认不指定key的情况下，以文件内容的hash值作为文件名
		String key = null;
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		
			try {
				Response response = uploadManager.put(localFilePath, key, upToken);
				// 解析上传成功的结果
				DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
				System.out.println(putRet.key);
				System.out.println(putRet.hash);
			} catch (QiniuException ex) {
				Response r = ex.response;
				System.err.println(r.toString());
				try {
					System.err.println(r.bodyString());
				} catch (QiniuException ex2) {
					// ignore
				}
			}
		
		
		return RespMessage.success();
		
	}
}