package cn.com.tjise.dao;

import cn.com.tjise.pojo.User;

//����dao�ӿ�
public interface LoginDao {
	User checkLoginDao(String uname,String pwd);
}
