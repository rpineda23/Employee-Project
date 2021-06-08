package emp;

public class Employee extends Address {
	public int empNum;
	public String empName;
	public double salary;
	public Address address;
	
	public Employee(int empNum, String empName, double salary, Address address) {
		super(address.getCity(), address.getState());
		this.empNum = empNum;
		this.empName = empName;
		this.salary = salary;
		this.address = address;
	}
	
	public int getEmpNum() {
		return empNum;
	}
	public void setEmpNum(int empNum) {
		this.empNum = empNum;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [empNum=" + empNum + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ "]";
	}
}
