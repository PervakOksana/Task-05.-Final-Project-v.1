package by.htp.jwd.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.jwd.bean.User;
import by.htp.jwd.connection_pool.ConnectionPool;
import by.htp.jwd.connection_pool.ConnectionPoolException;
import by.htp.jwd.connection_pool.ConnectionProvider;
import by.htp.jwd.dao.DAOException;
import by.htp.jwd.dao.UserDAO;

public class UserDAOimpl implements UserDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public boolean registration(User user) throws DAOException {
		boolean result = true;
		Connection con = null;
		Statement st = null;
		ConnectionProvider provider = ConnectionProvider.getInstance();
		ConnectionPool cp = provider.getConnectionPool();

		try {
			cp.initPoolData();
			con = cp.takeConnection();
			st = con.createStatement();

			String command = "INSERT INTO users (login, password,name ,surname, role) VALUES ('" + user.getLogin()
					+ "','" + user.getPassword() + "','" + user.getName() + "','" + user.getSurname() + "','"
					+ user.getRole() + "')";
			st.executeUpdate(command);

		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		} catch (ConnectionPoolException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return result;

	}

}
