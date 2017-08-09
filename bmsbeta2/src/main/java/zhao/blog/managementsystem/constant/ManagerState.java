package zhao.blog.managementsystem.constant;

public enum ManagerState {
	FAILED("验证失败"),
	FAILED_ACCOUNT("账号错误"),
	FAILED_PASSWORD("密码错误"),
	SUCCESS("验证 成功");
	private String msg;
	private ManagerState(String msg) {
		this.msg = msg;
	}
	public String getStateMsg(){
		return msg;
	}
}
