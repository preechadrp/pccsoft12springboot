package com.pcc.sys.lib;

import java.math.BigDecimal;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * 
 * @author Mr.Preecha daroonpunth 19/10/2016
 *
 */
public class FModelHasMap extends HashMap<String, Object> {

	private static final long serialVersionUID = 1L;

	/**
	 * นำข้อมูลเข้า Hasmap . By Preecha
	 * @param rs
	 * @throws SQLException
	 */
	public void putRecord(java.sql.ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData(); //ใช้ไม่ได้กับ sql จำพวก select * from (xx union xx) //31/7/60 preecha
		int columnCount = rsmd.getColumnCount();
		for (int t = 1; t <= columnCount; t++) {
			//String columnName = rsmd.getColumnName(t);
			String columnName = rsmd.getColumnLabel(t);//กรณีใช้ sql แบบ xx as fieldName2 จะได้ fieldName2  fix 11/8/64 
			this.put(columnName.toUpperCase(), rs.getObject(columnName));//ให้เป็นฟิลด์ตัวใหญ่ไปเลย จะได้ใช้ myreport.addField ไม่มีปัญหา
		}
	}

	public String getString(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return "";
			} else {
				return (String) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setString(String columnName, String value) throws Exception {
		if (value == null) {
			this.put(columnName.toUpperCase(), "");
		} else {
			this.put(columnName.toUpperCase(), value);
		}
	}

	public BigDecimal getBigDecimal(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return BigDecimal.ZERO;
			} else {
				return (BigDecimal) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setBigDecimal(String columnName, BigDecimal value) throws Exception {
		if (value == null) {
			this.put(columnName.toUpperCase(), BigDecimal.ZERO);
		} else {
			this.put(columnName.toUpperCase(), value);
		}
	}

	public Integer getInteger(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return Integer.valueOf(0);
			} else {
				return (Integer) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setInteger(String columnName, Integer value) throws Exception {
		if (value == null) {
			this.put(columnName.toUpperCase(), Integer.valueOf(0));
		} else {
			this.put(columnName.toUpperCase(), value);
		}
	}

	public int getInt(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return 0;
			} else {
				return (int) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setInt(String columnName, int value) throws Exception {
		this.put(columnName.toUpperCase(), value);
	}

	public java.util.Date getDateUtil(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return null;
			} else {
				return (java.util.Date) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setDateUtil(String columnName, java.util.Date value) throws Exception {
		this.put(columnName.toUpperCase(), value);
	}

	public java.sql.Date getDate(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return null;
			} else {
				return (java.sql.Date) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setDate(String columnName, java.sql.Date value) throws Exception {
		this.put(columnName.toUpperCase(), value);
	}

	public java.sql.Timestamp getTimestamp(String columnName) throws Exception {
		if (this.containsKey(columnName.toUpperCase())) {
			if (this.get(columnName.toUpperCase()) == null) {
				return null;
			} else {
				return (java.sql.Timestamp) this.get(columnName.toUpperCase());
			}
		} else {
			throw new Exception("Unknown Column :" + columnName.toUpperCase());
		}
	}

	public void setTimestamp(String columnName, java.sql.Timestamp value) throws Exception {
		this.put(columnName.toUpperCase(), value);
	}

}
