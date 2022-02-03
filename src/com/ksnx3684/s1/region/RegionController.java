package com.ksnx3684.s1.region;

import java.util.List;
import java.util.Scanner;

public class RegionController {

	private RegionInput regionInput;
	private RegionDAO regionDAO;
	private RegionView regionView;
	private Scanner sc;
	
	public RegionController() {
		regionInput = new RegionInput();
		regionDAO = new RegionDAO();
		regionView = new RegionView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. Region 리스트 출력");
			System.out.println("2. Region 검색");
			System.out.println("3. Region 추가");
			System.out.println("4. Region 삭제");
			System.out.println("5. Region 수정");
			System.out.println("6. 메인 메뉴로 가기");
			int select = sc.nextInt();
			// RegionDTO regionDTO = null;
			int result = 0;
			String message = null;
			switch(select) {
			case 1:
				List<RegionDTO> ar = regionDAO.getList();
				regionView.view(ar);
				break;
			case 2:
				System.out.println("검색할 번호를 입력하시오");
				RegionDTO regionDTO = new RegionDTO();
				regionDTO.setRegion_id(sc.nextLong());
				regionDTO = regionDAO.getOne(regionDTO);
				if(regionDTO != null)
					regionView.view(regionDTO);
				else
					System.out.println("해당 번호의 지역이 없습니다");
				break;
			case 3:
				regionDTO = regionInput.setInsert();
				result = regionDAO.setInsert(regionDTO);
				message = "Insert Fail";
				if(result > 0) {
					message = "Insert Success";
				}
				regionView.view(message);
				break;
			case 4:
				regionDTO = regionInput.setDelete();
				result = regionDAO.setDelete(regionDTO);
				message = "Delete Fail";
				if(result > 0)
					message = "Delete Success";
				regionView.view(message);
				break;
			case 5:
				regionDTO = regionInput.setInsert();
				result = regionDAO.setUpdate(regionDTO);
				message = "Update Fail";
				if(result > 0)
					message = "Update Success";
				regionView.view(message);
				break;
			default:
				flag = false;
			}
			
		}
		
	}
}
