package com.ksnx3684.s1.start;

import java.util.Scanner;
import com.ksnx3684.s1.department.DepartmentController;
import com.ksnx3684.s1.employee.EmployeeController;
import com.ksnx3684.s1.location.LocationController;
import com.ksnx3684.s1.region.RegionController;
public class FrontController {
	
	private Scanner sc;
	private DepartmentController departMemtController;
	private LocationController locationController;
	private EmployeeController employeeController;
	private RegionController regionController;
	
	public FrontController() {
		sc = new Scanner(System.in);
		departMemtController = new DepartmentController();
		locationController = new LocationController();
		employeeController = new EmployeeController();
		regionController = new RegionController();
	}
	
	public void mainStart() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원 관리");
			System.out.println("2. 부서 관리");
			System.out.println("3. 지역 관리");
			System.out.println("4. 대륙 관리");
			System.out.println("5. 종 료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				employeeController.start();
				break;
			case 2:
				departMemtController.start();
				break;
			case 3:
				locationController.start();
				break;
			case 4:
				regionController.start();
				break;
			default :
				flag = false;
			}
		}
	}
	
}
