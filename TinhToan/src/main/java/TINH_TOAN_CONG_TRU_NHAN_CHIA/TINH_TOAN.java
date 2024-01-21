package TINH_TOAN_CONG_TRU_NHAN_CHIA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TINH_TOAN
 */
@WebServlet("/TINH_TOAN")
public class TINH_TOAN extends HttpServlet {
	 private String message;
	 public void init() throws ServletException {
	    	// Khởi tạo giá trị cho biến
	    	message = "Hello World";
	    	}
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TINH_TOAN() {
        super();
        // TODO Auto-generated constructor stub
    }
   

    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// chuyển tới trang views tinhToan.jsp đầu tiên khi khởi động.
		RequestDispatcher rd = request.getRequestDispatcher("/Views/tinhToan.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// khi nhấn nút submit thì nó sẽ chạy tới trang kết quả. jsp
		//Lấy 2 số ở 2 khung nhập 
		double a = Double.parseDouble(request.getParameter("soA"));
		double b = Double.parseDouble(request.getParameter("soB"));
		// lấy dấu ở các nút 
		String dau = request.getParameter("pheptinh");
		double ketquatrave = 0;
		switch (dau)
		{
		case "plus":
			ketquatrave = a+b;
			break;
		case "minus":
			ketquatrave = a-b;
			break;
		case "nhan":
			 ketquatrave = a*b;
			break;
		case "chia":
			if(b==0)
			{
				
				PrintWriter ketquatrave1 = response.getWriter();
				ketquatrave1.println("<h1>" + message + "</h1>");
				
			}
			else {
				ketquatrave = a/b;
				break;
			}
			
		}
		// tạo ra một cái setAttribule để gửi dữ liệu đi. có 2 tham số: 1 là cái để bên kia nhận, 2 ;à cái kết quả nó gửi đi
		request.setAttribute("KEY_NHAN_DU_LIEU", ketquatrave);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Views/KetQua.jsp");
		rd.forward(request, response);
	}

}
