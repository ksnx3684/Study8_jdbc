package com.ksnx3684.s1.department;

import java.util.List;
import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentInput departmentInput;
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		departmentInput = new DepartmentInput();
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
	}

	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 부서 추가");
			System.out.println("4. 부서 삭제");
			System.out.println("5. 메인 메뉴로 가기");
			int select = sc.nextInt();
			
			int result = 0;
			String message = null;
			
			switch(select) {
			case 1:
				List<DepartmentDTO> ar = departmentDAO.getList();
				departmentView.view(ar);
				break;
			case 2:
				System.out.println("검색할 부서 번호를 입력하시오");
				DepartmentDTO departmentDTO= new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				if(departmentDTO != null)
					departmentView.view(departmentDTO);
				else
					System.out.println("없는 번호입니다");
				break;
			case 3:
				DepartmentDTO departmentDTO2 = departmentInput.setInsert();
				result = departmentDAO.setInsert(departmentDTO2);
				message = "Insert Fail";
				if(result > 0)
					message = "Insert Success";
				departmentView.view(message);
				break;
			case 4:
				DepartmentDTO departmentDTO3 = departmentInput.setDelete();
				result = departmentDAO.setDelete(departmentDTO3);
				message = "Delete Fail";
				if(result > 0)
					message = "Delete Success";
				departmentView.view(message);
				break;
			default :
				flag = false;
				
			}
		}
	}
}
