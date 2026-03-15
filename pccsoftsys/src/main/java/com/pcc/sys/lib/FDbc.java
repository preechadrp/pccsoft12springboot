package com.pcc.sys.lib;

import java.sql.Connection;

import com.pcc.sys.lib.db.Db1;

public class FDbc extends FDbcMaster {

	/**
	 * เรียกแบบไม่ต้อง new ใช้ใน try{..}
	 * 
	 * @return FDbc ที่เชื่อมแล้ว
	 * @throws Exception
	 */
	public static FDbc connectMasterDb() throws Exception {
		FDbc dbc = new FDbc();
		dbc.connect1("MASTERDB");
		return dbc;
	}

	/**
	 * ทำการเชื่อมต่อ databaseName
	 * 
	 * @param dbname
	 * @throws Exception
	 */
	private void connect1(String dbname) throws Exception {
		try {

			if (dbname.equals("MASTERDB")) {
				objConn = Db1.getConnection();
			}

			objConn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

		} catch (java.sql.SQLException ex) {
			throw new Exception(ex.getMessage());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}

	public static FDbc connectByConsole() throws Exception {

		try {

			FDbc dbc = new FDbc();

			String driverName = "org.firebirdsql.jdbc.FBDriver";
			String urlConnect = "jdbc:firebird://localhost:3050/D:/Firebird/databaseV5x/TSN.FDB?encoding=UTF8";
			String userName = "sysdba";
			String passWord = "masterkey";

			Class.forName(driverName);
			dbc.objConn = java.sql.DriverManager.getConnection(urlConnect, userName, passWord);
			dbc.objConn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

			return dbc;

		} catch (java.sql.SQLException ex) {
			throw new Exception(ex.getMessage());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}

}
