package ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dao.BuyItemDAO;
import ecsite.dao.LoginDAO;
import ecsite.dto.BuyItemDTO;
import ecsite.dto.LoginDTO;


public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String errorMessage;
	private Map<String,Object> session;

	public String execute() {

		String result = ERROR;

		LoginDAO loginDAO = new LoginDAO();
		LoginDTO loginDTO = loginDAO.getLogin(loginUserId,loginPassword);
		BuyItemDAO buyItemDAO = new BuyItemDAO();

		if(loginDTO.getLoginFlg()) {

			List<BuyItemDTO> buyItemDTOList = buyItemDAO.getItemInfo();

			session.put("id",loginDTO.getLoginUserId());
			session.put("buyItemDTOList", buyItemDTOList);

			result = SUCCESS;
		}else{
			errorMessage = "ログインに失敗しました。再度ログイン情報を入力してください。";
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

	public String getErrorMessage(){
		return errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
