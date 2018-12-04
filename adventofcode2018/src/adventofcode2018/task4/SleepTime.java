package adventofcode2018.task4;

import java.util.Date;

public class SleepTime {
	private Date start;
	private Date stop;

	public SleepTime() {
		super();
	}

	public SleepTime(Date start, Date stop) {
		super();
		this.start = start;
		this.stop = stop;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	@Override
	public String toString() {
		return "SleepTime [start=" + start + ", stop=" + stop + "]";
	}

}
