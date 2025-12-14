package com.pcc.tk.ui.FrmTkJob;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.pcc.sys.beans.LoginBean;
import com.pcc.sys.lib.FModelHasMap;
import com.pcc.sys.lib.FWindow;
import com.pcc.sys.lib.Msg;
import com.pcc.sys.lib.ZkUtil;
import com.pcc.tk.progman.ManTkJob;

public class FrmTkDescManage1 extends FWindow {

	private static final long serialVersionUID = 1L;

	public static void showData(LoginBean loginBean, Window winCall, EventListener<Event> event1) throws Exception {

		FrmTkDescManage1 frm1 = (FrmTkDescManage1) ZkUtil.callZulFile("/com/pcc/tk/zul/FrmTkJob/FrmTkDescManage1.zul");

		//==parameter
		frm1.setLoginBean(loginBean);
		frm1.p_win_call = winCall;
		frm1.p_Event = event1;
		frm1.setPosition("top,center");
		frm1.doModal();

	}

	public Button btnExit;
	public Textbox txtDOCDESC;
	public Button btnShow;
	public Grid grdViewt;

	private java.util.List<FModelHasMap> lst_data = new java.util.ArrayList<FModelHasMap>();
	public Window p_win_call = null;
	public EventListener<Event> p_Event;

	@Override
	public void setFormObj() {
		btnExit = (Button) getFellow("btnExit");
		txtDOCDESC = (Textbox) getFellow("txtDOCDESC");
		btnShow = (Button) getFellow("btnShow");
		grdViewt = (Grid) getFellow("grdViewt");
	}

	@Override
	public void addEnterIndex() {
		addEnterIndex(btnExit);
		addEnterIndex(txtDOCDESC);
		addEnterIndex(btnShow);
	}

	@Override
	public void formInit() {
		try {
			ZkUtil.setGridHeaderStyle(grdViewt);
			grdViewt.setRowRenderer(getRowRendererView1());
			clearData();

			showGridViewt();
		} catch (Exception e) {
			e.printStackTrace();
			Msg.error(e);
		}

	}

	public void clearData() {
		grdViewt.getRows().getChildren().clear();
	}

	public void onOK() {
		try {
			super.onOK();
		} catch (Exception e) {
			e.printStackTrace();
			Msg.error(e);
		}

	}

	public void onClick_btnShow() {
		try {
			showGridViewt();
		} catch (Exception e) {
			Msg.error(e);
		}

	}

	private void showGridViewt() throws WrongValueException, Exception {

		FModelHasMap para = new FModelHasMap();
		para.put("DOCDESC", txtDOCDESC.getValue());
		ManTkJob.getTkFindDocdesc(this.getLoginBean().getCOMP_CDE(), para, lst_data);
		SimpleListModel rstModel = new SimpleListModel(lst_data);
		this.grdViewt.setModel(rstModel);

	}

	private RowRenderer<?> getRowRendererView1() {
		return (row, data, index) -> {

			FModelHasMap rs = (FModelHasMap) data;
			int seq = index + 1;
			row.setStyle(ZkUtil.styleFindLookUp);

			row.setAttribute("DATA1", rs);

			// == append child ==//

			Button btn1 = new Button();
			btn1.setLabel("ลบ");
			btn1.setSclass("buttondel");
			btn1.setAutodisable("self");
			btn1.addEventListener(Events.ON_CLICK, event -> onClick_DelJobRow(event));
			row.setAttribute("btn_del", btn1);
			row.appendChild(btn1);

			row.appendChild(ZkUtil.gridIntbox(seq));
			row.appendChild(ZkUtil.gridLabel(rs.getString("DOCDESC")));

		};
	}

	private void onClick_DelJobRow(Event event) {

		try {

			Component comp = event.getTarget().getParent();
			FModelHasMap sel_rs = (FModelHasMap) comp.getAttribute("DATA1");
			String sel_DOCDESC = sel_rs.getString("DOCDESC");

			Msg.confirm("ลบรายการ ?", "?", (event1) -> {
				if (Messagebox.Button.YES.equals(event1.getButton())) {
					try {
						ManTkJob.getTkDelDocdesc(this.getLoginBean().getCOMP_CDE(), sel_DOCDESC);
						showGridViewt();
						if (p_Event != null) {
							p_Event.onEvent(new Event(Events.ON_CLICK, null, -1));
						}
					} catch (Exception ex) {
						Msg.error(ex);
					}
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
			Msg.error(ex);
		}

	}

}
