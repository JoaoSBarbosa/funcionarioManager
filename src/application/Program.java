package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n;
		List<Employee> employees = new ArrayList<>();
		
		System.out.print("How many employees will be registered? ");
		n=sc.nextInt();
		
		for(int i =0; i < n; i++) {
			System.out.println();
			
			System.out.printf("Employee #%d: %n",i+1);
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while(hasId(employees,id)) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			employees.add(new Employee(id,name,salary));
			
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int searchId = sc.nextInt();
		
		Employee emp = employees.stream().filter(x -> x.getId() == searchId).findFirst().orElse(null);
		
		if(emp == null) {
			System.out.println("This is does not exist!");
		}else {
			System.out.print("Enter the percentage: ");
			Double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}
		System.out.println();
		System.out.println("List of employees: ");
		for(Employee ep : employees) {
			System.out.println(ep);
		}
		
		sc.close();
	}
	
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}

}
