package ai.yale.server.vo;

public class PutPolicyVo {

	private String scope;
	private Long deadline;
	private String returnBody;
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public Long getDeadline() {
		return deadline;
	}
	public void setDeadline(Long deadline) {
		this.deadline = deadline;
	}
	public String getReturnBody() {
		return returnBody;
	}
	public void setReturnBody(String returnBody) {
		this.returnBody = returnBody;
	}
	@Override
	public String toString() {
		return "PutPolicyVo [scope=" + scope + ", deadline=" + deadline + ", returnBody=" + returnBody + "]";
	}
	
}
