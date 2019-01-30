package ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dao.BuyItemCompleteDAO;
import ecsite.dto.BuyItemDTO;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;

	public String execute() {


		String result = SUCCESS;
		BuyItemCompleteDAO dao = new BuyItemCompleteDAO();


		for(int j=0; j<=(((List<BuyItemDTO>)(session.get("buyItemDTOList"))).size()-1); j++) {

			if(((List<Integer>)(session.get("stockList"))).get(j) != 0) {

				// 購入を選択された商品の情報を、user_buy_item_transactionに登録する
				int item_total_price = (((List<BuyItemDTO>)(session.get("buyItemDTOList"))).get(j).getItemPrice())*(((List<Integer>)(session.get("stockList"))).get(j));

				int res = dao.setBuyItemHistory(
					((List<BuyItemDTO>)(session.get("buyItemDTOList"))).get(j).getItemId(),
					item_total_price,
					((List<Integer>)(session.get("stockList"))).get(j),
					session.get("id").toString(),
					session.get("payment").toString()
				);


				// 購入を選択された商品の在庫(stock)を更新する
				int re2 = dao.updateStock(((List<BuyItemDTO>)(session.get("buyItemDTOList"))).get(j).getItemId(), ((List<Integer>)(session.get("stockList"))).get(j));

			}

		}

		return result;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
