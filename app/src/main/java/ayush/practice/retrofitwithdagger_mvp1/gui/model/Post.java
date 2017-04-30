package ayush.practice.retrofitwithdagger_mvp1.gui.model;

import java.util.List;

public class Post{
	private int code;
	private String response;
	private List<EmployeeDataItem> employeeData;
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setResponse(String response){
		this.response = response;
	}

	public String getResponse(){
		return response;
	}

	public void setEmployeeData(List<EmployeeDataItem> employeeData){
		this.employeeData = employeeData;
	}

	public List<EmployeeDataItem> getEmployeeData(){
		return employeeData;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Post{" + 
			"code = '" + code + '\'' + 
			",response = '" + response + '\'' + 
			",employeeData = '" + employeeData + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}