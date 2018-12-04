package adventofcode2018.task4;

import java.util.Date;

public class PieceOfScheduler implements Comparable<PieceOfScheduler> {
	private Date date;
	private String message;

	public PieceOfScheduler(Date date, String message) {
		super();
		this.date = date;
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OnePieceOfScheduler [date=" + date + ", message=" + message + "]";
	}

	@Override
	public int compareTo(PieceOfScheduler o) {
		if (getDate() == null || o.getDate() == null) {
			return 0;
		}
		return getDate().compareTo(o.getDate());
	}

}
