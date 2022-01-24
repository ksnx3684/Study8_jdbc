package com.ksnx3684.s1.location;

import java.util.List;
import java.util.Scanner;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new Scanner(System.in);
	}
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 지역 리스트 출력");
			System.out.println("2. 지역 리스트 검색");
			System.out.println("3. 메인 메뉴로 가기");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				List<LocationDTO> ar = locationDAO.getList();
				locationView.view(ar);
				break;
			case 2:
				System.out.println("검색할 지역의 번호를 입력하시오");
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(sc.nextInt());
				locationDTO = locationDAO.getOne(locationDTO);
				if(locationDTO != null)
					locationView.view(locationDTO);
				else
					System.out.println("해당 번호의 지역번호가 없습니다");
				break;
			default :
				flag = false;
			
			}
		}
		
	}
	
}
