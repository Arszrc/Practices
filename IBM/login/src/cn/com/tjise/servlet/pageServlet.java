package cn.com.tjise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

public class pageServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	req.setCharacterEncoding("UTF-8");
	resp.setCharacterEncoding("UTF-8");
	resp.setContentType("text/html;charset=utf-8");
	resp.getWriter().write("<html>");
	resp.getWriter().write("<head>");
	resp.getWriter().write("</head>");
	resp.getWriter().write("<body>");
	resp.getWriter().write("<p> pageҳ��");
	resp.getWriter().write("</p>");
	resp.getWriter().write("<form action='login' method='get' >");
	resp.getWriter().write("�û���<input type='text' name='uname'>");
	resp.getWriter().write("���룺<input type='text' name='pwd'>");
	resp.getWriter().write("<input type='submit' values='��¼'>");
	resp.getWriter().write("</form>");
	resp.getWriter().write("</body>");
	resp.getWriter().write("</html>");
	
}
}
