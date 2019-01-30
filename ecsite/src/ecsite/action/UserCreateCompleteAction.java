package ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dao.UserCreateCompleteDAO;

public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String errorMessage;

	public String execute() {

		UserCreateCompleteDAO dao = new UserCreateCompleteDAO();

		String result = ERROR;
		int i = dao.setUserProf(session.get("loginUserId").toString(), session.get("loginPassword").toString(), session.get("userName").toString());

		if(i>0){
			result = SUCCESS;
			session.remove("loginUserId");
			session.remove("loginPassword");
			session.remove("userName");
		}else {
			errorMessage = "登録に失敗しました。再度入力をお願いします。";
		}

		return result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
