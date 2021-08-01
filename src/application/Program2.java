package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
	
	public static void  main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 1: Department findById ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: Department findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: Department insert ===");
		Department newDepartment = new Department(null, "music");
		departmentDao.insert(newDepartment);
		System.out.println("Departmnet inserted! new Id = " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: Department update ===");
		
		department = departmentDao.findById(1);
		department.setName("Trip");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n=== TEST 5: Department delete ===");
		System.out.println("Enter id department for delete");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
		DB.closeConnection();
	}

}
