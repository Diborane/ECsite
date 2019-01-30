package ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private String errorMessage;
	private Map<String,Object> session;

	public String execute() {

		String result=ERROR;

		if((!(loginUserId.equals("")))&&(!(loginPassword.equals("")))&&(!(userName.equals("")))) {
			result=SUCCESS;
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);
		}else {
			errorMessage = "未入力の項目があります";
		}

		return result;
	}


	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
