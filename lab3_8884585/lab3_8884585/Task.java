
public class Task {
	private int priority;
	private int time;
	
	public Task(int priority, int time) {
		this.priority= priority;
		this.time = time;
	}
	
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
}
