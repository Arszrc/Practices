package tjise.service;

import tjise.pojo.User;

/**
 * ����һ��ҵ��ӿ�
 */
public interface LoginService {
    User checkLoginService(String uname, String pwd);
    //У���û�uid�ķ���
    User checkUidService(String uid);
}
