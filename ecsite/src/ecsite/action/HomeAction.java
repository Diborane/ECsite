package ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dao.BuyItemDAO;
import ecsite.dto.BuyItemDTO;


public class HomeAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute() {

		String result = "login";

		if(session.containsKey("id")) {

			BuyItemDAO buyItemDAO = new BuyItemDAO();

			List<BuyItemDTO> buyItemDTOList = buyItemDAO.getItemInfo();
			session.put("buyItemDTOList", buyItemDTOList);

			result = SUCCESS;
		}

		return result;
	}


	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
