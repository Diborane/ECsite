package ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecsite.dto.MyPageDTO;
import ecsite.util.DBConnector;

public class MyPageDAO {

	public List<MyPageDTO> getBuyHistory(String loginUserId){

	DBConnector db = new DBConnector();
	Connection con = db.getConnection();
	List<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();
	String sql = "SELECT iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id=iit.id WHERE user_master_id=? ORDER BY ubit.insert_date DESC";

	try {
		PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			MyPageDTO dto = new MyPageDTO();
				dto.setBuyItemName(rs.getString("item_name"));
				dto.setBuyTotalPrice(rs.getInt("total_price"));
				dto.setBuyTotalCount(rs.getInt("total_count"));
				dto.setPayment(rs.getString("pay"));
				dto.setInsertDate(rs.getString("insert_date"));
			myPageDTOList.add(dto);
		}

	}catch(SQLException e) {
		e.printStackTrace();
	}


	try {
		con.close();
	}catch(SQLException e) {
		e.printStackTrace();
	}

	return myPageDTOList;
	}

	public int deleteHistory(String loginUserId) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from user_buy_item_transaction where user_master_id=?";
		int result = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, loginUserId);
			result = ps.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}

		try{
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}


		return result;
	}

}
