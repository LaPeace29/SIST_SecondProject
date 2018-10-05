package com.scoremanagement.persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scoremanagement.connection.OracleConnection;
import com.scoremanagement.domain.Instructor;

public class InstructorDAO {

	String instructor_id = null;
	
	// ���� �α��� �޼ҵ�
	public String login(Instructor i) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "SELECT instructor_id\r\n" + 
							"    FROM instructor\r\n" + 
							"    WHERE instructor_name = ? AND instructor_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getInstructor_name());
			pstmt.setString(2, i.getInstructor_pw());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				instructor_id = rs.getString("instructor_id");
			}
			
			rs.close();
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
		
		return instructor_id;
	}
	
	// ���� �߰� �޼ҵ�
	public int insert(Instructor i) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			String sql = "INSERT INTO instructor (instructor_id, instructor_name, instructor_phone, instructor_pw\r\n" + 
					"    ,instructor_regdate)\r\n" + 
					"    VALUES ((SELECT CONCAT('INS',\r\n" + 
					"		 LPAD(NVL(SUBSTR(MAX(instructor_id),4), 0) + 1, 3, 0)) AS newId FROM instructor)\r\n" + 
					"         , ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getInstructor_name());
			pstmt.setString(2, i.getInstructor_phone());
			pstmt.setString(3, i.getInstructor_pw());
			pstmt.setDate(4, i.getInstructor_regDate());
			
			result = pstmt.executeUpdate();
			
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
		
		return result;
	}
	
	// ���� ��� �޼ҵ�(1)
	// �����̸� / �����޴�����ȣ
	public List<Instructor> print1() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		return list;
	}
	
	// ���� ��� �޼ҵ�(2)
	// �����ȣ / �����̸� / �����޴�����ȣ / �����
	public List<Instructor> print2(String instructor_id) {
		List<Instructor> list = new ArrayList<Instructor>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT instructor_id, instructor_name, instructor_phone, instructor_regDate\r\n" + 
					"    FROM instructor\r\n" + 
					"    WHERE instructor_id = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, instructor_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String instructor_id1 = rs.getString("instructor_id");
				String instructor_name = rs.getString("instructor_name");
				String instructor_phone = rs.getString("instructor_phone");
				Date instructor_regDate = rs.getDate("instructor_regDate");
				Instructor i = new Instructor(instructor_id1, instructor_name, instructor_phone, instructor_regDate);
				list.add(i);
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
	
	// ���� ��� �޼ҵ�(3)
	// �����ȣ / �����̸� / �����޴�����ȣ / ����� / ���ǰ��ɰ���
	public List<Instructor> print3(String key, String value) {
		List<Instructor> list = new ArrayList<Instructor>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = OracleConnection.connect();
			
			if(key.equals("all")) {
				String sql = "SELECT i.instructor_id, i.instructor_name, i.instructor_phone, i.instructor_regdate\r\n" + 
						"    , (SELECT (LISTAGG(s.subject_name, ', ') WITHIN GROUP(ORDER BY pc.instructor_id))\r\n" + 
						"    FROM subject s, instructor_possible pc\r\n" + 
						"    WHERE pc.subject_id = s.subject_id\r\n" + 
						"    AND pc.instructor_id = i.instructor_id)  subjectList\r\n" + 
						"    FROM instructor i";
				
				pstmt = conn.prepareStatement(sql);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String instructor_id1 = rs.getString("instructor_id");
				String instructor_name = rs.getString("instructor_name");
				String instructor_phone = rs.getString("instructor_phone");
				Date instructor_regDate = rs.getDate("instructor_regDate");
				String subjectList = rs.getString("subjectList");
				Instructor i = new Instructor(instructor_id1, instructor_name, instructor_phone, instructor_regDate, subjectList);
				list.add(i);
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
	
	// ���� ��� �޼ҵ�(4)
	// �����ȣ / �����̸� / �����޴�����ȣ / ����� / �������ɿ���
	public List<Instructor> print4() {
		List<Instructor> list = new ArrayList<Instructor>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "SELECT i2.instructor_id, i2.instructor_name, i2.instructor_phone, i2.instructor_regdate\r\n" + 
					"    , (SELECT (LISTAGG(s.subject_name, ', ') WITHIN GROUP(ORDER BY pc.instructor_id))\r\n" + 
					"    FROM subject s, instructor_possible pc\r\n" + 
					"    WHERE pc.subject_id = s.subject_id\r\n" + 
					"    AND pc.instructor_id = i2.instructor_id)  subjectList, (SELECT count(*) \r\n" + 
					"                                            FROM open_subject os\r\n" + 
					"                                           WHERE i2.instructor_id = os.instructor_id) count_\r\n" + 
					"    FROM instructor i2";
				
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String instructor_id = rs.getString("instructor_id");
				String instructor_name = rs.getString("instructor_name");
				String instructor_phone = rs.getString("instructor_phone");
				Date instructor_regDate = rs.getDate("instructor_regDate");
				String subjectList = rs.getString("subjectList");
				int count_ = rs.getInt("count_");
				
				Instructor i = new Instructor(instructor_id, instructor_name, instructor_phone, instructor_regDate, subjectList, count_);
				list.add(i);
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
	
	// ���� �˻� �޼ҵ�
	// �����ȣ or �����̸�
	public List<Instructor> search(String key, String value) {
		List<Instructor> list = new ArrayList<Instructor>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			
			if(key.equals("instructor_id")) {
				String sql = "SELECT instructor_id, instructor_name, instructor_phone, instructor_regDate\r\n" + 
						"    FROM instructor\r\n" + 
						"    WHERE UPPER(instructor_id) = UPPER(?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			else if(key.equals("instructor_name")) {
				String sql = "SELECT instructor_id, instructor_name, instructor_phone, instructor_regDate\r\n" + 
						"    FROM instructor\r\n" + 
						"    WHERE INSTR(instructor_name, ?) > 0";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, value);
			}
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String instructor_id = rs.getString("instructor_id");
				String instructor_name = rs.getString("instructor_name");
				String instructor_phone = rs.getString("instructor_phone");
				Date instructor_regDate = rs.getDate("instructor_regDate");
				
				Instructor i = new Instructor(instructor_id, instructor_name, instructor_phone, instructor_regDate);
				list.add(i);
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
	
	// ���� ���� �޼ҵ�
	public int remove(Instructor i) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "DELETE FROM instructor WHERE UPPER(instructor_id)=UPPER(?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, i.getInstructor_id());
			
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	// ���� ��й�ȣ ���� �޼ҵ�
	public int modify(Instructor i) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "UPDATE instructor\r\n" + 
					"    SET instructor_pw = ?\r\n" + 
					"    WHERE instructor_name = ? AND instructor_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getInstructor_new_pw());
			pstmt.setString(2, i.getInstructor_name());
			pstmt.setString(3, i.getInstructor_pw());
			
			result = pstmt.executeUpdate();
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
		
		return result;
	}
	
	// ���� ��й�ȣ �ʱ�ȭ �޼ҵ�
	public int reset(Instructor i) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = OracleConnection.connect();
			String sql = "UPDATE instructor\r\n" + 
					"    SET instructor_pw = ?\r\n" + 
					"    WHERE UPPER(instructor_id) = UPPER(?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, i.getInstructor_pw());
			pstmt.setString(2, i.getInstructor_id());
			
			result = pstmt.executeUpdate();
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
		
		return result;
	}
}
