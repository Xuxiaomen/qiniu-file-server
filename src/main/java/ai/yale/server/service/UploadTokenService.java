package ai.yale.server.service;

import org.springframework.stereotype.Service;

import com.qiniu.util.StringMap;

import ai.yale.server.utils.AuthUtils;
import ai.yale.server.utils.RespMessage;
import ai.yale.server.vo.PutPolicyVo;

@Service
public class UploadTokenService {
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey) {
//		String accessKey = "access key";
//		String secretKey = "secret key";
//		String bucket = "bucket name";
		
//		Auth auth = Auth.create(accessKey, secretKey);
//		String upToken = auth.uploadToken(bucket);
//		System.out.println(upToken);
		
		String uploadToken = AuthUtils.create(accessKey, secretKey).uploadToken(bucket);
		return RespMessage.success(uploadToken);

	}
	
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key) {
//		String accessKey = "access key";
//		String secretKey = "secret key";
//		String bucket = "bucket name";
//		String key = "file key";
		
//		Auth auth = Auth.create(accessKey, secretKey);
//		String upToken = auth.uploadToken(bucket, key);
//		System.out.println(upToken);
		String uploadToken = AuthUtils.create(accessKey, secretKey).uploadToken(bucket, key);
		return RespMessage.success(uploadToken);

	}
	
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key, long expires, StringMap policy) {
//		String accessKey = "access key";
//		String secretKey = "secret key";
//		String bucket = "bucket name";
		
//		Auth auth = Auth.create(accessKey, secretKey);
//		StringMap putPolicy = new StringMap();
//		putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
//		long expireSeconds = 3600;
//		String upToken = auth.uploadToken(bucket, null, expireSeconds, putPolicy);
//		System.out.println(upToken);
		
		AuthUtils authUtils = AuthUtils.create(accessKey, secretKey);
		PutPolicyVo policyVo = new PutPolicyVo();
		policy.put("returnBody", policyVo.getReturnBody());
		
		String uploadToken = authUtils.uploadToken(bucket, null, expires, policy);
		return RespMessage.success(uploadToken);

	}
	
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key, long expires, StringMap policy, boolean strict) {
		
		AuthUtils authUtils = AuthUtils.create(accessKey, secretKey);
		String uploadToken = authUtils.uploadToken(bucket, key, expires, policy, strict);
		return RespMessage.success(uploadToken);

	}
	
	public String uploadTokenWithDeadline(String bucket, String key, long deadline, StringMap policy, boolean strict) {
		
		
		return null;
	
	}
	
	 public String uploadTokenWithPolicy(Object obj) {
		
		
		return null;
		 
	 }
	
//	
//	public RespMessage uploadTokenWithPolicy(String accessKey, String secretKey, PutPolicyVo vo) {
//		String accessKey = "access key";
//		String secretKey = "secret key";
//		String bucket = "bucket name";
//		
//		AuthUtils authUtils = AuthUtils.create(accessKey, secretKey);
//		StringMap putPolicy = new StringMap();
//		putPolicy.put("returnBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
//		long expireSeconds = 3600;
//		String upToken = authUtils.uploadToken(bucket, null, expireSeconds, putPolicy);
//		System.out.println(upToken);
//		
//		AuthUtils authUtils = AuthUtils.create("sSQvardFGUEYXQEoDgstVqnR0JqwA4cTT2lR-rGh", "e-hiyeOBJHxD3BS5Y2GM9CMCJl1mQ7a6pYE6Y35l");
//		PutPolicyVo putPolicyVo = new PutPolicyVo();
//		putPolicyVo.setDeadline(3600L);
//		putPolicyVo.setScope("mybucket:title.jpg");
//		putPolicyVo.setReturnBody("{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
//		StringMap putPolicy = new StringMap();
//		putPolicy.put("scope", putPolicyVo.getScope());
//		putPolicy.put("returnBody", putPolicyVo.getReturnBody());
//		putPolicy.put("deadline", putPolicyVo.getDeadline());
//		String uploadToken = authUtils.uploadTokenWithPolicy(putPolicyVo);
//		return RespMessage.success(uploadToken);
//
//	}
}
