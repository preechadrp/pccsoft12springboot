package com.pcc.gl.ui.acProfit;

import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;

import com.pcc.gl.progman.ManAcProfit;
import com.pcc.sys.lib.FJasperPrintList;
import com.pcc.sys.lib.FReport;
import com.pcc.sys.lib.FWinMenu;
import com.pcc.sys.lib.FnDate;
import com.pcc.sys.lib.Msg;

public class AcProfit extends FWinMenu {

	private static final long serialVersionUID = 1L;

	public Combobox cmbOption;
	public Datebox tdbFromPostdate, tdbToPostdate;

	public Button btnExit, btnPrint, btnSave, btnDelete, btnAdd;

	@Override
	public void setFormObj() {
		cmbOption = (Combobox) getFellow("cmbOption");
		tdbFromPostdate = (Datebox) getFellow("tdbFromPostdate");
		tdbToPostdate = (Datebox) getFellow("tdbToPostdate");

		btnExit = (Button) getFellow("btnExit");
		btnPrint = (Button) getFellow("btnPrint");
	}

	@Override
	public void addEnterIndex() {
		addEnterIndex(cmbOption);
		addEnterIndex(tdbFromPostdate);
		addEnterIndex(tdbToPostdate);
		addEnterIndex(btnPrint);

	}

	@Override
	public void formInit() {
		try {
			clearData();
		} catch (Exception e) {
			Msg.error(e);
		}
	}

	private void clearData() {
		cmbOption.setSelectedIndex(0);
		tdbFromPostdate.focus();
		onChange_cmbOption();
	}

	public void onOK() {
		try {
			super.onOK();
		} catch (Exception e) {
			Msg.error(e);
		}

	}

	private void validateData() throws Exception {

		if (tdbFromPostdate.getValue() == null) {
			throw new Exception("ระบุช่อง \"" + tdbFromPostdate.getTooltiptext() + "\" ");
		}
		
		if (cmbOption.getSelectedIndex() == 0) {
			if (tdbToPostdate.getValue() == null) {
				throw new Exception("ระบุช่อง \"" + tdbToPostdate.getTooltiptext() + "\" ");
			}
		}

	}
	
	public void onChange_cmbOption() {
		if (cmbOption.getSelectedIndex() == 0) {
			tdbToPostdate.setDisabled(false);
		} else {
			tdbToPostdate.setDisabled(true);
		}
	}

	public void onClick_btnPrint(int print_option) {

		try {

			validateData();
			FJasperPrintList fJasperPrintList = new FJasperPrintList();
			if (cmbOption.getSelectedIndex() == 0) {
				ManAcProfit.getReport(this.getLoginBean(), FnDate.getSqlDate(tdbFromPostdate.getValue()),
						FnDate.getSqlDate(tdbToPostdate.getValue()), fJasperPrintList, print_option);
			} else {
				ManAcProfit.getReport12m(this.getLoginBean(), FnDate.getSqlDate(tdbFromPostdate.getValue()),
						fJasperPrintList, print_option);
			}
			if (fJasperPrintList.getJasperPrintLst().size() > 0) {
				if (print_option == 1) {
					FReport.viewPdf(fJasperPrintList.getJasperPrintLst());
				} else {
					FReport.exportExcel(fJasperPrintList, "AcProfit");
				}
			} else {
				throw new Exception("ไม่พบข้อมูล");
			}

		} catch (Exception e) {
			Msg.error(e);
		}

	}

}
