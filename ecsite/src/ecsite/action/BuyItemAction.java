package ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import ecsite.dto.BuyItemDTO;


public class BuyItemAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private int[] stock;
	private String pay;
	private String errorMessage;

	public String execute() {

		// 商品情報が１つだけの場合 ver.1
		/*int intStock = Integer.parseInt(stock);
		session.put("totalStock", intStock);

		List<BuyItemDTO> dtoList = (List<BuyItemDTO>)(session.get("buyItemDTOList"));
		int intPrice = dtoList.get(0).getItemPrice();

		session.put("totalPrice", intStock*intPrice);*/



		//購入個数が全て0であった場合result=ERROR&errorMessageを返すようにする
		int flg = 0;
		for(int stk : stock) {
			if(stk==0) {
				flg ++;
			}
		}

		if(flg==stock.length) {
		errorMessage = "購入個数を必ず１つ以上指定してください";
		return ERROR;
		}


		// 以下購入商品確認画面へ遷移するための準備処理
		int totalPrice = 0;

		for(int i=0;i<=(((List<BuyItemDTO>)(session.get("buyItemDTOList"))).size()-1);i++) {

			int price = ((List<BuyItemDTO>)(session.get("buyItemDTOList"))).get(i).getItemPrice();
			int num = stock[i];
			/*int num = Integer.parseInt(stock[i]);*/

			totalPrice += price*num;
		}

		session.put("totalPrice", totalPrice);


		// stock[]をListに変換してsessionにput
		List<Integer> stockList = new ArrayList<Integer>();
			for(int j=0; j<=((stock.length)-1); j++) {
				stockList.add(stock[j]);
			}
		session.put("stockList", stockList);


		if(pay.equals("1")) {
			session.put("payment", "現金払い");
		}else if(pay.equals("2")) {
			session.put("payment", "クレジットカード");
		}

		return SUCCESS;

	}


	public int[] getStock() {
		return stock;
	}
	public void setStock(int[] stock) {
		this.stock = stock;
	}

	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}
}
