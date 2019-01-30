package ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecsite.dto.BuyItemDTO;
import ecsite.util.DBConnector;



public class BuyItemDAO {


	public List<BuyItemDTO> getItemInfo(){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
		String sql = "select * from item_info_transaction";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();


			while(rs.next()) {

				BuyItemDTO dto = new BuyItemDTO();
				dto.setItemId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));
				dto.setItemStock(rs.getInt("item_stock"));
				buyItemDTOList.add(dto);

				/*System.out.println(dto.getItemName());
				System.out.println(dto.getItemPrice());
				System.out.println(dto.getItemStock());*/

			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}


		return buyItemDTOList;
	}

}
