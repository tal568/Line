package def;

public class List<T>  {
 	private T value;
	private List<T> next;
	
	public List()
	{
		this.value=null;
		this.next=null;
	}
	public List(T value)
	{
		
		this.value=value;
		this.next=null;
	}

	public T GetValue() {
		return value;
	}

	public void SetValue(T value) {
		this.value = value;
	}

	public List<T> GetNext() {
		return next;
	}

	public void SetNext(List<T> next) {
		this.next = next;
	}
	
}
