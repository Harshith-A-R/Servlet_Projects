import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstHttpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid =req.getParameter("id");
		int id =Integer.parseInt(sid);
		String name =req.getParameter("nm");
		String place =req.getParameter("pl");
		String phone =req.getParameter("ph");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body> <h1> hello "+name+"</h1></body></html>");
		
		out.flush();
	out.close()	;
	
	
	Connection con=null;
	PreparedStatement psmt=null;
	String sql ="insert into Registration.application values(?,?,?,?)";
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con =DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=8099");
		//con.setAutoCommit(false);
		psmt=con.prepareStatement(sql);
		psmt.setInt(1, id);
		psmt.setString(2, name);
		psmt.setString(3, place);
		psmt.setString(4, phone);
		psmt.executeUpdate();
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}

	
	
}
