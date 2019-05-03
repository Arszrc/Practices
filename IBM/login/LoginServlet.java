package cn.com.tjise.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import cn.com.tjise.pojo.User;
import cn.com.tjise.service.LoginService;
import cn.com.tjise.service.impl.LoginServiceImpl;

/*
 * ����һ�������¼����servlet
 *1.��ȡ��������
 *2.�������ݡ���ҵ�����
 *3.չʾ��Ӧ�Ľ�������ַ�ת��
 * */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// ���ñ����ʽ
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String uname = req.getParameter("uname"); // parameter--����
		String pwd = req.getParameter("pwd");
		System.out.println("�û���" + uname);
		System.out.println("����" + pwd);
		LoginService ls = new LoginServiceImpl();
		User u = ls.checkLoginService(uname, pwd);
		if (u != null) {
			resp.getWriter().write("��¼�ɹ���");
			// ����cookie7�����¼
			Cookie c = new Cookie("uid", u.getUid() + "");
			c.setMaxAge(7 * 24 * 3600);
			resp.addCookie(c);
			HttpSession hs = req.getSession();
			// �ض���getCҳ��
			hs.setAttribute("user", u);
			resp.sendRedirect("getC");
		} else {
			resp.getWriter().write("��¼ʧ�ܣ�");
			// ת����pageҳ��
//			req.getRequestDispatcher("/page").forward(req, resp);

		}

	}
}
