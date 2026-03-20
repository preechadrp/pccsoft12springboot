package com.pcc.sys.lib;

import java.sql.Connection;

import com.pcc.sys.lib.db.Db1;

public class FDbc extends FDbcMaster {
	
	
	public FDbc() throws Exception {
		this.connect1("db1");
	}
	
	public FDbc(String dbName) throws Exception {
		this.connect1(dbName);
	}

	/**
	 * ทำการเชื่อมต่อ databaseName
	 * 
	 * @param dbname
	 * @throws Exception
	 */
	private void connect1(String dbname) throws Exception {
		try {

			if ("db1".equalsIgnoreCase(dbname)) {
				objConn = Db1.getConnection();
			}

			objConn.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

		} catch (java.sql.SQLException ex) {
			throw new Exception(ex.getMessage());
		} catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}

	}

}
