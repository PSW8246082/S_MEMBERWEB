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
 * Servlet implementation class EnrollController
 */
@WebServlet("/member/register.do")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view와 back의 중간과정
		
		request.setCharacterEncoding("UTF-8");
		
		String memberId = request.getParameter("id");  //jsp의 name값이 들어간다.
		String memberPw = request.getParameter("password");
		String memberName = request.getParameter("name");
		int memberAge = Integer.parseInt(request.getParameter("age"));
		String memberGender = request.getParameter("gender");
		String memberEmail = request.getParameter("email");
		String memberPhone = request.getParameter("phone");
		String memberAddress = request.getParameter("address");
		String memberHobby = request.getParameter("hobby");
		
	
		Member member = new Member(memberId, memberPw, memberName, memberAge, memberGender, memberEmail, memberPhone, memberAddress, memberHobby);
	
		//서비스 호출
		MemberService service = new MemberService();
		//INSERT INTO MEMBER_TBL VALUES(?,?,?,?,?,?,?,?,?,DEFAULT,DEFAULT,DEFAULT)    전달되는 값이 있으므로 매개변수 필요
		int result = service.insertMember(member);
		
		if(result>0) {
			//성공- 성공페이지로 이동 ->RequestDispatcher
			request.setAttribute("msg", "회원가입 성공했어요.");
			request.setAttribute("url", "/index.jsp");
			request.getRequestDispatcher("/member/serviceSuccess.jsp")
			.forward(request, response);
			
			
		} else {
			//실패
			request.getRequestDispatcher("/member/serviceFail.jsp")
			.forward(request, response);
		}
		
	}

}
