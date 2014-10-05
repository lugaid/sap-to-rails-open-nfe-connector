package br.com.lugaid.params;

import java.io.Serializable;
import java.util.Date;

import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;

public class NfeXmlInImport implements Serializable {
	private static final long serialVersionUID = 337339270983782151L;

	// NFe Access Key
	private IAcckey iAcckey;
	// Authorization code for NFe
	private String iAuthcode;
	// NF-e Authorization Timestamp - Date
	private Date iAuthdate;
	// NF-e Authorization Timestamp - Time
	private Date iAuthtime;
	// Status code for NFe
	private String iCode;
	// Document number
	private Long iDocnum;
	// NF-e: Type of Inbound Message for Event
	private String iEventMsgtyp;
	// NF-e: Type of Inbound Message
	private String iMsgtyp;

	public NfeXmlInImport(IAcckey iAcckey, String iAuthcode, Date iAuthdate,
			Date iAuthtime, String iCode, Long iDocnum, String iEventMsgtyp,
			String iMsgtyp) {
		this.iAcckey = iAcckey;
		this.iAuthcode = iAuthcode;
		this.iAuthdate = iAuthdate;
		this.iAuthtime = iAuthtime;
		this.iCode = iCode;
		this.iDocnum = iDocnum;
		this.iEventMsgtyp = iEventMsgtyp;
		this.iMsgtyp = iMsgtyp;
	}

	public NfeXmlInImport(JCoParameterList jcoParam) {
		fillClassAttributes(jcoParam);
	}

	public void setIAcckey(IAcckey iAcckey) {
		this.iAcckey = iAcckey;
	}

	public IAcckey getIAcckey() {
		return this.iAcckey;
	}

	public void setIAuthcode(String iAuthcode) {
		this.iAuthcode = iAuthcode;
	}

	public String getIAuthcode() {
		return this.iAuthcode;
	}

	public void setIAuthdate(Date iAuthdate) {
		this.iAuthdate = iAuthdate;
	}

	public Date getIAuthdate() {
		return this.iAuthdate;
	}

	public void setIAuthtime(Date iAuthtime) {
		this.iAuthtime = iAuthtime;
	}

	public Date getIAuthtime() {
		return this.iAuthtime;
	}

	public void setICode(String iCode) {
		this.iCode = iCode;
	}

	public String getICode() {
		return this.iCode;
	}

	public void setIDocnum(Long iDocnum) {
		this.iDocnum = iDocnum;
	}

	public Long getIDocnum() {
		return this.iDocnum;
	}

	public void setIEventMsgtyp(String iEventMsgtyp) {
		this.iEventMsgtyp = iEventMsgtyp;
	}

	public String getIEventMsgtyp() {
		return this.iEventMsgtyp;
	}

	public void setIMsgtyp(String iMsgtyp) {
		this.iMsgtyp = iMsgtyp;
	}

	public String getIMsgtyp() {
		return this.iMsgtyp;
	}

	public void fillClassAttributes(JCoParameterList jcoParam) {
		this.iAcckey = new IAcckey(jcoParam.getStructure("I_ACCKEY"));
		this.iAuthcode = jcoParam.getString("I_AUTHCODE");
		this.iAuthdate = jcoParam.getDate("I_AUTHDATE");
		this.iAuthtime = jcoParam.getTime("I_AUTHTIME");
		this.iCode = jcoParam.getString("I_CODE");
		this.iDocnum = jcoParam.getLong("I_DOCNUM");
		this.iEventMsgtyp = jcoParam.getString("I_EVENT_MSGTYP");
		this.iMsgtyp = jcoParam.getString("I_MSGTYP");
	}

