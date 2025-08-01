/*
 * The MIT License
 *
 * Copyright (c) 2020 preecha daroonpunth (prch13@gmail.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gencode.app;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbHelper {

	public static Connection getConnection() {
		Connection conn = null;
		try {

			String driverName = "";
			String urlConnect = "";
			String userName = "";
			String passWord = "";

//			driverName = "org.mariadb.jdbc.Driver";
//			urlConnect = "jdbc:mariadb://127.0.0.1:8094/pccsoft11?useUnicode=true&characterEncoding=UTF-8";
//			userName = "root";
//			passWord = "a1234";

			driverName = "org.firebirdsql.jdbc.FBDriver";
			urlConnect = "jdbc:firebird://localhost:3050/E:/Firebird/databaseV5x/PCCSOFT11.FDB?encoding=UTF8";
			userName = "SYSDBA";
			passWord = "masterkey";

//			driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	
//			urlConnect = "jdbc:sqlserver://115.31.163.236:1433;databaseName=shkdev;selectMethod=cursor;";
//			userName = "anan";
//			passWord = "it2s39";

			Class.forName(driverName);
			conn = DriverManager.getConnection(urlConnect, userName, passWord);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
