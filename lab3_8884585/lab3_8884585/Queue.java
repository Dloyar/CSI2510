import java.util.LinkedList;
public class Queue {
	private LinkedList<Task> tasks;
	
	public Queue() {
		this.tasks = new LinkedList<Task>();
	}
	
	public void add(Task task) {
		this.tasks.addLast(task);
	}
	public boolean isEmpty() {
		return tasks.isEmpty();
	}
	
	public Task remove() {
		if(!isEmpty()) {
		 return tasks.removeFirst();
		}
		throw new EmptyQueueException("La liste est vide");
	}
}
