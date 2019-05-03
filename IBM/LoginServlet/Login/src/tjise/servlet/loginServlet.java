package tjise.servlet;

import tjise.pojo.User;
import tjise.service.LoginService;
import tjise.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * ����һ�������¼�����servlet
 * 1.��ȡ��������
 * 2.��������----ҵ�����
 * 3.չʾ��Ӧ�Ľ��----�ַ�ת��
 * ����ת����ת�� ʵ�ֶ��servlet������������req�������������  �ֹ���ȷ
 * req.getRequestDispatcher("Ҫת���ĵ�ַ").forward(req, resp);
 * �ص㣺 һ��������     �������ַ����Ϣ����
 * �ض��򣺽�����ظ��ύ�����⣬��ǰ��servlet�޷��ٴ�������
 * �ص㣺���λ��������ϵ�����   �������������� req����
 * ��ַ��Ҫ�����仯
 */
public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //���ñ����ʽ
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        //1.��ȡ��������
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println("�û�����" + uname + ",���룺" + pwd);
//		resp.getWriter().write("�û�����"+uname+",���룺"+pwd);

        //2.��������----ҵ���߼�����
        LoginService ls = new LoginServiceImpl();
        User u = ls.checkLoginService(uname, pwd);
        System.out.println(u);

        //3.��Ӧ������                                                                                               k        v
        if (u != null) {    //��ǰ���u�Ѿ��������� �� Userʵ������     uid----->uname&pwd
            //ֱ����Ӧ
//			resp.getWriter().write("��¼�ɹ���");
            //��ȷ��������ҳ
            //����ת��
//			req.getRequestDispatcher("main").forward(req, resp);
            //�ض���
            //resp.sendRedirect("/Login/main");
            //����cookie����ʵ��7�����½
            Cookie c = new Cookie("uid", u.getUid() + "");
            //����һ����Ч��
            c.setMaxAge(7 * 24 * 3600);
            resp.addCookie(c);
            //����session����
            HttpSession hs = req.getSession();//��ȡ/����sessionid
            hs.setAttribute("user", u);
            //�ض���
            resp.sendRedirect("getc");
        } else {
            System.out.println("û��cookie");
//            resp.getWriter().write("��¼ʧ�ܣ�");
            //�����ٻص���¼ҳ��
            req.getRequestDispatcher("/page").forward(req, resp);
        }
    }
}
