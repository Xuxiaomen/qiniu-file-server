package ai.yale.server.service;

import org.springframework.stereotype.Service;

import com.qiniu.util.StringMap;

import ai.yale.server.utils.AuthUtils;
import ai.yale.server.utils.RespMessage;
import ai.yale.server.vo.PutPolicyVo;

@Service
public class UploadTokenService {
	/**
	 * 简单上传的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @return
	 */
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
	
	/**
	 * 覆盖上传的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @param key
	 * @return
	 */
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
	
	/**
	 * 自定义上传回复的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @param key
	 * @param expires
	 * @param policy
	 * @return
	 */
/*	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key, long expires, StringMap policy) {
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

	}*/
	
	/**
	 * 自定义上传回复的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @param key
	 * @param expires
	 * @param policy
	 * @return
	 */
	public RespMessage uploadTokenWithPolicy(String accessKey, String secretKey, PutPolicyVo vo) {
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
		
		AuthUtils authUtils = AuthUtils.create("sSQvardFGUEYXQEoDgstVqnR0JqwA4cTT2lR-rGh", "e-hiyeOBJHxD3BS5Y2GM9CMCJl1mQ7a6pYE6Y35l");
		PutPolicyVo putPolicyVo = new PutPolicyVo();
		putPolicyVo.setExpires(3600L);
		putPolicyVo.setScope("mybucket:title.jpg");
		putPolicyVo.setReturnBody("{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"bucket\":\"$(bucket)\",\"fsize\":$(fsize)}");
		StringMap putPolicy = new StringMap();
		putPolicy.put("scope", putPolicyVo.getScope());
		putPolicy.put("returnBody", putPolicyVo.getReturnBody());
		putPolicy.put("expires", putPolicyVo.getExpires());
		String uploadToken = authUtils.uploadTokenWithPolicy(putPolicyVo);
		return RespMessage.success(uploadToken);

	}
}
