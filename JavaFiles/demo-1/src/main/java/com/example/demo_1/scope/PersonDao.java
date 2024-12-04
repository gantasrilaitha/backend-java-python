package com.example.demo_1.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonDao {
	 @Autowired
	 JDBCconnection jdbc_conn;

	public JDBCconnection getJdbc_conn() {
		return jdbc_conn;
	}

	public void setJdbc_conn(JDBCconnection jdbc_conn) {
		this.jdbc_conn = jdbc_conn;
	}
}
