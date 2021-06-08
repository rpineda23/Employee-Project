package emp;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService{
	ArrayList<Employee> list = new ArrayList<Employee>() {
		{	
			add(new Employee(1,"Pedro",1000,new Address("El Paso","Tx")));
			add(new Employee(2,"Stella",2000,new Address("Austin","Tx")));
			add(new Employee(3,"Nancy",4000,new Address("Houston","Tx")));
			add(new Employee(4,"West",500,new Address("San Antonio","Tx")));
		}
	};
	
	public void displayAllEmployees() {
		list.stream().forEach(System.out::println);
	}
	
	public double calculateYearlySalary(Employee emp1) {
		double yearly = emp1.getSalary();
		yearly = yearly * 12;
		return yearly;
	}
	
	public Employee findByEmployeeNum(int empNum) {
		ArrayList<Employee> temp =(ArrayList<Employee>)list.
				stream().filter(w ->w.getEmpNum() == empNum).collect(Collectors.toList());
				if(temp.isEmpty()){
					return null;
				}
				else{
					return temp.get(0);
				}
	}
	
	public void updateEmployee(Employee emp1) {
		Employee select = list.stream().filter(var->var.getEmpNum() == emp1.getEmpNum())
				.findFirst().orElse(null);
			select.setEmpName(emp1.getEmpName());
			select.setSalary(emp1.getSalary());
			select.setAddress(emp1.getAddress());

	}
	
	public void deleteEmployee(Employee emp1) {
		list.remove(emp1);
	}
}
