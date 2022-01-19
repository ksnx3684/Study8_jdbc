package com.ksnx3684.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ksnx3684.s1.util.DBConnector;

public class DepartmentDAO {
	// DAO : Data Access Object
	private DBConnector dbConnector; // DAO에서만 access 하므로 private으로 선언
	
	public DepartmentDAO() { // 생성자
		dbConnector = new DBConnector(); // 객체 생성
	}
	
	public List<DepartmentDTO> getList() throws Exception {
		ArrayList<DepartmentDTO> ar = new ArrayList<>(); // DepartmentDTO타입의 데이터를 담을 어레이리스트 객체 생성
		
		// SELECT * FROM DEPARTMENTS;
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		
		// 2. SQL Query문 작성
		// Java에서는 ; 을 빼준다.
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 3. 작성한 SQL Query문을 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ? 의 값을 세팅, 없으면 통과
		
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery(); // rs에 Data를 집어넣어 최종 Query문 실행
		
		// DB상에서 Cursur가 한 줄씩 읽으면서 메서드 rs.next()가 실행된다. 리턴은 데이터가 있으면 true, 더 이상 읽을 데이터가 없으면 false를 반환한다.
		while(rs.next()) { // DepartmentView에서 꺼내오기만 한다. 출력은 view에서 한다.
			DepartmentDTO departmentDTO = new DepartmentDTO(); // DTO 객체 생성
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			
			ar.add(departmentDTO); // 어레이리스트 ar에 departmentDTO 담기 
		}
		
		// 6. 외부 연결 자원 해제
		// 연결된 순서의 역순으로 해제해준다.
		rs.close();
		st.close();
		con.close();
		
		return ar; // ar 리턴
		
	}
	
	
}
