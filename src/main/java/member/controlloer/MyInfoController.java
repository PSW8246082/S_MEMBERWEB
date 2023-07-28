package member.controlloer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class MyInfoController
 */
@WebServlet("/member/myInfo.do")
public class MyInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이지 이동 2가지
		//1.with Data (DataBase에서 가져온 데이터를 같이 가져감)
		//쿼리문 : SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?   LIST,INT,MEMBER 중 MEMBER로 리턴함
		MemberService service = new MemberService();
		String memberId = request.getParameter("member-id");  //index a태그에서 가져온 값
		Member member = service.selectOneById(memberId);
		request.setAttribute("member", member);
		RequestDispatcher view = request.getRequestDispatcher("/member/myInfo.jsp");
		view.forward(request, response);
		
		//2.without Data(단순 페이지 이동)
		//response.sendRedirect("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
