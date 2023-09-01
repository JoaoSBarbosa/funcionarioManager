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
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			employees.add(new Employee(id,name,salary));
			
		}
		System.out.println();
		for(Employee x: employees) {
			System.out.printf("ID: %d%nName: %s%nSalary: %.2f%n", x.getId(), x.getName(), x.getSalary());
			System.out.println();
		}
		
		sc.close();
	}

}
