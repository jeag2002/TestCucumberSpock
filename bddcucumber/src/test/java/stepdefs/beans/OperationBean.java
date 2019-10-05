package stepdefs.beans;

public class OperationBean {
	

	private Integer first;
	private Integer second;
	private String operation;
	
	public OperationBean() {
		first = 0;
		second = 0;
		operation = "";
	}
	
	public OperationBean(Integer _First, Integer _Second, String _Operation) {
		super();
		this.first = _First;
		this.second = _Second;
		this.operation = _Operation;
	}
	
	
	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public Integer getSecond() {
		return second;
	}

	public void setSecond(Integer second) {
		this.second = second;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}


	
	

	
	

}
