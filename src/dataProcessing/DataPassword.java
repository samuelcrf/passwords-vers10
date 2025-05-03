package dataProcessing;

import java.text.SimpleDateFormat;
import java.util.Date;

public class dataPassword{

	private int line;
	private String password;
	private int length;
	private Date date;
	private Date yearMonth;
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public DataPassword(int line, String password, int length, Date date, Date yearMonth) {
		this.line = line;
		this.password = password;
		this.length = length;
		this.date = date;
		this.yearMonth = yearMonth;
	}
	
	public int getLine() {
		return line;
	}

	public String getPassword() {
		return password;
	}

	public int getLength() {
		return length;
	}

	public Date getDate() {
		return date;
	}

	public Date getYearMonth() {
		return yearMonth;
	}

	@Override
	public String toString() {
		return getLine() + "," + getPassword() + "," + getLength() + "," + sdf.format(getDate());
	}
	
	
	
}
