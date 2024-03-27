package T8_insa;

import java.sql.SQLException;
import java.util.Vector;

public class InsaDAO extends DBConn {  // dbconn 상속받아서 사용(db연결 안해도 됨)
	InsaVO vo = null;

	// 회원 개별 조회(성명 중복체크)
	public InsaVO getNameSearch(String name) {
		InsaVO vo = new InsaVO();  // 타입 복사  // 위에 있으니 뺴도 되긴함
		try {
			sql = "select * from insa2 where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {  // vo니까 1개 if로 받음 아니면 while로 받음
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setGender(rs.getString("gender"));
				vo.setIpsail(rs.getString("ipsail"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 회원가입 처리
	public int setInsaInput(InsaVO vo) {
		int res = 0;
		try {
			sql = "insert into insa2 values (default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getIpsail());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//회원정보 수정처리
	public int setInsaUpdate(InsaVO vo) {
		int res = 0;
		try {
			sql = "update insa2 set age=?, gender=?, ipsail=? where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getAge());
			pstmt.setString(2, vo.getGender());
			pstmt.setString(3, vo.getIpsail());
			pstmt.setString(4, vo.getName());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 회원 삭제 처리
	public int setInsaDelete(String name) {
		int res = 0;
		try {
			sql = "delete from insa2 where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	public Vector getInsaList(String str, String order) {
		Vector vData = new Vector<>();
		try {
			if(str.equals("ipsail") && order.equals("a")) {  // str이 ipsail로 넘어오고 a(asc)로 넘어오면
				sql = "select * from insa2 order by ipsail";				
			}
			else if(str.equals("ipsail") && order.equals("d")) {
				sql = "select * from insa2 order by ipsail desc";
			}
			else {
				sql = "select * from insa2 order by idx desc";
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {  // 여러건 while // vo도 Vector로 만들어서 Vector를 Vector 객체에 집어넣음
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo);  // arraylist에 담는 것처럼  // jTable이 arrayList를 지원 안해서
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	// 조건을 이용한 다양한 검색처리
	public Vector getConditionSearch(String fieldName, String txtCondi) {
		Vector vData = new Vector<>();
		try {
			sql = "select * from insa2 where "+fieldName+" like ? order by ipsail";  // ?=? 불가 필드명은 변수로 받아야함  // 연산자 양쪽엔 공백이 있어야함  // ? 는 '' 생략되어있음 % 여기에 넣으면 안됨
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+txtCondi+"%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {  // 여러건 while // vo도 Vector로 만들어서 Vector를 Vector 객체에 집어넣음
				Vector vo = new Vector<>();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("ipsail").substring(0,10));
				
				vData.add(vo);  // arraylist에 담는 것처럼  // jTable이 arrayList를 지원 안해서
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류" + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
	
}
