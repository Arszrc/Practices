package tjise.dao.impl;

import tjise.dao.LoginDao;
import tjise.pojo.User;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/demo";
    private static final String DB_PARAMS = "?serverTimezone=UTC&useCursorFetch=true";
    private static final String USERNAME = "Hasaker";
    private static final String PASSWORD = "5523";

    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User checkLoginDao(String uname, String pwd) {
        //����JDBC����
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            //��������
            conn = DriverManager.getConnection(DB_URL+ DB_PARAMS, USERNAME, PASSWORD);
            //sql���
            String sql = "SELECT * FROM t_user WHERE uname=? AND pwd=?";
            //����sql�������
            ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, pwd);
            rs = ps.executeQuery();
            //���������
            while (rs.next()) {
                u = new User();//����һ��user�������ڱ�������
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    @Override
    public User checkUidDao(String uid) {
        //����JDBC����
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;

        try {
            //��������
            conn = DriverManager.getConnection(DB_URL+ DB_PARAMS, USERNAME, PASSWORD);
            //sql���
            String sql = "SELECT * FROM t_user WHERE uid=?";
            //����sql�������
            ps = conn.prepareStatement(sql);
            ps.setString(1, uid);
            rs = ps.executeQuery();
            //���������
            while (rs.next()) {
                u = new User();//����һ��user�������ڱ�������
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }

    private void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