	public void fillJCoParameter(JCoParameterList jcoParam) {
		jcoParam.clear();
		JCoStructure jcoIAcckey = jcoParam.getStructure("I_ACCKEY");
		this.iAcckey.fillJCoParameter(jcoIAcckey);
		jcoParam.setValue("I_AUTHCODE", this.iAuthcode);
		jcoParam.setValue("I_AUTHDATE", this.iAuthdate);
		jcoParam.setValue("I_AUTHTIME", this.iAuthtime);
		jcoParam.setValue("I_CODE", this.iCode);
		jcoParam.setValue("I_DOCNUM", this.iDocnum);
		jcoParam.setValue("I_EVENT_MSGTYP", this.iEventMsgtyp);
		jcoParam.setValue("I_MSGTYP", this.iMsgtyp);
	}

	public static class IAcckey implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Region of NF-e Issuer
		private String regio;
		// Year of NF-e Posting Date
		private String nfyear;
		// Month of NF-e Posting Date
		private String nfmonth;
		// CNPJ Number of NF-e Issuer
		private String stcd1;
		// Model of Nota Fiscal
		private Long model;
		// Series
		private String serie;
		// Nine-Digit NF-e Number
		private String nfnum9;
		// NF-e: Random Number
		private String docnum9;
		// Check Digit for NF-e Access Key
		private String cdv;

		public IAcckey(String regio, String nfyear, String nfmonth,
				String stcd1, Long model, String serie, String nfnum9,
				String docnum9, String cdv) {
			this.regio = regio;
			this.nfyear = nfyear;
			this.nfmonth = nfmonth;
			this.stcd1 = stcd1;
			this.model = model;
			this.serie = serie;
			this.nfnum9 = nfnum9;
			this.docnum9 = docnum9;
			this.cdv = cdv;
		}

		public IAcckey(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setRegio(String regio) {
			this.regio = regio;
		}

		public String getRegio() {
			return this.regio;
		}

		public void setNfyear(String nfyear) {
			this.nfyear = nfyear;
		}

		public String getNfyear() {
			return this.nfyear;
		}

		public void setNfmonth(String nfmonth) {
			this.nfmonth = nfmonth;
		}

		public String getNfmonth() {
			return this.nfmonth;
		}

		public void setStcd1(String stcd1) {
			this.stcd1 = stcd1;
		}

		public String getStcd1() {
			return this.stcd1;
		}

		public void setModel(Long model) {
			this.model = model;
		}

		public Long getModel() {
			return this.model;
		}

		public void setSerie(String serie) {
			this.serie = serie;
		}

		public String getSerie() {
			return this.serie;
		}

		public void setNfnum9(String nfnum9) {
			this.nfnum9 = nfnum9;
		}

		public String getNfnum9() {
			return this.nfnum9;
		}

		public void setDocnum9(String docnum9) {
			this.docnum9 = docnum9;
		}

		public String getDocnum9() {
			return this.docnum9;
		}

		public void setCdv(String cdv) {
			this.cdv = cdv;
		}

		public String getCdv() {
			return this.cdv;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.regio = jcoParam.getString("REGIO");
			this.nfyear = jcoParam.getString("NFYEAR");
			this.nfmonth = jcoParam.getString("NFMONTH");
			this.stcd1 = jcoParam.getString("STCD1");
			this.model = jcoParam.getLong("MODEL");
			this.serie = jcoParam.getString("SERIE");
			this.nfnum9 = jcoParam.getString("NFNUM9");
			this.docnum9 = jcoParam.getString("DOCNUM9");
			this.cdv = jcoParam.getString("CDV");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("REGIO", this.regio);
			jcoParam.setValue("NFYEAR", this.nfyear);
			jcoParam.setValue("NFMONTH", this.nfmonth);
			jcoParam.setValue("STCD1", this.stcd1);
			jcoParam.setValue("MODEL", this.model);
			jcoParam.setValue("SERIE", this.serie);
			jcoParam.setValue("NFNUM9", this.nfnum9);
			jcoParam.setValue("DOCNUM9", this.docnum9);
			jcoParam.setValue("CDV", this.cdv);
		}

	}
}