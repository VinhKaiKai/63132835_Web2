package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginBaiTap
 */
@WebServlet("/LoginBaiTap")
public class LoginBaiTap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginBaiTap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/Views/login.jsp");
		rd.forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String taikhoan = request.getParameter("taikhoan");
		String matkhau = request.getParameter("matkhau");
		if(taikhoan.equals("ABC") && matkhau.equals("123"))
		{
			request.setAttribute("TAIKHOAN", taikhoan);
			request.setAttribute("MATKHAU", matkhau);
			RequestDispatcher rd = request.getRequestDispatcher("/Views/thongtintkmk.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("TAIKHOAN", taikhoan);
			request.setAttribute("MATKHAU", matkhau);
			RequestDispatcher vd = request.getRequestDispatcher("/Views/login.jsp");
			vd.forward(request, response);
		}
		
		
	}

}
