package emp;

public interface EmployeeService {
	public void displayAllEmployees();
	public double calculateYearlySalary(Employee emp1);
	public Employee findByEmployeeNum(int empNum);
	public void updateEmployee(Employee emp1);
	public void deleteEmployee(Employee emp1);
	
}
