package com.ksnx3684.s1.department;

import java.util.List;

public class DepartmentView {
	
	public void view(String message) {
		System.out.println("--------------------");
		System.out.println("Message : " + message);
		System.out.println("--------------------");
	}
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.print(departmentDTO.getDepartment_id()+"\t");
		System.out.print(departmentDTO.getDepartment_name()+"\t");
		System.out.print(departmentDTO.getManager_id()+"\t");
		System.out.println(departmentDTO.getLocation_id());
		System.out.println("--------------------------------------------------");
	}

	public void view(List<DepartmentDTO> ar) {
		// 모두 출력
		for(int i = 0; i < ar.size(); i++) {
			this.view(ar.get(i));
		}
	}
	
}
