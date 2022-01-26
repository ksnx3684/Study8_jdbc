package com.ksnx3684.s1.department;

import java.util.Scanner;

public class DepartmentInput {

	private Scanner sc;
	
	public DepartmentInput() {
		sc = new Scanner(System.in);
	}
	
	public DepartmentDTO setDelete() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("삭제할 부서의 ID를 입력하시오");
		departmentDTO.setDepartment_id(sc.nextInt());
		
		return departmentDTO;
	}
	
	public DepartmentDTO setInsert() {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		System.out.println("추가할 부서의 ID를 입력하시오");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.println("추가할 부서의 Name을 입력하시오");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("추가할 부서의 Manager ID를 입력하시오");
		departmentDTO.setManager_id(sc.nextInt());
		System.out.println("추가할 부서의 Location ID을 입력하시오");
		departmentDTO.setLocation_id(sc.nextInt());
		
		return departmentDTO;
	}
}
