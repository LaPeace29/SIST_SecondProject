package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.InstructorPossible;

public class InstructorPossibleDAO {

	// 강의 가능 과목 추가 메소드
	public int subjectPossibleAdd(InstructorPossible ip) {
		int result = 0;
		
		return result;
	}
	
	// 강의 가능 과목 출력 메소드
	public List<InstructorPossible> print(String instructor_id) {
		List<InstructorPossible> list = new ArrayList<InstructorPossible>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT s.subject_id, s.subject_name\r\n" + 
					"    FROM instructor i, instructor_possible iso, subject s\r\n" + 
					"    WHERE i.instructor_id = iso.instructor_id\r\n" + 
					"    AND iso.subject_id = s.subject_id\r\n" + 
					"    AND i.instructor_id = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, instructor_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String subject_id = rs.getString("subject_id");
				String subject_name = rs.getString("subject_name");
				InstructorPossible ip = new InstructorPossible("", subject_id, subject_name);
				list.add(ip);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                OracleConnection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
		
		return list;
	}
	
	// 강의 가능 과목 삭제 메소드
	public int subjectPossibleRemove(InstructorPossible ip) {
		int result = 0;
		
		return result;
	}
}
