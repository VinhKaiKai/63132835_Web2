package LamLaiDOPOST;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DOPOST
 */
@WebServlet("/DOPOST")
public class DOPOST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DOPOST() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// định dạng tiếng việt
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher("/Views/NhapThongTin.jsp");
		rd.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String a = request.getParameter("ten");
		String b= request.getParameter("lop");
		request.setAttribute("KEY_TEN", a);
		request.setAttribute("KEY_LOP", b);
		RequestDispatcher rd = request.getRequestDispatcher("/Views/NhanThongTin.jsp");
		rd.forward(request, response);
		
	}

}
