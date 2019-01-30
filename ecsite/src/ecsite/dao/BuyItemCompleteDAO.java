package ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecsite.util.DBConnector;
import ecsite.util.DateUtil;

public class BuyItemCompleteDAO {


	public int setBuyItemHistory(int item_transaction_id,int total_price,int total_count,String user_master_id,String payment) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		DateUtil date = new DateUtil();
		String sql="insert into user_buy_item_transaction(item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) values(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, item_transaction_id);
				ps.setInt(2, total_price);
				ps.setInt(3, total_count);
				ps.setString(4, user_master_id);
				ps.setString(5, payment);
				ps.setString(6, date.getDate());
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public int updateStock(int item_transaction_id, int total_count) {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int result = 0;
		DateUtil date = new DateUtil();
		String sql = "UPDATE item_info_transaction SET item_stock=item_stock-?, update_date=? WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, total_count);
				ps.setString(2, date.getDate());
				ps.setInt(3, item_transaction_id);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
