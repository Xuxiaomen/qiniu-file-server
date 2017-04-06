package ai.yale.server.vo;

public class PutPolicyVo {

	private String scope;
	private Long expires;
	private String returnBody;
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Long getExpires() {
		return expires;
	}
	public void setExpires(Long expires) {
		this.expires = expires;
	}
	public String getReturnBody() {
		return returnBody;
	}
	public void setReturnBody(String returnBody) {
		this.returnBody = returnBody;
	}
	@Override
	public String toString() {
		return "PutPolicyVo [scope=" + scope + ", expires=" + expires + ", returnBody=" + returnBody + "]";
	}
	
}
