
public class PriorityQueue {

	private Queue max;
	private Queue med;
	private Queue low;
	
	public PriorityQueue() {
		this.max = new Queue();
		this.med = new Queue();
		this.low = new Queue();
	}
	
	public void initFromTasks(Queue tasks) {
		Task task;
		
		while(!tasks.isEmpty()) {
			task = tasks.remove();
			
			switch(task.getPriority()) {
				case 0:{
					this.max.add(task);
				}
				break;
				case 1:{
					this.med.add(task);
				}
				break;
				case 2:{
					this.low.add(task);
				}
				break;
			}
		}
		
	}
	
	public boolean isEmpty() {
		return this.max.isEmpty() && this.med.isEmpty() && this.low.isEmpty();
	}
	
	
	public Task getTask() {
		Task task;
		
		if(!this.max.isEmpty()) {
			task = this.max.remove();
			}else if(!this.med.isEmpty()) {
				task = this.med.remove();
			}else if(!this.low.isEmpty()) {
				task = this.low.remove();
			}else {
				throw new EmptyQueueException("La liste de priorite est vide.");
			}
		return task;
		
	}
	
}
