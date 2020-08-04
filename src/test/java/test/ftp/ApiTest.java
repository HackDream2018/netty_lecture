package test.ftp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ApiTest {
	public static void main(String[] args) throws Exception {
		String str = "20200603";
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date parse = format.parse(str);

		Date currentDate = DateUtils.addDate(parse, +1);


		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		String format1 = format2.format(parse);

	}

}
