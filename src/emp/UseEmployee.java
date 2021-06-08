package emp;
import java.util.Scanner;

//import EmployeeServiceImpl;

public class UseEmployee {
	public static void main(String[] args) {
		//Create employeeserviceiple object to call implemented method
		//create menu choice
		//1. list imployee call displayAll Employee()
			//2. display salaray 
		//3. display specific emplyee details
			//4. modify employee details 
		EmployeeServiceImpl solution = new EmployeeServiceImpl();
		Scanner scan = new Scanner(System.in);
		boolean running = true;
		while(running) {
			printMain();
			int select = scan.nextInt();
			switch(select) {
			case 0:
				running = false;
				break;
			case 1:
				System.out.println("Here is the list of all employees.\n");
				solution.displayAllEmployees();
				break;
			case 2:
				System.out.println("Enter number of employee please: ");
				int num = scan.nextInt();
				Employee temp = solution.list.stream()
	                    .filter( emp -> emp.getEmpNum() == num)
	                    .findFirst()
	                    .orElse(null);
				System.out.println("Employee Salary for " + solution.findByEmployeeNum(num).empName 
						+ " yearly is:"  +solution.calculateYearlySalary(temp));
				break;
			case 3:
				System.out.println("Enter number of employee please: "); 
				num = scan.nextInt();
				System.out.println("Employee name: " + solution.findByEmployeeNum(num).empName + ", Employee a4ddress: "
						+ solution.findByEmployeeNum(num).getCity() + ", " + 
						solution.findByEmployeeNum(num).getState());
				 break;
			case 4:
				System.out.println("Enter number of employee please: "); 
				num = scan.nextInt();
				scan.nextLine();
				
				System.out.println("New Employee Name: "); 
				String name = scan.nextLine();
				
				System.out.println("New Employee Salary: "); 
				double salary = scan.nextDouble();
				scan.nextLine();
				
				System.out.println("New Address for City: "); 
				String city = scan.nextLine();
				
				System.out.println("New Address for Sate: "); 
				String state = scan.nextLine();

				solution.updateEmployee(new Employee(num,name,salary,new Address(city,state)));
				break;
			case 5:
				System.out.println("Enter number of employee please: "); 
				num = scan.nextInt();
				Employee temp1 = solution.list.stream()
	                    .filter( emp -> emp.getEmpNum() == num)
	                    .findFirst()
	                    .orElse(null);
				solution.deleteEmployee(temp1);
				System.out.println("Employee List updated: ");
				solution.displayAllEmployees();
				break;
			}
		}
		scan.close();
	}
	
	public static void printMain() {
		System.out.println("\nWelcome to your Employee Management....");
		System.out.println("1. List all employees.");
		System.out.println("2. Display Yearly Salary.");
		System.out.println("3. Display specific employee details.");
		System.out.println("4. Modify employee details.");
		System.out.println("5. Delete one of the employees.");
	}
}