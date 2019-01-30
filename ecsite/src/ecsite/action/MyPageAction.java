package ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dao.MyPageDAO;
import ecsite.dto.MyPageDTO;


public class MyPageAction extends ActionSupport implements SessionAware{

	private MyPageDAO dao = new MyPageDAO();
	private Map<String,Object> session;
	private List<MyPageDTO> myPageDTOList;
	private String message;
	private int deleteFlg;

	public String execute() {

		if(deleteFlg != 1) {
			myPageDTOList = dao.getBuyHistory((session.get("id")).toString());
		}else if(deleteFlg == 1) {
			delete();
		}

		return SUCCESS;
	}

	public void delete() {
		int result = dao.deleteHistory((session.get("id")).toString());

		if(result>0) {
			message = "履歴の削除に成功しました";
			myPageDTOList = null;
		}else {
			message = "履歴の削除に失敗しました";
		}
	}


	public List<MyPageDTO> getMyPageDTOList(){
		return myPageDTOList;
	}

	public String getMessage() {
		return message;
	}

	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
