package member.controlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/member/delete.do")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		//DELETE FROM MEMBER_TBL WHERE MEMBER_ID = ?  int, member, List 중에 리턴형 확인
		//UPDATE, DELETE  WHERE조건절 주의
		String memberId = request.getParameter("memberId");
		int result = service.deleteMember(memberId);
		if(result>0) {
			//성공
			//페이지 이동방식 2가지
			//1.with Data
			request.setAttribute("msg", "회원탈퇴성공");
			request.setAttribute("url", "/member/logout.do");
			RequestDispatcher view = request.getRequestDispatcher("/member/serviceSuccess.jsp");
			view.forward(request, response);
			
			//2.without Data
//			response.sendRedirect("/member/serviceSuccess.jsp");
//			response.sendRedirect("/member/logout.do");
		} else {
		   //실패
			//페이지 이동방식 2가지
			//1.with Data
			request.setAttribute("msg", "회원탈퇴실패");
			RequestDispatcher view = request.getRequestDispatcher("/member/serviceFail.jsp");
			view.forward(request, response);
			//2.without Data
			//response.sendRedirect("/member/serviceSuccess.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
