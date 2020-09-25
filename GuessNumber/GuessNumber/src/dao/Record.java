package dao;

public class Record {
	private String mode;
	private String time;
	private String name;
	
	public Record(){
		
	}
	public Record(String m,String t,String n){
		mode = m;
		time = t;
		name = n;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
