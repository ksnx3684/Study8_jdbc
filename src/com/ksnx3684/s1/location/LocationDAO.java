package com.ksnx3684.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.ksnx3684.s1.util.DBConnector;

public class LocationDAO {
	
	private DBConnector dbconnector; // 멤버변수 선언
	
	public LocationDAO() { // 생성자에서 멤버변수의 객체를 생성
		dbconnector = new DBConnector();
	}

	public LocationDTO getOne(LocationDTO loc) throws Exception {
		// 부분 검색
		LocationDTO locationDTO = null;
		Connection con = dbconnector.getConnect();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, loc.getLocation_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getNString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
		}
		rs.close();
		st.close();
		con.close();
		
		return locationDTO;
	}
	public List<LocationDTO> getList() throws Exception {
		// 전체 검색
		// 1. DB에 로그인
		// 2. SQL Query문 작성
		// 3. Query문 미리 전송
		// 4. ? 세팅은 통과
		// 5. 최종 전송 후 결과 처리 코드 작성
		// 6. 자원 해제
		ArrayList<LocationDTO> ar = new ArrayList<>();
		Connection con = dbconnector.getConnect();
			
		String sql = "SELECT * FROM LOCATIONS";
			
		PreparedStatement st = con.prepareStatement(sql);
			
		ResultSet rs = st.executeQuery();
			
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO(); // DB상에서의 하나의 row가 자바상에서는 하나의 DTO에 해당한다. 
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			ar.add(locationDTO);
		}
		
		rs.close();
		st.close();
		con.close();
			
		return ar;

	}
}
