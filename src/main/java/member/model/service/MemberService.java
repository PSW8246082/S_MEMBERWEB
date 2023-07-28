package member.model.service;

import java.sql.Connection;

import common.JDBCTemplat;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	//연결생성 - 전역변수로 올려줌
	private JDBCTemplat jdbcTemplate;
	private MemberDAO mDao;
	
	public MemberService() {
		jdbcTemplate = JDBCTemplat.getInstance();
		mDao = new MemberDAO();
	}
	
	//연결생성
	//DAO호출
	//커밋/롤백

	
	
	public int insertMember(Member member) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출
		int result = mDao.insertMember(conn,member);
		//커밋/롤백
		if(result>0) {
			//성공 - 커밋
			jdbcTemplate.comit(conn);
		} else {
			//실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn); 
		return result;
	}

	public Member selectCheckLogin(Member member) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출 (연결도 넘겨줘야함)
		Member mOne = mDao.selectCheckLogin(conn, member);
		//커밋/롤백은 SELECT에서 안해줘도 된다. 할 필요가 없음 저장하고 롤백할 필요 없으니까
		jdbcTemplate.close(conn);
		return mOne;
	}

	public Member selectOneById(String memberId) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출
		Member member = mDao.selectOneById(conn,memberId);
		//커밋/롤백은 SELECT에서 안해줘도 된다. 할 필요가 없음 저장하고 롤백할 필요 없으니까
		jdbcTemplate.close(conn);
		return member;
	}

	public int deleteMember(String memberId) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출(연결 넘겨주기)
		int result = mDao.deleteMember(conn, memberId);
		//커밋/롤백
		if(result>0) {
			//성공 - 커밋
		} else {
			//실패 - 롤백
		}
		jdbcTemplate.close(conn);
		return result;
	}

	

	public int updateMember(Member member) {
		//연결생성
		Connection conn = jdbcTemplate.createConnection();
		//DAO호출
		int result = mDao.updateMember(conn,member);
		//커밋/롤백
		if(result>0) {
			//성공 - 커밋
			jdbcTemplate.comit(conn);
		} else {
			//실패 - 롤백
			jdbcTemplate.rollback(conn);
		}
		jdbcTemplate.close(conn); 
		return result;
	}
	

}
