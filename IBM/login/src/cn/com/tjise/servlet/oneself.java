package cn.com.tjise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class oneself extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("uft-8");
		resp.setContentType("text/http,charset=utf-8");
		resp.getWriter().write("<http>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("<title>��������ҳ��");
		resp.getWriter().write("</title>");
		resp.getWriter().write("</head>");
		resp.getWriter().write("<body>");
		resp.getWriter().write("<form action='' mothed=get>");
		resp.getWriter().write("input name=���� type=text");
		resp.getWriter().write("input name=�Ա�  type=text");
		resp.getWriter().write("input name=������ò type=text");
		resp.getWriter().write("input name=���� type=text");
		resp.getWriter().write("<input name=���� type=text>");
		resp.getWriter().write("<input name=������ type=text>");
		resp.getWriter().write("<p> ����ϸ��д������Ϣ��");
		resp.getWriter().write("</p>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");
		resp.getWriter().write("</http>");
	}
}
