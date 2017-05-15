package ai.yale.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiniu.util.StringMap;

import ai.yale.server.service.UploadTokenService;
import ai.yale.server.utils.RespMessage;

@RestController
public class UploadTokenController {

	@Autowired
	UploadTokenService uploadTokenService;
	
	@RequestMapping(value = "/uptoken/simple_uptoken")
	public RespMessage uploadToken(String bucket,String accessKey,String secretKey) {
		
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey);
		
	}
	
	@RequestMapping(value = "/uptoken/cover_file_name")
	public RespMessage uploadToken(String bucket,String accessKey,String secretKey, String key) {
		
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey, key);
		
	}
	
	@RequestMapping(value = "/uptoken/reply/policy")
	public RespMessage uploadTokenWith(String bucket, String accessKey, String secretKey, String key, long expires, StringMap policy) {
		
		//return uploadTokenService.uploadTokenWithDeadline(bucket, accessKey, secretKey, key, expireSeconds,null);
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey, key, expires, policy);
		
	}
	
	@RequestMapping(value = "/uptoken/reply/strict")
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key, long expires, StringMap policy, boolean strict) {
		
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey, key, expires, policy, true);
		
	}
	
//	@RequestMapping(value = "/uptoken/reply/putpolicy_vo")
//	public RespMessage uploadTokenWithPolicy(String accessKey, String secretKey, PutPolicyVo vo) {
//		return uploadTokenService.uploadTokenWithPolicy(accessKey, secretKey, vo);
//		
//	}
}
