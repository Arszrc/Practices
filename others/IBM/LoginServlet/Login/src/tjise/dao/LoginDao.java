package tjise.dao;

import tjise.pojo.User;

/**
 * ����dao�ӿ�
 *
 */
public interface LoginDao {
	User checkLoginDao(String uname, String pwd);

	User checkUidDao(String uid);
}
