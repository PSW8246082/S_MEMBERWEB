package notice.controlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class noticeDeleteController
 */
@WebServlet("/notice/delete.do")
public class noticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public noticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼태그의 태그가 포스트가 아니면 전부 겟방식
		//DELETE FROM NOTICE_TBL WHERE NOTICE_NO = ? 위치홀더가 있으니까 매개변수가 있음
		NoticeService service = new NoticeService();
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo")); //jsp에서 ?뒤의 값
		int result = service.deleteNoticeByNo(noticeNo);
		if(result > 0) {
			//성공 = 공지사항 목록 페이지 이동
			response.sendRedirect("/notice/list.do");
		} else {
			//실패 = 에러페이지 이동
			RequestDispatcher view = request.getRequestDispatcher("/WEB-IFO/views/common/serviceFail.jsp");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼태그의 태그가 포스트가 아니면 전부 겟방식
		doGet(request, response);
	}

}
