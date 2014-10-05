package br.com.lugaid.params;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class NfeCreateImport implements Serializable {
	private static final long serialVersionUID = 337339270983782151L;

	// NF-e Avulsa
	private IsNfeAvulsa isNfeAvulsa;
	// NF-e Data - HEADER - Sugar Cane
	private IsNfeCana isNfeCana;
	// NF-e purchase header structure
	private IsNfeCompra isNfeCompra;
	// Export structure for NF-e
	private IsNfeExporta isNfeExporta;
	// Billing - Block Y
	private IsNfeFat isNfeFat;
	// NF-e Header - RFC Interface
	private IsNfeHeader isNfeHeader;
	// Totals for the ICMS - Block W
	private IsNfeIcmstot isNfeIcmstot;
	// NF-e RFC IDE Information: Block B
	private IsNfeIde isNfeIde;
	// Additional Information
	private IsNfeInfadic isNfeInfadic;
	// Totals for the ISSQN - Block V
	private IsNfeIssqntot isNfeIssqntot;
	// NF-e RFC Partner IDs
	private IsNfePartnerIds isNfePartnerIds;
	// Withholding taxes - Block V
	private IsNfeRettrib isNfeRettrib;
	// Transport - Block X
	private IsNfeTransp isNfeTransp;
	// NF-e Authorization Download
	private List<ItNfeAutxml> itNfeAutxmls;
	// NF-e XML, Daily Sugar Cane Supply Group
	private List<ItNfeCanaFordia> itNfeCanaFordias;
	// NF-e RFC Product and Services Detail
	private List<ItNfeDet> itNfeDets;
	// Total Tax - Block W
	private List<ItNfeDetImposto> itNfeDetImpostos;
	// NF-e RFC Product Detail Information
	private List<ItNfeDetProd> itNfeDetProds;
	// NF-e Additions of DI
	private List<ItNfeDiAdi> itNfeDiAdis;
	// Duplicate collection - Block Y
	private List<ItNfeDup> itNfeDups;
	// NF-e Container1 for &#39;Customer Exit&#39; Parameter
	private List<ItNfeExt1> itNfeExt1s;
	// NF-e Container2 for &#39;Customer Exit&#39; Parameter
	private List<ItNfeExt2> itNfeExt2s;
	// COFINS - Block S
	private List<ItNfeImpostoCofins> itNfeImpostoCofinss;
	// COFINS ST - Block T
	private List<ItNfeImpostoCofinsst> itNfeImpostoCofinssts;
	// ICMS and ICMS ST Tax - Block N
	private List<ItNfeImpostoIcms> itNfeImpostoIcmss;
	// Import tax - Block P
	private List<ItNfeImpostoIi> itNfeImpostoIis;
	// IPI Tax - Block
	private List<ItNfeImpostoIpi> itNfeImpostoIpis;
	// ISSQN - Block U
	private List<ItNfeImpostoIssqn> itNfeImpostoIssqns;
	// PIS - Block Q
	private List<ItNfeImpostoPis> itNfeImpostoPiss;
	// PIS ST - Block R
	private List<ItNfeImpostoPisst> itNfeImpostoPissts;
	// NF-e RFC NF Reference
	private List<ItNfeNfref> itNfeNfrefs;
	// Payment type table
	private List<ItNfePag> itNfePags;
	// NF-e RFC Partner List - block
	private List<ItNfePartner> itNfePartners;
	// NF-e XML, Referenced Processes
	private List<ItNfeProcref> itNfeProcrefs;
	// Specific detailing of weapons
	private List<ItNfeProdArma> itNfeProdArmas;
	// Specific Information for liquid fuels and lubricants
	private List<ItNfeProdComb> itNfeProdCombs;
	// Product Exportation Group - Block I03
	private List<ItNfeProdDetexport> itNfeProdDetexports;
	// NF-e Product DI
	private List<ItNfeProdDi> itNfeProdDis;
	// Medicine Detail
	private List<ItNfeProdMed> itNfeProdMeds;
	// RECOPI Number
	private List<ItNfeProdNrecopi> itNfeProdNrecopis;
	// NF-e New Vehicle&#39;s Detail
	private List<ItNfeProdVeicprod> itNfeProdVeicprods;
	// Tow transport - Block X
	private List<ItNfeReboque> itNfeReboques;
	// NF-e RFC Text
	private List<ItNfeText> itNfeTexts;
	// NF-e RFC Value
	private List<ItNfeValue> itNfeValues;
	// Volume Transport - Block X
	private List<ItNfeVol> itNfeVols;
	// General Flag
	private String ivResend;

	public NfeCreateImport(IsNfeAvulsa isNfeAvulsa, IsNfeCana isNfeCana,
			IsNfeCompra isNfeCompra, IsNfeExporta isNfeExporta,
			IsNfeFat isNfeFat, IsNfeHeader isNfeHeader,
			IsNfeIcmstot isNfeIcmstot, IsNfeIde isNfeIde,
			IsNfeInfadic isNfeInfadic, IsNfeIssqntot isNfeIssqntot,
			IsNfePartnerIds isNfePartnerIds, IsNfeRettrib isNfeRettrib,
			IsNfeTransp isNfeTransp, List<ItNfeAutxml> itNfeAutxmls,
			List<ItNfeCanaFordia> itNfeCanaFordias, List<ItNfeDet> itNfeDets,
			List<ItNfeDetImposto> itNfeDetImpostos,
			List<ItNfeDetProd> itNfeDetProds, List<ItNfeDiAdi> itNfeDiAdis,
			List<ItNfeDup> itNfeDups, List<ItNfeExt1> itNfeExt1s,
			List<ItNfeExt2> itNfeExt2s,
			List<ItNfeImpostoCofins> itNfeImpostoCofinss,
			List<ItNfeImpostoCofinsst> itNfeImpostoCofinssts,
			List<ItNfeImpostoIcms> itNfeImpostoIcmss,
			List<ItNfeImpostoIi> itNfeImpostoIis,
			List<ItNfeImpostoIpi> itNfeImpostoIpis,
			List<ItNfeImpostoIssqn> itNfeImpostoIssqns,
			List<ItNfeImpostoPis> itNfeImpostoPiss,
			List<ItNfeImpostoPisst> itNfeImpostoPissts,
			List<ItNfeNfref> itNfeNfrefs, List<ItNfePag> itNfePags,
			List<ItNfePartner> itNfePartners, List<ItNfeProcref> itNfeProcrefs,
			List<ItNfeProdArma> itNfeProdArmas,
			List<ItNfeProdComb> itNfeProdCombs,
			List<ItNfeProdDetexport> itNfeProdDetexports,
			List<ItNfeProdDi> itNfeProdDis, List<ItNfeProdMed> itNfeProdMeds,
			List<ItNfeProdNrecopi> itNfeProdNrecopis,
			List<ItNfeProdVeicprod> itNfeProdVeicprods,
			List<ItNfeReboque> itNfeReboques, List<ItNfeText> itNfeTexts,
			List<ItNfeValue> itNfeValues, List<ItNfeVol> itNfeVols,
			String ivResend) {
		this.isNfeAvulsa = isNfeAvulsa;
		this.isNfeCana = isNfeCana;
		this.isNfeCompra = isNfeCompra;
		this.isNfeExporta = isNfeExporta;
		this.isNfeFat = isNfeFat;
		this.isNfeHeader = isNfeHeader;
		this.isNfeIcmstot = isNfeIcmstot;
		this.isNfeIde = isNfeIde;
		this.isNfeInfadic = isNfeInfadic;
		this.isNfeIssqntot = isNfeIssqntot;
		this.isNfePartnerIds = isNfePartnerIds;
		this.isNfeRettrib = isNfeRettrib;
		this.isNfeTransp = isNfeTransp;
		this.itNfeAutxmls = itNfeAutxmls;
		this.itNfeCanaFordias = itNfeCanaFordias;
		this.itNfeDets = itNfeDets;
		this.itNfeDetImpostos = itNfeDetImpostos;
		this.itNfeDetProds = itNfeDetProds;
		this.itNfeDiAdis = itNfeDiAdis;
		this.itNfeDups = itNfeDups;
		this.itNfeExt1s = itNfeExt1s;
		this.itNfeExt2s = itNfeExt2s;
		this.itNfeImpostoCofinss = itNfeImpostoCofinss;
		this.itNfeImpostoCofinssts = itNfeImpostoCofinssts;
		this.itNfeImpostoIcmss = itNfeImpostoIcmss;
		this.itNfeImpostoIis = itNfeImpostoIis;
		this.itNfeImpostoIpis = itNfeImpostoIpis;
		this.itNfeImpostoIssqns = itNfeImpostoIssqns;
		this.itNfeImpostoPiss = itNfeImpostoPiss;
		this.itNfeImpostoPissts = itNfeImpostoPissts;
		this.itNfeNfrefs = itNfeNfrefs;
		this.itNfePags = itNfePags;
		this.itNfePartners = itNfePartners;
		this.itNfeProcrefs = itNfeProcrefs;
		this.itNfeProdArmas = itNfeProdArmas;
		this.itNfeProdCombs = itNfeProdCombs;
		this.itNfeProdDetexports = itNfeProdDetexports;
		this.itNfeProdDis = itNfeProdDis;
		this.itNfeProdMeds = itNfeProdMeds;
		this.itNfeProdNrecopis = itNfeProdNrecopis;
		this.itNfeProdVeicprods = itNfeProdVeicprods;
		this.itNfeReboques = itNfeReboques;
		this.itNfeTexts = itNfeTexts;
		this.itNfeValues = itNfeValues;
		this.itNfeVols = itNfeVols;
		this.ivResend = ivResend;
	}

	public NfeCreateImport(JCoParameterList jcoParam) {
		fillClassAttributes(jcoParam);
	}

	public void setIsNfeAvulsa(IsNfeAvulsa isNfeAvulsa) {
		this.isNfeAvulsa = isNfeAvulsa;
	}

	public IsNfeAvulsa getIsNfeAvulsa() {
		return this.isNfeAvulsa;
	}

	public void setIsNfeCana(IsNfeCana isNfeCana) {
		this.isNfeCana = isNfeCana;
	}

	public IsNfeCana getIsNfeCana() {
		return this.isNfeCana;
	}

	public void setIsNfeCompra(IsNfeCompra isNfeCompra) {
		this.isNfeCompra = isNfeCompra;
	}

	public IsNfeCompra getIsNfeCompra() {
		return this.isNfeCompra;
	}

	public void setIsNfeExporta(IsNfeExporta isNfeExporta) {
		this.isNfeExporta = isNfeExporta;
	}

	public IsNfeExporta getIsNfeExporta() {
		return this.isNfeExporta;
	}

	public void setIsNfeFat(IsNfeFat isNfeFat) {
		this.isNfeFat = isNfeFat;
	}

	public IsNfeFat getIsNfeFat() {
		return this.isNfeFat;
	}

	public void setIsNfeHeader(IsNfeHeader isNfeHeader) {
		this.isNfeHeader = isNfeHeader;
	}

	public IsNfeHeader getIsNfeHeader() {
		return this.isNfeHeader;
	}

	public void setIsNfeIcmstot(IsNfeIcmstot isNfeIcmstot) {
		this.isNfeIcmstot = isNfeIcmstot;
	}

	public IsNfeIcmstot getIsNfeIcmstot() {
		return this.isNfeIcmstot;
	}

	public void setIsNfeIde(IsNfeIde isNfeIde) {
		this.isNfeIde = isNfeIde;
	}

	public IsNfeIde getIsNfeIde() {
		return this.isNfeIde;
	}

	public void setIsNfeInfadic(IsNfeInfadic isNfeInfadic) {
		this.isNfeInfadic = isNfeInfadic;
	}

	public IsNfeInfadic getIsNfeInfadic() {
		return this.isNfeInfadic;
	}

	public void setIsNfeIssqntot(IsNfeIssqntot isNfeIssqntot) {
		this.isNfeIssqntot = isNfeIssqntot;
	}

	public IsNfeIssqntot getIsNfeIssqntot() {
		return this.isNfeIssqntot;
	}

	public void setIsNfePartnerIds(IsNfePartnerIds isNfePartnerIds) {
		this.isNfePartnerIds = isNfePartnerIds;
	}

	public IsNfePartnerIds getIsNfePartnerIds() {
		return this.isNfePartnerIds;
	}

	public void setIsNfeRettrib(IsNfeRettrib isNfeRettrib) {
		this.isNfeRettrib = isNfeRettrib;
	}

	public IsNfeRettrib getIsNfeRettrib() {
		return this.isNfeRettrib;
	}

	public void setIsNfeTransp(IsNfeTransp isNfeTransp) {
		this.isNfeTransp = isNfeTransp;
	}

	public IsNfeTransp getIsNfeTransp() {
		return this.isNfeTransp;
	}

	public void setItNfeAutxmls(List<ItNfeAutxml> itNfeAutxmls) {
		this.itNfeAutxmls = itNfeAutxmls;
	}

	public List<ItNfeAutxml> getItNfeAutxmls() {
		return this.itNfeAutxmls;
	}

	public void setItNfeCanaFordias(List<ItNfeCanaFordia> itNfeCanaFordias) {
		this.itNfeCanaFordias = itNfeCanaFordias;
	}

	public List<ItNfeCanaFordia> getItNfeCanaFordias() {
		return this.itNfeCanaFordias;
	}

	public void setItNfeDets(List<ItNfeDet> itNfeDets) {
		this.itNfeDets = itNfeDets;
	}

	public List<ItNfeDet> getItNfeDets() {
		return this.itNfeDets;
	}

	public void setItNfeDetImpostos(List<ItNfeDetImposto> itNfeDetImpostos) {
		this.itNfeDetImpostos = itNfeDetImpostos;
	}

	public List<ItNfeDetImposto> getItNfeDetImpostos() {
		return this.itNfeDetImpostos;
	}

	public void setItNfeDetProds(List<ItNfeDetProd> itNfeDetProds) {
		this.itNfeDetProds = itNfeDetProds;
	}

	public List<ItNfeDetProd> getItNfeDetProds() {
		return this.itNfeDetProds;
	}

	public void setItNfeDiAdis(List<ItNfeDiAdi> itNfeDiAdis) {
		this.itNfeDiAdis = itNfeDiAdis;
	}

	public List<ItNfeDiAdi> getItNfeDiAdis() {
		return this.itNfeDiAdis;
	}

	public void setItNfeDups(List<ItNfeDup> itNfeDups) {
		this.itNfeDups = itNfeDups;
	}

	public List<ItNfeDup> getItNfeDups() {
		return this.itNfeDups;
	}

	public void setItNfeExt1s(List<ItNfeExt1> itNfeExt1s) {
		this.itNfeExt1s = itNfeExt1s;
	}

	public List<ItNfeExt1> getItNfeExt1s() {
		return this.itNfeExt1s;
	}

	public void setItNfeExt2s(List<ItNfeExt2> itNfeExt2s) {
		this.itNfeExt2s = itNfeExt2s;
	}

	public List<ItNfeExt2> getItNfeExt2s() {
		return this.itNfeExt2s;
	}

	public void setItNfeImpostoCofinss(
			List<ItNfeImpostoCofins> itNfeImpostoCofinss) {
		this.itNfeImpostoCofinss = itNfeImpostoCofinss;
	}

	public List<ItNfeImpostoCofins> getItNfeImpostoCofinss() {
		return this.itNfeImpostoCofinss;
	}

	public void setItNfeImpostoCofinssts(
			List<ItNfeImpostoCofinsst> itNfeImpostoCofinssts) {
		this.itNfeImpostoCofinssts = itNfeImpostoCofinssts;
	}

	public List<ItNfeImpostoCofinsst> getItNfeImpostoCofinssts() {
		return this.itNfeImpostoCofinssts;
	}

	public void setItNfeImpostoIcmss(List<ItNfeImpostoIcms> itNfeImpostoIcmss) {
		this.itNfeImpostoIcmss = itNfeImpostoIcmss;
	}

	public List<ItNfeImpostoIcms> getItNfeImpostoIcmss() {
		return this.itNfeImpostoIcmss;
	}

	public void setItNfeImpostoIis(List<ItNfeImpostoIi> itNfeImpostoIis) {
		this.itNfeImpostoIis = itNfeImpostoIis;
	}

	public List<ItNfeImpostoIi> getItNfeImpostoIis() {
		return this.itNfeImpostoIis;
	}

	public void setItNfeImpostoIpis(List<ItNfeImpostoIpi> itNfeImpostoIpis) {
		this.itNfeImpostoIpis = itNfeImpostoIpis;
	}

	public List<ItNfeImpostoIpi> getItNfeImpostoIpis() {
		return this.itNfeImpostoIpis;
	}

	public void setItNfeImpostoIssqns(List<ItNfeImpostoIssqn> itNfeImpostoIssqns) {
		this.itNfeImpostoIssqns = itNfeImpostoIssqns;
	}

	public List<ItNfeImpostoIssqn> getItNfeImpostoIssqns() {
		return this.itNfeImpostoIssqns;
	}

	public void setItNfeImpostoPiss(List<ItNfeImpostoPis> itNfeImpostoPiss) {
		this.itNfeImpostoPiss = itNfeImpostoPiss;
	}

	public List<ItNfeImpostoPis> getItNfeImpostoPiss() {
		return this.itNfeImpostoPiss;
	}

	public void setItNfeImpostoPissts(List<ItNfeImpostoPisst> itNfeImpostoPissts) {
		this.itNfeImpostoPissts = itNfeImpostoPissts;
	}

	public List<ItNfeImpostoPisst> getItNfeImpostoPissts() {
		return this.itNfeImpostoPissts;
	}

	public void setItNfeNfrefs(List<ItNfeNfref> itNfeNfrefs) {
		this.itNfeNfrefs = itNfeNfrefs;
	}

	public List<ItNfeNfref> getItNfeNfrefs() {
		return this.itNfeNfrefs;
	}

	public void setItNfePags(List<ItNfePag> itNfePags) {
		this.itNfePags = itNfePags;
	}

	public List<ItNfePag> getItNfePags() {
		return this.itNfePags;
	}

	public void setItNfePartners(List<ItNfePartner> itNfePartners) {
		this.itNfePartners = itNfePartners;
	}

	public List<ItNfePartner> getItNfePartners() {
		return this.itNfePartners;
	}

	public void setItNfeProcrefs(List<ItNfeProcref> itNfeProcrefs) {
		this.itNfeProcrefs = itNfeProcrefs;
	}

	public List<ItNfeProcref> getItNfeProcrefs() {
		return this.itNfeProcrefs;
	}

	public void setItNfeProdArmas(List<ItNfeProdArma> itNfeProdArmas) {
		this.itNfeProdArmas = itNfeProdArmas;
	}

	public List<ItNfeProdArma> getItNfeProdArmas() {
		return this.itNfeProdArmas;
	}

	public void setItNfeProdCombs(List<ItNfeProdComb> itNfeProdCombs) {
		this.itNfeProdCombs = itNfeProdCombs;
	}

	public List<ItNfeProdComb> getItNfeProdCombs() {
		return this.itNfeProdCombs;
	}

	public void setItNfeProdDetexports(
			List<ItNfeProdDetexport> itNfeProdDetexports) {
		this.itNfeProdDetexports = itNfeProdDetexports;
	}

	public List<ItNfeProdDetexport> getItNfeProdDetexports() {
		return this.itNfeProdDetexports;
	}

	public void setItNfeProdDis(List<ItNfeProdDi> itNfeProdDis) {
		this.itNfeProdDis = itNfeProdDis;
	}

	public List<ItNfeProdDi> getItNfeProdDis() {
		return this.itNfeProdDis;
	}

	public void setItNfeProdMeds(List<ItNfeProdMed> itNfeProdMeds) {
		this.itNfeProdMeds = itNfeProdMeds;
	}

	public List<ItNfeProdMed> getItNfeProdMeds() {
		return this.itNfeProdMeds;
	}

	public void setItNfeProdNrecopis(List<ItNfeProdNrecopi> itNfeProdNrecopis) {
		this.itNfeProdNrecopis = itNfeProdNrecopis;
	}

	public List<ItNfeProdNrecopi> getItNfeProdNrecopis() {
		return this.itNfeProdNrecopis;
	}

	public void setItNfeProdVeicprods(List<ItNfeProdVeicprod> itNfeProdVeicprods) {
		this.itNfeProdVeicprods = itNfeProdVeicprods;
	}

	public List<ItNfeProdVeicprod> getItNfeProdVeicprods() {
		return this.itNfeProdVeicprods;
	}

	public void setItNfeReboques(List<ItNfeReboque> itNfeReboques) {
		this.itNfeReboques = itNfeReboques;
	}

	public List<ItNfeReboque> getItNfeReboques() {
		return this.itNfeReboques;
	}

	public void setItNfeTexts(List<ItNfeText> itNfeTexts) {
		this.itNfeTexts = itNfeTexts;
	}

	public List<ItNfeText> getItNfeTexts() {
		return this.itNfeTexts;
	}

	public void setItNfeValues(List<ItNfeValue> itNfeValues) {
		this.itNfeValues = itNfeValues;
	}

	public List<ItNfeValue> getItNfeValues() {
		return this.itNfeValues;
	}

	public void setItNfeVols(List<ItNfeVol> itNfeVols) {
		this.itNfeVols = itNfeVols;
	}

	public List<ItNfeVol> getItNfeVols() {
		return this.itNfeVols;
	}

	public void setIvResend(String ivResend) {
		this.ivResend = ivResend;
	}

	public String getIvResend() {
		return this.ivResend;
	}

	public void fillClassAttributes(JCoParameterList jcoParam) {
		this.isNfeAvulsa = new IsNfeAvulsa(
				jcoParam.getStructure("IS_NFE_AVULSA"));
		this.isNfeCana = new IsNfeCana(jcoParam.getStructure("IS_NFE_CANA"));
		this.isNfeCompra = new IsNfeCompra(
				jcoParam.getStructure("IS_NFE_COMPRA"));
		this.isNfeExporta = new IsNfeExporta(
				jcoParam.getStructure("IS_NFE_EXPORTA"));
		this.isNfeFat = new IsNfeFat(jcoParam.getStructure("IS_NFE_FAT"));
		this.isNfeHeader = new IsNfeHeader(
				jcoParam.getStructure("IS_NFE_HEADER"));
		this.isNfeIcmstot = new IsNfeIcmstot(
				jcoParam.getStructure("IS_NFE_ICMSTOT"));
		this.isNfeIde = new IsNfeIde(jcoParam.getStructure("IS_NFE_IDE"));
		this.isNfeInfadic = new IsNfeInfadic(
				jcoParam.getStructure("IS_NFE_INFADIC"));
		this.isNfeIssqntot = new IsNfeIssqntot(
				jcoParam.getStructure("IS_NFE_ISSQNTOT"));
		this.isNfePartnerIds = new IsNfePartnerIds(
				jcoParam.getStructure("IS_NFE_PARTNER_IDS"));
		this.isNfeRettrib = new IsNfeRettrib(
				jcoParam.getStructure("IS_NFE_RETTRIB"));
		this.isNfeTransp = new IsNfeTransp(
				jcoParam.getStructure("IS_NFE_TRANSP"));
		this.itNfeAutxmls = new ArrayList<>();
		JCoTable jcoItNfeAutxml = jcoParam.getTable("IT_NFE_AUTXML");
		jcoItNfeAutxml.firstRow();
		for (int i = 0; i < jcoItNfeAutxml.getNumRows(); jcoItNfeAutxml
				.nextRow()) {
			this.itNfeAutxmls.add(new ItNfeAutxml(jcoItNfeAutxml));
			i++;
		}
		this.itNfeCanaFordias = new ArrayList<>();
		JCoTable jcoItNfeCanaFordia = jcoParam.getTable("IT_NFE_CANA_FORDIA");
		jcoItNfeCanaFordia.firstRow();
		for (int i = 0; i < jcoItNfeCanaFordia.getNumRows(); jcoItNfeCanaFordia
				.nextRow()) {
			this.itNfeCanaFordias.add(new ItNfeCanaFordia(jcoItNfeCanaFordia));
			i++;
		}
		this.itNfeDets = new ArrayList<>();
		JCoTable jcoItNfeDet = jcoParam.getTable("IT_NFE_DET");
		jcoItNfeDet.firstRow();
		for (int i = 0; i < jcoItNfeDet.getNumRows(); jcoItNfeDet.nextRow()) {
			this.itNfeDets.add(new ItNfeDet(jcoItNfeDet));
			i++;
		}
		this.itNfeDetImpostos = new ArrayList<>();
		JCoTable jcoItNfeDetImposto = jcoParam.getTable("IT_NFE_DET_IMPOSTO");
		jcoItNfeDetImposto.firstRow();
		for (int i = 0; i < jcoItNfeDetImposto.getNumRows(); jcoItNfeDetImposto
				.nextRow()) {
			this.itNfeDetImpostos.add(new ItNfeDetImposto(jcoItNfeDetImposto));
			i++;
		}
		this.itNfeDetProds = new ArrayList<>();
		JCoTable jcoItNfeDetProd = jcoParam.getTable("IT_NFE_DET_PROD");
		jcoItNfeDetProd.firstRow();
		for (int i = 0; i < jcoItNfeDetProd.getNumRows(); jcoItNfeDetProd
				.nextRow()) {
			this.itNfeDetProds.add(new ItNfeDetProd(jcoItNfeDetProd));
			i++;
		}
		this.itNfeDiAdis = new ArrayList<>();
		JCoTable jcoItNfeDiAdi = jcoParam.getTable("IT_NFE_DI_ADI");
		jcoItNfeDiAdi.firstRow();
		for (int i = 0; i < jcoItNfeDiAdi.getNumRows(); jcoItNfeDiAdi.nextRow()) {
			this.itNfeDiAdis.add(new ItNfeDiAdi(jcoItNfeDiAdi));
			i++;
		}
		this.itNfeDups = new ArrayList<>();
		JCoTable jcoItNfeDup = jcoParam.getTable("IT_NFE_DUP");
		jcoItNfeDup.firstRow();
		for (int i = 0; i < jcoItNfeDup.getNumRows(); jcoItNfeDup.nextRow()) {
			this.itNfeDups.add(new ItNfeDup(jcoItNfeDup));
			i++;
		}
		this.itNfeExt1s = new ArrayList<>();
		JCoTable jcoItNfeExt1 = jcoParam.getTable("IT_NFE_EXT1");
		jcoItNfeExt1.firstRow();
		for (int i = 0; i < jcoItNfeExt1.getNumRows(); jcoItNfeExt1.nextRow()) {
			this.itNfeExt1s.add(new ItNfeExt1(jcoItNfeExt1));
			i++;
		}
		this.itNfeExt2s = new ArrayList<>();
		JCoTable jcoItNfeExt2 = jcoParam.getTable("IT_NFE_EXT2");
		jcoItNfeExt2.firstRow();
		for (int i = 0; i < jcoItNfeExt2.getNumRows(); jcoItNfeExt2.nextRow()) {
			this.itNfeExt2s.add(new ItNfeExt2(jcoItNfeExt2));
			i++;
		}
		this.itNfeImpostoCofinss = new ArrayList<>();
		JCoTable jcoItNfeImpostoCofins = jcoParam
				.getTable("IT_NFE_IMPOSTO_COFINS");
		jcoItNfeImpostoCofins.firstRow();
		for (int i = 0; i < jcoItNfeImpostoCofins.getNumRows(); jcoItNfeImpostoCofins
				.nextRow()) {
			this.itNfeImpostoCofinss.add(new ItNfeImpostoCofins(
					jcoItNfeImpostoCofins));
			i++;
		}
		this.itNfeImpostoCofinssts = new ArrayList<>();
		JCoTable jcoItNfeImpostoCofinsst = jcoParam
				.getTable("IT_NFE_IMPOSTO_COFINSST");
		jcoItNfeImpostoCofinsst.firstRow();
		for (int i = 0; i < jcoItNfeImpostoCofinsst.getNumRows(); jcoItNfeImpostoCofinsst
				.nextRow()) {
			this.itNfeImpostoCofinssts.add(new ItNfeImpostoCofinsst(
					jcoItNfeImpostoCofinsst));
			i++;
		}
		this.itNfeImpostoIcmss = new ArrayList<>();
		JCoTable jcoItNfeImpostoIcms = jcoParam.getTable("IT_NFE_IMPOSTO_ICMS");
		jcoItNfeImpostoIcms.firstRow();
		for (int i = 0; i < jcoItNfeImpostoIcms.getNumRows(); jcoItNfeImpostoIcms
				.nextRow()) {
			this.itNfeImpostoIcmss
					.add(new ItNfeImpostoIcms(jcoItNfeImpostoIcms));
			i++;
		}
		this.itNfeImpostoIis = new ArrayList<>();
		JCoTable jcoItNfeImpostoIi = jcoParam.getTable("IT_NFE_IMPOSTO_II");
		jcoItNfeImpostoIi.firstRow();
		for (int i = 0; i < jcoItNfeImpostoIi.getNumRows(); jcoItNfeImpostoIi
				.nextRow()) {
			this.itNfeImpostoIis.add(new ItNfeImpostoIi(jcoItNfeImpostoIi));
			i++;
		}
		this.itNfeImpostoIpis = new ArrayList<>();
		JCoTable jcoItNfeImpostoIpi = jcoParam.getTable("IT_NFE_IMPOSTO_IPI");
		jcoItNfeImpostoIpi.firstRow();
		for (int i = 0; i < jcoItNfeImpostoIpi.getNumRows(); jcoItNfeImpostoIpi
				.nextRow()) {
			this.itNfeImpostoIpis.add(new ItNfeImpostoIpi(jcoItNfeImpostoIpi));
			i++;
		}
		this.itNfeImpostoIssqns = new ArrayList<>();
		JCoTable jcoItNfeImpostoIssqn = jcoParam
				.getTable("IT_NFE_IMPOSTO_ISSQN");
		jcoItNfeImpostoIssqn.firstRow();
		for (int i = 0; i < jcoItNfeImpostoIssqn.getNumRows(); jcoItNfeImpostoIssqn
				.nextRow()) {
			this.itNfeImpostoIssqns.add(new ItNfeImpostoIssqn(
					jcoItNfeImpostoIssqn));
			i++;
		}
		this.itNfeImpostoPiss = new ArrayList<>();
		JCoTable jcoItNfeImpostoPis = jcoParam.getTable("IT_NFE_IMPOSTO_PIS");
		jcoItNfeImpostoPis.firstRow();
		for (int i = 0; i < jcoItNfeImpostoPis.getNumRows(); jcoItNfeImpostoPis
				.nextRow()) {
			this.itNfeImpostoPiss.add(new ItNfeImpostoPis(jcoItNfeImpostoPis));
			i++;
		}
		this.itNfeImpostoPissts = new ArrayList<>();
		JCoTable jcoItNfeImpostoPisst = jcoParam
				.getTable("IT_NFE_IMPOSTO_PISST");
		jcoItNfeImpostoPisst.firstRow();
		for (int i = 0; i < jcoItNfeImpostoPisst.getNumRows(); jcoItNfeImpostoPisst
				.nextRow()) {
			this.itNfeImpostoPissts.add(new ItNfeImpostoPisst(
					jcoItNfeImpostoPisst));
			i++;
		}
		this.itNfeNfrefs = new ArrayList<>();
		JCoTable jcoItNfeNfref = jcoParam.getTable("IT_NFE_NFREF");
		jcoItNfeNfref.firstRow();
		for (int i = 0; i < jcoItNfeNfref.getNumRows(); jcoItNfeNfref.nextRow()) {
			this.itNfeNfrefs.add(new ItNfeNfref(jcoItNfeNfref));
			i++;
		}
		this.itNfePags = new ArrayList<>();
		JCoTable jcoItNfePag = jcoParam.getTable("IT_NFE_PAG");
		jcoItNfePag.firstRow();
		for (int i = 0; i < jcoItNfePag.getNumRows(); jcoItNfePag.nextRow()) {
			this.itNfePags.add(new ItNfePag(jcoItNfePag));
			i++;
		}
		this.itNfePartners = new ArrayList<>();
		JCoTable jcoItNfePartner = jcoParam.getTable("IT_NFE_PARTNER");
		jcoItNfePartner.firstRow();
		for (int i = 0; i < jcoItNfePartner.getNumRows(); jcoItNfePartner
				.nextRow()) {
			this.itNfePartners.add(new ItNfePartner(jcoItNfePartner));
			i++;
		}
		this.itNfeProcrefs = new ArrayList<>();
		JCoTable jcoItNfeProcref = jcoParam.getTable("IT_NFE_PROCREF");
		jcoItNfeProcref.firstRow();
		for (int i = 0; i < jcoItNfeProcref.getNumRows(); jcoItNfeProcref
				.nextRow()) {
			this.itNfeProcrefs.add(new ItNfeProcref(jcoItNfeProcref));
			i++;
		}
		this.itNfeProdArmas = new ArrayList<>();
		JCoTable jcoItNfeProdArma = jcoParam.getTable("IT_NFE_PROD_ARMA");
		jcoItNfeProdArma.firstRow();
		for (int i = 0; i < jcoItNfeProdArma.getNumRows(); jcoItNfeProdArma
				.nextRow()) {
			this.itNfeProdArmas.add(new ItNfeProdArma(jcoItNfeProdArma));
			i++;
		}
		this.itNfeProdCombs = new ArrayList<>();
		JCoTable jcoItNfeProdComb = jcoParam.getTable("IT_NFE_PROD_COMB");
		jcoItNfeProdComb.firstRow();
		for (int i = 0; i < jcoItNfeProdComb.getNumRows(); jcoItNfeProdComb
				.nextRow()) {
			this.itNfeProdCombs.add(new ItNfeProdComb(jcoItNfeProdComb));
			i++;
		}
		this.itNfeProdDetexports = new ArrayList<>();
		JCoTable jcoItNfeProdDetexport = jcoParam
				.getTable("IT_NFE_PROD_DETEXPORT");
		jcoItNfeProdDetexport.firstRow();
		for (int i = 0; i < jcoItNfeProdDetexport.getNumRows(); jcoItNfeProdDetexport
				.nextRow()) {
			this.itNfeProdDetexports.add(new ItNfeProdDetexport(
					jcoItNfeProdDetexport));
			i++;
		}
		this.itNfeProdDis = new ArrayList<>();
		JCoTable jcoItNfeProdDi = jcoParam.getTable("IT_NFE_PROD_DI");
		jcoItNfeProdDi.firstRow();
		for (int i = 0; i < jcoItNfeProdDi.getNumRows(); jcoItNfeProdDi
				.nextRow()) {
			this.itNfeProdDis.add(new ItNfeProdDi(jcoItNfeProdDi));
			i++;
		}
		this.itNfeProdMeds = new ArrayList<>();
		JCoTable jcoItNfeProdMed = jcoParam.getTable("IT_NFE_PROD_MED");
		jcoItNfeProdMed.firstRow();
		for (int i = 0; i < jcoItNfeProdMed.getNumRows(); jcoItNfeProdMed
				.nextRow()) {
			this.itNfeProdMeds.add(new ItNfeProdMed(jcoItNfeProdMed));
			i++;
		}
		this.itNfeProdNrecopis = new ArrayList<>();
		JCoTable jcoItNfeProdNrecopi = jcoParam.getTable("IT_NFE_PROD_NRECOPI");
		jcoItNfeProdNrecopi.firstRow();
		for (int i = 0; i < jcoItNfeProdNrecopi.getNumRows(); jcoItNfeProdNrecopi
				.nextRow()) {
			this.itNfeProdNrecopis
					.add(new ItNfeProdNrecopi(jcoItNfeProdNrecopi));
			i++;
		}
		this.itNfeProdVeicprods = new ArrayList<>();
		JCoTable jcoItNfeProdVeicprod = jcoParam
				.getTable("IT_NFE_PROD_VEICPROD");
		jcoItNfeProdVeicprod.firstRow();
		for (int i = 0; i < jcoItNfeProdVeicprod.getNumRows(); jcoItNfeProdVeicprod
				.nextRow()) {
			this.itNfeProdVeicprods.add(new ItNfeProdVeicprod(
					jcoItNfeProdVeicprod));
			i++;
		}
		this.itNfeReboques = new ArrayList<>();
		JCoTable jcoItNfeReboque = jcoParam.getTable("IT_NFE_REBOQUE");
		jcoItNfeReboque.firstRow();
		for (int i = 0; i < jcoItNfeReboque.getNumRows(); jcoItNfeReboque
				.nextRow()) {
			this.itNfeReboques.add(new ItNfeReboque(jcoItNfeReboque));
			i++;
		}
		this.itNfeTexts = new ArrayList<>();
		JCoTable jcoItNfeText = jcoParam.getTable("IT_NFE_TEXT");
		jcoItNfeText.firstRow();
		for (int i = 0; i < jcoItNfeText.getNumRows(); jcoItNfeText.nextRow()) {
			this.itNfeTexts.add(new ItNfeText(jcoItNfeText));
			i++;
		}
		this.itNfeValues = new ArrayList<>();
		JCoTable jcoItNfeValue = jcoParam.getTable("IT_NFE_VALUE");
		jcoItNfeValue.firstRow();
		for (int i = 0; i < jcoItNfeValue.getNumRows(); jcoItNfeValue.nextRow()) {
			this.itNfeValues.add(new ItNfeValue(jcoItNfeValue));
			i++;
		}
		this.itNfeVols = new ArrayList<>();
		JCoTable jcoItNfeVol = jcoParam.getTable("IT_NFE_VOL");
		jcoItNfeVol.firstRow();
		for (int i = 0; i < jcoItNfeVol.getNumRows(); jcoItNfeVol.nextRow()) {
			this.itNfeVols.add(new ItNfeVol(jcoItNfeVol));
			i++;
		}
		this.ivResend = jcoParam.getString("IV_RESEND");
	}

	public void fillJCoParameter(JCoParameterList jcoParam) {
		jcoParam.clear();
		JCoStructure jcoIsNfeAvulsa = jcoParam.getStructure("IS_NFE_AVULSA");
		this.isNfeAvulsa.fillJCoParameter(jcoIsNfeAvulsa);
		JCoStructure jcoIsNfeCana = jcoParam.getStructure("IS_NFE_CANA");
		this.isNfeCana.fillJCoParameter(jcoIsNfeCana);
		JCoStructure jcoIsNfeCompra = jcoParam.getStructure("IS_NFE_COMPRA");
		this.isNfeCompra.fillJCoParameter(jcoIsNfeCompra);
		JCoStructure jcoIsNfeExporta = jcoParam.getStructure("IS_NFE_EXPORTA");
		this.isNfeExporta.fillJCoParameter(jcoIsNfeExporta);
		JCoStructure jcoIsNfeFat = jcoParam.getStructure("IS_NFE_FAT");
		this.isNfeFat.fillJCoParameter(jcoIsNfeFat);
		JCoStructure jcoIsNfeHeader = jcoParam.getStructure("IS_NFE_HEADER");
		this.isNfeHeader.fillJCoParameter(jcoIsNfeHeader);
		JCoStructure jcoIsNfeIcmstot = jcoParam.getStructure("IS_NFE_ICMSTOT");
		this.isNfeIcmstot.fillJCoParameter(jcoIsNfeIcmstot);
		JCoStructure jcoIsNfeIde = jcoParam.getStructure("IS_NFE_IDE");
		this.isNfeIde.fillJCoParameter(jcoIsNfeIde);
		JCoStructure jcoIsNfeInfadic = jcoParam.getStructure("IS_NFE_INFADIC");
		this.isNfeInfadic.fillJCoParameter(jcoIsNfeInfadic);
		JCoStructure jcoIsNfeIssqntot = jcoParam
				.getStructure("IS_NFE_ISSQNTOT");
		this.isNfeIssqntot.fillJCoParameter(jcoIsNfeIssqntot);
		JCoStructure jcoIsNfePartnerIds = jcoParam
				.getStructure("IS_NFE_PARTNER_IDS");
		this.isNfePartnerIds.fillJCoParameter(jcoIsNfePartnerIds);
		JCoStructure jcoIsNfeRettrib = jcoParam.getStructure("IS_NFE_RETTRIB");
		this.isNfeRettrib.fillJCoParameter(jcoIsNfeRettrib);
		JCoStructure jcoIsNfeTransp = jcoParam.getStructure("IS_NFE_TRANSP");
		this.isNfeTransp.fillJCoParameter(jcoIsNfeTransp);
		JCoTable jcoItNfeAutxml = jcoParam.getTable("IT_NFE_AUTXML");
		jcoItNfeAutxml.clear();
		for (ItNfeAutxml item : this.itNfeAutxmls) {
			item.fillJCoParameter(jcoItNfeAutxml);
			jcoItNfeAutxml.appendRow();
		}
		JCoTable jcoItNfeCanaFordia = jcoParam.getTable("IT_NFE_CANA_FORDIA");
		jcoItNfeCanaFordia.clear();
		for (ItNfeCanaFordia item : this.itNfeCanaFordias) {
			item.fillJCoParameter(jcoItNfeCanaFordia);
			jcoItNfeCanaFordia.appendRow();
		}
		JCoTable jcoItNfeDet = jcoParam.getTable("IT_NFE_DET");
		jcoItNfeDet.clear();
		for (ItNfeDet item : this.itNfeDets) {
			item.fillJCoParameter(jcoItNfeDet);
			jcoItNfeDet.appendRow();
		}
		JCoTable jcoItNfeDetImposto = jcoParam.getTable("IT_NFE_DET_IMPOSTO");
		jcoItNfeDetImposto.clear();
		for (ItNfeDetImposto item : this.itNfeDetImpostos) {
			item.fillJCoParameter(jcoItNfeDetImposto);
			jcoItNfeDetImposto.appendRow();
		}
		JCoTable jcoItNfeDetProd = jcoParam.getTable("IT_NFE_DET_PROD");
		jcoItNfeDetProd.clear();
		for (ItNfeDetProd item : this.itNfeDetProds) {
			item.fillJCoParameter(jcoItNfeDetProd);
			jcoItNfeDetProd.appendRow();
		}
		JCoTable jcoItNfeDiAdi = jcoParam.getTable("IT_NFE_DI_ADI");
		jcoItNfeDiAdi.clear();
		for (ItNfeDiAdi item : this.itNfeDiAdis) {
			item.fillJCoParameter(jcoItNfeDiAdi);
			jcoItNfeDiAdi.appendRow();
		}
		JCoTable jcoItNfeDup = jcoParam.getTable("IT_NFE_DUP");
		jcoItNfeDup.clear();
		for (ItNfeDup item : this.itNfeDups) {
			item.fillJCoParameter(jcoItNfeDup);
			jcoItNfeDup.appendRow();
		}
		JCoTable jcoItNfeExt1 = jcoParam.getTable("IT_NFE_EXT1");
		jcoItNfeExt1.clear();
		for (ItNfeExt1 item : this.itNfeExt1s) {
			item.fillJCoParameter(jcoItNfeExt1);
			jcoItNfeExt1.appendRow();
		}
		JCoTable jcoItNfeExt2 = jcoParam.getTable("IT_NFE_EXT2");
		jcoItNfeExt2.clear();
		for (ItNfeExt2 item : this.itNfeExt2s) {
			item.fillJCoParameter(jcoItNfeExt2);
			jcoItNfeExt2.appendRow();
		}
		JCoTable jcoItNfeImpostoCofins = jcoParam
				.getTable("IT_NFE_IMPOSTO_COFINS");
		jcoItNfeImpostoCofins.clear();
		for (ItNfeImpostoCofins item : this.itNfeImpostoCofinss) {
			item.fillJCoParameter(jcoItNfeImpostoCofins);
			jcoItNfeImpostoCofins.appendRow();
		}
		JCoTable jcoItNfeImpostoCofinsst = jcoParam
				.getTable("IT_NFE_IMPOSTO_COFINSST");
		jcoItNfeImpostoCofinsst.clear();
		for (ItNfeImpostoCofinsst item : this.itNfeImpostoCofinssts) {
			item.fillJCoParameter(jcoItNfeImpostoCofinsst);
			jcoItNfeImpostoCofinsst.appendRow();
		}
		JCoTable jcoItNfeImpostoIcms = jcoParam.getTable("IT_NFE_IMPOSTO_ICMS");
		jcoItNfeImpostoIcms.clear();
		for (ItNfeImpostoIcms item : this.itNfeImpostoIcmss) {
			item.fillJCoParameter(jcoItNfeImpostoIcms);
			jcoItNfeImpostoIcms.appendRow();
		}
		JCoTable jcoItNfeImpostoIi = jcoParam.getTable("IT_NFE_IMPOSTO_II");
		jcoItNfeImpostoIi.clear();
		for (ItNfeImpostoIi item : this.itNfeImpostoIis) {
			item.fillJCoParameter(jcoItNfeImpostoIi);
			jcoItNfeImpostoIi.appendRow();
		}
		JCoTable jcoItNfeImpostoIpi = jcoParam.getTable("IT_NFE_IMPOSTO_IPI");
		jcoItNfeImpostoIpi.clear();
		for (ItNfeImpostoIpi item : this.itNfeImpostoIpis) {
			item.fillJCoParameter(jcoItNfeImpostoIpi);
			jcoItNfeImpostoIpi.appendRow();
		}
		JCoTable jcoItNfeImpostoIssqn = jcoParam
				.getTable("IT_NFE_IMPOSTO_ISSQN");
		jcoItNfeImpostoIssqn.clear();
		for (ItNfeImpostoIssqn item : this.itNfeImpostoIssqns) {
			item.fillJCoParameter(jcoItNfeImpostoIssqn);
			jcoItNfeImpostoIssqn.appendRow();
		}
		JCoTable jcoItNfeImpostoPis = jcoParam.getTable("IT_NFE_IMPOSTO_PIS");
		jcoItNfeImpostoPis.clear();
		for (ItNfeImpostoPis item : this.itNfeImpostoPiss) {
			item.fillJCoParameter(jcoItNfeImpostoPis);
			jcoItNfeImpostoPis.appendRow();
		}
		JCoTable jcoItNfeImpostoPisst = jcoParam
				.getTable("IT_NFE_IMPOSTO_PISST");
		jcoItNfeImpostoPisst.clear();
		for (ItNfeImpostoPisst item : this.itNfeImpostoPissts) {
			item.fillJCoParameter(jcoItNfeImpostoPisst);
			jcoItNfeImpostoPisst.appendRow();
		}
		JCoTable jcoItNfeNfref = jcoParam.getTable("IT_NFE_NFREF");
		jcoItNfeNfref.clear();
		for (ItNfeNfref item : this.itNfeNfrefs) {
			item.fillJCoParameter(jcoItNfeNfref);
			jcoItNfeNfref.appendRow();
		}
		JCoTable jcoItNfePag = jcoParam.getTable("IT_NFE_PAG");
		jcoItNfePag.clear();
		for (ItNfePag item : this.itNfePags) {
			item.fillJCoParameter(jcoItNfePag);
			jcoItNfePag.appendRow();
		}
		JCoTable jcoItNfePartner = jcoParam.getTable("IT_NFE_PARTNER");
		jcoItNfePartner.clear();
		for (ItNfePartner item : this.itNfePartners) {
			item.fillJCoParameter(jcoItNfePartner);
			jcoItNfePartner.appendRow();
		}
		JCoTable jcoItNfeProcref = jcoParam.getTable("IT_NFE_PROCREF");
		jcoItNfeProcref.clear();
		for (ItNfeProcref item : this.itNfeProcrefs) {
			item.fillJCoParameter(jcoItNfeProcref);
			jcoItNfeProcref.appendRow();
		}
		JCoTable jcoItNfeProdArma = jcoParam.getTable("IT_NFE_PROD_ARMA");
		jcoItNfeProdArma.clear();
		for (ItNfeProdArma item : this.itNfeProdArmas) {
			item.fillJCoParameter(jcoItNfeProdArma);
			jcoItNfeProdArma.appendRow();
		}
		JCoTable jcoItNfeProdComb = jcoParam.getTable("IT_NFE_PROD_COMB");
		jcoItNfeProdComb.clear();
		for (ItNfeProdComb item : this.itNfeProdCombs) {
			item.fillJCoParameter(jcoItNfeProdComb);
			jcoItNfeProdComb.appendRow();
		}
		JCoTable jcoItNfeProdDetexport = jcoParam
				.getTable("IT_NFE_PROD_DETEXPORT");
		jcoItNfeProdDetexport.clear();
		for (ItNfeProdDetexport item : this.itNfeProdDetexports) {
			item.fillJCoParameter(jcoItNfeProdDetexport);
			jcoItNfeProdDetexport.appendRow();
		}
		JCoTable jcoItNfeProdDi = jcoParam.getTable("IT_NFE_PROD_DI");
		jcoItNfeProdDi.clear();
		for (ItNfeProdDi item : this.itNfeProdDis) {
			item.fillJCoParameter(jcoItNfeProdDi);
			jcoItNfeProdDi.appendRow();
		}
		JCoTable jcoItNfeProdMed = jcoParam.getTable("IT_NFE_PROD_MED");
		jcoItNfeProdMed.clear();
		for (ItNfeProdMed item : this.itNfeProdMeds) {
			item.fillJCoParameter(jcoItNfeProdMed);
			jcoItNfeProdMed.appendRow();
		}
		JCoTable jcoItNfeProdNrecopi = jcoParam.getTable("IT_NFE_PROD_NRECOPI");
		jcoItNfeProdNrecopi.clear();
		for (ItNfeProdNrecopi item : this.itNfeProdNrecopis) {
			item.fillJCoParameter(jcoItNfeProdNrecopi);
			jcoItNfeProdNrecopi.appendRow();
		}
		JCoTable jcoItNfeProdVeicprod = jcoParam
				.getTable("IT_NFE_PROD_VEICPROD");
		jcoItNfeProdVeicprod.clear();
		for (ItNfeProdVeicprod item : this.itNfeProdVeicprods) {
			item.fillJCoParameter(jcoItNfeProdVeicprod);
			jcoItNfeProdVeicprod.appendRow();
		}
		JCoTable jcoItNfeReboque = jcoParam.getTable("IT_NFE_REBOQUE");
		jcoItNfeReboque.clear();
		for (ItNfeReboque item : this.itNfeReboques) {
			item.fillJCoParameter(jcoItNfeReboque);
			jcoItNfeReboque.appendRow();
		}
		JCoTable jcoItNfeText = jcoParam.getTable("IT_NFE_TEXT");
		jcoItNfeText.clear();
		for (ItNfeText item : this.itNfeTexts) {
			item.fillJCoParameter(jcoItNfeText);
			jcoItNfeText.appendRow();
		}
		JCoTable jcoItNfeValue = jcoParam.getTable("IT_NFE_VALUE");
		jcoItNfeValue.clear();
		for (ItNfeValue item : this.itNfeValues) {
			item.fillJCoParameter(jcoItNfeValue);
			jcoItNfeValue.appendRow();
		}
		JCoTable jcoItNfeVol = jcoParam.getTable("IT_NFE_VOL");
		jcoItNfeVol.clear();
		for (ItNfeVol item : this.itNfeVols) {
			item.fillJCoParameter(jcoItNfeVol);
			jcoItNfeVol.appendRow();
		}
		jcoParam.setValue("IV_RESEND", this.ivResend);
	}

	public static class IsNfeAvulsa implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Tax Number 1
		private String cnpj;
		// NF-e Issuing Organization Name
		private String xOrgao;
		// NF-e Agent Registration
		private String matr;
		// NF-e Agent Name
		private String xAgente;
		// NF-e telephone number
		private String fone;
		// State
		private String uf;
		// NF-e Revenue Collection Document Number
		private String nDar;
		// Document date
		private Date dEmi;
		// NF-e Revenue Collection Document Total Value
		private BigDecimal vDar;
		// NF-e Issuing Tax Authority Department
		private String repEmi;
		// NF-e Collection Doc Payment Date
		private Date dPag;

		public IsNfeAvulsa(String cnpj, String xOrgao, String matr,
				String xAgente, String fone, String uf, String nDar, Date dEmi,
				BigDecimal vDar, String repEmi, Date dPag) {
			this.cnpj = cnpj;
			this.xOrgao = xOrgao;
			this.matr = matr;
			this.xAgente = xAgente;
			this.fone = fone;
			this.uf = uf;
			this.nDar = nDar;
			this.dEmi = dEmi;
			this.vDar = vDar;
			this.repEmi = repEmi;
			this.dPag = dPag;
		}

		public IsNfeAvulsa(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setXOrgao(String xOrgao) {
			this.xOrgao = xOrgao;
		}

		public String getXOrgao() {
			return this.xOrgao;
		}

		public void setMatr(String matr) {
			this.matr = matr;
		}

		public String getMatr() {
			return this.matr;
		}

		public void setXAgente(String xAgente) {
			this.xAgente = xAgente;
		}

		public String getXAgente() {
			return this.xAgente;
		}

		public void setFone(String fone) {
			this.fone = fone;
		}

		public String getFone() {
			return this.fone;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getUf() {
			return this.uf;
		}

		public void setNDar(String nDar) {
			this.nDar = nDar;
		}

		public String getNDar() {
			return this.nDar;
		}

		public void setDEmi(Date dEmi) {
			this.dEmi = dEmi;
		}

		public Date getDEmi() {
			return this.dEmi;
		}

		public void setVDar(BigDecimal vDar) {
			this.vDar = vDar;
		}

		public BigDecimal getVDar() {
			return this.vDar;
		}

		public void setRepEmi(String repEmi) {
			this.repEmi = repEmi;
		}

		public String getRepEmi() {
			return this.repEmi;
		}

		public void setDPag(Date dPag) {
			this.dPag = dPag;
		}

		public Date getDPag() {
			return this.dPag;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.cnpj = jcoParam.getString("CNPJ");
			this.xOrgao = jcoParam.getString("X_ORGAO");
			this.matr = jcoParam.getString("MATR");
			this.xAgente = jcoParam.getString("X_AGENTE");
			this.fone = jcoParam.getString("FONE");
			this.uf = jcoParam.getString("UF");
			this.nDar = jcoParam.getString("N_DAR");
			this.dEmi = jcoParam.getDate("D_EMI");
			this.vDar = jcoParam.getBigDecimal("V_DAR");
			this.repEmi = jcoParam.getString("REP_EMI");
			this.dPag = jcoParam.getDate("D_PAG");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("X_ORGAO", this.xOrgao);
			jcoParam.setValue("MATR", this.matr);
			jcoParam.setValue("X_AGENTE", this.xAgente);
			jcoParam.setValue("FONE", this.fone);
			jcoParam.setValue("UF", this.uf);
			jcoParam.setValue("N_DAR", this.nDar);
			jcoParam.setValue("D_EMI", this.dEmi);
			jcoParam.setValue("V_DAR", this.vDar);
			jcoParam.setValue("REP_EMI", this.repEmi);
			jcoParam.setValue("D_PAG", this.dPag);
		}

	}

	public static class IsNfeCana implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Harvest Identification
		private String safra;
		// Reference Month and Year
		private String ref;
		// Month Total Quantity
		private BigDecimal qTotMes;
		// Previous Total Quantity
		private BigDecimal qTotAnt;
		// General Total Quantity
		private BigDecimal qTotGer;
		// Supplies Amount
		private BigDecimal vFor;
		// Total Amount of Deductions
		private BigDecimal vTotDed;
		// Supplies Net Value
		private BigDecimal vLiqFor;
		// Reference to Line ID of Value Table
		private Long valueIdDeduc;

		public IsNfeCana(String safra, String ref, BigDecimal qTotMes,
				BigDecimal qTotAnt, BigDecimal qTotGer, BigDecimal vFor,
				BigDecimal vTotDed, BigDecimal vLiqFor, Long valueIdDeduc) {
			this.safra = safra;
			this.ref = ref;
			this.qTotMes = qTotMes;
			this.qTotAnt = qTotAnt;
			this.qTotGer = qTotGer;
			this.vFor = vFor;
			this.vTotDed = vTotDed;
			this.vLiqFor = vLiqFor;
			this.valueIdDeduc = valueIdDeduc;
		}

		public IsNfeCana(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setSafra(String safra) {
			this.safra = safra;
		}

		public String getSafra() {
			return this.safra;
		}

		public void setRef(String ref) {
			this.ref = ref;
		}

		public String getRef() {
			return this.ref;
		}

		public void setQTotMes(BigDecimal qTotMes) {
			this.qTotMes = qTotMes;
		}

		public BigDecimal getQTotMes() {
			return this.qTotMes;
		}

		public void setQTotAnt(BigDecimal qTotAnt) {
			this.qTotAnt = qTotAnt;
		}

		public BigDecimal getQTotAnt() {
			return this.qTotAnt;
		}

		public void setQTotGer(BigDecimal qTotGer) {
			this.qTotGer = qTotGer;
		}

		public BigDecimal getQTotGer() {
			return this.qTotGer;
		}

		public void setVFor(BigDecimal vFor) {
			this.vFor = vFor;
		}

		public BigDecimal getVFor() {
			return this.vFor;
		}

		public void setVTotDed(BigDecimal vTotDed) {
			this.vTotDed = vTotDed;
		}

		public BigDecimal getVTotDed() {
			return this.vTotDed;
		}

		public void setVLiqFor(BigDecimal vLiqFor) {
			this.vLiqFor = vLiqFor;
		}

		public BigDecimal getVLiqFor() {
			return this.vLiqFor;
		}

		public void setValueIdDeduc(Long valueIdDeduc) {
			this.valueIdDeduc = valueIdDeduc;
		}

		public Long getValueIdDeduc() {
			return this.valueIdDeduc;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.safra = jcoParam.getString("SAFRA");
			this.ref = jcoParam.getString("REF");
			this.qTotMes = jcoParam.getBigDecimal("Q_TOT_MES");
			this.qTotAnt = jcoParam.getBigDecimal("Q_TOT_ANT");
			this.qTotGer = jcoParam.getBigDecimal("Q_TOT_GER");
			this.vFor = jcoParam.getBigDecimal("V_FOR");
			this.vTotDed = jcoParam.getBigDecimal("V_TOT_DED");
			this.vLiqFor = jcoParam.getBigDecimal("V_LIQ_FOR");
			this.valueIdDeduc = jcoParam.getLong("VALUE_ID_DEDUC");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("SAFRA", this.safra);
			jcoParam.setValue("REF", this.ref);
			jcoParam.setValue("Q_TOT_MES", this.qTotMes);
			jcoParam.setValue("Q_TOT_ANT", this.qTotAnt);
			jcoParam.setValue("Q_TOT_GER", this.qTotGer);
			jcoParam.setValue("V_FOR", this.vFor);
			jcoParam.setValue("V_TOT_DED", this.vTotDed);
			jcoParam.setValue("V_LIQ_FOR", this.vLiqFor);
			jcoParam.setValue("VALUE_ID_DEDUC", this.valueIdDeduc);
		}

	}

	public static class IsNfeCompra implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Commitment Note
		private String xnemp;
		// Purchase Order Number
		private String xPed;
		// Purchase Contract Number
		private String xCont;

		public IsNfeCompra(String xnemp, String xPed, String xCont) {
			this.xnemp = xnemp;
			this.xPed = xPed;
			this.xCont = xCont;
		}

		public IsNfeCompra(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setXnemp(String xnemp) {
			this.xnemp = xnemp;
		}

		public String getXnemp() {
			return this.xnemp;
		}

		public void setXPed(String xPed) {
			this.xPed = xPed;
		}

		public String getXPed() {
			return this.xPed;
		}

		public void setXCont(String xCont) {
			this.xCont = xCont;
		}

		public String getXCont() {
			return this.xCont;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.xnemp = jcoParam.getString("XNEMP");
			this.xPed = jcoParam.getString("X_PED");
			this.xCont = jcoParam.getString("X_CONT");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("XNEMP", this.xnemp);
			jcoParam.setValue("X_PED", this.xPed);
			jcoParam.setValue("X_CONT", this.xCont);
		}

	}

	public static class IsNfeExporta implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Border cross region
		private String ufSaidaPais;
		// Departure Place/Border Location
		private String xLocExporta;
		// Local of the Dispatch
		private String xLocDespacho;

		public IsNfeExporta(String ufSaidaPais, String xLocExporta,
				String xLocDespacho) {
			this.ufSaidaPais = ufSaidaPais;
			this.xLocExporta = xLocExporta;
			this.xLocDespacho = xLocDespacho;
		}

		public IsNfeExporta(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setUfSaidaPais(String ufSaidaPais) {
			this.ufSaidaPais = ufSaidaPais;
		}

		public String getUfSaidaPais() {
			return this.ufSaidaPais;
		}

		public void setXLocExporta(String xLocExporta) {
			this.xLocExporta = xLocExporta;
		}

		public String getXLocExporta() {
			return this.xLocExporta;
		}

		public void setXLocDespacho(String xLocDespacho) {
			this.xLocDespacho = xLocDespacho;
		}

		public String getXLocDespacho() {
			return this.xLocDespacho;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.ufSaidaPais = jcoParam.getString("UF_SAIDA_PAIS");
			this.xLocExporta = jcoParam.getString("X_LOC_EXPORTA");
			this.xLocDespacho = jcoParam.getString("X_LOC_DESPACHO");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("UF_SAIDA_PAIS", this.ufSaidaPais);
			jcoParam.setValue("X_LOC_EXPORTA", this.xLocExporta);
			jcoParam.setValue("X_LOC_DESPACHO", this.xLocDespacho);
		}

	}

	public static class IsNfeFat implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Invoice Number
		private String nFat;
		// Invoice Original Value
		private BigDecimal vOrig;
		// Discount Amount Including Taxes
		private BigDecimal vDesc;
		// Invoice Net Value
		private BigDecimal vLiq;

		public IsNfeFat(String nFat, BigDecimal vOrig, BigDecimal vDesc,
				BigDecimal vLiq) {
			this.nFat = nFat;
			this.vOrig = vOrig;
			this.vDesc = vDesc;
			this.vLiq = vLiq;
		}

		public IsNfeFat(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setNFat(String nFat) {
			this.nFat = nFat;
		}

		public String getNFat() {
			return this.nFat;
		}

		public void setVOrig(BigDecimal vOrig) {
			this.vOrig = vOrig;
		}

		public BigDecimal getVOrig() {
			return this.vOrig;
		}

		public void setVDesc(BigDecimal vDesc) {
			this.vDesc = vDesc;
		}

		public BigDecimal getVDesc() {
			return this.vDesc;
		}

		public void setVLiq(BigDecimal vLiq) {
			this.vLiq = vLiq;
		}

		public BigDecimal getVLiq() {
			return this.vLiq;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.nFat = jcoParam.getString("N_FAT");
			this.vOrig = jcoParam.getBigDecimal("V_ORIG");
			this.vDesc = jcoParam.getBigDecimal("V_DESC");
			this.vLiq = jcoParam.getBigDecimal("V_LIQ");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("N_FAT", this.nFat);
			jcoParam.setValue("V_ORIG", this.vOrig);
			jcoParam.setValue("V_DESC", this.vDesc);
			jcoParam.setValue("V_LIQ", this.vLiq);
		}

	}

	public static class IsNfeHeader implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// NF-e RFC Interface Version
		private String rfcVersion;
		// Document Number
		private Long docnum;
		// NF-e: 44-Digit Access Key
		private String accesskey;
		// Logical system
		private String logsys;
		// Currency Key
		private String waers;

		public IsNfeHeader(String rfcVersion, Long docnum, String accesskey,
				String logsys, String waers) {
			this.rfcVersion = rfcVersion;
			this.docnum = docnum;
			this.accesskey = accesskey;
			this.logsys = logsys;
			this.waers = waers;
		}

		public IsNfeHeader(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setRfcVersion(String rfcVersion) {
			this.rfcVersion = rfcVersion;
		}

		public String getRfcVersion() {
			return this.rfcVersion;
		}

		public void setDocnum(Long docnum) {
			this.docnum = docnum;
		}

		public Long getDocnum() {
			return this.docnum;
		}

		public void setAccesskey(String accesskey) {
			this.accesskey = accesskey;
		}

		public String getAccesskey() {
			return this.accesskey;
		}

		public void setLogsys(String logsys) {
			this.logsys = logsys;
		}

		public String getLogsys() {
			return this.logsys;
		}

		public void setWaers(String waers) {
			this.waers = waers;
		}

		public String getWaers() {
			return this.waers;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.rfcVersion = jcoParam.getString("RFC_VERSION");
			this.docnum = jcoParam.getLong("DOCNUM");
			this.accesskey = jcoParam.getString("ACCESSKEY");
			this.logsys = jcoParam.getString("LOGSYS");
			this.waers = jcoParam.getString("WAERS");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("RFC_VERSION", this.rfcVersion);
			jcoParam.setValue("DOCNUM", this.docnum);
			jcoParam.setValue("ACCESSKEY", this.accesskey);
			jcoParam.setValue("LOGSYS", this.logsys);
			jcoParam.setValue("WAERS", this.waers);
		}

	}

	public static class IsNfeIcmstot implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// ICMS Base Amount
		private BigDecimal vBc;
		// ICMS Value
		private BigDecimal vIcms;
		// NF-e Total of desoneration of ICMS
		private BigDecimal vIcmsdeson;
		// ICMS ST Base Amount
		private BigDecimal vBcst;
		// ICMS ST Total Value
		private BigDecimal vSt;
		// Products or Services Total Value
		private BigDecimal vProd;
		// Total Freight Value Including Taxes
		private BigDecimal vFrete;
		// Total Insurance Value Including Taxes
		private BigDecimal vSeg;
		// Discount Value Including Taxes
		private BigDecimal vDesc;
		// Total II Value
		private BigDecimal vIi;
		// IPI Tax Value
		private BigDecimal vIpi;
		// PIS Value
		private BigDecimal vPis;
		// COFINS Value
		private BigDecimal vCofins;
		// Other Accessory Costs
		private BigDecimal vOutro;
		// Total Value Including Taxes
		private BigDecimal vNf;
		// Total Tax Value, Version 2
		private BigDecimal vTotTrib;

		public IsNfeIcmstot(BigDecimal vBc, BigDecimal vIcms,
				BigDecimal vIcmsdeson, BigDecimal vBcst, BigDecimal vSt,
				BigDecimal vProd, BigDecimal vFrete, BigDecimal vSeg,
				BigDecimal vDesc, BigDecimal vIi, BigDecimal vIpi,
				BigDecimal vPis, BigDecimal vCofins, BigDecimal vOutro,
				BigDecimal vNf, BigDecimal vTotTrib) {
			this.vBc = vBc;
			this.vIcms = vIcms;
			this.vIcmsdeson = vIcmsdeson;
			this.vBcst = vBcst;
			this.vSt = vSt;
			this.vProd = vProd;
			this.vFrete = vFrete;
			this.vSeg = vSeg;
			this.vDesc = vDesc;
			this.vIi = vIi;
			this.vIpi = vIpi;
			this.vPis = vPis;
			this.vCofins = vCofins;
			this.vOutro = vOutro;
			this.vNf = vNf;
			this.vTotTrib = vTotTrib;
		}

		public IsNfeIcmstot(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setVIcms(BigDecimal vIcms) {
			this.vIcms = vIcms;
		}

		public BigDecimal getVIcms() {
			return this.vIcms;
		}

		public void setVIcmsdeson(BigDecimal vIcmsdeson) {
			this.vIcmsdeson = vIcmsdeson;
		}

		public BigDecimal getVIcmsdeson() {
			return this.vIcmsdeson;
		}

		public void setVBcst(BigDecimal vBcst) {
			this.vBcst = vBcst;
		}

		public BigDecimal getVBcst() {
			return this.vBcst;
		}

		public void setVSt(BigDecimal vSt) {
			this.vSt = vSt;
		}

		public BigDecimal getVSt() {
			return this.vSt;
		}

		public void setVProd(BigDecimal vProd) {
			this.vProd = vProd;
		}

		public BigDecimal getVProd() {
			return this.vProd;
		}

		public void setVFrete(BigDecimal vFrete) {
			this.vFrete = vFrete;
		}

		public BigDecimal getVFrete() {
			return this.vFrete;
		}

		public void setVSeg(BigDecimal vSeg) {
			this.vSeg = vSeg;
		}

		public BigDecimal getVSeg() {
			return this.vSeg;
		}

		public void setVDesc(BigDecimal vDesc) {
			this.vDesc = vDesc;
		}

		public BigDecimal getVDesc() {
			return this.vDesc;
		}

		public void setVIi(BigDecimal vIi) {
			this.vIi = vIi;
		}

		public BigDecimal getVIi() {
			return this.vIi;
		}

		public void setVIpi(BigDecimal vIpi) {
			this.vIpi = vIpi;
		}

		public BigDecimal getVIpi() {
			return this.vIpi;
		}

		public void setVPis(BigDecimal vPis) {
			this.vPis = vPis;
		}

		public BigDecimal getVPis() {
			return this.vPis;
		}

		public void setVCofins(BigDecimal vCofins) {
			this.vCofins = vCofins;
		}

		public BigDecimal getVCofins() {
			return this.vCofins;
		}

		public void setVOutro(BigDecimal vOutro) {
			this.vOutro = vOutro;
		}

		public BigDecimal getVOutro() {
			return this.vOutro;
		}

		public void setVNf(BigDecimal vNf) {
			this.vNf = vNf;
		}

		public BigDecimal getVNf() {
			return this.vNf;
		}

		public void setVTotTrib(BigDecimal vTotTrib) {
			this.vTotTrib = vTotTrib;
		}

		public BigDecimal getVTotTrib() {
			return this.vTotTrib;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.vIcms = jcoParam.getBigDecimal("V_ICMS");
			this.vIcmsdeson = jcoParam.getBigDecimal("V_ICMSDESON");
			this.vBcst = jcoParam.getBigDecimal("V_BCST");
			this.vSt = jcoParam.getBigDecimal("V_ST");
			this.vProd = jcoParam.getBigDecimal("V_PROD");
			this.vFrete = jcoParam.getBigDecimal("V_FRETE");
			this.vSeg = jcoParam.getBigDecimal("V_SEG");
			this.vDesc = jcoParam.getBigDecimal("V_DESC");
			this.vIi = jcoParam.getBigDecimal("V_II");
			this.vIpi = jcoParam.getBigDecimal("V_IPI");
			this.vPis = jcoParam.getBigDecimal("V_PIS");
			this.vCofins = jcoParam.getBigDecimal("V_COFINS");
			this.vOutro = jcoParam.getBigDecimal("V_OUTRO");
			this.vNf = jcoParam.getBigDecimal("V_NF");
			this.vTotTrib = jcoParam.getBigDecimal("V_TOT_TRIB");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("V_ICMS", this.vIcms);
			jcoParam.setValue("V_ICMSDESON", this.vIcmsdeson);
			jcoParam.setValue("V_BCST", this.vBcst);
			jcoParam.setValue("V_ST", this.vSt);
			jcoParam.setValue("V_PROD", this.vProd);
			jcoParam.setValue("V_FRETE", this.vFrete);
			jcoParam.setValue("V_SEG", this.vSeg);
			jcoParam.setValue("V_DESC", this.vDesc);
			jcoParam.setValue("V_II", this.vIi);
			jcoParam.setValue("V_IPI", this.vIpi);
			jcoParam.setValue("V_PIS", this.vPis);
			jcoParam.setValue("V_COFINS", this.vCofins);
			jcoParam.setValue("V_OUTRO", this.vOutro);
			jcoParam.setValue("V_NF", this.vNf);
			jcoParam.setValue("V_TOT_TRIB", this.vTotTrib);
		}

	}

	public static class IsNfeIde implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// State
		private String cUf;
		// NF-e: Random Number
		private String cNf;
		// Operation Nature Description
		private String natOp;
		// Payment Form Indicator
		private String indPag;
		// Model of Nota Fiscal
		private Long mod;
		// Series
		private String serie;
		// Nine-Digit NF-e Number
		private String nNf;
		// NF-e Issuing Date UTC
		private String dhEmi;
		// NF-e Goods Receipt Time UTC
		private String dhSaiEnt;
		// Direction of the movement
		private String tpNf;
		// NF-e Identifier of Destination Place
		private String idDest;
		// NF-e City Code for Taxation
		private String cMunFg;
		// NF-e DANFE Print Format
		private String tpImp;
		// NF-e Issuing Type
		private String tpEmis;
		// Check Digit for NF-e Access Key
		private String cDv;
		// Type of Environment (Test or Production)
		private String tpAmb;
		// NF-e Issuing Function
		private String finNfe;
		// NF-e Final Consumer Identification
		private String indFinal;
		// NF-e Customer Presence
		private String indPres;
		// NF-e Issuing Process Identifier
		private String procEmi;
		// NF-e Application Version
		private String verProc;
		// NF-e Contingency Time UTC
		private String dhCont;
		// NF-e Contingency Reason
		private String xJust;

		public IsNfeIde(String cUf, String cNf, String natOp, String indPag,
				Long mod, String serie, String nNf, String dhEmi,
				String dhSaiEnt, String tpNf, String idDest, String cMunFg,
				String tpImp, String tpEmis, String cDv, String tpAmb,
				String finNfe, String indFinal, String indPres, String procEmi,
				String verProc, String dhCont, String xJust) {
			this.cUf = cUf;
			this.cNf = cNf;
			this.natOp = natOp;
			this.indPag = indPag;
			this.mod = mod;
			this.serie = serie;
			this.nNf = nNf;
			this.dhEmi = dhEmi;
			this.dhSaiEnt = dhSaiEnt;
			this.tpNf = tpNf;
			this.idDest = idDest;
			this.cMunFg = cMunFg;
			this.tpImp = tpImp;
			this.tpEmis = tpEmis;
			this.cDv = cDv;
			this.tpAmb = tpAmb;
			this.finNfe = finNfe;
			this.indFinal = indFinal;
			this.indPres = indPres;
			this.procEmi = procEmi;
			this.verProc = verProc;
			this.dhCont = dhCont;
			this.xJust = xJust;
		}

		public IsNfeIde(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setCUf(String cUf) {
			this.cUf = cUf;
		}

		public String getCUf() {
			return this.cUf;
		}

		public void setCNf(String cNf) {
			this.cNf = cNf;
		}

		public String getCNf() {
			return this.cNf;
		}

		public void setNatOp(String natOp) {
			this.natOp = natOp;
		}

		public String getNatOp() {
			return this.natOp;
		}

		public void setIndPag(String indPag) {
			this.indPag = indPag;
		}

		public String getIndPag() {
			return this.indPag;
		}

		public void setMod(Long mod) {
			this.mod = mod;
		}

		public Long getMod() {
			return this.mod;
		}

		public void setSerie(String serie) {
			this.serie = serie;
		}

		public String getSerie() {
			return this.serie;
		}

		public void setNNf(String nNf) {
			this.nNf = nNf;
		}

		public String getNNf() {
			return this.nNf;
		}

		public void setDhEmi(String dhEmi) {
			this.dhEmi = dhEmi;
		}

		public String getDhEmi() {
			return this.dhEmi;
		}

		public void setDhSaiEnt(String dhSaiEnt) {
			this.dhSaiEnt = dhSaiEnt;
		}

		public String getDhSaiEnt() {
			return this.dhSaiEnt;
		}

		public void setTpNf(String tpNf) {
			this.tpNf = tpNf;
		}

		public String getTpNf() {
			return this.tpNf;
		}

		public void setIdDest(String idDest) {
			this.idDest = idDest;
		}

		public String getIdDest() {
			return this.idDest;
		}

		public void setCMunFg(String cMunFg) {
			this.cMunFg = cMunFg;
		}

		public String getCMunFg() {
			return this.cMunFg;
		}

		public void setTpImp(String tpImp) {
			this.tpImp = tpImp;
		}

		public String getTpImp() {
			return this.tpImp;
		}

		public void setTpEmis(String tpEmis) {
			this.tpEmis = tpEmis;
		}

		public String getTpEmis() {
			return this.tpEmis;
		}

		public void setCDv(String cDv) {
			this.cDv = cDv;
		}

		public String getCDv() {
			return this.cDv;
		}

		public void setTpAmb(String tpAmb) {
			this.tpAmb = tpAmb;
		}

		public String getTpAmb() {
			return this.tpAmb;
		}

		public void setFinNfe(String finNfe) {
			this.finNfe = finNfe;
		}

		public String getFinNfe() {
			return this.finNfe;
		}

		public void setIndFinal(String indFinal) {
			this.indFinal = indFinal;
		}

		public String getIndFinal() {
			return this.indFinal;
		}

		public void setIndPres(String indPres) {
			this.indPres = indPres;
		}

		public String getIndPres() {
			return this.indPres;
		}

		public void setProcEmi(String procEmi) {
			this.procEmi = procEmi;
		}

		public String getProcEmi() {
			return this.procEmi;
		}

		public void setVerProc(String verProc) {
			this.verProc = verProc;
		}

		public String getVerProc() {
			return this.verProc;
		}

		public void setDhCont(String dhCont) {
			this.dhCont = dhCont;
		}

		public String getDhCont() {
			return this.dhCont;
		}

		public void setXJust(String xJust) {
			this.xJust = xJust;
		}

		public String getXJust() {
			return this.xJust;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.cUf = jcoParam.getString("C_UF");
			this.cNf = jcoParam.getString("C_NF");
			this.natOp = jcoParam.getString("NAT_OP");
			this.indPag = jcoParam.getString("IND_PAG");
			this.mod = jcoParam.getLong("MOD");
			this.serie = jcoParam.getString("SERIE");
			this.nNf = jcoParam.getString("N_NF");
			this.dhEmi = jcoParam.getString("DH_EMI");
			this.dhSaiEnt = jcoParam.getString("DH_SAI_ENT");
			this.tpNf = jcoParam.getString("TP_NF");
			this.idDest = jcoParam.getString("ID_DEST");
			this.cMunFg = jcoParam.getString("C_MUN_FG");
			this.tpImp = jcoParam.getString("TP_IMP");
			this.tpEmis = jcoParam.getString("TP_EMIS");
			this.cDv = jcoParam.getString("C_DV");
			this.tpAmb = jcoParam.getString("TP_AMB");
			this.finNfe = jcoParam.getString("FIN_NFE");
			this.indFinal = jcoParam.getString("IND_FINAL");
			this.indPres = jcoParam.getString("IND_PRES");
			this.procEmi = jcoParam.getString("PROC_EMI");
			this.verProc = jcoParam.getString("VER_PROC");
			this.dhCont = jcoParam.getString("DH_CONT");
			this.xJust = jcoParam.getString("X_JUST");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("C_UF", this.cUf);
			jcoParam.setValue("C_NF", this.cNf);
			jcoParam.setValue("NAT_OP", this.natOp);
			jcoParam.setValue("IND_PAG", this.indPag);
			jcoParam.setValue("MOD", this.mod);
			jcoParam.setValue("SERIE", this.serie);
			jcoParam.setValue("N_NF", this.nNf);
			jcoParam.setValue("DH_EMI", this.dhEmi);
			jcoParam.setValue("DH_SAI_ENT", this.dhSaiEnt);
			jcoParam.setValue("TP_NF", this.tpNf);
			jcoParam.setValue("ID_DEST", this.idDest);
			jcoParam.setValue("C_MUN_FG", this.cMunFg);
			jcoParam.setValue("TP_IMP", this.tpImp);
			jcoParam.setValue("TP_EMIS", this.tpEmis);
			jcoParam.setValue("C_DV", this.cDv);
			jcoParam.setValue("TP_AMB", this.tpAmb);
			jcoParam.setValue("FIN_NFE", this.finNfe);
			jcoParam.setValue("IND_FINAL", this.indFinal);
			jcoParam.setValue("IND_PRES", this.indPres);
			jcoParam.setValue("PROC_EMI", this.procEmi);
			jcoParam.setValue("VER_PROC", this.verProc);
			jcoParam.setValue("DH_CONT", this.dhCont);
			jcoParam.setValue("X_JUST", this.xJust);
		}

	}

	public static class IsNfeInfadic implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Additional Information Concerning to the Authorities
		private String infAdFisco;
		// Complementary Information Concerning to the Company
		private String infCpl;
		// Reference to Line ID of Text Table
		private Long textIdObscont;
		// Reference to Line ID of Text Table
		private Long textIdObsfisco;

		public IsNfeInfadic(String infAdFisco, String infCpl,
				Long textIdObscont, Long textIdObsfisco) {
			this.infAdFisco = infAdFisco;
			this.infCpl = infCpl;
			this.textIdObscont = textIdObscont;
			this.textIdObsfisco = textIdObsfisco;
		}

		public IsNfeInfadic(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setInfAdFisco(String infAdFisco) {
			this.infAdFisco = infAdFisco;
		}

		public String getInfAdFisco() {
			return this.infAdFisco;
		}

		public void setInfCpl(String infCpl) {
			this.infCpl = infCpl;
		}

		public String getInfCpl() {
			return this.infCpl;
		}

		public void setTextIdObscont(Long textIdObscont) {
			this.textIdObscont = textIdObscont;
		}

		public Long getTextIdObscont() {
			return this.textIdObscont;
		}

		public void setTextIdObsfisco(Long textIdObsfisco) {
			this.textIdObsfisco = textIdObsfisco;
		}

		public Long getTextIdObsfisco() {
			return this.textIdObsfisco;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.infAdFisco = jcoParam.getString("INF_AD_FISCO");
			this.infCpl = jcoParam.getString("INF_CPL");
			this.textIdObscont = jcoParam.getLong("TEXT_ID_OBSCONT");
			this.textIdObsfisco = jcoParam.getLong("TEXT_ID_OBSFISCO");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("INF_AD_FISCO", this.infAdFisco);
			jcoParam.setValue("INF_CPL", this.infCpl);
			jcoParam.setValue("TEXT_ID_OBSCONT", this.textIdObscont);
			jcoParam.setValue("TEXT_ID_OBSFISCO", this.textIdObsfisco);
		}

	}

	public static class IsNfeIssqntot implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Total Value of Services Not Due or Exempt of ICMS Tax (ISS)
		private BigDecimal vServ;
		// ISS Tax Base
		private BigDecimal vBc;
		// ISS Total Value
		private BigDecimal vIss;
		// PIS Value from ISS Services
		private BigDecimal vPis;
		// Value of COFINS through Taxes
		private BigDecimal vCofins;
		// Date of Service
		private Date dCompet;
		// Value Deduction for Calculation Base Reduction
		private BigDecimal vDeducao;
		// NF-e Other Additional Costs
		private BigDecimal vOutro;
		// Unconditioned Discount Value
		private BigDecimal vDescIncond;
		// Conditioned Discount Value
		private BigDecimal vDescCond;
		// Total Withhold Amount of ISS
		private BigDecimal vIssret;
		// Code of Special Taxation Regimen
		private String cRegTrib;

		public IsNfeIssqntot(BigDecimal vServ, BigDecimal vBc, BigDecimal vIss,
				BigDecimal vPis, BigDecimal vCofins, Date dCompet,
				BigDecimal vDeducao, BigDecimal vOutro, BigDecimal vDescIncond,
				BigDecimal vDescCond, BigDecimal vIssret, String cRegTrib) {
			this.vServ = vServ;
			this.vBc = vBc;
			this.vIss = vIss;
			this.vPis = vPis;
			this.vCofins = vCofins;
			this.dCompet = dCompet;
			this.vDeducao = vDeducao;
			this.vOutro = vOutro;
			this.vDescIncond = vDescIncond;
			this.vDescCond = vDescCond;
			this.vIssret = vIssret;
			this.cRegTrib = cRegTrib;
		}

		public IsNfeIssqntot(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setVServ(BigDecimal vServ) {
			this.vServ = vServ;
		}

		public BigDecimal getVServ() {
			return this.vServ;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setVIss(BigDecimal vIss) {
			this.vIss = vIss;
		}

		public BigDecimal getVIss() {
			return this.vIss;
		}

		public void setVPis(BigDecimal vPis) {
			this.vPis = vPis;
		}

		public BigDecimal getVPis() {
			return this.vPis;
		}

		public void setVCofins(BigDecimal vCofins) {
			this.vCofins = vCofins;
		}

		public BigDecimal getVCofins() {
			return this.vCofins;
		}

		public void setDCompet(Date dCompet) {
			this.dCompet = dCompet;
		}

		public Date getDCompet() {
			return this.dCompet;
		}

		public void setVDeducao(BigDecimal vDeducao) {
			this.vDeducao = vDeducao;
		}

		public BigDecimal getVDeducao() {
			return this.vDeducao;
		}

		public void setVOutro(BigDecimal vOutro) {
			this.vOutro = vOutro;
		}

		public BigDecimal getVOutro() {
			return this.vOutro;
		}

		public void setVDescIncond(BigDecimal vDescIncond) {
			this.vDescIncond = vDescIncond;
		}

		public BigDecimal getVDescIncond() {
			return this.vDescIncond;
		}

		public void setVDescCond(BigDecimal vDescCond) {
			this.vDescCond = vDescCond;
		}

		public BigDecimal getVDescCond() {
			return this.vDescCond;
		}

		public void setVIssret(BigDecimal vIssret) {
			this.vIssret = vIssret;
		}

		public BigDecimal getVIssret() {
			return this.vIssret;
		}

		public void setCRegTrib(String cRegTrib) {
			this.cRegTrib = cRegTrib;
		}

		public String getCRegTrib() {
			return this.cRegTrib;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.vServ = jcoParam.getBigDecimal("V_SERV");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.vIss = jcoParam.getBigDecimal("V_ISS");
			this.vPis = jcoParam.getBigDecimal("V_PIS");
			this.vCofins = jcoParam.getBigDecimal("V_COFINS");
			this.dCompet = jcoParam.getDate("D_COMPET");
			this.vDeducao = jcoParam.getBigDecimal("V_DEDUCAO");
			this.vOutro = jcoParam.getBigDecimal("V_OUTRO");
			this.vDescIncond = jcoParam.getBigDecimal("V_DESC_INCOND");
			this.vDescCond = jcoParam.getBigDecimal("V_DESC_COND");
			this.vIssret = jcoParam.getBigDecimal("V_ISSRET");
			this.cRegTrib = jcoParam.getString("C_REG_TRIB");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("V_SERV", this.vServ);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("V_ISS", this.vIss);
			jcoParam.setValue("V_PIS", this.vPis);
			jcoParam.setValue("V_COFINS", this.vCofins);
			jcoParam.setValue("D_COMPET", this.dCompet);
			jcoParam.setValue("V_DEDUCAO", this.vDeducao);
			jcoParam.setValue("V_OUTRO", this.vOutro);
			jcoParam.setValue("V_DESC_INCOND", this.vDescIncond);
			jcoParam.setValue("V_DESC_COND", this.vDescCond);
			jcoParam.setValue("V_ISSRET", this.vIssret);
			jcoParam.setValue("C_REG_TRIB", this.cRegTrib);
		}

	}

	public static class IsNfePartnerIds implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// NF-e RFC Partner Reference
		private Long partnerIdEmit;
		// NF-e RFC Partner Reference
		private Long partnerIdDest;
		// NF-e RFC Partner Reference
		private Long partnerIdRetirada;
		// NF-e RFC Partner Reference
		private Long partnerIdEntrega;
		// NF-e RFC Partner Reference
		private Long partnerIdTransporta;

		public IsNfePartnerIds(Long partnerIdEmit, Long partnerIdDest,
				Long partnerIdRetirada, Long partnerIdEntrega,
				Long partnerIdTransporta) {
			this.partnerIdEmit = partnerIdEmit;
			this.partnerIdDest = partnerIdDest;
			this.partnerIdRetirada = partnerIdRetirada;
			this.partnerIdEntrega = partnerIdEntrega;
			this.partnerIdTransporta = partnerIdTransporta;
		}

		public IsNfePartnerIds(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setPartnerIdEmit(Long partnerIdEmit) {
			this.partnerIdEmit = partnerIdEmit;
		}

		public Long getPartnerIdEmit() {
			return this.partnerIdEmit;
		}

		public void setPartnerIdDest(Long partnerIdDest) {
			this.partnerIdDest = partnerIdDest;
		}

		public Long getPartnerIdDest() {
			return this.partnerIdDest;
		}

		public void setPartnerIdRetirada(Long partnerIdRetirada) {
			this.partnerIdRetirada = partnerIdRetirada;
		}

		public Long getPartnerIdRetirada() {
			return this.partnerIdRetirada;
		}

		public void setPartnerIdEntrega(Long partnerIdEntrega) {
			this.partnerIdEntrega = partnerIdEntrega;
		}

		public Long getPartnerIdEntrega() {
			return this.partnerIdEntrega;
		}

		public void setPartnerIdTransporta(Long partnerIdTransporta) {
			this.partnerIdTransporta = partnerIdTransporta;
		}

		public Long getPartnerIdTransporta() {
			return this.partnerIdTransporta;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.partnerIdEmit = jcoParam.getLong("PARTNER_ID_EMIT");
			this.partnerIdDest = jcoParam.getLong("PARTNER_ID_DEST");
			this.partnerIdRetirada = jcoParam.getLong("PARTNER_ID_RETIRADA");
			this.partnerIdEntrega = jcoParam.getLong("PARTNER_ID_ENTREGA");
			this.partnerIdTransporta = jcoParam
					.getLong("PARTNER_ID_TRANSPORTA");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("PARTNER_ID_EMIT", this.partnerIdEmit);
			jcoParam.setValue("PARTNER_ID_DEST", this.partnerIdDest);
			jcoParam.setValue("PARTNER_ID_RETIRADA", this.partnerIdRetirada);
			jcoParam.setValue("PARTNER_ID_ENTREGA", this.partnerIdEntrega);
			jcoParam.setValue("PARTNER_ID_TRANSPORTA", this.partnerIdTransporta);
		}

	}

	public static class IsNfeRettrib implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Withheld PIS Value
		private BigDecimal vRetPis;
		// Withheld COFINS Value
		private BigDecimal vRetCofins;
		// Withheld CSLL Value
		private BigDecimal vRetCsll;
		// IRRF Tax Base
		private BigDecimal vBcirrf;
		// Withheld IRRF Value
		private BigDecimal vIrrf;
		// Social Security Withholding Tax Base
		private BigDecimal vBcretPrev;
		// Withheld Social Security Value
		private BigDecimal vRetPrev;

		public IsNfeRettrib(BigDecimal vRetPis, BigDecimal vRetCofins,
				BigDecimal vRetCsll, BigDecimal vBcirrf, BigDecimal vIrrf,
				BigDecimal vBcretPrev, BigDecimal vRetPrev) {
			this.vRetPis = vRetPis;
			this.vRetCofins = vRetCofins;
			this.vRetCsll = vRetCsll;
			this.vBcirrf = vBcirrf;
			this.vIrrf = vIrrf;
			this.vBcretPrev = vBcretPrev;
			this.vRetPrev = vRetPrev;
		}

		public IsNfeRettrib(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setVRetPis(BigDecimal vRetPis) {
			this.vRetPis = vRetPis;
		}

		public BigDecimal getVRetPis() {
			return this.vRetPis;
		}

		public void setVRetCofins(BigDecimal vRetCofins) {
			this.vRetCofins = vRetCofins;
		}

		public BigDecimal getVRetCofins() {
			return this.vRetCofins;
		}

		public void setVRetCsll(BigDecimal vRetCsll) {
			this.vRetCsll = vRetCsll;
		}

		public BigDecimal getVRetCsll() {
			return this.vRetCsll;
		}

		public void setVBcirrf(BigDecimal vBcirrf) {
			this.vBcirrf = vBcirrf;
		}

		public BigDecimal getVBcirrf() {
			return this.vBcirrf;
		}

		public void setVIrrf(BigDecimal vIrrf) {
			this.vIrrf = vIrrf;
		}

		public BigDecimal getVIrrf() {
			return this.vIrrf;
		}

		public void setVBcretPrev(BigDecimal vBcretPrev) {
			this.vBcretPrev = vBcretPrev;
		}

		public BigDecimal getVBcretPrev() {
			return this.vBcretPrev;
		}

		public void setVRetPrev(BigDecimal vRetPrev) {
			this.vRetPrev = vRetPrev;
		}

		public BigDecimal getVRetPrev() {
			return this.vRetPrev;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.vRetPis = jcoParam.getBigDecimal("V_RET_PIS");
			this.vRetCofins = jcoParam.getBigDecimal("V_RET_COFINS");
			this.vRetCsll = jcoParam.getBigDecimal("V_RET_CSLL");
			this.vBcirrf = jcoParam.getBigDecimal("V_BCIRRF");
			this.vIrrf = jcoParam.getBigDecimal("V_IRRF");
			this.vBcretPrev = jcoParam.getBigDecimal("V_BCRET_PREV");
			this.vRetPrev = jcoParam.getBigDecimal("V_RET_PREV");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("V_RET_PIS", this.vRetPis);
			jcoParam.setValue("V_RET_COFINS", this.vRetCofins);
			jcoParam.setValue("V_RET_CSLL", this.vRetCsll);
			jcoParam.setValue("V_BCIRRF", this.vBcirrf);
			jcoParam.setValue("V_IRRF", this.vIrrf);
			jcoParam.setValue("V_BCRET_PREV", this.vBcretPrev);
			jcoParam.setValue("V_RET_PREV", this.vRetPrev);
		}

	}

	public static class IsNfeTransp implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Freight Cost Paid by
		private String modFrete;
		// Total Value Including Taxes
		private BigDecimal vServ;
		// Withholding ICMS Tax Base
		private BigDecimal vBcret;
		// Withheld ICMS Tax Rate
		private BigDecimal pIcmsret;
		// Withheld ICMS Value
		private BigDecimal vIcmsret;
		// NF-e Item CFOP Code
		private String cfop;
		// City Code
		private Long cMunFg;
		// Vehicle License Plate
		private String placa;
		// Region
		private String uf;
		// National Cargo Carrier Registration (ANTT)
		private String rntc;
		// Wagon Identification
		private String vagao;
		// Ferryboat Identification
		private String balsa;

		public IsNfeTransp(String modFrete, BigDecimal vServ,
				BigDecimal vBcret, BigDecimal pIcmsret, BigDecimal vIcmsret,
				String cfop, Long cMunFg, String placa, String uf, String rntc,
				String vagao, String balsa) {
			this.modFrete = modFrete;
			this.vServ = vServ;
			this.vBcret = vBcret;
			this.pIcmsret = pIcmsret;
			this.vIcmsret = vIcmsret;
			this.cfop = cfop;
			this.cMunFg = cMunFg;
			this.placa = placa;
			this.uf = uf;
			this.rntc = rntc;
			this.vagao = vagao;
			this.balsa = balsa;
		}

		public IsNfeTransp(JCoStructure jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setModFrete(String modFrete) {
			this.modFrete = modFrete;
		}

		public String getModFrete() {
			return this.modFrete;
		}

		public void setVServ(BigDecimal vServ) {
			this.vServ = vServ;
		}

		public BigDecimal getVServ() {
			return this.vServ;
		}

		public void setVBcret(BigDecimal vBcret) {
			this.vBcret = vBcret;
		}

		public BigDecimal getVBcret() {
			return this.vBcret;
		}

		public void setPIcmsret(BigDecimal pIcmsret) {
			this.pIcmsret = pIcmsret;
		}

		public BigDecimal getPIcmsret() {
			return this.pIcmsret;
		}

		public void setVIcmsret(BigDecimal vIcmsret) {
			this.vIcmsret = vIcmsret;
		}

		public BigDecimal getVIcmsret() {
			return this.vIcmsret;
		}

		public void setCfop(String cfop) {
			this.cfop = cfop;
		}

		public String getCfop() {
			return this.cfop;
		}

		public void setCMunFg(Long cMunFg) {
			this.cMunFg = cMunFg;
		}

		public Long getCMunFg() {
			return this.cMunFg;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getPlaca() {
			return this.placa;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getUf() {
			return this.uf;
		}

		public void setRntc(String rntc) {
			this.rntc = rntc;
		}

		public String getRntc() {
			return this.rntc;
		}

		public void setVagao(String vagao) {
			this.vagao = vagao;
		}

		public String getVagao() {
			return this.vagao;
		}

		public void setBalsa(String balsa) {
			this.balsa = balsa;
		}

		public String getBalsa() {
			return this.balsa;
		}

		public void fillClassAttributes(JCoStructure jcoParam) {
			this.modFrete = jcoParam.getString("MOD_FRETE");
			this.vServ = jcoParam.getBigDecimal("V_SERV");
			this.vBcret = jcoParam.getBigDecimal("V_BCRET");
			this.pIcmsret = jcoParam.getBigDecimal("P_ICMSRET");
			this.vIcmsret = jcoParam.getBigDecimal("V_ICMSRET");
			this.cfop = jcoParam.getString("CFOP");
			this.cMunFg = jcoParam.getLong("C_MUN_FG");
			this.placa = jcoParam.getString("PLACA");
			this.uf = jcoParam.getString("UF");
			this.rntc = jcoParam.getString("RNTC");
			this.vagao = jcoParam.getString("VAGAO");
			this.balsa = jcoParam.getString("BALSA");
		}

		public void fillJCoParameter(JCoStructure jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("MOD_FRETE", this.modFrete);
			jcoParam.setValue("V_SERV", this.vServ);
			jcoParam.setValue("V_BCRET", this.vBcret);
			jcoParam.setValue("P_ICMSRET", this.pIcmsret);
			jcoParam.setValue("V_ICMSRET", this.vIcmsret);
			jcoParam.setValue("CFOP", this.cfop);
			jcoParam.setValue("C_MUN_FG", this.cMunFg);
			jcoParam.setValue("PLACA", this.placa);
			jcoParam.setValue("UF", this.uf);
			jcoParam.setValue("RNTC", this.rntc);
			jcoParam.setValue("VAGAO", this.vagao);
			jcoParam.setValue("BALSA", this.balsa);
		}

	}

	public static class ItNfeAutxml implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Tax Number 1
		private String cnpj;
		// Tax Number 2
		private String cpf;

		public ItNfeAutxml(Long id, String cnpj, String cpf) {
			this.id = id;
			this.cnpj = cnpj;
			this.cpf = cpf;
		}

		public ItNfeAutxml(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getCpf() {
			return this.cpf;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.cnpj = jcoParam.getString("CNPJ");
			this.cpf = jcoParam.getString("CPF");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("CPF", this.cpf);
		}

	}

	public static class ItNfeCanaFordia implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Document Number
		private Long docnum;
		// Day
		private Long dia;
		// Quantity (kg)
		private BigDecimal qtde;

		public ItNfeCanaFordia(Long docnum, Long dia, BigDecimal qtde) {
			this.docnum = docnum;
			this.dia = dia;
			this.qtde = qtde;
		}

		public ItNfeCanaFordia(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setDocnum(Long docnum) {
			this.docnum = docnum;
		}

		public Long getDocnum() {
			return this.docnum;
		}

		public void setDia(Long dia) {
			this.dia = dia;
		}

		public Long getDia() {
			return this.dia;
		}

		public void setQtde(BigDecimal qtde) {
			this.qtde = qtde;
		}

		public BigDecimal getQtde() {
			return this.qtde;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.docnum = jcoParam.getLong("DOCNUM");
			this.dia = jcoParam.getLong("DIA");
			this.qtde = jcoParam.getBigDecimal("QTDE");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("DOCNUM", this.docnum);
			jcoParam.setValue("DIA", this.dia);
			jcoParam.setValue("QTDE", this.qtde);
		}

	}

	public static class ItNfeDet implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Item Number
		private Long nItem;
		// NF-e RFC Product Reference
		private Long prodRef;
		// NF-e RFC Tax Reference
		private Long impostoRef;
		// NF-e Percentage of Returned Goods
		private BigDecimal pDevol;
		// NF-e IPI Returned Value
		private BigDecimal vIpidevol;
		// Additional Information Concerning to the Authorities
		private String infAdProd;

		public ItNfeDet(Long id, Long nItem, Long prodRef, Long impostoRef,
				BigDecimal pDevol, BigDecimal vIpidevol, String infAdProd) {
			this.id = id;
			this.nItem = nItem;
			this.prodRef = prodRef;
			this.impostoRef = impostoRef;
			this.pDevol = pDevol;
			this.vIpidevol = vIpidevol;
			this.infAdProd = infAdProd;
		}

		public ItNfeDet(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setNItem(Long nItem) {
			this.nItem = nItem;
		}

		public Long getNItem() {
			return this.nItem;
		}

		public void setProdRef(Long prodRef) {
			this.prodRef = prodRef;
		}

		public Long getProdRef() {
			return this.prodRef;
		}

		public void setImpostoRef(Long impostoRef) {
			this.impostoRef = impostoRef;
		}

		public Long getImpostoRef() {
			return this.impostoRef;
		}

		public void setPDevol(BigDecimal pDevol) {
			this.pDevol = pDevol;
		}

		public BigDecimal getPDevol() {
			return this.pDevol;
		}

		public void setVIpidevol(BigDecimal vIpidevol) {
			this.vIpidevol = vIpidevol;
		}

		public BigDecimal getVIpidevol() {
			return this.vIpidevol;
		}

		public void setInfAdProd(String infAdProd) {
			this.infAdProd = infAdProd;
		}

		public String getInfAdProd() {
			return this.infAdProd;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.nItem = jcoParam.getLong("N_ITEM");
			this.prodRef = jcoParam.getLong("PROD_REF");
			this.impostoRef = jcoParam.getLong("IMPOSTO_REF");
			this.pDevol = jcoParam.getBigDecimal("P_DEVOL");
			this.vIpidevol = jcoParam.getBigDecimal("V_IPIDEVOL");
			this.infAdProd = jcoParam.getString("INF_AD_PROD");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("N_ITEM", this.nItem);
			jcoParam.setValue("PROD_REF", this.prodRef);
			jcoParam.setValue("IMPOSTO_REF", this.impostoRef);
			jcoParam.setValue("P_DEVOL", this.pDevol);
			jcoParam.setValue("V_IPIDEVOL", this.vIpidevol);
			jcoParam.setValue("INF_AD_PROD", this.infAdProd);
		}

	}

	public static class ItNfeDetImposto implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Total Tax Value, Version 2
		private BigDecimal vtottrib;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_ICMS
		private Long icmsRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_IPI
		private Long ipiRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_II
		private Long iiRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_ISSQN
		private Long issqnRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_PIS
		private Long pisRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_PISST
		private Long pisstRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_COFINS
		private Long cofinsRef;
		// Reference of line-ID of Tab. J_1BNFE_T_RFC_IMPOSTO_COFINSST
		private Long cofinsstRef;

		public ItNfeDetImposto(Long id, BigDecimal vtottrib, Long icmsRef,
				Long ipiRef, Long iiRef, Long issqnRef, Long pisRef,
				Long pisstRef, Long cofinsRef, Long cofinsstRef) {
			this.id = id;
			this.vtottrib = vtottrib;
			this.icmsRef = icmsRef;
			this.ipiRef = ipiRef;
			this.iiRef = iiRef;
			this.issqnRef = issqnRef;
			this.pisRef = pisRef;
			this.pisstRef = pisstRef;
			this.cofinsRef = cofinsRef;
			this.cofinsstRef = cofinsstRef;
		}

		public ItNfeDetImposto(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setVtottrib(BigDecimal vtottrib) {
			this.vtottrib = vtottrib;
		}

		public BigDecimal getVtottrib() {
			return this.vtottrib;
		}

		public void setIcmsRef(Long icmsRef) {
			this.icmsRef = icmsRef;
		}

		public Long getIcmsRef() {
			return this.icmsRef;
		}

		public void setIpiRef(Long ipiRef) {
			this.ipiRef = ipiRef;
		}

		public Long getIpiRef() {
			return this.ipiRef;
		}

		public void setIiRef(Long iiRef) {
			this.iiRef = iiRef;
		}

		public Long getIiRef() {
			return this.iiRef;
		}

		public void setIssqnRef(Long issqnRef) {
			this.issqnRef = issqnRef;
		}

		public Long getIssqnRef() {
			return this.issqnRef;
		}

		public void setPisRef(Long pisRef) {
			this.pisRef = pisRef;
		}

		public Long getPisRef() {
			return this.pisRef;
		}

		public void setPisstRef(Long pisstRef) {
			this.pisstRef = pisstRef;
		}

		public Long getPisstRef() {
			return this.pisstRef;
		}

		public void setCofinsRef(Long cofinsRef) {
			this.cofinsRef = cofinsRef;
		}

		public Long getCofinsRef() {
			return this.cofinsRef;
		}

		public void setCofinsstRef(Long cofinsstRef) {
			this.cofinsstRef = cofinsstRef;
		}

		public Long getCofinsstRef() {
			return this.cofinsstRef;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.vtottrib = jcoParam.getBigDecimal("VTOTTRIB");
			this.icmsRef = jcoParam.getLong("ICMS_REF");
			this.ipiRef = jcoParam.getLong("IPI_REF");
			this.iiRef = jcoParam.getLong("II_REF");
			this.issqnRef = jcoParam.getLong("ISSQN_REF");
			this.pisRef = jcoParam.getLong("PIS_REF");
			this.pisstRef = jcoParam.getLong("PISST_REF");
			this.cofinsRef = jcoParam.getLong("COFINS_REF");
			this.cofinsstRef = jcoParam.getLong("COFINSST_REF");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("VTOTTRIB", this.vtottrib);
			jcoParam.setValue("ICMS_REF", this.icmsRef);
			jcoParam.setValue("IPI_REF", this.ipiRef);
			jcoParam.setValue("II_REF", this.iiRef);
			jcoParam.setValue("ISSQN_REF", this.issqnRef);
			jcoParam.setValue("PIS_REF", this.pisRef);
			jcoParam.setValue("PISST_REF", this.pisstRef);
			jcoParam.setValue("COFINS_REF", this.cofinsRef);
			jcoParam.setValue("COFINSST_REF", this.cofinsstRef);
		}

	}

	public static class ItNfeDetProd implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e Material Number
		private String cProd;
		// NF-e EAN/UPC-Code Item
		private String cEan;
		// NF-e RFC Product Description
		private String xProd;
		// NF-e Item Control Code For Consumption Taxes in Foreign Trad
		private String ncm;
		// Line ID of Table
		private Long textIdNve;
		// NF-e Exception in IPI Table
		private String extipi;
		// NF-e Item CFOP Code
		private String cfop;
		// NF-e Item Commercial Unit
		private String uCom;
		// NF-e Item Commercial Quantity
		private BigDecimal qCom;
		// NF-e Item Commercial Unit Value
		private BigDecimal vUnCom;
		// Total value including all taxes
		private BigDecimal vProd;
		// NF-e Taxable Unity GTIN (Global Trade Item Number)
		private String cEantrib;
		// NF-e Taxable Unit
		private String uTrib;
		// NF-e Taxable Quantity
		private BigDecimal qTrib;
		// NF-e Taxable Unit Value
		private BigDecimal vUnTrib;
		// Freight value including taxes
		private BigDecimal vFrete;
		// Insurance value including taxes
		private BigDecimal vSeg;
		// Discount value including taxes
		private BigDecimal vDesc;
		// NF-e Other Additional Costs
		private BigDecimal vOutro;
		// Indicator of Whether Item Value (vProd) Included in NF-e
		private Long indTot;
		// Line ID of Table
		private Long diRef;
		// Line ID of Table
		private Long detexportRef;
		// NF-e Purchase Order Number
		private String xPed;
		// NF-e Item Number of Purchase Order
		private Long nItemPed;
		// FCI Number
		private String nFci;
		// Line ID of Table
		private Long veicprodRef;
		// Line ID of Table
		private Long medRef;
		// Line ID of Table
		private Long armaRef;
		// Line ID of Table
		private Long combRef;
		// Line ID of Table
		private Long nrecopiRef;

		public ItNfeDetProd(Long id, String cProd, String cEan, String xProd,
				String ncm, Long textIdNve, String extipi, String cfop,
				String uCom, BigDecimal qCom, BigDecimal vUnCom,
				BigDecimal vProd, String cEantrib, String uTrib,
				BigDecimal qTrib, BigDecimal vUnTrib, BigDecimal vFrete,
				BigDecimal vSeg, BigDecimal vDesc, BigDecimal vOutro,
				Long indTot, Long diRef, Long detexportRef, String xPed,
				Long nItemPed, String nFci, Long veicprodRef, Long medRef,
				Long armaRef, Long combRef, Long nrecopiRef) {
			this.id = id;
			this.cProd = cProd;
			this.cEan = cEan;
			this.xProd = xProd;
			this.ncm = ncm;
			this.textIdNve = textIdNve;
			this.extipi = extipi;
			this.cfop = cfop;
			this.uCom = uCom;
			this.qCom = qCom;
			this.vUnCom = vUnCom;
			this.vProd = vProd;
			this.cEantrib = cEantrib;
			this.uTrib = uTrib;
			this.qTrib = qTrib;
			this.vUnTrib = vUnTrib;
			this.vFrete = vFrete;
			this.vSeg = vSeg;
			this.vDesc = vDesc;
			this.vOutro = vOutro;
			this.indTot = indTot;
			this.diRef = diRef;
			this.detexportRef = detexportRef;
			this.xPed = xPed;
			this.nItemPed = nItemPed;
			this.nFci = nFci;
			this.veicprodRef = veicprodRef;
			this.medRef = medRef;
			this.armaRef = armaRef;
			this.combRef = combRef;
			this.nrecopiRef = nrecopiRef;
		}

		public ItNfeDetProd(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setCProd(String cProd) {
			this.cProd = cProd;
		}

		public String getCProd() {
			return this.cProd;
		}

		public void setCEan(String cEan) {
			this.cEan = cEan;
		}

		public String getCEan() {
			return this.cEan;
		}

		public void setXProd(String xProd) {
			this.xProd = xProd;
		}

		public String getXProd() {
			return this.xProd;
		}

		public void setNcm(String ncm) {
			this.ncm = ncm;
		}

		public String getNcm() {
			return this.ncm;
		}

		public void setTextIdNve(Long textIdNve) {
			this.textIdNve = textIdNve;
		}

		public Long getTextIdNve() {
			return this.textIdNve;
		}

		public void setExtipi(String extipi) {
			this.extipi = extipi;
		}

		public String getExtipi() {
			return this.extipi;
		}

		public void setCfop(String cfop) {
			this.cfop = cfop;
		}

		public String getCfop() {
			return this.cfop;
		}

		public void setUCom(String uCom) {
			this.uCom = uCom;
		}

		public String getUCom() {
			return this.uCom;
		}

		public void setQCom(BigDecimal qCom) {
			this.qCom = qCom;
		}

		public BigDecimal getQCom() {
			return this.qCom;
		}

		public void setVUnCom(BigDecimal vUnCom) {
			this.vUnCom = vUnCom;
		}

		public BigDecimal getVUnCom() {
			return this.vUnCom;
		}

		public void setVProd(BigDecimal vProd) {
			this.vProd = vProd;
		}

		public BigDecimal getVProd() {
			return this.vProd;
		}

		public void setCEantrib(String cEantrib) {
			this.cEantrib = cEantrib;
		}

		public String getCEantrib() {
			return this.cEantrib;
		}

		public void setUTrib(String uTrib) {
			this.uTrib = uTrib;
		}

		public String getUTrib() {
			return this.uTrib;
		}

		public void setQTrib(BigDecimal qTrib) {
			this.qTrib = qTrib;
		}

		public BigDecimal getQTrib() {
			return this.qTrib;
		}

		public void setVUnTrib(BigDecimal vUnTrib) {
			this.vUnTrib = vUnTrib;
		}

		public BigDecimal getVUnTrib() {
			return this.vUnTrib;
		}

		public void setVFrete(BigDecimal vFrete) {
			this.vFrete = vFrete;
		}

		public BigDecimal getVFrete() {
			return this.vFrete;
		}

		public void setVSeg(BigDecimal vSeg) {
			this.vSeg = vSeg;
		}

		public BigDecimal getVSeg() {
			return this.vSeg;
		}

		public void setVDesc(BigDecimal vDesc) {
			this.vDesc = vDesc;
		}

		public BigDecimal getVDesc() {
			return this.vDesc;
		}

		public void setVOutro(BigDecimal vOutro) {
			this.vOutro = vOutro;
		}

		public BigDecimal getVOutro() {
			return this.vOutro;
		}

		public void setIndTot(Long indTot) {
			this.indTot = indTot;
		}

		public Long getIndTot() {
			return this.indTot;
		}

		public void setDiRef(Long diRef) {
			this.diRef = diRef;
		}

		public Long getDiRef() {
			return this.diRef;
		}

		public void setDetexportRef(Long detexportRef) {
			this.detexportRef = detexportRef;
		}

		public Long getDetexportRef() {
			return this.detexportRef;
		}

		public void setXPed(String xPed) {
			this.xPed = xPed;
		}

		public String getXPed() {
			return this.xPed;
		}

		public void setNItemPed(Long nItemPed) {
			this.nItemPed = nItemPed;
		}

		public Long getNItemPed() {
			return this.nItemPed;
		}

		public void setNFci(String nFci) {
			this.nFci = nFci;
		}

		public String getNFci() {
			return this.nFci;
		}

		public void setVeicprodRef(Long veicprodRef) {
			this.veicprodRef = veicprodRef;
		}

		public Long getVeicprodRef() {
			return this.veicprodRef;
		}

		public void setMedRef(Long medRef) {
			this.medRef = medRef;
		}

		public Long getMedRef() {
			return this.medRef;
		}

		public void setArmaRef(Long armaRef) {
			this.armaRef = armaRef;
		}

		public Long getArmaRef() {
			return this.armaRef;
		}

		public void setCombRef(Long combRef) {
			this.combRef = combRef;
		}

		public Long getCombRef() {
			return this.combRef;
		}

		public void setNrecopiRef(Long nrecopiRef) {
			this.nrecopiRef = nrecopiRef;
		}

		public Long getNrecopiRef() {
			return this.nrecopiRef;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.cProd = jcoParam.getString("C_PROD");
			this.cEan = jcoParam.getString("C_EAN");
			this.xProd = jcoParam.getString("X_PROD");
			this.ncm = jcoParam.getString("NCM");
			this.textIdNve = jcoParam.getLong("TEXT_ID_NVE");
			this.extipi = jcoParam.getString("EXTIPI");
			this.cfop = jcoParam.getString("CFOP");
			this.uCom = jcoParam.getString("U_COM");
			this.qCom = jcoParam.getBigDecimal("Q_COM");
			this.vUnCom = jcoParam.getBigDecimal("V_UN_COM");
			this.vProd = jcoParam.getBigDecimal("V_PROD");
			this.cEantrib = jcoParam.getString("C_EANTRIB");
			this.uTrib = jcoParam.getString("U_TRIB");
			this.qTrib = jcoParam.getBigDecimal("Q_TRIB");
			this.vUnTrib = jcoParam.getBigDecimal("V_UN_TRIB");
			this.vFrete = jcoParam.getBigDecimal("V_FRETE");
			this.vSeg = jcoParam.getBigDecimal("V_SEG");
			this.vDesc = jcoParam.getBigDecimal("V_DESC");
			this.vOutro = jcoParam.getBigDecimal("V_OUTRO");
			this.indTot = jcoParam.getLong("IND_TOT");
			this.diRef = jcoParam.getLong("DI_REF");
			this.detexportRef = jcoParam.getLong("DETEXPORT_REF");
			this.xPed = jcoParam.getString("X_PED");
			this.nItemPed = jcoParam.getLong("N_ITEM_PED");
			this.nFci = jcoParam.getString("N_FCI");
			this.veicprodRef = jcoParam.getLong("VEICPROD_REF");
			this.medRef = jcoParam.getLong("MED_REF");
			this.armaRef = jcoParam.getLong("ARMA_REF");
			this.combRef = jcoParam.getLong("COMB_REF");
			this.nrecopiRef = jcoParam.getLong("NRECOPI_REF");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("C_PROD", this.cProd);
			jcoParam.setValue("C_EAN", this.cEan);
			jcoParam.setValue("X_PROD", this.xProd);
			jcoParam.setValue("NCM", this.ncm);
			jcoParam.setValue("TEXT_ID_NVE", this.textIdNve);
			jcoParam.setValue("EXTIPI", this.extipi);
			jcoParam.setValue("CFOP", this.cfop);
			jcoParam.setValue("U_COM", this.uCom);
			jcoParam.setValue("Q_COM", this.qCom);
			jcoParam.setValue("V_UN_COM", this.vUnCom);
			jcoParam.setValue("V_PROD", this.vProd);
			jcoParam.setValue("C_EANTRIB", this.cEantrib);
			jcoParam.setValue("U_TRIB", this.uTrib);
			jcoParam.setValue("Q_TRIB", this.qTrib);
			jcoParam.setValue("V_UN_TRIB", this.vUnTrib);
			jcoParam.setValue("V_FRETE", this.vFrete);
			jcoParam.setValue("V_SEG", this.vSeg);
			jcoParam.setValue("V_DESC", this.vDesc);
			jcoParam.setValue("V_OUTRO", this.vOutro);
			jcoParam.setValue("IND_TOT", this.indTot);
			jcoParam.setValue("DI_REF", this.diRef);
			jcoParam.setValue("DETEXPORT_REF", this.detexportRef);
			jcoParam.setValue("X_PED", this.xPed);
			jcoParam.setValue("N_ITEM_PED", this.nItemPed);
			jcoParam.setValue("N_FCI", this.nFci);
			jcoParam.setValue("VEICPROD_REF", this.veicprodRef);
			jcoParam.setValue("MED_REF", this.medRef);
			jcoParam.setValue("ARMA_REF", this.armaRef);
			jcoParam.setValue("COMB_REF", this.combRef);
			jcoParam.setValue("NRECOPI_REF", this.nrecopiRef);
		}

	}

	public static class ItNfeDiAdi implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Sequence Number 3 positions
		private Long seqNo;
		// Addition Number
		private Long nAdicao;
		// Sequential Number of Item in the Addition
		private Long nSeqAdic;
		// Foreign Manufacturer Code in System
		private String cFabricante;
		// Addition Item Discount Value
		private BigDecimal vDescDi;
		// Number of drawback concession
		private String nDraw;

		public ItNfeDiAdi(Long id, Long seqNo, Long nAdicao, Long nSeqAdic,
				String cFabricante, BigDecimal vDescDi, String nDraw) {
			this.id = id;
			this.seqNo = seqNo;
			this.nAdicao = nAdicao;
			this.nSeqAdic = nSeqAdic;
			this.cFabricante = cFabricante;
			this.vDescDi = vDescDi;
			this.nDraw = nDraw;
		}

		public ItNfeDiAdi(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setNAdicao(Long nAdicao) {
			this.nAdicao = nAdicao;
		}

		public Long getNAdicao() {
			return this.nAdicao;
		}

		public void setNSeqAdic(Long nSeqAdic) {
			this.nSeqAdic = nSeqAdic;
		}

		public Long getNSeqAdic() {
			return this.nSeqAdic;
		}

		public void setCFabricante(String cFabricante) {
			this.cFabricante = cFabricante;
		}

		public String getCFabricante() {
			return this.cFabricante;
		}

		public void setVDescDi(BigDecimal vDescDi) {
			this.vDescDi = vDescDi;
		}

		public BigDecimal getVDescDi() {
			return this.vDescDi;
		}

		public void setNDraw(String nDraw) {
			this.nDraw = nDraw;
		}

		public String getNDraw() {
			return this.nDraw;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.nAdicao = jcoParam.getLong("N_ADICAO");
			this.nSeqAdic = jcoParam.getLong("N_SEQ_ADIC");
			this.cFabricante = jcoParam.getString("C_FABRICANTE");
			this.vDescDi = jcoParam.getBigDecimal("V_DESC_DI");
			this.nDraw = jcoParam.getString("N_DRAW");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("N_ADICAO", this.nAdicao);
			jcoParam.setValue("N_SEQ_ADIC", this.nSeqAdic);
			jcoParam.setValue("C_FABRICANTE", this.cFabricante);
			jcoParam.setValue("V_DESC_DI", this.vDescDi);
			jcoParam.setValue("N_DRAW", this.nDraw);
		}

	}

	public static class ItNfeDup implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Trade Note Number
		private String nDup;
		// Expiring Date of Trade Note (YYYY-MM-DD)
		private Date dVenc;
		// Trade Note Value
		private BigDecimal vDup;

		public ItNfeDup(Long id, String nDup, Date dVenc, BigDecimal vDup) {
			this.id = id;
			this.nDup = nDup;
			this.dVenc = dVenc;
			this.vDup = vDup;
		}

		public ItNfeDup(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setNDup(String nDup) {
			this.nDup = nDup;
		}

		public String getNDup() {
			return this.nDup;
		}

		public void setDVenc(Date dVenc) {
			this.dVenc = dVenc;
		}

		public Date getDVenc() {
			return this.dVenc;
		}

		public void setVDup(BigDecimal vDup) {
			this.vDup = vDup;
		}

		public BigDecimal getVDup() {
			return this.vDup;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.nDup = jcoParam.getString("N_DUP");
			this.dVenc = jcoParam.getDate("D_VENC");
			this.vDup = jcoParam.getBigDecimal("V_DUP");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("N_DUP", this.nDup);
			jcoParam.setValue("D_VENC", this.dVenc);
			jcoParam.setValue("V_DUP", this.vDup);
		}

	}

	public static class ItNfeExt1 implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Document Number
		private Long docnum;
		// Document Item Number
		private Long itmnum;
		// Character field with length 250
		private String field1;
		// Character field with length 250
		private String field2;
		// Character field with length 250
		private String field3;
		// Character field with length 250
		private String field4;

		public ItNfeExt1(Long docnum, Long itmnum, String field1,
				String field2, String field3, String field4) {
			this.docnum = docnum;
			this.itmnum = itmnum;
			this.field1 = field1;
			this.field2 = field2;
			this.field3 = field3;
			this.field4 = field4;
		}

		public ItNfeExt1(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setDocnum(Long docnum) {
			this.docnum = docnum;
		}

		public Long getDocnum() {
			return this.docnum;
		}

		public void setItmnum(Long itmnum) {
			this.itmnum = itmnum;
		}

		public Long getItmnum() {
			return this.itmnum;
		}

		public void setField1(String field1) {
			this.field1 = field1;
		}

		public String getField1() {
			return this.field1;
		}

		public void setField2(String field2) {
			this.field2 = field2;
		}

		public String getField2() {
			return this.field2;
		}

		public void setField3(String field3) {
			this.field3 = field3;
		}

		public String getField3() {
			return this.field3;
		}

		public void setField4(String field4) {
			this.field4 = field4;
		}

		public String getField4() {
			return this.field4;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.docnum = jcoParam.getLong("DOCNUM");
			this.itmnum = jcoParam.getLong("ITMNUM");
			this.field1 = jcoParam.getString("FIELD1");
			this.field2 = jcoParam.getString("FIELD2");
			this.field3 = jcoParam.getString("FIELD3");
			this.field4 = jcoParam.getString("FIELD4");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("DOCNUM", this.docnum);
			jcoParam.setValue("ITMNUM", this.itmnum);
			jcoParam.setValue("FIELD1", this.field1);
			jcoParam.setValue("FIELD2", this.field2);
			jcoParam.setValue("FIELD3", this.field3);
			jcoParam.setValue("FIELD4", this.field4);
		}

	}

	public static class ItNfeExt2 implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Document Number
		private Long docnum;
		// Document Item Number
		private Long itmnum;
		// Element
		private String param;
		// Lines in parameter
		private Integer row;
		// Field name
		private String field;
		// Char255
		private String value;
		// Data Type in ABAP Dictionary
		private String type;
		// Length (No. of Characters)
		private Long length;

		public ItNfeExt2(Long docnum, Long itmnum, String param, Integer row,
				String field, String value, String type, Long length) {
			this.docnum = docnum;
			this.itmnum = itmnum;
			this.param = param;
			this.row = row;
			this.field = field;
			this.value = value;
			this.type = type;
			this.length = length;
		}

		public ItNfeExt2(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setDocnum(Long docnum) {
			this.docnum = docnum;
		}

		public Long getDocnum() {
			return this.docnum;
		}

		public void setItmnum(Long itmnum) {
			this.itmnum = itmnum;
		}

		public Long getItmnum() {
			return this.itmnum;
		}

		public void setParam(String param) {
			this.param = param;
		}

		public String getParam() {
			return this.param;
		}

		public void setRow(Integer row) {
			this.row = row;
		}

		public Integer getRow() {
			return this.row;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getField() {
			return this.field;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getType() {
			return this.type;
		}

		public void setLength(Long length) {
			this.length = length;
		}

		public Long getLength() {
			return this.length;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.docnum = jcoParam.getLong("DOCNUM");
			this.itmnum = jcoParam.getLong("ITMNUM");
			this.param = jcoParam.getString("PARAM");
			this.row = jcoParam.getInt("ROW");
			this.field = jcoParam.getString("FIELD");
			this.value = jcoParam.getString("VALUE");
			this.type = jcoParam.getString("TYPE");
			this.length = jcoParam.getLong("LENGTH");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("DOCNUM", this.docnum);
			jcoParam.setValue("ITMNUM", this.itmnum);
			jcoParam.setValue("PARAM", this.param);
			jcoParam.setValue("ROW", this.row);
			jcoParam.setValue("FIELD", this.field);
			jcoParam.setValue("VALUE", this.value);
			jcoParam.setValue("TYPE", this.type);
			jcoParam.setValue("LENGTH", this.length);
		}

	}

	public static class ItNfeImpostoCofins implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Tax Situation
		private String cst;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pCofins;
		// Tax Value
		private BigDecimal vCofins;
		// Sold quantity
		private BigDecimal qBcprod;
		// Factoring (in BRL)
		private BigDecimal vAliqProd;

		public ItNfeImpostoCofins(Long id, String cst, BigDecimal vBc,
				BigDecimal pCofins, BigDecimal vCofins, BigDecimal qBcprod,
				BigDecimal vAliqProd) {
			this.id = id;
			this.cst = cst;
			this.vBc = vBc;
			this.pCofins = pCofins;
			this.vCofins = vCofins;
			this.qBcprod = qBcprod;
			this.vAliqProd = vAliqProd;
		}

		public ItNfeImpostoCofins(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setCst(String cst) {
			this.cst = cst;
		}

		public String getCst() {
			return this.cst;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPCofins(BigDecimal pCofins) {
			this.pCofins = pCofins;
		}

		public BigDecimal getPCofins() {
			return this.pCofins;
		}

		public void setVCofins(BigDecimal vCofins) {
			this.vCofins = vCofins;
		}

		public BigDecimal getVCofins() {
			return this.vCofins;
		}

		public void setQBcprod(BigDecimal qBcprod) {
			this.qBcprod = qBcprod;
		}

		public BigDecimal getQBcprod() {
			return this.qBcprod;
		}

		public void setVAliqProd(BigDecimal vAliqProd) {
			this.vAliqProd = vAliqProd;
		}

		public BigDecimal getVAliqProd() {
			return this.vAliqProd;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.cst = jcoParam.getString("CST");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pCofins = jcoParam.getBigDecimal("P_COFINS");
			this.vCofins = jcoParam.getBigDecimal("V_COFINS");
			this.qBcprod = jcoParam.getBigDecimal("Q_BCPROD");
			this.vAliqProd = jcoParam.getBigDecimal("V_ALIQ_PROD");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("CST", this.cst);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_COFINS", this.pCofins);
			jcoParam.setValue("V_COFINS", this.vCofins);
			jcoParam.setValue("Q_BCPROD", this.qBcprod);
			jcoParam.setValue("V_ALIQ_PROD", this.vAliqProd);
		}

	}

	public static class ItNfeImpostoCofinsst implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pCofins;
		// Tax Value
		private BigDecimal vCofins;
		// Sold quantity
		private BigDecimal qBcprod;
		// Factoring (in BRL)
		private BigDecimal vAliqProd;

		public ItNfeImpostoCofinsst(Long id, BigDecimal vBc,
				BigDecimal pCofins, BigDecimal vCofins, BigDecimal qBcprod,
				BigDecimal vAliqProd) {
			this.id = id;
			this.vBc = vBc;
			this.pCofins = pCofins;
			this.vCofins = vCofins;
			this.qBcprod = qBcprod;
			this.vAliqProd = vAliqProd;
		}

		public ItNfeImpostoCofinsst(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPCofins(BigDecimal pCofins) {
			this.pCofins = pCofins;
		}

		public BigDecimal getPCofins() {
			return this.pCofins;
		}

		public void setVCofins(BigDecimal vCofins) {
			this.vCofins = vCofins;
		}

		public BigDecimal getVCofins() {
			return this.vCofins;
		}

		public void setQBcprod(BigDecimal qBcprod) {
			this.qBcprod = qBcprod;
		}

		public BigDecimal getQBcprod() {
			return this.qBcprod;
		}

		public void setVAliqProd(BigDecimal vAliqProd) {
			this.vAliqProd = vAliqProd;
		}

		public BigDecimal getVAliqProd() {
			return this.vAliqProd;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pCofins = jcoParam.getBigDecimal("P_COFINS");
			this.vCofins = jcoParam.getBigDecimal("V_COFINS");
			this.qBcprod = jcoParam.getBigDecimal("Q_BCPROD");
			this.vAliqProd = jcoParam.getBigDecimal("V_ALIQ_PROD");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_COFINS", this.pCofins);
			jcoParam.setValue("V_COFINS", this.vCofins);
			jcoParam.setValue("Q_BCPROD", this.qBcprod);
			jcoParam.setValue("V_ALIQ_PROD", this.vAliqProd);
		}

	}

	public static class ItNfeImpostoIcms implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Merchandise Origin
		private String orig;
		// Tax Situation
		private String cst;
		// ICMS Calculation Base Modality Determination
		private Long modBc;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pIcms;
		// Tax Value
		private BigDecimal vIcms;
		// ICMS Calculation Base Modality Determination
		private Long modBcst;
		// Margin percentage of value Added from ICMS ST
		private BigDecimal pMvast;
		// Percentage Reduction of BC of ICMS
		private BigDecimal pRedBcst;
		// Base amount
		private BigDecimal vBcst;
		// Tax Rate
		private BigDecimal pIcmsst;
		// Tax Value
		private BigDecimal vIcmsst;
		// Percentage Reduction of BC of ICMS
		private BigDecimal pRedBc;
		// NF-e Total of desoneration of ICMS
		private BigDecimal vIcmsdeson;
		// Reason of desoneration of ICMS
		private String motDesIcms;
		// Value of operation of ICMS
		private BigDecimal vIcmsop;
		// Percentage of deferral
		private BigDecimal pDif;
		// Value of deferred ICMS
		private BigDecimal vIcmsdif;
		// Base amount
		private BigDecimal vBcstret;
		// Tax Value
		private BigDecimal vIcmsstret;
		// Percentage of BC own operation
		private BigDecimal pBcop;
		// Region
		private String ufst;
		// Base amount
		private BigDecimal vBcstdest;
		// Tax Value
		private BigDecimal vIcmsstdest;
		// Operation Situation Code - &quot;Simples Nacional&quot;
		private Long csosn;
		// Applicable rate of the credit calculation (Simples Nacional)
		private BigDecimal pCredSn;
		// ICMS Credit Value According to LC 123 (Simples Nacional)
		private BigDecimal vCredIcmssn;

		public ItNfeImpostoIcms(Long id, String orig, String cst, Long modBc,
				BigDecimal vBc, BigDecimal pIcms, BigDecimal vIcms,
				Long modBcst, BigDecimal pMvast, BigDecimal pRedBcst,
				BigDecimal vBcst, BigDecimal pIcmsst, BigDecimal vIcmsst,
				BigDecimal pRedBc, BigDecimal vIcmsdeson, String motDesIcms,
				BigDecimal vIcmsop, BigDecimal pDif, BigDecimal vIcmsdif,
				BigDecimal vBcstret, BigDecimal vIcmsstret, BigDecimal pBcop,
				String ufst, BigDecimal vBcstdest, BigDecimal vIcmsstdest,
				Long csosn, BigDecimal pCredSn, BigDecimal vCredIcmssn) {
			this.id = id;
			this.orig = orig;
			this.cst = cst;
			this.modBc = modBc;
			this.vBc = vBc;
			this.pIcms = pIcms;
			this.vIcms = vIcms;
			this.modBcst = modBcst;
			this.pMvast = pMvast;
			this.pRedBcst = pRedBcst;
			this.vBcst = vBcst;
			this.pIcmsst = pIcmsst;
			this.vIcmsst = vIcmsst;
			this.pRedBc = pRedBc;
			this.vIcmsdeson = vIcmsdeson;
			this.motDesIcms = motDesIcms;
			this.vIcmsop = vIcmsop;
			this.pDif = pDif;
			this.vIcmsdif = vIcmsdif;
			this.vBcstret = vBcstret;
			this.vIcmsstret = vIcmsstret;
			this.pBcop = pBcop;
			this.ufst = ufst;
			this.vBcstdest = vBcstdest;
			this.vIcmsstdest = vIcmsstdest;
			this.csosn = csosn;
			this.pCredSn = pCredSn;
			this.vCredIcmssn = vCredIcmssn;
		}

		public ItNfeImpostoIcms(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setOrig(String orig) {
			this.orig = orig;
		}

		public String getOrig() {
			return this.orig;
		}

		public void setCst(String cst) {
			this.cst = cst;
		}

		public String getCst() {
			return this.cst;
		}

		public void setModBc(Long modBc) {
			this.modBc = modBc;
		}

		public Long getModBc() {
			return this.modBc;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPIcms(BigDecimal pIcms) {
			this.pIcms = pIcms;
		}

		public BigDecimal getPIcms() {
			return this.pIcms;
		}

		public void setVIcms(BigDecimal vIcms) {
			this.vIcms = vIcms;
		}

		public BigDecimal getVIcms() {
			return this.vIcms;
		}

		public void setModBcst(Long modBcst) {
			this.modBcst = modBcst;
		}

		public Long getModBcst() {
			return this.modBcst;
		}

		public void setPMvast(BigDecimal pMvast) {
			this.pMvast = pMvast;
		}

		public BigDecimal getPMvast() {
			return this.pMvast;
		}

		public void setPRedBcst(BigDecimal pRedBcst) {
			this.pRedBcst = pRedBcst;
		}

		public BigDecimal getPRedBcst() {
			return this.pRedBcst;
		}

		public void setVBcst(BigDecimal vBcst) {
			this.vBcst = vBcst;
		}

		public BigDecimal getVBcst() {
			return this.vBcst;
		}

		public void setPIcmsst(BigDecimal pIcmsst) {
			this.pIcmsst = pIcmsst;
		}

		public BigDecimal getPIcmsst() {
			return this.pIcmsst;
		}

		public void setVIcmsst(BigDecimal vIcmsst) {
			this.vIcmsst = vIcmsst;
		}

		public BigDecimal getVIcmsst() {
			return this.vIcmsst;
		}

		public void setPRedBc(BigDecimal pRedBc) {
			this.pRedBc = pRedBc;
		}

		public BigDecimal getPRedBc() {
			return this.pRedBc;
		}

		public void setVIcmsdeson(BigDecimal vIcmsdeson) {
			this.vIcmsdeson = vIcmsdeson;
		}

		public BigDecimal getVIcmsdeson() {
			return this.vIcmsdeson;
		}

		public void setMotDesIcms(String motDesIcms) {
			this.motDesIcms = motDesIcms;
		}

		public String getMotDesIcms() {
			return this.motDesIcms;
		}

		public void setVIcmsop(BigDecimal vIcmsop) {
			this.vIcmsop = vIcmsop;
		}

		public BigDecimal getVIcmsop() {
			return this.vIcmsop;
		}

		public void setPDif(BigDecimal pDif) {
			this.pDif = pDif;
		}

		public BigDecimal getPDif() {
			return this.pDif;
		}

		public void setVIcmsdif(BigDecimal vIcmsdif) {
			this.vIcmsdif = vIcmsdif;
		}

		public BigDecimal getVIcmsdif() {
			return this.vIcmsdif;
		}

		public void setVBcstret(BigDecimal vBcstret) {
			this.vBcstret = vBcstret;
		}

		public BigDecimal getVBcstret() {
			return this.vBcstret;
		}

		public void setVIcmsstret(BigDecimal vIcmsstret) {
			this.vIcmsstret = vIcmsstret;
		}

		public BigDecimal getVIcmsstret() {
			return this.vIcmsstret;
		}

		public void setPBcop(BigDecimal pBcop) {
			this.pBcop = pBcop;
		}

		public BigDecimal getPBcop() {
			return this.pBcop;
		}

		public void setUfst(String ufst) {
			this.ufst = ufst;
		}

		public String getUfst() {
			return this.ufst;
		}

		public void setVBcstdest(BigDecimal vBcstdest) {
			this.vBcstdest = vBcstdest;
		}

		public BigDecimal getVBcstdest() {
			return this.vBcstdest;
		}

		public void setVIcmsstdest(BigDecimal vIcmsstdest) {
			this.vIcmsstdest = vIcmsstdest;
		}

		public BigDecimal getVIcmsstdest() {
			return this.vIcmsstdest;
		}

		public void setCsosn(Long csosn) {
			this.csosn = csosn;
		}

		public Long getCsosn() {
			return this.csosn;
		}

		public void setPCredSn(BigDecimal pCredSn) {
			this.pCredSn = pCredSn;
		}

		public BigDecimal getPCredSn() {
			return this.pCredSn;
		}

		public void setVCredIcmssn(BigDecimal vCredIcmssn) {
			this.vCredIcmssn = vCredIcmssn;
		}

		public BigDecimal getVCredIcmssn() {
			return this.vCredIcmssn;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.orig = jcoParam.getString("ORIG");
			this.cst = jcoParam.getString("CST");
			this.modBc = jcoParam.getLong("MOD_BC");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pIcms = jcoParam.getBigDecimal("P_ICMS");
			this.vIcms = jcoParam.getBigDecimal("V_ICMS");
			this.modBcst = jcoParam.getLong("MOD_BCST");
			this.pMvast = jcoParam.getBigDecimal("P_MVAST");
			this.pRedBcst = jcoParam.getBigDecimal("P_RED_BCST");
			this.vBcst = jcoParam.getBigDecimal("V_BCST");
			this.pIcmsst = jcoParam.getBigDecimal("P_ICMSST");
			this.vIcmsst = jcoParam.getBigDecimal("V_ICMSST");
			this.pRedBc = jcoParam.getBigDecimal("P_RED_BC");
			this.vIcmsdeson = jcoParam.getBigDecimal("V_ICMSDESON");
			this.motDesIcms = jcoParam.getString("MOT_DES_ICMS");
			this.vIcmsop = jcoParam.getBigDecimal("V_ICMSOP");
			this.pDif = jcoParam.getBigDecimal("P_DIF");
			this.vIcmsdif = jcoParam.getBigDecimal("V_ICMSDIF");
			this.vBcstret = jcoParam.getBigDecimal("V_BCSTRET");
			this.vIcmsstret = jcoParam.getBigDecimal("V_ICMSSTRET");
			this.pBcop = jcoParam.getBigDecimal("P_BCOP");
			this.ufst = jcoParam.getString("UFST");
			this.vBcstdest = jcoParam.getBigDecimal("V_BCSTDEST");
			this.vIcmsstdest = jcoParam.getBigDecimal("V_ICMSSTDEST");
			this.csosn = jcoParam.getLong("CSOSN");
			this.pCredSn = jcoParam.getBigDecimal("P_CRED_SN");
			this.vCredIcmssn = jcoParam.getBigDecimal("V_CRED_ICMSSN");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("ORIG", this.orig);
			jcoParam.setValue("CST", this.cst);
			jcoParam.setValue("MOD_BC", this.modBc);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_ICMS", this.pIcms);
			jcoParam.setValue("V_ICMS", this.vIcms);
			jcoParam.setValue("MOD_BCST", this.modBcst);
			jcoParam.setValue("P_MVAST", this.pMvast);
			jcoParam.setValue("P_RED_BCST", this.pRedBcst);
			jcoParam.setValue("V_BCST", this.vBcst);
			jcoParam.setValue("P_ICMSST", this.pIcmsst);
			jcoParam.setValue("V_ICMSST", this.vIcmsst);
			jcoParam.setValue("P_RED_BC", this.pRedBc);
			jcoParam.setValue("V_ICMSDESON", this.vIcmsdeson);
			jcoParam.setValue("MOT_DES_ICMS", this.motDesIcms);
			jcoParam.setValue("V_ICMSOP", this.vIcmsop);
			jcoParam.setValue("P_DIF", this.pDif);
			jcoParam.setValue("V_ICMSDIF", this.vIcmsdif);
			jcoParam.setValue("V_BCSTRET", this.vBcstret);
			jcoParam.setValue("V_ICMSSTRET", this.vIcmsstret);
			jcoParam.setValue("P_BCOP", this.pBcop);
			jcoParam.setValue("UFST", this.ufst);
			jcoParam.setValue("V_BCSTDEST", this.vBcstdest);
			jcoParam.setValue("V_ICMSSTDEST", this.vIcmsstdest);
			jcoParam.setValue("CSOSN", this.csosn);
			jcoParam.setValue("P_CRED_SN", this.pCredSn);
			jcoParam.setValue("V_CRED_ICMSSN", this.vCredIcmssn);
		}

	}

	public static class ItNfeImpostoIi implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Base amount
		private BigDecimal vBc;
		// Customs Clearance Costs Value
		private BigDecimal vDespAdu;
		// Total II Value
		private BigDecimal vIi;
		// Financial Operations Tax (IOF) Value
		private BigDecimal vIof;

		public ItNfeImpostoIi(Long id, BigDecimal vBc, BigDecimal vDespAdu,
				BigDecimal vIi, BigDecimal vIof) {
			this.id = id;
			this.vBc = vBc;
			this.vDespAdu = vDespAdu;
			this.vIi = vIi;
			this.vIof = vIof;
		}

		public ItNfeImpostoIi(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setVDespAdu(BigDecimal vDespAdu) {
			this.vDespAdu = vDespAdu;
		}

		public BigDecimal getVDespAdu() {
			return this.vDespAdu;
		}

		public void setVIi(BigDecimal vIi) {
			this.vIi = vIi;
		}

		public BigDecimal getVIi() {
			return this.vIi;
		}

		public void setVIof(BigDecimal vIof) {
			this.vIof = vIof;
		}

		public BigDecimal getVIof() {
			return this.vIof;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.vDespAdu = jcoParam.getBigDecimal("V_DESP_ADU");
			this.vIi = jcoParam.getBigDecimal("V_II");
			this.vIof = jcoParam.getBigDecimal("V_IOF");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("V_DESP_ADU", this.vDespAdu);
			jcoParam.setValue("V_II", this.vIi);
			jcoParam.setValue("V_IOF", this.vIof);
		}

	}

	public static class ItNfeImpostoIpi implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// IPI Classification for Tobacco Products and Beverages
		private String clEnq;
		// Tax Number 1
		private String cnpjprod;
		// IPI Control Seal Code
		private String cSelo;
		// Control Seal Quantity
		private Long qSelo;
		// IPI Legal Classification Code
		private String cEnq;
		// Tax Situation
		private String cst;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pIpi;
		// Tax Value
		private BigDecimal vIpi;
		// Total Quantity in the Taxable Standard Unity
		private BigDecimal qUnid;
		// Taxable Unity Value
		private BigDecimal vUnid;

		public ItNfeImpostoIpi(Long id, String clEnq, String cnpjprod,
				String cSelo, Long qSelo, String cEnq, String cst,
				BigDecimal vBc, BigDecimal pIpi, BigDecimal vIpi,
				BigDecimal qUnid, BigDecimal vUnid) {
			this.id = id;
			this.clEnq = clEnq;
			this.cnpjprod = cnpjprod;
			this.cSelo = cSelo;
			this.qSelo = qSelo;
			this.cEnq = cEnq;
			this.cst = cst;
			this.vBc = vBc;
			this.pIpi = pIpi;
			this.vIpi = vIpi;
			this.qUnid = qUnid;
			this.vUnid = vUnid;
		}

		public ItNfeImpostoIpi(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setClEnq(String clEnq) {
			this.clEnq = clEnq;
		}

		public String getClEnq() {
			return this.clEnq;
		}

		public void setCnpjprod(String cnpjprod) {
			this.cnpjprod = cnpjprod;
		}

		public String getCnpjprod() {
			return this.cnpjprod;
		}

		public void setCSelo(String cSelo) {
			this.cSelo = cSelo;
		}

		public String getCSelo() {
			return this.cSelo;
		}

		public void setQSelo(Long qSelo) {
			this.qSelo = qSelo;
		}

		public Long getQSelo() {
			return this.qSelo;
		}

		public void setCEnq(String cEnq) {
			this.cEnq = cEnq;
		}

		public String getCEnq() {
			return this.cEnq;
		}

		public void setCst(String cst) {
			this.cst = cst;
		}

		public String getCst() {
			return this.cst;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPIpi(BigDecimal pIpi) {
			this.pIpi = pIpi;
		}

		public BigDecimal getPIpi() {
			return this.pIpi;
		}

		public void setVIpi(BigDecimal vIpi) {
			this.vIpi = vIpi;
		}

		public BigDecimal getVIpi() {
			return this.vIpi;
		}

		public void setQUnid(BigDecimal qUnid) {
			this.qUnid = qUnid;
		}

		public BigDecimal getQUnid() {
			return this.qUnid;
		}

		public void setVUnid(BigDecimal vUnid) {
			this.vUnid = vUnid;
		}

		public BigDecimal getVUnid() {
			return this.vUnid;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.clEnq = jcoParam.getString("CL_ENQ");
			this.cnpjprod = jcoParam.getString("CNPJPROD");
			this.cSelo = jcoParam.getString("C_SELO");
			this.qSelo = jcoParam.getLong("Q_SELO");
			this.cEnq = jcoParam.getString("C_ENQ");
			this.cst = jcoParam.getString("CST");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pIpi = jcoParam.getBigDecimal("P_IPI");
			this.vIpi = jcoParam.getBigDecimal("V_IPI");
			this.qUnid = jcoParam.getBigDecimal("Q_UNID");
			this.vUnid = jcoParam.getBigDecimal("V_UNID");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("CL_ENQ", this.clEnq);
			jcoParam.setValue("CNPJPROD", this.cnpjprod);
			jcoParam.setValue("C_SELO", this.cSelo);
			jcoParam.setValue("Q_SELO", this.qSelo);
			jcoParam.setValue("C_ENQ", this.cEnq);
			jcoParam.setValue("CST", this.cst);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_IPI", this.pIpi);
			jcoParam.setValue("V_IPI", this.vIpi);
			jcoParam.setValue("Q_UNID", this.qUnid);
			jcoParam.setValue("V_UNID", this.vUnid);
		}

	}

	public static class ItNfeImpostoIssqn implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal vAliq;
		// Tax Value
		private BigDecimal vIssqn;
		// City Code
		private Long cMunFg;
		// ISS service type code according to law LC 116/03
		private String cListServ;
		// Value Deduction for Calculation Base Reduction
		private BigDecimal vDeducao;
		// Other Accessory Costs
		private BigDecimal vOutro;
		// Unconditioned Discount Value
		private BigDecimal vDescIncond;
		// Conditioned Discount Value
		private BigDecimal vDescCond;
		// Total Withhold Amount of ISS
		private BigDecimal vIssret;
		// Liability indicator of ISS
		private Long indIss;
		// Service code in the town
		private String cServico;
		// City Code
		private Long cMun;
		// Country Key
		private String cPais;
		// N° of judicial or admin. process to liability&#39;s suspension
		private String nProcesso;
		// Fiscal incentives Indicator
		private Long indIncentivo;

		public ItNfeImpostoIssqn(Long id, BigDecimal vBc, BigDecimal vAliq,
				BigDecimal vIssqn, Long cMunFg, String cListServ,
				BigDecimal vDeducao, BigDecimal vOutro, BigDecimal vDescIncond,
				BigDecimal vDescCond, BigDecimal vIssret, Long indIss,
				String cServico, Long cMun, String cPais, String nProcesso,
				Long indIncentivo) {
			this.id = id;
			this.vBc = vBc;
			this.vAliq = vAliq;
			this.vIssqn = vIssqn;
			this.cMunFg = cMunFg;
			this.cListServ = cListServ;
			this.vDeducao = vDeducao;
			this.vOutro = vOutro;
			this.vDescIncond = vDescIncond;
			this.vDescCond = vDescCond;
			this.vIssret = vIssret;
			this.indIss = indIss;
			this.cServico = cServico;
			this.cMun = cMun;
			this.cPais = cPais;
			this.nProcesso = nProcesso;
			this.indIncentivo = indIncentivo;
		}

		public ItNfeImpostoIssqn(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setVAliq(BigDecimal vAliq) {
			this.vAliq = vAliq;
		}

		public BigDecimal getVAliq() {
			return this.vAliq;
		}

		public void setVIssqn(BigDecimal vIssqn) {
			this.vIssqn = vIssqn;
		}

		public BigDecimal getVIssqn() {
			return this.vIssqn;
		}

		public void setCMunFg(Long cMunFg) {
			this.cMunFg = cMunFg;
		}

		public Long getCMunFg() {
			return this.cMunFg;
		}

		public void setCListServ(String cListServ) {
			this.cListServ = cListServ;
		}

		public String getCListServ() {
			return this.cListServ;
		}

		public void setVDeducao(BigDecimal vDeducao) {
			this.vDeducao = vDeducao;
		}

		public BigDecimal getVDeducao() {
			return this.vDeducao;
		}

		public void setVOutro(BigDecimal vOutro) {
			this.vOutro = vOutro;
		}

		public BigDecimal getVOutro() {
			return this.vOutro;
		}

		public void setVDescIncond(BigDecimal vDescIncond) {
			this.vDescIncond = vDescIncond;
		}

		public BigDecimal getVDescIncond() {
			return this.vDescIncond;
		}

		public void setVDescCond(BigDecimal vDescCond) {
			this.vDescCond = vDescCond;
		}

		public BigDecimal getVDescCond() {
			return this.vDescCond;
		}

		public void setVIssret(BigDecimal vIssret) {
			this.vIssret = vIssret;
		}

		public BigDecimal getVIssret() {
			return this.vIssret;
		}

		public void setIndIss(Long indIss) {
			this.indIss = indIss;
		}

		public Long getIndIss() {
			return this.indIss;
		}

		public void setCServico(String cServico) {
			this.cServico = cServico;
		}

		public String getCServico() {
			return this.cServico;
		}

		public void setCMun(Long cMun) {
			this.cMun = cMun;
		}

		public Long getCMun() {
			return this.cMun;
		}

		public void setCPais(String cPais) {
			this.cPais = cPais;
		}

		public String getCPais() {
			return this.cPais;
		}

		public void setNProcesso(String nProcesso) {
			this.nProcesso = nProcesso;
		}

		public String getNProcesso() {
			return this.nProcesso;
		}

		public void setIndIncentivo(Long indIncentivo) {
			this.indIncentivo = indIncentivo;
		}

		public Long getIndIncentivo() {
			return this.indIncentivo;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.vAliq = jcoParam.getBigDecimal("V_ALIQ");
			this.vIssqn = jcoParam.getBigDecimal("V_ISSQN");
			this.cMunFg = jcoParam.getLong("C_MUN_FG");
			this.cListServ = jcoParam.getString("C_LIST_SERV");
			this.vDeducao = jcoParam.getBigDecimal("V_DEDUCAO");
			this.vOutro = jcoParam.getBigDecimal("V_OUTRO");
			this.vDescIncond = jcoParam.getBigDecimal("V_DESC_INCOND");
			this.vDescCond = jcoParam.getBigDecimal("V_DESC_COND");
			this.vIssret = jcoParam.getBigDecimal("V_ISSRET");
			this.indIss = jcoParam.getLong("IND_ISS");
			this.cServico = jcoParam.getString("C_SERVICO");
			this.cMun = jcoParam.getLong("C_MUN");
			this.cPais = jcoParam.getString("C_PAIS");
			this.nProcesso = jcoParam.getString("N_PROCESSO");
			this.indIncentivo = jcoParam.getLong("IND_INCENTIVO");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("V_ALIQ", this.vAliq);
			jcoParam.setValue("V_ISSQN", this.vIssqn);
			jcoParam.setValue("C_MUN_FG", this.cMunFg);
			jcoParam.setValue("C_LIST_SERV", this.cListServ);
			jcoParam.setValue("V_DEDUCAO", this.vDeducao);
			jcoParam.setValue("V_OUTRO", this.vOutro);
			jcoParam.setValue("V_DESC_INCOND", this.vDescIncond);
			jcoParam.setValue("V_DESC_COND", this.vDescCond);
			jcoParam.setValue("V_ISSRET", this.vIssret);
			jcoParam.setValue("IND_ISS", this.indIss);
			jcoParam.setValue("C_SERVICO", this.cServico);
			jcoParam.setValue("C_MUN", this.cMun);
			jcoParam.setValue("C_PAIS", this.cPais);
			jcoParam.setValue("N_PROCESSO", this.nProcesso);
			jcoParam.setValue("IND_INCENTIVO", this.indIncentivo);
		}

	}

	public static class ItNfeImpostoPis implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Tax Situation
		private Long cst;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pPis;
		// Tax Value
		private BigDecimal vPis;
		// Sold quantity
		private BigDecimal qBcprod;
		// Factoring (in BRL)
		private BigDecimal vAliqProd;

		public ItNfeImpostoPis(Long id, Long cst, BigDecimal vBc,
				BigDecimal pPis, BigDecimal vPis, BigDecimal qBcprod,
				BigDecimal vAliqProd) {
			this.id = id;
			this.cst = cst;
			this.vBc = vBc;
			this.pPis = pPis;
			this.vPis = vPis;
			this.qBcprod = qBcprod;
			this.vAliqProd = vAliqProd;
		}

		public ItNfeImpostoPis(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setCst(Long cst) {
			this.cst = cst;
		}

		public Long getCst() {
			return this.cst;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPPis(BigDecimal pPis) {
			this.pPis = pPis;
		}

		public BigDecimal getPPis() {
			return this.pPis;
		}

		public void setVPis(BigDecimal vPis) {
			this.vPis = vPis;
		}

		public BigDecimal getVPis() {
			return this.vPis;
		}

		public void setQBcprod(BigDecimal qBcprod) {
			this.qBcprod = qBcprod;
		}

		public BigDecimal getQBcprod() {
			return this.qBcprod;
		}

		public void setVAliqProd(BigDecimal vAliqProd) {
			this.vAliqProd = vAliqProd;
		}

		public BigDecimal getVAliqProd() {
			return this.vAliqProd;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.cst = jcoParam.getLong("CST");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pPis = jcoParam.getBigDecimal("P_PIS");
			this.vPis = jcoParam.getBigDecimal("V_PIS");
			this.qBcprod = jcoParam.getBigDecimal("Q_BCPROD");
			this.vAliqProd = jcoParam.getBigDecimal("V_ALIQ_PROD");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("CST", this.cst);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_PIS", this.pPis);
			jcoParam.setValue("V_PIS", this.vPis);
			jcoParam.setValue("Q_BCPROD", this.qBcprod);
			jcoParam.setValue("V_ALIQ_PROD", this.vAliqProd);
		}

	}

	public static class ItNfeImpostoPisst implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Base amount
		private BigDecimal vBc;
		// Tax Rate
		private BigDecimal pPis;
		// Sold quantity
		private BigDecimal qBcprod;
		// Factoring (in BRL)
		private BigDecimal vAliqProd;
		// Tax Value
		private BigDecimal vPis;

		public ItNfeImpostoPisst(Long id, BigDecimal vBc, BigDecimal pPis,
				BigDecimal qBcprod, BigDecimal vAliqProd, BigDecimal vPis) {
			this.id = id;
			this.vBc = vBc;
			this.pPis = pPis;
			this.qBcprod = qBcprod;
			this.vAliqProd = vAliqProd;
			this.vPis = vPis;
		}

		public ItNfeImpostoPisst(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setVBc(BigDecimal vBc) {
			this.vBc = vBc;
		}

		public BigDecimal getVBc() {
			return this.vBc;
		}

		public void setPPis(BigDecimal pPis) {
			this.pPis = pPis;
		}

		public BigDecimal getPPis() {
			return this.pPis;
		}

		public void setQBcprod(BigDecimal qBcprod) {
			this.qBcprod = qBcprod;
		}

		public BigDecimal getQBcprod() {
			return this.qBcprod;
		}

		public void setVAliqProd(BigDecimal vAliqProd) {
			this.vAliqProd = vAliqProd;
		}

		public BigDecimal getVAliqProd() {
			return this.vAliqProd;
		}

		public void setVPis(BigDecimal vPis) {
			this.vPis = vPis;
		}

		public BigDecimal getVPis() {
			return this.vPis;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.vBc = jcoParam.getBigDecimal("V_BC");
			this.pPis = jcoParam.getBigDecimal("P_PIS");
			this.qBcprod = jcoParam.getBigDecimal("Q_BCPROD");
			this.vAliqProd = jcoParam.getBigDecimal("V_ALIQ_PROD");
			this.vPis = jcoParam.getBigDecimal("V_PIS");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("V_BC", this.vBc);
			jcoParam.setValue("P_PIS", this.pPis);
			jcoParam.setValue("Q_BCPROD", this.qBcprod);
			jcoParam.setValue("V_ALIQ_PROD", this.vAliqProd);
			jcoParam.setValue("V_PIS", this.vPis);
		}

	}

	public static class ItNfeNfref implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e: 44-Digit Access Key
		private String refNfe;
		// State
		private String cUf;
		// NF-e Issue Date (MMYY) of Reference NF
		private Long aamm;
		// Tax Number 1
		private String cnpj;
		// Model of Nota Fiscal
		private Long mod;
		// Series
		private String serie;
		// Nine-Digit NF-e Number
		private String nNf;
		// Tax Number 2
		private String cpf;
		// State Tax Number
		private String ie;
		// NF-e: 44-Digit Access Key
		private String refCte;
		// NF-e ECF Model
		private String modEcf;
		// NF-e ECF Number
		private Long nEcf;
		// NF-e Operation Order Counter Number
		private Long nCoo;

		public ItNfeNfref(Long id, String refNfe, String cUf, Long aamm,
				String cnpj, Long mod, String serie, String nNf, String cpf,
				String ie, String refCte, String modEcf, Long nEcf, Long nCoo) {
			this.id = id;
			this.refNfe = refNfe;
			this.cUf = cUf;
			this.aamm = aamm;
			this.cnpj = cnpj;
			this.mod = mod;
			this.serie = serie;
			this.nNf = nNf;
			this.cpf = cpf;
			this.ie = ie;
			this.refCte = refCte;
			this.modEcf = modEcf;
			this.nEcf = nEcf;
			this.nCoo = nCoo;
		}

		public ItNfeNfref(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setRefNfe(String refNfe) {
			this.refNfe = refNfe;
		}

		public String getRefNfe() {
			return this.refNfe;
		}

		public void setCUf(String cUf) {
			this.cUf = cUf;
		}

		public String getCUf() {
			return this.cUf;
		}

		public void setAamm(Long aamm) {
			this.aamm = aamm;
		}

		public Long getAamm() {
			return this.aamm;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setMod(Long mod) {
			this.mod = mod;
		}

		public Long getMod() {
			return this.mod;
		}

		public void setSerie(String serie) {
			this.serie = serie;
		}

		public String getSerie() {
			return this.serie;
		}

		public void setNNf(String nNf) {
			this.nNf = nNf;
		}

		public String getNNf() {
			return this.nNf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getCpf() {
			return this.cpf;
		}

		public void setIe(String ie) {
			this.ie = ie;
		}

		public String getIe() {
			return this.ie;
		}

		public void setRefCte(String refCte) {
			this.refCte = refCte;
		}

		public String getRefCte() {
			return this.refCte;
		}

		public void setModEcf(String modEcf) {
			this.modEcf = modEcf;
		}

		public String getModEcf() {
			return this.modEcf;
		}

		public void setNEcf(Long nEcf) {
			this.nEcf = nEcf;
		}

		public Long getNEcf() {
			return this.nEcf;
		}

		public void setNCoo(Long nCoo) {
			this.nCoo = nCoo;
		}

		public Long getNCoo() {
			return this.nCoo;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.refNfe = jcoParam.getString("REF_NFE");
			this.cUf = jcoParam.getString("C_UF");
			this.aamm = jcoParam.getLong("AAMM");
			this.cnpj = jcoParam.getString("CNPJ");
			this.mod = jcoParam.getLong("MOD");
			this.serie = jcoParam.getString("SERIE");
			this.nNf = jcoParam.getString("N_NF");
			this.cpf = jcoParam.getString("CPF");
			this.ie = jcoParam.getString("IE");
			this.refCte = jcoParam.getString("REF_CTE");
			this.modEcf = jcoParam.getString("MOD_ECF");
			this.nEcf = jcoParam.getLong("N_ECF");
			this.nCoo = jcoParam.getLong("N_COO");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("REF_NFE", this.refNfe);
			jcoParam.setValue("C_UF", this.cUf);
			jcoParam.setValue("AAMM", this.aamm);
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("MOD", this.mod);
			jcoParam.setValue("SERIE", this.serie);
			jcoParam.setValue("N_NF", this.nNf);
			jcoParam.setValue("CPF", this.cpf);
			jcoParam.setValue("IE", this.ie);
			jcoParam.setValue("REF_CTE", this.refCte);
			jcoParam.setValue("MOD_ECF", this.modEcf);
			jcoParam.setValue("N_ECF", this.nEcf);
			jcoParam.setValue("N_COO", this.nCoo);
		}

	}

	public static class ItNfePag implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Payment Method
		private String tPag;
		// Payment Amount
		private BigDecimal vPag;
		// Tax Number 1
		private String cnpj;
		// Credit Card Company
		private String tBand;
		// Authorization Number
		private String cAut;

		public ItNfePag(Long id, String tPag, BigDecimal vPag, String cnpj,
				String tBand, String cAut) {
			this.id = id;
			this.tPag = tPag;
			this.vPag = vPag;
			this.cnpj = cnpj;
			this.tBand = tBand;
			this.cAut = cAut;
		}

		public ItNfePag(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setTPag(String tPag) {
			this.tPag = tPag;
		}

		public String getTPag() {
			return this.tPag;
		}

		public void setVPag(BigDecimal vPag) {
			this.vPag = vPag;
		}

		public BigDecimal getVPag() {
			return this.vPag;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setTBand(String tBand) {
			this.tBand = tBand;
		}

		public String getTBand() {
			return this.tBand;
		}

		public void setCAut(String cAut) {
			this.cAut = cAut;
		}

		public String getCAut() {
			return this.cAut;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.tPag = jcoParam.getString("T_PAG");
			this.vPag = jcoParam.getBigDecimal("V_PAG");
			this.cnpj = jcoParam.getString("CNPJ");
			this.tBand = jcoParam.getString("T_BAND");
			this.cAut = jcoParam.getString("C_AUT");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("T_PAG", this.tPag);
			jcoParam.setValue("V_PAG", this.vPag);
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("T_BAND", this.tBand);
			jcoParam.setValue("C_AUT", this.cAut);
		}

	}

	public static class ItNfePartner implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// NF-e RFC Partner Reference
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// Tax Number 1
		private String cnpj;
		// Tax Number 2
		private String cpf;
		// NF-e RFC Partner Name
		private String xNome;
		// NF-e RFC Partner Trade Name
		private String xFant;
		// Street
		private String xLgr;
		// NF-e Partner No.
		private String nro;
		// NF-e RFC Address Supplement
		private String xCpl;
		// NF-e RFC Address District
		private String xBairro;
		// NF-e RFC Address City Code
		private Long cMun;
		// NF-e RFC Address City Name
		private String xMun;
		// State
		private String uf;
		// NF-e RFC Partner CEP
		private String cep;
		// Country code according to the destination
		private String cPais;
		// NF-e RFC Country Name
		private String xPais;
		// NF-e telephone number
		private String fone;
		// NF-e RFC State Tax Number
		private String ie;
		// SUFRAMA Subscription of Partner
		private String isuf;
		// NF-e RFC E-mail Address
		private String email;
		// NF-e RFC State Tax Number
		private String iest;
		// NF-e RFC City Code Identification
		private String im;
		// CNAE
		private String cnae;
		// Taxation Code
		private Long crt;
		// NF-e State Tax Number Indicator
		private Long indIedest;
		// NF-e Partner Foreign ID
		private String idEstrangeiro;
		// NF-e RFC Complete Address
		private String xEnder;

		public ItNfePartner(Long id, Long seqNo, String cnpj, String cpf,
				String xNome, String xFant, String xLgr, String nro,
				String xCpl, String xBairro, Long cMun, String xMun, String uf,
				String cep, String cPais, String xPais, String fone, String ie,
				String isuf, String email, String iest, String im, String cnae,
				Long crt, Long indIedest, String idEstrangeiro, String xEnder) {
			this.id = id;
			this.seqNo = seqNo;
			this.cnpj = cnpj;
			this.cpf = cpf;
			this.xNome = xNome;
			this.xFant = xFant;
			this.xLgr = xLgr;
			this.nro = nro;
			this.xCpl = xCpl;
			this.xBairro = xBairro;
			this.cMun = cMun;
			this.xMun = xMun;
			this.uf = uf;
			this.cep = cep;
			this.cPais = cPais;
			this.xPais = xPais;
			this.fone = fone;
			this.ie = ie;
			this.isuf = isuf;
			this.email = email;
			this.iest = iest;
			this.im = im;
			this.cnae = cnae;
			this.crt = crt;
			this.indIedest = indIedest;
			this.idEstrangeiro = idEstrangeiro;
			this.xEnder = xEnder;
		}

		public ItNfePartner(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getCpf() {
			return this.cpf;
		}

		public void setXNome(String xNome) {
			this.xNome = xNome;
		}

		public String getXNome() {
			return this.xNome;
		}

		public void setXFant(String xFant) {
			this.xFant = xFant;
		}

		public String getXFant() {
			return this.xFant;
		}

		public void setXLgr(String xLgr) {
			this.xLgr = xLgr;
		}

		public String getXLgr() {
			return this.xLgr;
		}

		public void setNro(String nro) {
			this.nro = nro;
		}

		public String getNro() {
			return this.nro;
		}

		public void setXCpl(String xCpl) {
			this.xCpl = xCpl;
		}

		public String getXCpl() {
			return this.xCpl;
		}

		public void setXBairro(String xBairro) {
			this.xBairro = xBairro;
		}

		public String getXBairro() {
			return this.xBairro;
		}

		public void setCMun(Long cMun) {
			this.cMun = cMun;
		}

		public Long getCMun() {
			return this.cMun;
		}

		public void setXMun(String xMun) {
			this.xMun = xMun;
		}

		public String getXMun() {
			return this.xMun;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getUf() {
			return this.uf;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public String getCep() {
			return this.cep;
		}

		public void setCPais(String cPais) {
			this.cPais = cPais;
		}

		public String getCPais() {
			return this.cPais;
		}

		public void setXPais(String xPais) {
			this.xPais = xPais;
		}

		public String getXPais() {
			return this.xPais;
		}

		public void setFone(String fone) {
			this.fone = fone;
		}

		public String getFone() {
			return this.fone;
		}

		public void setIe(String ie) {
			this.ie = ie;
		}

		public String getIe() {
			return this.ie;
		}

		public void setIsuf(String isuf) {
			this.isuf = isuf;
		}

		public String getIsuf() {
			return this.isuf;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEmail() {
			return this.email;
		}

		public void setIest(String iest) {
			this.iest = iest;
		}

		public String getIest() {
			return this.iest;
		}

		public void setIm(String im) {
			this.im = im;
		}

		public String getIm() {
			return this.im;
		}

		public void setCnae(String cnae) {
			this.cnae = cnae;
		}

		public String getCnae() {
			return this.cnae;
		}

		public void setCrt(Long crt) {
			this.crt = crt;
		}

		public Long getCrt() {
			return this.crt;
		}

		public void setIndIedest(Long indIedest) {
			this.indIedest = indIedest;
		}

		public Long getIndIedest() {
			return this.indIedest;
		}

		public void setIdEstrangeiro(String idEstrangeiro) {
			this.idEstrangeiro = idEstrangeiro;
		}

		public String getIdEstrangeiro() {
			return this.idEstrangeiro;
		}

		public void setXEnder(String xEnder) {
			this.xEnder = xEnder;
		}

		public String getXEnder() {
			return this.xEnder;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.cnpj = jcoParam.getString("CNPJ");
			this.cpf = jcoParam.getString("CPF");
			this.xNome = jcoParam.getString("X_NOME");
			this.xFant = jcoParam.getString("X_FANT");
			this.xLgr = jcoParam.getString("X_LGR");
			this.nro = jcoParam.getString("NRO");
			this.xCpl = jcoParam.getString("X_CPL");
			this.xBairro = jcoParam.getString("X_BAIRRO");
			this.cMun = jcoParam.getLong("C_MUN");
			this.xMun = jcoParam.getString("X_MUN");
			this.uf = jcoParam.getString("UF");
			this.cep = jcoParam.getString("CEP");
			this.cPais = jcoParam.getString("C_PAIS");
			this.xPais = jcoParam.getString("X_PAIS");
			this.fone = jcoParam.getString("FONE");
			this.ie = jcoParam.getString("IE");
			this.isuf = jcoParam.getString("ISUF");
			this.email = jcoParam.getString("EMAIL");
			this.iest = jcoParam.getString("IEST");
			this.im = jcoParam.getString("IM");
			this.cnae = jcoParam.getString("CNAE");
			this.crt = jcoParam.getLong("CRT");
			this.indIedest = jcoParam.getLong("IND_IEDEST");
			this.idEstrangeiro = jcoParam.getString("ID_ESTRANGEIRO");
			this.xEnder = jcoParam.getString("X_ENDER");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("CPF", this.cpf);
			jcoParam.setValue("X_NOME", this.xNome);
			jcoParam.setValue("X_FANT", this.xFant);
			jcoParam.setValue("X_LGR", this.xLgr);
			jcoParam.setValue("NRO", this.nro);
			jcoParam.setValue("X_CPL", this.xCpl);
			jcoParam.setValue("X_BAIRRO", this.xBairro);
			jcoParam.setValue("C_MUN", this.cMun);
			jcoParam.setValue("X_MUN", this.xMun);
			jcoParam.setValue("UF", this.uf);
			jcoParam.setValue("CEP", this.cep);
			jcoParam.setValue("C_PAIS", this.cPais);
			jcoParam.setValue("X_PAIS", this.xPais);
			jcoParam.setValue("FONE", this.fone);
			jcoParam.setValue("IE", this.ie);
			jcoParam.setValue("ISUF", this.isuf);
			jcoParam.setValue("EMAIL", this.email);
			jcoParam.setValue("IEST", this.iest);
			jcoParam.setValue("IM", this.im);
			jcoParam.setValue("CNAE", this.cnae);
			jcoParam.setValue("CRT", this.crt);
			jcoParam.setValue("IND_IEDEST", this.indIedest);
			jcoParam.setValue("ID_ESTRANGEIRO", this.idEstrangeiro);
			jcoParam.setValue("X_ENDER", this.xEnder);
		}

	}

	public static class ItNfeProcref implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Process Identification
		private String nProc;
		// Process Origin Indicator
		private String indProc;

		public ItNfeProcref(Long id, String nProc, String indProc) {
			this.id = id;
			this.nProc = nProc;
			this.indProc = indProc;
		}

		public ItNfeProcref(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setNProc(String nProc) {
			this.nProc = nProc;
		}

		public String getNProc() {
			return this.nProc;
		}

		public void setIndProc(String indProc) {
			this.indProc = indProc;
		}

		public String getIndProc() {
			return this.indProc;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.nProc = jcoParam.getString("N_PROC");
			this.indProc = jcoParam.getString("IND_PROC");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("N_PROC", this.nProc);
			jcoParam.setValue("IND_PROC", this.indProc);
		}

	}

	public static class ItNfeProdArma implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// Fire Arm Type Indicator
		private Long tpArma;
		// Serial number of the gun
		private String nSerie;
		// Serial number of the barrel
		private String nCano;
		// Complete Gun Description
		private String descr;

		public ItNfeProdArma(Long id, Long seqNo, Long tpArma, String nSerie,
				String nCano, String descr) {
			this.id = id;
			this.seqNo = seqNo;
			this.tpArma = tpArma;
			this.nSerie = nSerie;
			this.nCano = nCano;
			this.descr = descr;
		}

		public ItNfeProdArma(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setTpArma(Long tpArma) {
			this.tpArma = tpArma;
		}

		public Long getTpArma() {
			return this.tpArma;
		}

		public void setNSerie(String nSerie) {
			this.nSerie = nSerie;
		}

		public String getNSerie() {
			return this.nSerie;
		}

		public void setNCano(String nCano) {
			this.nCano = nCano;
		}

		public String getNCano() {
			return this.nCano;
		}

		public void setDescr(String descr) {
			this.descr = descr;
		}

		public String getDescr() {
			return this.descr;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.tpArma = jcoParam.getLong("TP_ARMA");
			this.nSerie = jcoParam.getString("N_SERIE");
			this.nCano = jcoParam.getString("N_CANO");
			this.descr = jcoParam.getString("DESCR");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("TP_ARMA", this.tpArma);
			jcoParam.setValue("N_SERIE", this.nSerie);
			jcoParam.setValue("N_CANO", this.nCano);
			jcoParam.setValue("DESCR", this.descr);
		}

	}

	public static class ItNfeProdComb implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// ANP Product Code
		private Long cProdAnp;
		// Percentage of Natural Gas
		private BigDecimal pMixGn;
		// Authorization Code/Registration
		private Long codif;
		// Fuel Quantity at Room Temperature
		private BigDecimal qTemp;
		// Consume UF Abbreviation
		private String ufcons;
		// BC of CIDE
		private BigDecimal qBcprod;
		// Factoring (in BRL)
		private BigDecimal vAliqProd;
		// CIDE Amount
		private BigDecimal vCide;

		public ItNfeProdComb(Long id, Long cProdAnp, BigDecimal pMixGn,
				Long codif, BigDecimal qTemp, String ufcons,
				BigDecimal qBcprod, BigDecimal vAliqProd, BigDecimal vCide) {
			this.id = id;
			this.cProdAnp = cProdAnp;
			this.pMixGn = pMixGn;
			this.codif = codif;
			this.qTemp = qTemp;
			this.ufcons = ufcons;
			this.qBcprod = qBcprod;
			this.vAliqProd = vAliqProd;
			this.vCide = vCide;
		}

		public ItNfeProdComb(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setCProdAnp(Long cProdAnp) {
			this.cProdAnp = cProdAnp;
		}

		public Long getCProdAnp() {
			return this.cProdAnp;
		}

		public void setPMixGn(BigDecimal pMixGn) {
			this.pMixGn = pMixGn;
		}

		public BigDecimal getPMixGn() {
			return this.pMixGn;
		}

		public void setCodif(Long codif) {
			this.codif = codif;
		}

		public Long getCodif() {
			return this.codif;
		}

		public void setQTemp(BigDecimal qTemp) {
			this.qTemp = qTemp;
		}

		public BigDecimal getQTemp() {
			return this.qTemp;
		}

		public void setUfcons(String ufcons) {
			this.ufcons = ufcons;
		}

		public String getUfcons() {
			return this.ufcons;
		}

		public void setQBcprod(BigDecimal qBcprod) {
			this.qBcprod = qBcprod;
		}

		public BigDecimal getQBcprod() {
			return this.qBcprod;
		}

		public void setVAliqProd(BigDecimal vAliqProd) {
			this.vAliqProd = vAliqProd;
		}

		public BigDecimal getVAliqProd() {
			return this.vAliqProd;
		}

		public void setVCide(BigDecimal vCide) {
			this.vCide = vCide;
		}

		public BigDecimal getVCide() {
			return this.vCide;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.cProdAnp = jcoParam.getLong("C_PROD_ANP");
			this.pMixGn = jcoParam.getBigDecimal("P_MIX_GN");
			this.codif = jcoParam.getLong("CODIF");
			this.qTemp = jcoParam.getBigDecimal("Q_TEMP");
			this.ufcons = jcoParam.getString("UFCONS");
			this.qBcprod = jcoParam.getBigDecimal("Q_BCPROD");
			this.vAliqProd = jcoParam.getBigDecimal("V_ALIQ_PROD");
			this.vCide = jcoParam.getBigDecimal("V_CIDE");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("C_PROD_ANP", this.cProdAnp);
			jcoParam.setValue("P_MIX_GN", this.pMixGn);
			jcoParam.setValue("CODIF", this.codif);
			jcoParam.setValue("Q_TEMP", this.qTemp);
			jcoParam.setValue("UFCONS", this.ufcons);
			jcoParam.setValue("Q_BCPROD", this.qBcprod);
			jcoParam.setValue("V_ALIQ_PROD", this.vAliqProd);
			jcoParam.setValue("V_CIDE", this.vCide);
		}

	}

	public static class ItNfeProdDetexport implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// Number of drawback concession
		private String nDraw;
		// Number of exportation register
		private Long nRe;
		// 44-Place Access Key
		private String chNfe;
		// Item quantity actually exported
		private BigDecimal qExport;

		public ItNfeProdDetexport(Long id, Long seqNo, String nDraw, Long nRe,
				String chNfe, BigDecimal qExport) {
			this.id = id;
			this.seqNo = seqNo;
			this.nDraw = nDraw;
			this.nRe = nRe;
			this.chNfe = chNfe;
			this.qExport = qExport;
		}

		public ItNfeProdDetexport(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setNDraw(String nDraw) {
			this.nDraw = nDraw;
		}

		public String getNDraw() {
			return this.nDraw;
		}

		public void setNRe(Long nRe) {
			this.nRe = nRe;
		}

		public Long getNRe() {
			return this.nRe;
		}

		public void setChNfe(String chNfe) {
			this.chNfe = chNfe;
		}

		public String getChNfe() {
			return this.chNfe;
		}

		public void setQExport(BigDecimal qExport) {
			this.qExport = qExport;
		}

		public BigDecimal getQExport() {
			return this.qExport;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.nDraw = jcoParam.getString("N_DRAW");
			this.nRe = jcoParam.getLong("N_RE");
			this.chNfe = jcoParam.getString("CH_NFE");
			this.qExport = jcoParam.getBigDecimal("Q_EXPORT");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("N_DRAW", this.nDraw);
			jcoParam.setValue("N_RE", this.nRe);
			jcoParam.setValue("CH_NFE", this.chNfe);
			jcoParam.setValue("Q_EXPORT", this.qExport);
		}

	}

	public static class ItNfeProdDi implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Sequence Number 3 positions
		private Long seqNo;
		// NF-e Import Document Number (DI, DSI, DIRE)
		private String nDi;
		// Import Document (DI/DSI/DA) Registration Date
		private Date dDi;
		// Customs Clearance Place
		private String xLocDesemb;
		// Customs Clearance Region
		private String ufdesemb;
		// Customs Clearance Date
		private Date dDesemb;
		// Track of international transport informed in DI
		private Long tpViaTransp;
		// AFRMM Value
		private BigDecimal vAfrmm;
		// Import Form
		private Long tpIntermedio;
		// Tax Number 1
		private String cnpj;
		// Region
		private String ufterceiro;
		// Exporter Code
		private String cExportador;
		// Line ID of Table
		private Long adiRef;

		public ItNfeProdDi(Long id, Long seqNo, String nDi, Date dDi,
				String xLocDesemb, String ufdesemb, Date dDesemb,
				Long tpViaTransp, BigDecimal vAfrmm, Long tpIntermedio,
				String cnpj, String ufterceiro, String cExportador, Long adiRef) {
			this.id = id;
			this.seqNo = seqNo;
			this.nDi = nDi;
			this.dDi = dDi;
			this.xLocDesemb = xLocDesemb;
			this.ufdesemb = ufdesemb;
			this.dDesemb = dDesemb;
			this.tpViaTransp = tpViaTransp;
			this.vAfrmm = vAfrmm;
			this.tpIntermedio = tpIntermedio;
			this.cnpj = cnpj;
			this.ufterceiro = ufterceiro;
			this.cExportador = cExportador;
			this.adiRef = adiRef;
		}

		public ItNfeProdDi(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setNDi(String nDi) {
			this.nDi = nDi;
		}

		public String getNDi() {
			return this.nDi;
		}

		public void setDDi(Date dDi) {
			this.dDi = dDi;
		}

		public Date getDDi() {
			return this.dDi;
		}

		public void setXLocDesemb(String xLocDesemb) {
			this.xLocDesemb = xLocDesemb;
		}

		public String getXLocDesemb() {
			return this.xLocDesemb;
		}

		public void setUfdesemb(String ufdesemb) {
			this.ufdesemb = ufdesemb;
		}

		public String getUfdesemb() {
			return this.ufdesemb;
		}

		public void setDDesemb(Date dDesemb) {
			this.dDesemb = dDesemb;
		}

		public Date getDDesemb() {
			return this.dDesemb;
		}

		public void setTpViaTransp(Long tpViaTransp) {
			this.tpViaTransp = tpViaTransp;
		}

		public Long getTpViaTransp() {
			return this.tpViaTransp;
		}

		public void setVAfrmm(BigDecimal vAfrmm) {
			this.vAfrmm = vAfrmm;
		}

		public BigDecimal getVAfrmm() {
			return this.vAfrmm;
		}

		public void setTpIntermedio(Long tpIntermedio) {
			this.tpIntermedio = tpIntermedio;
		}

		public Long getTpIntermedio() {
			return this.tpIntermedio;
		}

		public void setCnpj(String cnpj) {
			this.cnpj = cnpj;
		}

		public String getCnpj() {
			return this.cnpj;
		}

		public void setUfterceiro(String ufterceiro) {
			this.ufterceiro = ufterceiro;
		}

		public String getUfterceiro() {
			return this.ufterceiro;
		}

		public void setCExportador(String cExportador) {
			this.cExportador = cExportador;
		}

		public String getCExportador() {
			return this.cExportador;
		}

		public void setAdiRef(Long adiRef) {
			this.adiRef = adiRef;
		}

		public Long getAdiRef() {
			return this.adiRef;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.nDi = jcoParam.getString("N_DI");
			this.dDi = jcoParam.getDate("D_DI");
			this.xLocDesemb = jcoParam.getString("X_LOC_DESEMB");
			this.ufdesemb = jcoParam.getString("UFDESEMB");
			this.dDesemb = jcoParam.getDate("D_DESEMB");
			this.tpViaTransp = jcoParam.getLong("TP_VIA_TRANSP");
			this.vAfrmm = jcoParam.getBigDecimal("V_AFRMM");
			this.tpIntermedio = jcoParam.getLong("TP_INTERMEDIO");
			this.cnpj = jcoParam.getString("CNPJ");
			this.ufterceiro = jcoParam.getString("UFTERCEIRO");
			this.cExportador = jcoParam.getString("C_EXPORTADOR");
			this.adiRef = jcoParam.getLong("ADI_REF");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("N_DI", this.nDi);
			jcoParam.setValue("D_DI", this.dDi);
			jcoParam.setValue("X_LOC_DESEMB", this.xLocDesemb);
			jcoParam.setValue("UFDESEMB", this.ufdesemb);
			jcoParam.setValue("D_DESEMB", this.dDesemb);
			jcoParam.setValue("TP_VIA_TRANSP", this.tpViaTransp);
			jcoParam.setValue("V_AFRMM", this.vAfrmm);
			jcoParam.setValue("TP_INTERMEDIO", this.tpIntermedio);
			jcoParam.setValue("CNPJ", this.cnpj);
			jcoParam.setValue("UFTERCEIRO", this.ufterceiro);
			jcoParam.setValue("C_EXPORTADOR", this.cExportador);
			jcoParam.setValue("ADI_REF", this.adiRef);
		}

	}

	public static class ItNfeProdMed implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// Medicines and Pharmaceutics Raw Materials Batch Number
		private String nLote;
		// Medicines and Pharmaceutics Raw Materials Products Quantity
		private BigDecimal qLote;
		// Manufacturing Date
		private Date dFab;
		// Expiring Date
		private Date dVal;
		// Consumer Maximum Price
		private BigDecimal vPmc;

		public ItNfeProdMed(Long id, Long seqNo, String nLote,
				BigDecimal qLote, Date dFab, Date dVal, BigDecimal vPmc) {
			this.id = id;
			this.seqNo = seqNo;
			this.nLote = nLote;
			this.qLote = qLote;
			this.dFab = dFab;
			this.dVal = dVal;
			this.vPmc = vPmc;
		}

		public ItNfeProdMed(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setNLote(String nLote) {
			this.nLote = nLote;
		}

		public String getNLote() {
			return this.nLote;
		}

		public void setQLote(BigDecimal qLote) {
			this.qLote = qLote;
		}

		public BigDecimal getQLote() {
			return this.qLote;
		}

		public void setDFab(Date dFab) {
			this.dFab = dFab;
		}

		public Date getDFab() {
			return this.dFab;
		}

		public void setDVal(Date dVal) {
			this.dVal = dVal;
		}

		public Date getDVal() {
			return this.dVal;
		}

		public void setVPmc(BigDecimal vPmc) {
			this.vPmc = vPmc;
		}

		public BigDecimal getVPmc() {
			return this.vPmc;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.nLote = jcoParam.getString("N_LOTE");
			this.qLote = jcoParam.getBigDecimal("Q_LOTE");
			this.dFab = jcoParam.getDate("D_FAB");
			this.dVal = jcoParam.getDate("D_VAL");
			this.vPmc = jcoParam.getBigDecimal("V_PMC");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("N_LOTE", this.nLote);
			jcoParam.setValue("Q_LOTE", this.qLote);
			jcoParam.setValue("D_FAB", this.dFab);
			jcoParam.setValue("D_VAL", this.dVal);
			jcoParam.setValue("V_PMC", this.vPmc);
		}

	}

	public static class ItNfeProdNrecopi implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// RECOPI Number
		private String nRecopi;

		public ItNfeProdNrecopi(Long id, String nRecopi) {
			this.id = id;
			this.nRecopi = nRecopi;
		}

		public ItNfeProdNrecopi(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setNRecopi(String nRecopi) {
			this.nRecopi = nRecopi;
		}

		public String getNRecopi() {
			return this.nRecopi;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.nRecopi = jcoParam.getString("N_RECOPI");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("N_RECOPI", this.nRecopi);
		}

	}

	public static class ItNfeProdVeicprod implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// NF-e Item Operation Type
		private Long tpOp;
		// Vehicle Chassis
		private String chassi;
		// Color
		private String cCor;
		// Color Description
		private String xCor;
		// Engine Power (HP)
		private String pot;
		// Cylinder Capacity
		private Long cilin;
		// Net Weight (KG)
		private String pesoL;
		// Gross Weight (KG)
		private String pesoB;
		// Series
		private String nSerie;
		// Fuel Type
		private String tpComb;
		// Engine Number
		private String nMotor;
		// Maximum Traction (in Metric Tons)
		private String cmt;
		// Distance Between Axles
		private String dist;
		// Model Year
		private Long anoMod;
		// Manufacturing Year
		private String anoFab;
		// Painting Type
		private String tpPint;
		// Vehicle Type
		private Long tpVeic;
		// Sort of Vehicle
		private String espVeic;
		// VIN Condition
		private String vin;
		// Vehicle Condition
		private Long condVeic;
		// Brand Model Code
		private String cMod;
		// Color Code
		private String cCorDenatran;
		// Capacity Limit
		private Long lota;
		// Restriction
		private Long tpRest;

		public ItNfeProdVeicprod(Long id, Long tpOp, String chassi,
				String cCor, String xCor, String pot, Long cilin, String pesoL,
				String pesoB, String nSerie, String tpComb, String nMotor,
				String cmt, String dist, Long anoMod, String anoFab,
				String tpPint, Long tpVeic, String espVeic, String vin,
				Long condVeic, String cMod, String cCorDenatran, Long lota,
				Long tpRest) {
			this.id = id;
			this.tpOp = tpOp;
			this.chassi = chassi;
			this.cCor = cCor;
			this.xCor = xCor;
			this.pot = pot;
			this.cilin = cilin;
			this.pesoL = pesoL;
			this.pesoB = pesoB;
			this.nSerie = nSerie;
			this.tpComb = tpComb;
			this.nMotor = nMotor;
			this.cmt = cmt;
			this.dist = dist;
			this.anoMod = anoMod;
			this.anoFab = anoFab;
			this.tpPint = tpPint;
			this.tpVeic = tpVeic;
			this.espVeic = espVeic;
			this.vin = vin;
			this.condVeic = condVeic;
			this.cMod = cMod;
			this.cCorDenatran = cCorDenatran;
			this.lota = lota;
			this.tpRest = tpRest;
		}

		public ItNfeProdVeicprod(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setTpOp(Long tpOp) {
			this.tpOp = tpOp;
		}

		public Long getTpOp() {
			return this.tpOp;
		}

		public void setChassi(String chassi) {
			this.chassi = chassi;
		}

		public String getChassi() {
			return this.chassi;
		}

		public void setCCor(String cCor) {
			this.cCor = cCor;
		}

		public String getCCor() {
			return this.cCor;
		}

		public void setXCor(String xCor) {
			this.xCor = xCor;
		}

		public String getXCor() {
			return this.xCor;
		}

		public void setPot(String pot) {
			this.pot = pot;
		}

		public String getPot() {
			return this.pot;
		}

		public void setCilin(Long cilin) {
			this.cilin = cilin;
		}

		public Long getCilin() {
			return this.cilin;
		}

		public void setPesoL(String pesoL) {
			this.pesoL = pesoL;
		}

		public String getPesoL() {
			return this.pesoL;
		}

		public void setPesoB(String pesoB) {
			this.pesoB = pesoB;
		}

		public String getPesoB() {
			return this.pesoB;
		}

		public void setNSerie(String nSerie) {
			this.nSerie = nSerie;
		}

		public String getNSerie() {
			return this.nSerie;
		}

		public void setTpComb(String tpComb) {
			this.tpComb = tpComb;
		}

		public String getTpComb() {
			return this.tpComb;
		}

		public void setNMotor(String nMotor) {
			this.nMotor = nMotor;
		}

		public String getNMotor() {
			return this.nMotor;
		}

		public void setCmt(String cmt) {
			this.cmt = cmt;
		}

		public String getCmt() {
			return this.cmt;
		}

		public void setDist(String dist) {
			this.dist = dist;
		}

		public String getDist() {
			return this.dist;
		}

		public void setAnoMod(Long anoMod) {
			this.anoMod = anoMod;
		}

		public Long getAnoMod() {
			return this.anoMod;
		}

		public void setAnoFab(String anoFab) {
			this.anoFab = anoFab;
		}

		public String getAnoFab() {
			return this.anoFab;
		}

		public void setTpPint(String tpPint) {
			this.tpPint = tpPint;
		}

		public String getTpPint() {
			return this.tpPint;
		}

		public void setTpVeic(Long tpVeic) {
			this.tpVeic = tpVeic;
		}

		public Long getTpVeic() {
			return this.tpVeic;
		}

		public void setEspVeic(String espVeic) {
			this.espVeic = espVeic;
		}

		public String getEspVeic() {
			return this.espVeic;
		}

		public void setVin(String vin) {
			this.vin = vin;
		}

		public String getVin() {
			return this.vin;
		}

		public void setCondVeic(Long condVeic) {
			this.condVeic = condVeic;
		}

		public Long getCondVeic() {
			return this.condVeic;
		}

		public void setCMod(String cMod) {
			this.cMod = cMod;
		}

		public String getCMod() {
			return this.cMod;
		}

		public void setCCorDenatran(String cCorDenatran) {
			this.cCorDenatran = cCorDenatran;
		}

		public String getCCorDenatran() {
			return this.cCorDenatran;
		}

		public void setLota(Long lota) {
			this.lota = lota;
		}

		public Long getLota() {
			return this.lota;
		}

		public void setTpRest(Long tpRest) {
			this.tpRest = tpRest;
		}

		public Long getTpRest() {
			return this.tpRest;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.tpOp = jcoParam.getLong("TP_OP");
			this.chassi = jcoParam.getString("CHASSI");
			this.cCor = jcoParam.getString("C_COR");
			this.xCor = jcoParam.getString("X_COR");
			this.pot = jcoParam.getString("POT");
			this.cilin = jcoParam.getLong("CILIN");
			this.pesoL = jcoParam.getString("PESO_L");
			this.pesoB = jcoParam.getString("PESO_B");
			this.nSerie = jcoParam.getString("N_SERIE");
			this.tpComb = jcoParam.getString("TP_COMB");
			this.nMotor = jcoParam.getString("N_MOTOR");
			this.cmt = jcoParam.getString("CMT");
			this.dist = jcoParam.getString("DIST");
			this.anoMod = jcoParam.getLong("ANO_MOD");
			this.anoFab = jcoParam.getString("ANO_FAB");
			this.tpPint = jcoParam.getString("TP_PINT");
			this.tpVeic = jcoParam.getLong("TP_VEIC");
			this.espVeic = jcoParam.getString("ESP_VEIC");
			this.vin = jcoParam.getString("VIN");
			this.condVeic = jcoParam.getLong("COND_VEIC");
			this.cMod = jcoParam.getString("C_MOD");
			this.cCorDenatran = jcoParam.getString("C_COR_DENATRAN");
			this.lota = jcoParam.getLong("LOTA");
			this.tpRest = jcoParam.getLong("TP_REST");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("TP_OP", this.tpOp);
			jcoParam.setValue("CHASSI", this.chassi);
			jcoParam.setValue("C_COR", this.cCor);
			jcoParam.setValue("X_COR", this.xCor);
			jcoParam.setValue("POT", this.pot);
			jcoParam.setValue("CILIN", this.cilin);
			jcoParam.setValue("PESO_L", this.pesoL);
			jcoParam.setValue("PESO_B", this.pesoB);
			jcoParam.setValue("N_SERIE", this.nSerie);
			jcoParam.setValue("TP_COMB", this.tpComb);
			jcoParam.setValue("N_MOTOR", this.nMotor);
			jcoParam.setValue("CMT", this.cmt);
			jcoParam.setValue("DIST", this.dist);
			jcoParam.setValue("ANO_MOD", this.anoMod);
			jcoParam.setValue("ANO_FAB", this.anoFab);
			jcoParam.setValue("TP_PINT", this.tpPint);
			jcoParam.setValue("TP_VEIC", this.tpVeic);
			jcoParam.setValue("ESP_VEIC", this.espVeic);
			jcoParam.setValue("VIN", this.vin);
			jcoParam.setValue("COND_VEIC", this.condVeic);
			jcoParam.setValue("C_MOD", this.cMod);
			jcoParam.setValue("C_COR_DENATRAN", this.cCorDenatran);
			jcoParam.setValue("LOTA", this.lota);
			jcoParam.setValue("TP_REST", this.tpRest);
		}

	}

	public static class ItNfeReboque implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Vehicle License Plate
		private String placa;
		// Region
		private String uf;
		// National Cargo Carrier Registration (ANTT)
		private String rntc;

		public ItNfeReboque(Long id, String placa, String uf, String rntc) {
			this.id = id;
			this.placa = placa;
			this.uf = uf;
			this.rntc = rntc;
		}

		public ItNfeReboque(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setPlaca(String placa) {
			this.placa = placa;
		}

		public String getPlaca() {
			return this.placa;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getUf() {
			return this.uf;
		}

		public void setRntc(String rntc) {
			this.rntc = rntc;
		}

		public String getRntc() {
			return this.rntc;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.placa = jcoParam.getString("PLACA");
			this.uf = jcoParam.getString("UF");
			this.rntc = jcoParam.getString("RNTC");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("PLACA", this.placa);
			jcoParam.setValue("UF", this.uf);
			jcoParam.setValue("RNTC", this.rntc);
		}

	}

	public static class ItNfeText implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// NF-e RFC Text Reference ID
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// NF-e RFC Text Type
		private String typ;
		// NF-e RFC Text Content
		private String text;

		public ItNfeText(Long id, Long seqNo, String typ, String text) {
			this.id = id;
			this.seqNo = seqNo;
			this.typ = typ;
			this.text = text;
		}

		public ItNfeText(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setTyp(String typ) {
			this.typ = typ;
		}

		public String getTyp() {
			return this.typ;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.typ = jcoParam.getString("TYP");
			this.text = jcoParam.getString("TEXT");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("TYP", this.typ);
			jcoParam.setValue("TEXT", this.text);
		}

	}

	public static class ItNfeValue implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// NF-e RFC Value Reference ID
		private Long id;
		// NF-e RFC Sequence Number
		private Long seqNo;
		// NF-e RFC Company Name
		private String xNome;
		// NF-e Value Decimal
		private BigDecimal vComp;

		public ItNfeValue(Long id, Long seqNo, String xNome, BigDecimal vComp) {
			this.id = id;
			this.seqNo = seqNo;
			this.xNome = xNome;
			this.vComp = vComp;
		}

		public ItNfeValue(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setSeqNo(Long seqNo) {
			this.seqNo = seqNo;
		}

		public Long getSeqNo() {
			return this.seqNo;
		}

		public void setXNome(String xNome) {
			this.xNome = xNome;
		}

		public String getXNome() {
			return this.xNome;
		}

		public void setVComp(BigDecimal vComp) {
			this.vComp = vComp;
		}

		public BigDecimal getVComp() {
			return this.vComp;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.seqNo = jcoParam.getLong("SEQ_NO");
			this.xNome = jcoParam.getString("X_NOME");
			this.vComp = jcoParam.getBigDecimal("V_COMP");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("SEQ_NO", this.seqNo);
			jcoParam.setValue("X_NOME", this.xNome);
			jcoParam.setValue("V_COMP", this.vComp);
		}

	}

	public static class ItNfeVol implements Serializable {
		private static final long serialVersionUID = 337339270983782151L;

		// Line ID of Table
		private Long id;
		// Quantity of Transported Volumes
		private BigDecimal qVol;
		// Kind of Transported Volumes
		private String esp;
		// Brand of Transported Volumes
		private String marca;
		// Number of Transported Volumes
		private String nVol;
		// Net Weight (kg)
		private BigDecimal pesoL;
		// Gross Weight (kg)
		private BigDecimal pesoB;
		// Reference to Line ID of Text Table
		private Long textIdLacres;

		public ItNfeVol(Long id, BigDecimal qVol, String esp, String marca,
				String nVol, BigDecimal pesoL, BigDecimal pesoB,
				Long textIdLacres) {
			this.id = id;
			this.qVol = qVol;
			this.esp = esp;
			this.marca = marca;
			this.nVol = nVol;
			this.pesoL = pesoL;
			this.pesoB = pesoB;
			this.textIdLacres = textIdLacres;
		}

		public ItNfeVol(JCoTable jcoParam) {
			fillClassAttributes(jcoParam);
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getId() {
			return this.id;
		}

		public void setQVol(BigDecimal qVol) {
			this.qVol = qVol;
		}

		public BigDecimal getQVol() {
			return this.qVol;
		}

		public void setEsp(String esp) {
			this.esp = esp;
		}

		public String getEsp() {
			return this.esp;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getMarca() {
			return this.marca;
		}

		public void setNVol(String nVol) {
			this.nVol = nVol;
		}

		public String getNVol() {
			return this.nVol;
		}

		public void setPesoL(BigDecimal pesoL) {
			this.pesoL = pesoL;
		}

		public BigDecimal getPesoL() {
			return this.pesoL;
		}

		public void setPesoB(BigDecimal pesoB) {
			this.pesoB = pesoB;
		}

		public BigDecimal getPesoB() {
			return this.pesoB;
		}

		public void setTextIdLacres(Long textIdLacres) {
			this.textIdLacres = textIdLacres;
		}

		public Long getTextIdLacres() {
			return this.textIdLacres;
		}

		public void fillClassAttributes(JCoTable jcoParam) {
			this.id = jcoParam.getLong("ID");
			this.qVol = jcoParam.getBigDecimal("Q_VOL");
			this.esp = jcoParam.getString("ESP");
			this.marca = jcoParam.getString("MARCA");
			this.nVol = jcoParam.getString("N_VOL");
			this.pesoL = jcoParam.getBigDecimal("PESO_L");
			this.pesoB = jcoParam.getBigDecimal("PESO_B");
			this.textIdLacres = jcoParam.getLong("TEXT_ID_LACRES");
		}

		public void fillJCoParameter(JCoTable jcoParam) {
			jcoParam.clear();
			jcoParam.setValue("ID", this.id);
			jcoParam.setValue("Q_VOL", this.qVol);
			jcoParam.setValue("ESP", this.esp);
			jcoParam.setValue("MARCA", this.marca);
			jcoParam.setValue("N_VOL", this.nVol);
			jcoParam.setValue("PESO_L", this.pesoL);
			jcoParam.setValue("PESO_B", this.pesoB);
			jcoParam.setValue("TEXT_ID_LACRES", this.textIdLacres);
		}

	}
}