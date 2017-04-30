package ayush.practice.retrofitwithdagger_mvp1.gui.model;

public class EmployeeDataItem{
	private String authKey;
	private String employeeId;

	public void setAuthKey(String authKey){
		this.authKey = authKey;
	}

	public String getAuthKey(){
		return authKey;
	}

	public void setEmployeeId(String employeeId){
		this.employeeId = employeeId;
	}

	public String getEmployeeId(){
		return employeeId;
	}

	@Override
 	public String toString(){
		return 
			"EmployeeDataItem{" + 
			"authKey = '" + authKey + '\'' + 
			",employee_id = '" + employeeId + '\'' + 
			"}";
		}
}
