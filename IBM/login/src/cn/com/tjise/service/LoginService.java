package cn.com.tjise.service;

import cn.com.tjise.pojo.User;

//import cn.com.tjise.pojo.User;


/*
 * ����һ��ҵ��ӿ�
 * */
public interface LoginService {
	User checkLoginService(String uname, String pwd);

	User checkUidService(String uid);
}
