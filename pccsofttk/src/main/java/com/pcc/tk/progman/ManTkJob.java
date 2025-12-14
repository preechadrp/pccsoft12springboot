package com.pcc.tk.progman;

import java.util.List;

import com.pcc.sys.lib.FDbc;
import com.pcc.sys.lib.FModelHasMap;
import com.pcc.sys.lib.Fnc;
import com.pcc.sys.lib.SqlStr;

public class ManTkJob {

	public static void getDataByJobno(String comp_cde, String jobno, List<FModelHasMap> lst_data) throws Exception {
		lst_data.clear();
		try (FDbc dbc = FDbc.connectMasterDb();) {
			String sql = """
					select aa.*,bb.LAWYERNAME  
					from tkjoblawyer aa 
					left join tklawyer bb on aa.COMP_CDE =bb.COMP_CDE and aa.LAWYERID =bb.LAWYERID 
					where aa.COMP_CDE =? and aa.JOBNO=? 
					order by aa.SEQ
					""";
			try(java.sql.ResultSet rs = dbc.getResultSetFw2(sql, comp_cde, jobno)){
				while (rs.next()) {
					FModelHasMap rec = new FModelHasMap();
					lst_data.add(rec);
					rec.putRecord(rs);
				}
			}		
		}
	}
	
	public static void getTkjobdocdesc(String comp_cde, List<String> lst_data) throws Exception {
		lst_data.clear();
		try (FDbc dbc = FDbc.connectMasterDb();) {
			String sql = """
					select DOCDESC from tkjobdocdesc where COMP_CDE=? and SYS_CDE=? order by DOCDESC
					""";
			try (java.sql.ResultSet rs = dbc.getResultSetFw2(sql, comp_cde, "FrmTkJobDoc")) {
				while (rs.next()) {
					lst_data.add(Fnc.getStr(rs.getString("DOCDESC")));
				}
			}
		}
	}
	
	public static void getTkFindDocdesc(String comp_cde, FModelHasMap para, List<FModelHasMap> lst_data) throws Exception {
		lst_data.clear();
		try (FDbc dbc = FDbc.connectMasterDb();) {
			SqlStr sql = new SqlStr();
			sql.addLine("select aa.DOCDESC from tkjobdocdesc aa where 1=1 ");
			sql.addLine("and aa.COMP_CDE= '"+ Fnc.sqlQuote(comp_cde)  +"' ");
			sql.addLine("and aa.SYS_CDE= 'FrmTkJobDoc' ");
			if (!Fnc.isEmpty(para.getString("DOCDESC"))) {
				sql.addLine("and aa.DOCDESC like '%" + Fnc.sqlQuote(para.getString("DOCDESC")) + "%' ");
			}
			sql.addLine("order by aa.DOCDESC");
			
			try (java.sql.ResultSet rs = dbc.getResultSetFw3(sql.getSql(), 10000)) {
				while (rs.next()) {
					FModelHasMap rec = new FModelHasMap();
					lst_data.add(rec);
					rec.putRecord(rs);
				}
			}
		}
	}
	
	public static void getTkDelDocdesc(String comp_cde, String del_DOCDESC) throws Exception {
		try (FDbc dbc = FDbc.connectMasterDb();) {
			SqlStr sql = new SqlStr();
			sql.addLine(" DELETE FROM tkjobdocdesc WHERE comp_cde=? AND sys_cde=? AND docdesc=? ");
			dbc.executeSql2(sql.getSql(), comp_cde, "FrmTkJobDoc", del_DOCDESC);
		}
	}

}
