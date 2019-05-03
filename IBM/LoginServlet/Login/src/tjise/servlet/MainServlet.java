package tjise.servlet;

import tjise.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //��ȡ����
        HttpSession hs = req.getSession();
        //��ȡsession�б����user����
        User u = (User) hs.getAttribute("user");
        //��Ӧ������
        // ���ñ����ʽ
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<p>��ҳ��</p>");
        resp.getWriter().write("<p>��ӭ��" + u.getUname() + "�����������ҳ</p>");
        resp.getWriter().write("<form action='show' method='get'>");
        resp.getWriter().write("<input type='submit' value='�鿴������Ϣ'>");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }
}
