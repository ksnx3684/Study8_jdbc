package com.ksnx3684.s1.region;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksnx3684.s1.util.DBConnector;

public class RegionDAO {

	private DBConnector dbConnector;
	
	public RegionDAO() {
		dbConnector = new DBConnector();	
	}
	// 전체 조회
	public List<RegionDTO> getList() throws Exception {
		ArrayList<RegionDTO> ar = new ArrayList<>();
		
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT * FROM REGIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getLong("region_id"));
			regionDTO.setRegion_name(rs.getString("region_name"));
			ar.add(regionDTO);
		}
		return ar;
	}
	// 검색 후 조회
	public RegionDTO getOne(RegionDTO reg) throws Exception {
		RegionDTO regionDTO = null;
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT * FROM REGIONS WHERE REGION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, reg.getRegion_id());
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			regionDTO = new RegionDTO();
			regionDTO.setRegion_id(rs.getLong("region_id"));
			regionDTO.setRegion_name(rs.getString("region_name"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return regionDTO;
	}
	
	// 대륙 정보 수정
	public int setUpdate(RegionDTO regionDTO) throws Exception {
		int result = 0;
		Connection con = dbConnector.getConnect();
		
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	// 대륙 정보 삭제
	public int setDelete(RegionDTO regionDTO) throws Exception {
		int result = 0;
		// 1. DB 연결
		Connection con = dbConnector.getConnect();
				
		// Java는 기본으로 auto commit이 실행 되며, rollback을 해도 데이터가 복구되지 않는다.
		//con.setAutoCommit(false); // auto commit 해제
			
		// 2. SQL 쿼리문 생성
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 세팅
		st.setLong(1, regionDTO.getRegion_id());
		// 5. 최종 전송 후 결과 처리
		result = st.executeUpdate(); // 조회와는 다르게 데이터 추가나 업데이트 시 결과값이 0 또는 정수형이 반환된다.
			
		// 자원 해제 전 auto commit으로 재설정
		//con.setAutoCommit(true);
			
		// 6. 자원 해제
		st.close();
		con.close();
				
		return result;
	}
	
	// 대륙 정보 추가
	public int setInsert(RegionDTO regionDTO) throws Exception {
		int result = 0;
		// 1. DB 연결
		Connection con = dbConnector.getConnect();
		
		// Java는 기본으로 auto commit이 실행 되며, rollback을 해도 데이터가 복구되지 않는다.
		//con.setAutoCommit(false); // auto commit 해제
		
		// 2. SQL 쿼리문 생성
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES(?, ?)";
		// 3. 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 세팅
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		// 5. 최종 전송 후 결과 처리
		result = st.executeUpdate(); // 조회와는 다르게 데이터 추가나 업데이트 시 결과값이 0 또는 정수형이 반환된다.
		
		// 자원 해제 전 auto commit으로 재설정
		//con.setAutoCommit(true);
		
		// 6. 자원 해제
		st.close();
		con.close();
		
		return result;
	}
	
	
	// 검색 조회
	
	// 전체 조회
}
