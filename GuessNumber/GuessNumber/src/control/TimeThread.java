package control;

import javax.swing.JLabel;

public class TimeThread extends Thread {
	long timer;
	long beginTime;
	String time;
	JLabel com;
	boolean state;

	public long getTimer() {
		return timer;
	}

	public void setTimer(long timer) {
		this.timer = timer;
	}
	
	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public JLabel getCom() {
		return com;
	}

	public void setCom(JLabel com) {
		this.com = com;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public TimeThread(){
		timer = 0;
		state = false;
	}
	public TimeThread(long t){
		timer = t;
		state = false;
	}
	
	public void run() {
		beginTime = System.currentTimeMillis();
		timer = 0;
		while (state) {
			if(timer == 3600)
				timer = 0;
			time = timer/60+ ":" +timer%60;
			com.setText("" + time);
			try {
				sleep(1000);
				timer++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("time stop!");
	}

}
