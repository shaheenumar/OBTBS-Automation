package masterBeans;

public class state {
	String stateName,stateCode;
	
	
	
	public state(String stateCode,String stateName){
		this.stateName = stateName;
		this.stateCode =stateCode;
		
	}
	

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	

}
