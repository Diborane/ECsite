package ecsite.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public String getDate() {

		//現在日時をlong型で取得
		Date date = new Date();

		//日時表示のフォーマットを指定
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

		//long型の日時を、指定した書式に変換
		String s = f.format(date);

		return s;
	}

}
