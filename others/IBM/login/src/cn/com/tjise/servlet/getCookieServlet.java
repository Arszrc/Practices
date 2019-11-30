package src.cn.com.tjise.servlet;

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

public class getCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		// 1.��ȡ����req
		Cookie[] cks = req.getCookies();
		String uid = "";

		// 2.����������Ϣ
		if (cks != null) {
			for (Cookie c : cks) {
				if ("uid".equals(c.getName())) {
					uid = c.getValue();
				}
			}
		}
		if ("".equals(uid)) {
			System.out.println("cookie�е�uidΪ��" + uid);
		} else {
			// 3.��Ӧ������Ϣ
			// У��uid�û���Ϣ------>ҵ�����
			LoginService ls = new LoginServiceImpl();
			User u = ls.checkUidService(uid);
			if (u != null) {
				System.out.println("��Cookie��uid" + uid);
				req.getSession().setAttribute("user", u);

				resp.sendRedirect("/login/main"); // �еĻ��ض�����ҳ��/main
				return;
			} else {
				System.out.println("û��Cookie��uid" + uid);
				req.getRequestDispatcher("page").forward(req, resp);
				return;
			}
		}
	}
}
