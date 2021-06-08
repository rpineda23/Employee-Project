package emp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.Scanner;

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
		/*for(Employee emplist: list) {
			if(empNum == emplist.getEmpNum()) {
				return emplist;
			}
		}
		return null;*/
		ArrayList<Employee> temp =(ArrayList<Employee>)list.
				stream().filter(w ->w.getEmpNum() == empNum).collect(Collectors.toList());
				if(temp.isEmpty()) {
					return null;
				}else {
					return temp.get(0);
				}
	}
	
	public void updateEmployee(Employee emp1) {
		/*for(Employee emplist: list) {
			if(emp1.getEmpName().equals(emplist.getEmpName())) {
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Which employee detail would you like to modify?");
				System.out.println("1. Employee Name.");
				System.out.println("2. Employee Number.");
				System.out.println("3. Employee Address.");
				System.out.println("4. Employee Salary.");
				int i = scan.nextInt();
				switch(i) {
				case 1:
					System.out.println("What is the new name?");
					String name = scan.nextLine();
					emplist.setEmpName(name);
					scan.close();
					break;
				case 2: 
					System.out.println("What is the new number?");
					int number = scan.nextInt();
					emplist.setEmpNum(number);
					scan.close();
					break;
				case 3: 
					System.out.println("What is the new address?");
					String add = scan.nextLine();
					emplist.setCity(add);//
					scan.close();
					break;
				case 4: 
					System.out.println("What is the new salary?");
					double salary = scan.nextDouble();
					emplist.setSalary(salary);
					scan.close();
					break;
				default:
					scan.close();
					break;
				}
			}
		}	*/
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
