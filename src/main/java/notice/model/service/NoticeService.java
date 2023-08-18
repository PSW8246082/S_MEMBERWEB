package notice.model.service;

import java.sql.Connection;
import java.util.List;

import common.JDBCTemplat;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.PageData;

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
	public PageData selectNoticeList(int currentPage) {
		Connection conn = jdbcTemplet.createConnection();
		List<Notice> nList = nDao. selectNoticeList(conn, currentPage);
		String pageNavi = nDao.generatePageNavi(currentPage);
		//pageNavi, nList 둘 다 보내는 방법
		//1. Map이용
		//2. VO클래스 이용
		PageData pd = new PageData(nList, pageNavi);
		jdbcTemplet.close(conn);
		return pd;
	}

	public Notice selectOneByNo(int noticeNo) {
		Connection conn = jdbcTemplet.createConnection();
		Notice notice = nDao.selectOneByNo(conn, noticeNo);
		jdbcTemplet.close(conn);
		return notice;
	}

	public int deleteNoticeByNo(int noticeNo) {
		Connection conn = jdbcTemplet.createConnection();
		int result = nDao.deleteNoticeByNo(conn, noticeNo);
		if(result > 0) {
			jdbcTemplet.comit(conn);
		} else {
			jdbcTemplet.rollback(conn);
		}
		jdbcTemplet.close(conn);
		return result;
	}

	public int updateNotice(Notice notice) {
		Connection conn = jdbcTemplet.createConnection();
		int result = nDao.updateNotice(conn, notice);
		if(result > 0) {
			jdbcTemplet.comit(conn);
		} else {
			jdbcTemplet.rollback(conn);
		}
		jdbcTemplet.close(conn);
		return result;
	}

}
