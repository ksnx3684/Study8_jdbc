package com.ksnx3684.s1.start;

import java.util.List;

///import com.ksnx3684.s1.department.DepartmentDAO;
///import com.ksnx3684.s1.department.DepartmentDTO;
///import com.ksnx3684.s1.department.DepartmentView;
import com.ksnx3684.s1.location.LocationDAO;
import com.ksnx3684.s1.location.LocationDTO;
import com.ksnx3684.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args){
		System.out.println("DB 연동 테스트 시작");
		
//		DBConnector dbConnector = new DBConnector();
//		try {
//			dbConnector.getConnect();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		DepartmentDAO departmentDAO = new DepartmentDAO();
//		DepartmentView departmentView = new DepartmentView();
//		try {
//			List<DepartmentDTO> ar = departmentDAO.getList();
//			//departmentDAO.getList();
//			departmentView.view(ar);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		try {
			List<LocationDTO> ar = locationDAO.getList();
			locationView.view(ar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("DB 연동 테스트 종료");

	}

}
