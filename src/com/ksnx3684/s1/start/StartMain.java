package com.ksnx3684.s1.start;

//import com.ksnx3684.s1.region.RegionController;
//import com.ksnx3684.s1.region.RegionDAO;
//import com.ksnx3684.s1.region.RegionDTO;
//import java.util.List;
//import com.ksnx3684.s1.department.DepartmentController;
//import com.ksnx3684.s1.department.DepartmentDAO;
//import com.ksnx3684.s1.department.DepartmentDTO;
//import com.ksnx3684.s1.department.DepartmentView;
//import com.ksnx3684.s1.location.LocationDAO;
//import com.ksnx3684.s1.location.LocationDTO;
//import com.ksnx3684.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args){
		System.out.println("DB 연동 테스트 시작");
		
		FrontController frontController = new FrontController();
		
		try {
			frontController.mainStart();
			
			
			
//			---------------------------------------------------
//			RegionDAO regionDAO = new RegionDAO();
//			RegionDTO regionDTO = new RegionDTO();
//			regionDTO.setRegion_id(6L); // 추가, 삭제, 수정 구문
//			regionDTO.setRegion_name("South Pole"); // 추가, 수정 구문
//			int result = regionDAO.setInsert(regionDTO); // 추가 구문
//			int result = regionDAO.setDelete(regionDTO); // 삭제 구문
//			int result = regionDAO.setUpdate(regionDTO); // 수정 구문
			
//			if(result > 0)
//				System.out.println("성공");
//			else
//				System.out.println("실패");
//			---------------------------------------------------	
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
//		------- Connector test -------
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
//			departmentView.view(ar);
//			DepartmentDTO departmentDTO = departmentDAO.getOne(20);
//			DepartmentDTO departmentDTO = new DepartmentDTO();
			//departmentDTO.setDepartment_id(20);
			//departmentDTO = departmentDAO.getOne(departmentDTO);
			//System.out.println(departmentDTO.getDepartment_name());
//			DepartmentController departmentController = new DepartmentController();
//			departmentController.start();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		
//		------- Location -------
//		LocationDAO locationDAO = new LocationDAO();
//		LocationView locationView = new LocationView();
//		try {
//			List<LocationDTO> ar = locationDAO.getList();
//			locationView.view(ar);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		System.out.println("DB 연동 테스트 종료");

	}

}
