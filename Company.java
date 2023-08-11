class Employee{
	private String empNo;
	private String empName;
	private double salary;
	
	Employee(String empNo,String empName,double salary){
			this.empNo=empNo;
			this.empName=empName;
			this.salary=salary;
	}
	
		double getSalary(){
				return salary;
		}
		String getEmpNo(){
				return empNo;
		}
		String getEmpName(){
				return empName;
		}
		double calBonus(){
				return salary*5/100;
		}
		double grossSalary(){
				return salary+calBonus();
		}
}
class Manager extends Employee{
		Manager(String empNo,String empName,double salary){
			super(empNo,empName,salary);	
		}
		
	@Override
		double calBonus(){
				return getSalary()*20/100;
		}
		double calTax(){
				double tax;
				tax=getSalary()*15/100;
				return tax;
		}
		double calGrossSalary(){
			double cal;
			cal=getSalary()+calBonus()-calTax();
				return cal;
		}
}
class Clerk extends Employee{
	private String category;
	Clerk(String empNo,String empName,double salary,String category){
		super(empNo,empName,salary);
		this.category=category;
	}
	@Override
		double calBonus(){
				return getSalary()*10/100;
		}
		double calGrossSalary(){
				return getSalary()+calBonus();
		}
		String getCategory(){
				return category;
		}
}
public class Company{
		public static void main(String[]args){
			Manager m1=new Manager("M001","Amila",90000.00);
			System.out.println("Bonus of manager"+m1.calBonus());
			Clerk c1=new Clerk("C001","ASDF",20000.00,"Grade 1");
			System.out.println("grosspay of clerk"+c1.calGrossSalary());
		}
}