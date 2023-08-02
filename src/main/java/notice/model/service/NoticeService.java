package notice.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplat;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {  //DB연결생성, 호출, ,넘겨줌 
	
	private NoticeDAO nDao;
	private JDBCTemplat jdbcTemplet;
	
	public NoticeService() {
		nDao = new NoticeDAO();
		jdbcTemplet = JDBCTemplat.getInstance();  //싱글톤 적용되어 있고 private 설정되어 있어 new로 객체생성 안됨
	}

	public int insertNotice(Notice notice) {
		Connection conn = jdbcTemplet.createConnection();
		int result = nDao.insertNotice(conn, notice);
		if(result > 0) {
			jdbcTemplet.comit(conn);
		} else {
			jdbcTemplet.rollback(conn);
		}
		jdbcTemplet.close(conn);
		return result;
	}

	//공지사항 전체 목록 조회 -> LIST로 받음
	public List<Notice> selectNoticeList() {
		Connection conn = jdbcTemplet.createConnection();
		List<Notice> nList = nDao. selectNoticeList(conn);
		jdbcTemplet.close(conn);
		return nList;
	}

	public Notice selectOneByNo(int noticeNo) {
		Connection conn = jdbcTemplet.createConnection();
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		jdbcTemplet.close(conn);
		return notice;
	}

}
