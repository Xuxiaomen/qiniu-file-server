package ai.yale.server.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiniu.util.StringMap;

import ai.yale.server.service.UploadTokenService;
import ai.yale.server.utils.RespMessage;
import ai.yale.server.vo.PutPolicyVo;

@RestController
public class UploadTokenController {

	@Autowired
	UploadTokenService uploadTokenService;
	
	@RequestMapping(value = "/uptoken/simple_uptoken")
	/**
	 * 简单上传的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @return
	 */
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey) {
		
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey);
		
	}
	
	@RequestMapping(value = "/uptoken/cover_file_name")
	/**
	 * 覆盖上传的凭证
	 * @param bucket
	 * @param accessKey
	 * @param secretKey
	 * @param key
	 * @return
	 */
	public RespMessage uploadToken(String bucket, String accessKey, String secretKey, String key) {
		
		return uploadTokenService.uploadToken(bucket, accessKey, secretKey, key);
		
	}
	
	@RequestMapping(value = "/uptoken/reply/policy")
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
	public RespMessage uploadTokenWith(String bucket, String accessKey, String secretKey, PutPolicyVo vo) {
		
		return uploadTokenService.uploadTokenWithPolicy(accessKey, secretKey, vo);
		
	}
}
