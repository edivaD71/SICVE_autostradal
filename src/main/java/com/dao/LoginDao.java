package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import com.bean.LoginBean;
import com.util.DBConnection;

// class LoginDao per il controllo delle credenziali d'accesso

public class LoginDao {

	public String authenticateUser(LoginBean loginBean) {
		String email = loginBean.getEmail();
		String password = loginBean.getPassword();

		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;

		String emailDB = "";
		String passwordDB = "";
		String roleDB = "";

		try {
			// connesione DB
			con = DBConnection.createConnection();
			statement = con.createStatement();
			// eseguo la query
			resultSet = statement.executeQuery("select email,password,role,messaggio from users");

			while (resultSet.next()) {
				emailDB = resultSet.getString("email");
				passwordDB = resultSet.getString("password");
				roleDB = resultSet.getString("role");
				// controllo se è admin o user
				if (email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
					return "Admin_Role";
				else if (email.equals(emailDB) && password.equals(passwordDB) && roleDB.equals("User"))
					return "User_Role";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Le credenziali non sono corrette";
	}
}
