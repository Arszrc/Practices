package tjise.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class pageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //���ñ����ʽ
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("<html>");
        resp.getWriter().write("<head>");
        resp.getWriter().write("</head>");
        resp.getWriter().write("<body>");
        resp.getWriter().write("<p>pageҳ��</p>");
        resp.getWriter().write("<form action='login' method='get'>");
        resp.getWriter().write("�û���:<input type='text' name='uname' /><br/>");
        resp.getWriter().write("����:<input type='password' name='pwd' /><br/>");
        resp.getWriter().write("<input type='submit' value='��¼' />");
        resp.getWriter().write("</form>");
        resp.getWriter().write("</body>");
        resp.getWriter().write("</html>");
    }

}





