package by.htp.jwd.service.impl;

import by.htp.jwd.bean.User;
import by.htp.jwd.dao.DAOException;
import by.htp.jwd.dao.DAOProvider;
import by.htp.jwd.dao.UserDAO;
import by.htp.jwd.service.ServiceException;
import by.htp.jwd.service.UserService;


public class UserServiceImpl implements UserService{

	@Override
	public User authorization(String login, String password) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registration(User user) throws ServiceException {
		DAOProvider proviger = DAOProvider.getInstance();
		UserDAO userDAO = proviger.getUserdao();
		boolean result = false;
		try {
			result = userDAO.registration(user);
			
		} catch (DAOException e) {
			throw new ServiceException( e);
		}
		return result;
	}

}
