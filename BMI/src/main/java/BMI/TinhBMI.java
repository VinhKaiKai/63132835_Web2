package BMI;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TinhBMI
 */
@WebServlet("/TinhBMI")
public class TinhBMI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TinhBMI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher r = request.getRequestDispatcher("/Views/Nhap.jsp");
		r.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double a = Double.parseDouble(request.getParameter("dulieucc"));
		double b = Double.parseDouble(request.getParameter("dulieucn"));
		double ketqua= 0;
		String thongbao = "";
		ketqua = (b/(a*a));
		if(ketqua< 18.5)
		{
			thongbao = "bạn đang bị suy dinh dưỡng";
		}
		else if(ketqua>18 && ketqua<25)
		{
			thongbao = "bạn đang đẹp";
		}
		else
		{
			thongbao = "bạn đang mập";
		}
		request.setAttribute("THONG_BAO", thongbao);
		
		RequestDispatcher r = request.getRequestDispatcher("/Views/xuat.jsp");
		r.forward(request,response);
	}

}
