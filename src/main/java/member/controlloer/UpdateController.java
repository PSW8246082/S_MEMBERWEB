package member.controlloer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/member/update.do")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글 안깨지게
		
		String memberId = request.getParameter("id");  //name값 넣기
		String memberPw = request.getParameter("password");
		String memberGender = request.getParameter("gender");
		String memberEmail = request.getParameter("email");
		String memberPhone = request.getParameter("phone");
		String memberAddress = request.getParameter("address");
		String memberHobby = request.getParameter("hobby");
		//UPDATE MEMBER_TBL SET MEMBER_PW = ?, MEMBER_EMAIL = ?, MEMBER_PHONE = ?, MEMBER_ADDRESS = ?, MEMBER_HOBBY = ?, UPDATE_DATE = SYSDATE WHERE MEMBER_ID = ?
		//WHERE절 빠지지 않게 주의!, list, member, int 중 리턴값 확인
		MemberService service = new MemberService();
		Member member = new Member(memberId, memberPw, memberGender, memberEmail, memberPhone, memberAddress, memberHobby);
		///Member member = new Member(memberId, memberPw, memberGender,  memberEmail, memberPhone, memberAddress, memberHobby);
//		int result = service.updateMember(memberId, memberPw, memberEmail, memberPhone, memberAddress, memberHobby);
		int result = service.updateMember(member);
		if(result>0) {
			//성공 -> 메인페이지
			response.sendRedirect("/index.jsp");
		} else {
			//실패 -> 에러페이지
			request.setAttribute("msg", "회원 수정이 완료되지 않았습니다.");
			request.getRequestDispatcher("/member/serviceFail.jsp")
			.forward(request, response);
			
		}
		
	}

}
