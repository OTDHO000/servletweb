/**
 * 
 */
package com.figo.study.service;

import com.figo.study.dao.UserDAO;
import com.figo.study.dao.impl.UserDAOImpl;
import com.figo.study.model.User;
import com.figo.study.utils.CommonUtil;

/**
 * @author figo
 *
 */
public class UserService {
	UserDAO userDao = new UserDAOImpl();

	public boolean login(User user) {
		try {
			return userDao.login(user);
		} catch (Exception e) {
			CommonUtil.printStacktrace(e);
			return false;
		}
	}
}
