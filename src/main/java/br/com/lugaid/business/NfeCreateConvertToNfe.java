package br.com.lugaid.business;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lugaid.SapConnectorConfig;
import br.inf.portalfiscal.nfe.*;
import br.inf.portalfiscal.nfe.TIpi.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.COFINS.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ICMS.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.ISSQN;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto.PIS.*;
import br.inf.portalfiscal.nfe.TNFe.InfNFe;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cana.ForDia;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Dup;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Cobr.Fat;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Imposto;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.ImpostoDevol;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.ImpostoDevol.IPI;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.Arma;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.Comb;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.Comb.CIDE;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.DI;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.DI.Adi;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.DetExport;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.DetExport.ExportInd;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.Med;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Det.Prod.VeicProd;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Ide.NFref.RefNF;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.InfAdic.ObsCont;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.InfAdic.ObsFisco;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.InfAdic.ProcRef;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Avulsa;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Dest;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Emit;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Ide.NFref;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Ide.NFref.RefECF;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Ide.NFref.RefNFP;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Pag.Card;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total.ICMSTot;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total.ISSQNtot;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Total.RetTrib;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp.RetTransp;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp.Transporta;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp.Vol;
import br.inf.portalfiscal.nfe.TNFe.InfNFe.Transp.Vol.Lacres;
import br.com.lugaid.exception.CofinsException;
import br.com.lugaid.exception.IcmsException;
import br.com.lugaid.exception.IpiException;
import br.com.lugaid.exception.PisException;
import br.com.lugaid.params.NfeCreateImport;
import br.com.lugaid.params.NfeCreateImport.*;

public class NfeCreateConvertToNfe {
	private static Logger logger = LoggerFactory
			.getLogger(NfeCreateConvertToNfe.class);

	// NF-e Complete parameters
	@SuppressWarnings("unused")
	private NfeCreateImport nfeCreateImport;
	// Configs for SAP conversor
	private SapConnectorConfig sapConnectorConfig;

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
	// NF-e Container1 for 'Customer Exit' Parameter
	@SuppressWarnings("unused")
	private List<ItNfeExt1> itNfeExt1s;
	// NF-e Container2 for 'Customer Exit' Parameter
	@SuppressWarnings("unused")
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
	// NF-e New Vehicle's Detail
	private List<ItNfeProdVeicprod> itNfeProdVeicprods;
	// Tow transport - Block X
	private List<ItNfeReboque> itNfeReboques;
	// NF-e RFC Text
	private List<ItNfeText> itNfeTexts;
	// NF-e RFC Value
	@SuppressWarnings("unused")
	private List<ItNfeValue> itNfeValues;
	// Volume Transport - Block X
	private List<ItNfeVol> itNfeVols;

	// Data Time pattern SAP and replace regex to UTC format.
	private static final String DT_TM_SAP_PAT = "^(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})$";
	private static final String DT_TM_NFE_REP = "$1-$2-$3T$4:$5:$6";

	private static final SimpleDateFormat DT_FORMAT = new SimpleDateFormat(
			"yyyy-MM-dd");

	public NfeCreateConvertToNfe(SapConnectorConfig sapConnectorConfig,
			NfeCreateImport nfeCreateImport) {
		this.sapConnectorConfig = sapConnectorConfig;
		this.nfeCreateImport = nfeCreateImport;

		// to make easy to use NfeCreateImport attributes inside conversor
		// class.
		isNfeAvulsa = nfeCreateImport.getIsNfeAvulsa();
		isNfeCana = nfeCreateImport.getIsNfeCana();
		isNfeCompra = nfeCreateImport.getIsNfeCompra();
		isNfeExporta = nfeCreateImport.getIsNfeExporta();
		isNfeFat = nfeCreateImport.getIsNfeFat();
		isNfeHeader = nfeCreateImport.getIsNfeHeader();
		isNfeIcmstot = nfeCreateImport.getIsNfeIcmstot();
		isNfeIde = nfeCreateImport.getIsNfeIde();
		isNfeInfadic = nfeCreateImport.getIsNfeInfadic();
		isNfeIssqntot = nfeCreateImport.getIsNfeIssqntot();
		isNfePartnerIds = nfeCreateImport.getIsNfePartnerIds();
		isNfeRettrib = nfeCreateImport.getIsNfeRettrib();
		isNfeTransp = nfeCreateImport.getIsNfeTransp();
		itNfeAutxmls = nfeCreateImport.getItNfeAutxmls();
		itNfeCanaFordias = nfeCreateImport.getItNfeCanaFordias();
		itNfeDets = nfeCreateImport.getItNfeDets();
		itNfeDetImpostos = nfeCreateImport.getItNfeDetImpostos();
		itNfeDetProds = nfeCreateImport.getItNfeDetProds();
		itNfeDiAdis = nfeCreateImport.getItNfeDiAdis();
		itNfeDups = nfeCreateImport.getItNfeDups();
		itNfeExt1s = nfeCreateImport.getItNfeExt1s();
		itNfeExt2s = nfeCreateImport.getItNfeExt2s();
		itNfeImpostoCofinss = nfeCreateImport.getItNfeImpostoCofinss();
		itNfeImpostoCofinssts = nfeCreateImport.getItNfeImpostoCofinssts();
		itNfeImpostoIcmss = nfeCreateImport.getItNfeImpostoIcmss();
		itNfeImpostoIis = nfeCreateImport.getItNfeImpostoIis();
		itNfeImpostoIpis = nfeCreateImport.getItNfeImpostoIpis();
		itNfeImpostoIssqns = nfeCreateImport.getItNfeImpostoIssqns();
		itNfeImpostoPiss = nfeCreateImport.getItNfeImpostoPiss();
		itNfeImpostoPissts = nfeCreateImport.getItNfeImpostoPissts();
		itNfeNfrefs = nfeCreateImport.getItNfeNfrefs();
		itNfePags = nfeCreateImport.getItNfePags();
		itNfePartners = nfeCreateImport.getItNfePartners();
		itNfeProcrefs = nfeCreateImport.getItNfeProcrefs();
		itNfeProdArmas = nfeCreateImport.getItNfeProdArmas();
		itNfeProdCombs = nfeCreateImport.getItNfeProdCombs();
		itNfeProdDetexports = nfeCreateImport.getItNfeProdDetexports();
		itNfeProdDis = nfeCreateImport.getItNfeProdDis();
		itNfeProdMeds = nfeCreateImport.getItNfeProdMeds();
		itNfeProdNrecopis = nfeCreateImport.getItNfeProdNrecopis();
		itNfeProdVeicprods = nfeCreateImport.getItNfeProdVeicprods();
		itNfeReboques = nfeCreateImport.getItNfeReboques();
		itNfeTexts = nfeCreateImport.getItNfeTexts();
		itNfeValues = nfeCreateImport.getItNfeValues();
		itNfeVols = nfeCreateImport.getItNfeVols();
	}

	public TNFe convertToTNFe() {
		logger.info("Starting convertion for DOCNUM {}.",
				isNfeHeader.getDocnum());

		TNFe tNFe = new TNFe();

		tNFe.setInfNFe(buildInfNfe());

		logger.info("Convertion for DOCNUM {} finished.",
				isNfeHeader.getDocnum());

		return tNFe;
	}

	private InfNFe buildInfNfe() {
		logger.info("Building InfNFe group.");

		InfNFe infNFe = new InfNFe();

		infNFe.setVersao("3.10");
		infNFe.setId("NFe".concat(isNfeHeader.getAccesskey()));

		infNFe.setIde(buildIde());
		infNFe.setEmit(buildEmit());
		infNFe.setAvulsa(buildAvulsa());
		infNFe.setDest(buildDest());
		infNFe.setRetirada(buildTLocal(isNfePartnerIds.getPartnerIdRetirada()));
		infNFe.setEntrega(buildTLocal(isNfePartnerIds.getPartnerIdEntrega()));

		List<AutXML> autXMLs = buildAutXMLs();
		if (autXMLs.size() > 0) {
			infNFe.getAutXML().addAll(autXMLs);
		}

		infNFe.getDet().addAll(buildDets());
		infNFe.setTotal(buildTotal());
		infNFe.setTransp(buildTransp());
		infNFe.setCobr(buildCobr());

		List<Pag> pags = buildPags();
		if (pags.size() > 0) {
			infNFe.getPag().addAll(pags);
		}

		infNFe.setInfAdic(buildInfAdic());
		infNFe.setExporta(buildExporta());
		infNFe.setCompra(buildCompra());
		infNFe.setCana(buildCana());

		logger.info("Build InfNFe group finished.");

		return infNFe;
	}

	private TNFe.InfNFe.Ide buildIde() {
		logger.info("Building Ide group.");

		TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();

		ide.setCUF(isNfeIde.getCUf());
		ide.setCNF(isNfeIde.getCNf());
		ide.setNatOp(isNfeIde.getNatOp());
		ide.setIndPag(isNfeIde.getIndPag());
		ide.setMod(isNfeIde.getMod().toString());
		ide.setSerie(isNfeIde.getSerie());
		ide.setNNF(String.valueOf(Long.valueOf(isNfeIde.getNNf())));
		ide.setDhEmi(sapDateTime2nfeDateTime(isNfeIde.getDhEmi()));

		if (isNfeIde.getDhSaiEnt().matches(DT_TM_SAP_PAT)) {
			ide.setDhSaiEnt(sapDateTime2nfeDateTime(isNfeIde.getDhSaiEnt()));
		}

		ide.setTpNF(isNfeIde.getTpNf());
		ide.setIdDest(isNfeIde.getIdDest());
		ide.setCMunFG(isNfeIde.getCMunFg());
		ide.setTpImp(isNfeIde.getTpImp());
		ide.setTpEmis(isNfeIde.getTpEmis());
		ide.setCDV(isNfeIde.getCDv());
		ide.setTpAmb(isNfeIde.getTpAmb());
		ide.setFinNFe(isNfeIde.getFinNfe());
		ide.setIndFinal(isNfeIde.getIndFinal());
		ide.setIndPres(isNfeIde.getIndPres());
		ide.setProcEmi(isNfeIde.getProcEmi());
		ide.setVerProc(isNfeIde.getVerProc());

		if (!isNfeIde.getXJust().trim().isEmpty()) {
			ide.setDhCont(sapDateTime2nfeDateTime(isNfeIde.getDhCont()));
			ide.setXJust(isNfeIde.getXJust());
		}

		List<NFref> nFRefs = buildNFrefs();
		if (nFRefs.size() > 0) {
			ide.getNFref().addAll(nFRefs);
		}

		logger.info("Building Ide group finished.");

		return ide;
	}

	private List<NFref> buildNFrefs() {
		logger.info("Building NFref group for {} element(s).",
				itNfeNfrefs.size());

		List<NFref> nFref = new ArrayList<>();

		for (ItNfeNfref ref : itNfeNfrefs) {
			NFref nfref = new NFref();

			logger.info("Definning Ref type for item {}.", ref.getId());

			if (!ref.getRefNfe().trim().isEmpty()) {
				logger.info("Ref type for item {} defined as RefNFe.",
						ref.getId());

				nfref.setRefNFe(ref.getRefNfe());
			} else if (!ref.getRefCte().trim().isEmpty()) {
				logger.info("Ref type for item {} defined as RefCte.",
						ref.getId());

				nfref.setRefCTe(ref.getRefCte());
			} else if (isRefNF(ref)) {
				RefNF refNF = new RefNF();

				refNF.setCUF(ref.getCUf());
				refNF.setAAMM(ref.getAamm().toString());
				refNF.setCNPJ(ref.getCnpj());
				refNF.setMod(ref.getMod().toString());
				refNF.setSerie(ref.getSerie());
				refNF.setNNF(String.valueOf(Long.getLong(ref.getNNf())));

				nfref.setRefNF(refNF);
			} else if (isRefNFP(ref)) {
				logger.info("Ref type for item {} defined as RefNFP.",
						ref.getId());

				RefNFP refNFP = new RefNFP();

				refNFP.setCUF(ref.getCUf());
				refNFP.setAAMM(ref.getAamm().toString());

				if (!ref.getCnpj().matches("^0+$")
						&& !ref.getCnpj().trim().isEmpty()) {
					refNFP.setCNPJ(ref.getCnpj());
				} else if (!ref.getCpf().matches("^0+$")
						&& !ref.getCpf().trim().isEmpty()) {
					refNFP.setCPF(ref.getCpf());
				}

				refNFP.setIE(ref.getIe());
				refNFP.setMod(ref.getMod().toString());
				refNFP.setSerie(ref.getSerie());
				refNFP.setNNF(String.valueOf(ref.getNNf()));

				nfref.setRefNFP(refNFP);
			} else if (isRefECF(ref)) {
				logger.info("Ref type for item {} defined as RefECF.",
						ref.getId());

				RefECF refECF = new RefECF();

				refECF.setMod(ref.getModEcf());
				refECF.setNECF(ref.getNEcf().toString());
				refECF.setNCOO(ref.getNCoo().toString());

				nfref.setRefECF(refECF);
			} else {
				logger.error("Ref type for item {} COULD NOT be definned.",
						ref.getId());
				continue;
			}

			nFref.add(nfref);
		}

		logger.info("Build NFref group for {}/{} element(s) finished.",
				nFref.size(), itNfeNfrefs.size());

		return nFref;
	}

	private Emit buildEmit() {
		logger.info("Building Emit group.");

		ItNfePartner itNfePartner = getItNfePartner(isNfePartnerIds
				.getPartnerIdEmit());

		if (itNfePartner != null) {
			Emit emit = new Emit();

			if (!itNfePartner.getCnpj().matches("^0+$")
					&& !itNfePartner.getCnpj().trim().isEmpty()) {
				emit.setCNPJ(itNfePartner.getCnpj());
			} else if (!itNfePartner.getCpf().matches("^0+$")
					&& !itNfePartner.getCpf().trim().isEmpty()) {
				emit.setCPF(itNfePartner.getCpf());
			}

			emit.setXNome(itNfePartner.getXNome());

			if (!itNfePartner.getXFant().trim().isEmpty()) {
				emit.setXFant(itNfePartner.getXFant());
			}

			emit.setIE(itNfePartner.getIe());

			if (!itNfePartner.getIest().trim().isEmpty()) {
				emit.setIEST(itNfePartner.getIest());
			}

			if (!itNfePartner.getIm().trim().isEmpty()) {
				emit.setIM(itNfePartner.getIm());
			}

			if (!itNfePartner.getCnae().trim().isEmpty()) {
				emit.setCNAE(itNfePartner.getCnae());
			}

			if (itNfePartner.getCrt() != 0) {
				emit.setCRT(itNfePartner.getCrt().toString());
			}

			emit.setEnderEmit(buildEnderEmit(itNfePartner));

			logger.info("Build Emit group finished.");

			return emit;
		} else {
			logger.error("Invalid PARTNER_ID_EMIT to build Emit group.");
			return null;
		}
	}

	private TEnderEmi buildEnderEmit(ItNfePartner itNfePartner) {
		logger.info("Building EnderEmit group.");

		TEnderEmi tEnderEmi = new TEnderEmi();

		tEnderEmi.setXLgr(itNfePartner.getXLgr());
		tEnderEmi.setNro(itNfePartner.getNro());

		if (!itNfePartner.getXCpl().trim().isEmpty()) {
			tEnderEmi.setXCpl(itNfePartner.getXCpl());
		}

		tEnderEmi.setXBairro(itNfePartner.getXBairro());
		tEnderEmi.setCMun(itNfePartner.getCMun().toString());
		tEnderEmi.setXMun(itNfePartner.getXMun());
		tEnderEmi.setUF(TUfEmi.fromValue(itNfePartner.getUf()));
		tEnderEmi.setCEP(itNfePartner.getCep());

		if (!itNfePartner.getCPais().trim().isEmpty()) {
			tEnderEmi.setCPais(itNfePartner.getCPais());
		}

		if (!itNfePartner.getXPais().trim().isEmpty()) {
			tEnderEmi.setXPais(itNfePartner.getXPais());
		}

		if (!itNfePartner.getFone().trim().isEmpty()) {
			tEnderEmi.setFone(itNfePartner.getFone());
		}

		logger.info("Build EnderEmit group finished.");

		return tEnderEmi;
	}

	private Avulsa buildAvulsa() {
		logger.info("Building Avulsa group.");

		if (checkIsNfeAvulsaFilled(isNfeAvulsa)) {
			logger.info("Avulsa group must be filled.");

			Avulsa avulsa = new Avulsa();

			avulsa.setCNPJ(isNfeAvulsa.getCnpj());
			avulsa.setXOrgao(isNfeAvulsa.getXOrgao());
			avulsa.setMatr(isNfeAvulsa.getMatr());
			avulsa.setXAgente(isNfeAvulsa.getXAgente());

			if (!isNfeAvulsa.getFone().trim().isEmpty()) {
				avulsa.setFone(isNfeAvulsa.getFone());
			}

			avulsa.setUF(TUfEmi.valueOf(isNfeAvulsa.getUf()));

			if (!isNfeAvulsa.getNDar().trim().isEmpty()) {
				avulsa.setNDAR(isNfeAvulsa.getNDar());
			}

			if (isNfeAvulsa.getDEmi() != null) {
				avulsa.setDEmi(DT_FORMAT.format(isNfeAvulsa.getDEmi()));
			}

			if (isNfeAvulsa.getVDar().longValue() != 0) {
				avulsa.setVDAR(isNfeAvulsa.getVDar().toString());
			}

			avulsa.setRepEmi(isNfeAvulsa.getRepEmi());

			if (isNfeAvulsa.getDPag() != null) {
				avulsa.setDPag(DT_FORMAT.format(isNfeAvulsa.getDPag()));
			}

			logger.info("Avulsa group finished to be filled.");
			return avulsa;
		} else {
			logger.warn("Avulsa group must not be filled.");
			return null;
		}
	}

	private Dest buildDest() {
		logger.info("Building Dest group.");

		ItNfePartner itNfePartner = getItNfePartner(isNfePartnerIds
				.getPartnerIdDest());

		if (itNfePartner != null) {
			Dest dest = new Dest();

			if (!itNfePartner.getCnpj().matches("^0+$")
					&& !itNfePartner.getCnpj().trim().isEmpty()) {
				dest.setCNPJ(itNfePartner.getCnpj());
			} else if (!itNfePartner.getCpf().matches("^0+$")
					&& !itNfePartner.getCpf().trim().isEmpty()) {
				dest.setCPF(itNfePartner.getCpf());
			} else {
				dest.setIdEstrangeiro("");
			}

			if (!itNfePartner.getIdEstrangeiro().trim().isEmpty()) {
				dest.setIdEstrangeiro(itNfePartner.getIdEstrangeiro());
			}

			dest.setXNome(itNfePartner.getXNome());
			dest.setIndIEDest(itNfePartner.getIndIedest().toString());

			if (!itNfePartner.getIe().trim().isEmpty()) {
				dest.setIE(itNfePartner.getIe());
			}

			if (!itNfePartner.getIsuf().trim().isEmpty()) {
				dest.setISUF(itNfePartner.getIsuf());
			}

			if (!itNfePartner.getIm().trim().isEmpty()) {
				dest.setIM(itNfePartner.getIm());
			}

			if (!itNfePartner.getEmail().trim().isEmpty()) {
				dest.setEmail(itNfePartner.getEmail());
			}

			dest.setEnderDest(buildEnderDest(itNfePartner));

			logger.info("Build Dest group finished.");

			return dest;
		} else {
			logger.error("Invalid PARTNER_ID_DEST to build Dest group.");
			return null;
		}
	}

	private TEndereco buildEnderDest(ItNfePartner itNfePartner) {
		logger.info("Building EnderDest group.");

		TEndereco tEndereco = new TEndereco();

		tEndereco.setXLgr(itNfePartner.getXLgr());
		tEndereco.setNro(itNfePartner.getNro());

		if (!itNfePartner.getXCpl().trim().isEmpty()) {
			tEndereco.setXCpl(itNfePartner.getXCpl());
		}

		tEndereco.setXBairro(itNfePartner.getXBairro());
		tEndereco.setCMun(itNfePartner.getCMun().toString());
		tEndereco.setXMun(itNfePartner.getXMun());
		tEndereco.setUF(TUf.fromValue(itNfePartner.getUf()));

		if (!itNfePartner.getCep().trim().isEmpty()
				&& !itNfePartner.getUf().equals("EX")) {
			tEndereco.setCEP(itNfePartner.getCep());
		}

		if (!itNfePartner.getCPais().trim().isEmpty()) {
			tEndereco.setCPais(itNfePartner.getCPais());
		}

		if (!itNfePartner.getXPais().trim().isEmpty()) {
			tEndereco.setXPais(itNfePartner.getXPais());
		}

		if (!itNfePartner.getFone().trim().isEmpty()) {
			tEndereco.setFone(itNfePartner.getFone());
		}

		logger.info("Build EnderDest group finished.");

		return tEndereco;
	}

	private TLocal buildTLocal(long partnerId) {
		logger.info("Building TLocal for PARTNER_ID {}.", partnerId);

		ItNfePartner itNfePartner = getItNfePartner(partnerId);

		if (itNfePartner != null) {
			TLocal local = new TLocal();

			if (!itNfePartner.getCnpj().matches("^0+$")
					&& !itNfePartner.getCnpj().trim().isEmpty()) {
				local.setCNPJ(itNfePartner.getCnpj());
			} else if (!itNfePartner.getCpf().matches("^0+$")
					&& !itNfePartner.getCpf().trim().isEmpty()) {
				local.setCPF(itNfePartner.getCpf());
			}

			local.setXLgr(itNfePartner.getXLgr());
			local.setNro(itNfePartner.getNro());

			if (!itNfePartner.getXCpl().trim().isEmpty()) {
				local.setXCpl(itNfePartner.getXCpl());
			}

			local.setXBairro(itNfePartner.getXBairro());
			local.setCMun(itNfePartner.getCMun().toString());
			local.setXMun(itNfePartner.getXMun());
			local.setUF(TUf.fromValue(itNfePartner.getUf()));

			logger.info("Build TLocal finished.");

			return local;
		} else {
			logger.warn("Invalid PARTNER_ID to build TLocal.");
			return null;
		}
	}

	private List<AutXML> buildAutXMLs() {
		logger.info("Building AutXML group for {} element(s).",
				itNfeAutxmls.size());

		List<AutXML> autXMLs = new ArrayList<>();

		for (ItNfeAutxml itNfeAutxml : itNfeAutxmls) {
			logger.info("Building AutXML group for ID {}.", itNfeAutxml.getId());

			AutXML autXML = new AutXML();

			if (!itNfeAutxml.getCnpj().matches("^0+$")
					&& !itNfeAutxml.getCnpj().trim().isEmpty()) {
				autXML.setCNPJ(itNfeAutxml.getCnpj());
			} else if (!itNfeAutxml.getCpf().matches("^0+$")
					&& !itNfeAutxml.getCpf().trim().isEmpty()) {
				autXML.setCPF(itNfeAutxml.getCpf());
			}

			autXMLs.add(autXML);
		}

		logger.info("Build AutXML group for {}/{} element(s) finished.",
				autXMLs.size(), itNfeAutxmls.size());

		return autXMLs;
	}

	private List<Det> buildDets() {
		logger.info("Building Det group for {} itens.", itNfeDets.size());

		List<Det> dets = new ArrayList<Det>();

		for (ItNfeDet itNfeDet : itNfeDets) {
			logger.info("Building Det group for ID {}.", itNfeDet.getId());

			Det det = new Det();

			det.setNItem(itNfeDet.getNItem().toString());
			det.setProd(buildProd(itNfeDet.getProdRef()));
			det.setImposto(buildImposto(itNfeDet.getImpostoRef()));
			det.setImpostoDevol(buildImpostoDevol(itNfeDet));

			if (itNfeDet.getInfAdProd() != null
					&& !itNfeDet.getInfAdProd().trim().isEmpty()) {
				det.setInfAdProd(itNfeDet.getInfAdProd());
			}

			dets.add(det);
		}

		logger.info("Build Det group for {}/{} element(s) finished.",
				dets.size(), itNfeDets.size());

		return dets;
	}

	private Prod buildProd(long prodRef) {
		logger.info("Building Prod group for PROD_REF {}.", prodRef);
		ItNfeDetProd itNfeDetProd = getItNfeDetProd(prodRef);

		if (itNfeDetProd != null) {
			Prod prod = new Prod();

			prod.setCProd(itNfeDetProd.getCProd());
			prod.setCEAN(itNfeDetProd.getCEan());
			prod.setXProd(itNfeDetProd.getXProd());
			prod.setNCM(itNfeDetProd.getNcm());

			if (!itNfeDetProd.getExtipi().trim().isEmpty()) {
				prod.setEXTIPI(itNfeDetProd.getExtipi());
			}

			prod.setCFOP(itNfeDetProd.getCfop());
			prod.setUCom(itNfeDetProd.getUCom());
			prod.setQCom(itNfeDetProd.getQCom().toString());
			prod.setVUnCom(itNfeDetProd.getVUnCom().toString());
			prod.setVProd(itNfeDetProd.getVProd().toString());
			prod.setCEANTrib(itNfeDetProd.getCEantrib());
			prod.setUTrib(itNfeDetProd.getUTrib());
			prod.setQTrib(itNfeDetProd.getQTrib().toString());
			prod.setVUnTrib(itNfeDetProd.getVUnTrib().toString());

			if (isGTZero(itNfeDetProd.getVFrete())) {
				prod.setVFrete(itNfeDetProd.getVFrete().toString());
			}

			if (isGTZero(itNfeDetProd.getVSeg())) {
				prod.setVSeg(itNfeDetProd.getVSeg().toString());
			}

			if (isGTZero(itNfeDetProd.getVDesc())) {
				prod.setVDesc(itNfeDetProd.getVDesc().toString());
			}

			if (isGTZero(itNfeDetProd.getVOutro())) {
				prod.setVOutro(itNfeDetProd.getVOutro().toString());
			}

			prod.setIndTot(itNfeDetProd.getIndTot().toString());

			if (!itNfeDetProd.getXPed().trim().isEmpty()) {
				prod.setXPed(itNfeDetProd.getXPed());
			}

			if (itNfeDetProd.getNItemPed() > 0) {
				prod.setNItemPed(itNfeDetProd.getNItemPed().toString());
			}

			if (!itNfeDetProd.getNFci().trim().isEmpty()) {
				prod.setNFCI(itNfeDetProd.getNFci());
			}

			List<DI> dis = buildDIs(itNfeDetProd.getDiRef());
			if (dis.size() > 0) {
				prod.getDI().addAll(dis);
			}

			List<DetExport> detExports = buildDetExports(itNfeDetProd
					.getDetexportRef());
			if (detExports.size() > 0) {
				prod.getDetExport().addAll(detExports);
			}

			prod.setVeicProd(buildVeicProd(itNfeDetProd.getVeicprodRef()));

			List<Med> meds = buildMeds(itNfeDetProd.getMedRef());
			if (meds.size() > 0) {
				prod.getMed().addAll(meds);
			}

			List<Arma> armas = buildArmas(itNfeDetProd.getArmaRef());
			if (meds.size() > 0) {
				prod.getArma().addAll(armas);
			}

			prod.setComb(buildComb(itNfeDetProd.getCombRef()));
			prod.setNRECOPI(buildNRECOPI(itNfeDetProd.getNrecopiRef()));

			logger.info("Building Prod group for PROD_REF {} finished.",
					prodRef);

			return prod;
		} else {
			logger.error("Invalid PROD_REF to build Prod group.");
			return null;
		}
	}

	private List<DI> buildDIs(long diRef) {
		List<DI> dis = new ArrayList<>();
		List<ItNfeProdDi> itNfeProdDisLoc = getItNfeProdDis(diRef);

		logger.info("Building DI group for DI_REF {} for {} element(s).",
				diRef, itNfeProdDisLoc.size());

		for (ItNfeProdDi itNfeProdDi : itNfeProdDisLoc) {
			logger.info("Building DI group for DI_REF {} seq {}.", diRef,
					itNfeProdDi.getSeqNo());

			DI di = new DI();

			di.setNDI(itNfeProdDi.getNDi());
			di.setDDI(DT_FORMAT.format(itNfeProdDi.getDDi()));
			di.setXLocDesemb(itNfeProdDi.getXLocDesemb());
			di.setUFDesemb(TUfEmi.fromValue(itNfeProdDi.getUfdesemb()));
			di.setDDesemb(DT_FORMAT.format(itNfeProdDi.getDDesemb()));
			di.setTpViaTransp(itNfeProdDi.getTpViaTransp().toString());

			if (isGTZero(itNfeProdDi.getVAfrmm())) {
				di.setVAFRMM(itNfeProdDi.getVAfrmm().toString());
			}

			di.setTpIntermedio(itNfeProdDi.getTpIntermedio().toString());

			if (!itNfeProdDi.getCnpj().trim().isEmpty()) {
				di.setCNPJ(itNfeProdDi.getCnpj());
			}

			if (!itNfeProdDi.getUfterceiro().trim().isEmpty()) {
				di.setUFTerceiro(TUfEmi.fromValue(itNfeProdDi.getUfterceiro()));
			}

			di.setCExportador(itNfeProdDi.getCExportador());

			List<Adi> adis = buildAdis(itNfeProdDi.getAdiRef());
			if (adis.size() > 0) {
				di.getAdi().addAll(adis);
			}

			dis.add(di);
		}

		logger.info(
				"Build DI group for DI_REF {} for {}/{} element(s) finished.",
				diRef, dis.size(), itNfeProdDisLoc.size());

		return dis;
	}

	private List<Adi> buildAdis(long adiRef) {
		List<Adi> adis = new ArrayList<>();
		List<ItNfeDiAdi> itNfeDiAdisLoc = getItNfeDiAdis(adiRef);

		logger.info("Building Adi group for ADI_REF {} for {} element(s).",
				adiRef, itNfeDiAdisLoc.size());

		for (ItNfeDiAdi itNfeDiAdi : itNfeDiAdisLoc) {
			logger.info("Building Adi group for ADI_REF {} seq {}.", adiRef,
					itNfeDiAdi.getSeqNo());

			Adi adi = new Adi();

			adi.setNAdicao(itNfeDiAdi.getNAdicao().toString());
			adi.setNSeqAdic(itNfeDiAdi.getNSeqAdic().toString());
			adi.setCFabricante(itNfeDiAdi.getCFabricante());

			if (isGTZero(itNfeDiAdi.getVDescDi())) {
				adi.setVDescDI(itNfeDiAdi.getVDescDi().toString());
			}

			if (!itNfeDiAdi.getNDraw().trim().isEmpty()) {
				adi.setNDraw(itNfeDiAdi.getNDraw());
			}

			adis.add(adi);
		}

		logger.info(
				"Build Adi group for ADI_REF {} for {}/{} element(s) finished.",
				adiRef, adis.size(), itNfeDiAdisLoc.size());

		return adis;
	}

	private List<DetExport> buildDetExports(long detExportRef) {
		List<DetExport> detExports = new ArrayList<>();
		List<ItNfeProdDetexport> itNfeProdDetexportsLoc = getItNfeProdDetexports(detExportRef);

		logger.info(
				"Building DetExport group for DET_EXPORT_REF {} for {} element(s).",
				detExportRef, itNfeProdDetexportsLoc.size());

		for (ItNfeProdDetexport itNfeProdDetexport : itNfeProdDetexportsLoc) {
			logger.info(
					"Building DetExport group for DET_EXPORT_REF {} seq {}.",
					detExportRef, itNfeProdDetexport.getSeqNo());

			DetExport detExport = new DetExport();
			ExportInd exportInd = new ExportInd();

			detExport.setNDraw(itNfeProdDetexport.getNDraw());

			exportInd.setChNFe(itNfeProdDetexport.getChNfe());
			exportInd.setNRE(itNfeProdDetexport.getNRe().toString());
			exportInd.setQExport(itNfeProdDetexport.getQExport().toString());

			detExport.setExportInd(exportInd);

			detExports.add(detExport);
		}

		logger.info(
				"Build DetExport group for ADI_REF {} for {}/{} element(s) finished.",
				detExportRef, detExports.size(), itNfeProdDetexportsLoc.size());

		return detExports;
	}

	private VeicProd buildVeicProd(long veicProdRef) {
		logger.info("Building VeicProd group for VEIC_PROD_REF {}.",
				veicProdRef);

		ItNfeProdVeicprod itNfeProdVeicprodsLoc = getItNfeProdVeicprod(veicProdRef);

		if (itNfeProdVeicprodsLoc != null) {
			VeicProd veicProd = new VeicProd();

			veicProd.setTpOp(itNfeProdVeicprodsLoc.getTpOp().toString());
			veicProd.setChassi(itNfeProdVeicprodsLoc.getChassi());
			veicProd.setCCor(itNfeProdVeicprodsLoc.getCCor());
			veicProd.setXCor(itNfeProdVeicprodsLoc.getXCor());
			veicProd.setPot(itNfeProdVeicprodsLoc.getPot());
			veicProd.setCilin(itNfeProdVeicprodsLoc.getCilin().toString());
			veicProd.setPesoL(itNfeProdVeicprodsLoc.getPesoL());
			veicProd.setPesoB(itNfeProdVeicprodsLoc.getPesoB());
			veicProd.setTpComb(itNfeProdVeicprodsLoc.getTpComb());
			veicProd.setNMotor(itNfeProdVeicprodsLoc.getNMotor());
			veicProd.setCMT(itNfeProdVeicprodsLoc.getCmt());
			veicProd.setDist(itNfeProdVeicprodsLoc.getDist());
			veicProd.setAnoMod(itNfeProdVeicprodsLoc.getAnoMod().toString());
			veicProd.setAnoFab(itNfeProdVeicprodsLoc.getAnoFab());
			veicProd.setTpPint(itNfeProdVeicprodsLoc.getTpPint());
			veicProd.setTpVeic(itNfeProdVeicprodsLoc.getTpVeic().toString());
			veicProd.setEspVeic(itNfeProdVeicprodsLoc.getEspVeic());
			veicProd.setVIN(itNfeProdVeicprodsLoc.getVin());
			veicProd.setCondVeic(itNfeProdVeicprodsLoc.getCondVeic().toString());
			veicProd.setCMod(itNfeProdVeicprodsLoc.getCMod());
			veicProd.setCCorDENATRAN(itNfeProdVeicprodsLoc.getCCorDenatran());
			veicProd.setLota(itNfeProdVeicprodsLoc.getLota().toString());
			veicProd.setTpRest(itNfeProdVeicprodsLoc.getTpRest().toString());

			logger.info("Build VeicProd group for VEIC_PROD_REF {} finished.",
					veicProdRef);

			return veicProd;
		} else {
			logger.warn("Invalid VEIC_PROD_REF to build VeicProd group.");
			return null;
		}
	}

	private List<Med> buildMeds(long medRef) {
		List<Med> meds = new ArrayList<>();
		List<ItNfeProdMed> itNfeProdMedsLoc = getItNfeProdMeds(medRef);

		logger.info("Building Med group for {} element(s) for MED_REF {}.",
				itNfeProdMedsLoc.size(), medRef);

		for (ItNfeProdMed itNfeProdMed : itNfeProdMedsLoc) {
			logger.info("Building Med group for MED_REF {} seq {}.",
					itNfeProdMed.getId(), itNfeProdMed.getSeqNo());

			Med med = new Med();

			med.setNLote(itNfeProdMed.getNLote());
			med.setQLote(itNfeProdMed.getQLote().toString());
			med.setDFab(DT_FORMAT.format(itNfeProdMed.getDFab()));
			med.setDVal(DT_FORMAT.format(itNfeProdMed.getDVal()));
			med.setVPMC(itNfeProdMed.getVPmc().toString());

			meds.add(med);
		}

		logger.info("Building Med group for {}/{} element(s) for MED_REF {}.",
				itNfeProdMedsLoc.size(), meds.size(), medRef);

		return meds;
	}

	private List<Arma> buildArmas(long armaRef) {
		List<Arma> armas = new ArrayList<>();
		List<ItNfeProdArma> itNfeProdArmasLoc = getItNfeProdArmas(armaRef);

		logger.info("Building Arma group for {} element(s) for ARMA_REF {}.",
				itNfeProdArmasLoc.size(), armaRef);

		for (ItNfeProdArma itNfeProdArma : itNfeProdArmasLoc) {
			logger.info("Building Arma group for MED_REF {} seq {}.",
					itNfeProdArma.getId(), itNfeProdArma.getSeqNo());

			Arma arma = new Arma();

			arma.setTpArma(itNfeProdArma.getTpArma().toString());
			arma.setNSerie(itNfeProdArma.getNSerie());
			arma.setNCano(itNfeProdArma.getNCano());
			arma.setDescr(itNfeProdArma.getDescr());

			armas.add(arma);
		}

		logger.info(
				"Building Arma group for {}/{} element(s) for ARMA_REF {}.",
				itNfeProdArmasLoc.size(), armas.size(), armaRef);

		return armas;
	}

	private Comb buildComb(long combRef) {
		ItNfeProdComb itNfeProdComb = getItNfeProdComb(combRef);

		logger.info("Building Comb group for COMB_REF {}.", combRef);

		if (itNfeProdComb != null) {
			Comb comb = new Comb();
			CIDE cide = new CIDE();

			comb.setCProdANP(itNfeProdComb.getCProdAnp().toString());

			if (isGTZero(itNfeProdComb.getPMixGn())) {
				comb.setPMixGN(itNfeProdComb.getPMixGn().toString());
			}

			if (itNfeProdComb.getCodif() > 0) {
				comb.setCODIF(itNfeProdComb.getCodif().toString());
			}

			if (isGTZero(itNfeProdComb.getQTemp())) {
				comb.setQTemp(itNfeProdComb.getQTemp().toString());
			}

			comb.setUFCons(TUf.fromValue(itNfeProdComb.getUfcons()));

			if (isGTZero(itNfeProdComb.getQBcprod())
					|| isGTZero(itNfeProdComb.getVAliqProd())
					|| isGTZero(itNfeProdComb.getVCide())) {
				cide.setQBCProd(itNfeProdComb.getQBcprod().toString());
				cide.setVAliqProd(itNfeProdComb.getVAliqProd().toString());
				cide.setVCIDE(itNfeProdComb.getVCide().toString());
				comb.setCIDE(cide);
			}

			logger.info("Build Comb group for COMB_REF {} finished.", combRef);

			return comb;
		} else {
			logger.warn("Invalid COMB_REF to build Comb group.");
			return null;
		}
	}

	private String buildNRECOPI(long nrecopiRef) {
		ItNfeProdNrecopi itNfeProdNrecopi = getItNfeProdNrecopi(nrecopiRef);

		logger.info("Building NRECOPI for NRECOPI_REF {}.", nrecopiRef);

		if (itNfeProdNrecopi != null) {
			logger.info("Build NRECOPI for NRECOPI_REF {} finished.",
					nrecopiRef);

			return itNfeProdNrecopi.getNRecopi();
		} else {
			logger.warn("Invalid NRECOPI_REF to build NRECOPI.");
			return null;
		}
	}

	private Imposto buildImposto(long impostoRef) {
		logger.info("Building Imposto group for IMPOSTO_REF {}.", impostoRef);

		ItNfeDetImposto itNfeDetImposto = getItNfeDetImposto(impostoRef);

		if (itNfeDetImposto != null) {
			Imposto imposto = new Imposto();

			if (isGTZero(itNfeDetImposto.getVtottrib())) {
				imposto.setVTotTrib(itNfeDetImposto.getVtottrib().toString());
			}

			imposto.setICMS(buildICMS(itNfeDetImposto.getIcmsRef()));
			imposto.setIPI(buildIPI(itNfeDetImposto.getIpiRef()));
			imposto.setII(buildII(itNfeDetImposto.getIiRef()));
			imposto.setPIS(buildPIS(itNfeDetImposto.getPisRef()));
			imposto.setPISST(buildPISST(itNfeDetImposto.getPisstRef()));
			imposto.setCOFINS(buildCOFINS(itNfeDetImposto.getCofinsRef()));
			imposto.setCOFINSST(buildCOFINSST(itNfeDetImposto.getCofinsstRef()));
			imposto.setISSQN(buildISSQN(itNfeDetImposto.getIssqnRef()));

			logger.info("Build Imposto group for IMPOSTO_REF {} finished.",
					impostoRef);

			return imposto;
		} else {
			logger.warn("Invalid IMPOSTO_REF to build Imposto group.");
			return null;
		}
	}

	private ICMS buildICMS(long icmsRef) {
		logger.info("Building ICMS group for ICMS_REF {}.", icmsRef);

		ItNfeImpostoIcms itNfeImpostoIcms = getItNfeImpostoIcms(icmsRef);

		if (itNfeImpostoIcms != null) {
			ICMS icms = new ICMS();

			if (itNfeImpostoIcms.getCst().equals("00")) {
				logger.info("ICMS defined as ICMS00 for ICMS_REF {}.", icmsRef);

				ICMS00 icms00 = new ICMS00();

				icms00.setOrig(itNfeImpostoIcms.getOrig());
				icms00.setCST(itNfeImpostoIcms.getCst());
				icms00.setModBC(itNfeImpostoIcms.getModBc().toString());
				icms00.setVBC(itNfeImpostoIcms.getVBc().toString());
				icms00.setPICMS(itNfeImpostoIcms.getPIcms().toString());
				icms00.setVICMS(itNfeImpostoIcms.getVIcms().toString());

				icms.setICMS00(icms00);
			} else if (itNfeImpostoIcms.getCst().equals("10")) {
				logger.info("ICMS defined as ICMS10 for ICMS_REF {}.", icmsRef);

				ICMS10 icms10 = new ICMS10();

				icms10.setOrig(itNfeImpostoIcms.getOrig());
				icms10.setCST(itNfeImpostoIcms.getCst());
				icms10.setModBC(itNfeImpostoIcms.getModBc().toString());
				icms10.setVBC(itNfeImpostoIcms.getVBc().toString());
				icms10.setPICMS(itNfeImpostoIcms.getPIcms().toString());
				icms10.setVICMS(itNfeImpostoIcms.getVIcms().toString());
				icms10.setModBCST(itNfeImpostoIcms.getModBcst().toString());

				if (isGTZero(itNfeImpostoIcms.getPMvast())) {
					icms10.setPMVAST(itNfeImpostoIcms.getPMvast().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
					icms10.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
							.toString());
				}

				icms10.setVBCST(itNfeImpostoIcms.getVBcst().toString());
				icms10.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
				icms10.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());

				icms.setICMS10(icms10);
			} else if (itNfeImpostoIcms.getCst().equals("20")) {
				logger.info("ICMS defined as ICMS20 for ICMS_REF {}.", icmsRef);

				ICMS20 icms20 = new ICMS20();

				icms20.setOrig(itNfeImpostoIcms.getOrig());
				icms20.setCST(itNfeImpostoIcms.getCst());
				icms20.setModBC(itNfeImpostoIcms.getModBc().toString());
				icms20.setPRedBC(itNfeImpostoIcms.getPRedBc().toString());
				icms20.setVBC(itNfeImpostoIcms.getVBc().toString());
				icms20.setPICMS(itNfeImpostoIcms.getPIcms().toString());
				icms20.setVICMS(itNfeImpostoIcms.getVIcms().toString());

				if (isGTZero(itNfeImpostoIcms.getVIcmsdeson())
						|| !itNfeImpostoIcms.getMotDesIcms().trim().isEmpty()) {
					icms20.setVICMSDeson(itNfeImpostoIcms.getVIcmsdeson()
							.toString());
					icms20.setMotDesICMS(itNfeImpostoIcms.getMotDesIcms());
				}

				icms.setICMS20(icms20);
			} else if (itNfeImpostoIcms.getCst().equals("30")) {
				logger.info("ICMS defined as ICMS30 for ICMS_REF {}.", icmsRef);

				ICMS30 icms30 = new ICMS30();

				icms30.setOrig(itNfeImpostoIcms.getOrig());
				icms30.setCST(itNfeImpostoIcms.getCst());
				icms30.setModBCST(itNfeImpostoIcms.getModBcst().toString());

				if (isGTZero(itNfeImpostoIcms.getPMvast())) {
					icms30.setPMVAST(itNfeImpostoIcms.getPMvast().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
					icms30.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
							.toString());
				}

				icms30.setVBCST(itNfeImpostoIcms.getVBcst().toString());
				icms30.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
				icms30.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());

				if (isGTZero(itNfeImpostoIcms.getVIcmsdeson())
						|| !itNfeImpostoIcms.getMotDesIcms().trim().isEmpty()) {
					icms30.setVICMSDeson(itNfeImpostoIcms.getVIcmsdeson()
							.toString());
					icms30.setMotDesICMS(itNfeImpostoIcms.getMotDesIcms());
				}

				icms.setICMS30(icms30);
			} else if (itNfeImpostoIcms.getCst().matches("^(40|41|50)$")) {
				logger.info("ICMS defined as ICMS40 for ICMS_REF {}.", icmsRef);

				ICMS40 icms40 = new ICMS40();

				icms40.setOrig(itNfeImpostoIcms.getOrig());
				icms40.setCST(itNfeImpostoIcms.getCst());

				if (isGTZero(itNfeImpostoIcms.getVIcmsdeson())
						|| !itNfeImpostoIcms.getMotDesIcms().trim().isEmpty()) {
					icms40.setVICMSDeson(itNfeImpostoIcms.getVIcmsdeson()
							.toString());
					icms40.setMotDesICMS(itNfeImpostoIcms.getMotDesIcms());
				}

				icms.setICMS40(icms40);
			} else if (itNfeImpostoIcms.getCst().equals("51")) {
				logger.info("ICMS defined as ICMS51 for ICMS_REF {}.", icmsRef);

				ICMS51 icms51 = new ICMS51();

				icms51.setOrig(itNfeImpostoIcms.getOrig());
				icms51.setCST(itNfeImpostoIcms.getCst());

				if (itNfeImpostoIcms.getModBc() > 0) {
					icms51.setModBC(itNfeImpostoIcms.getModBc().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBc())) {
					icms51.setPRedBC(itNfeImpostoIcms.getPRedBc().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVBc())) {
					icms51.setVBC(itNfeImpostoIcms.getVBc().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPIcms())) {
					icms51.setPICMS(itNfeImpostoIcms.getPIcms().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVIcmsop())) {
					icms51.setVICMSOp(itNfeImpostoIcms.getVIcmsop().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPDif())) {
					icms51.setPDif(itNfeImpostoIcms.getPDif().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVIcmsdif())) {
					icms51.setVICMSDif(itNfeImpostoIcms.getVIcmsdif()
							.toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVIcms())) {
					icms51.setVICMS(itNfeImpostoIcms.getVIcms().toString());
				}

				icms.setICMS51(icms51);
			} else if (itNfeImpostoIcms.getCst().equals("60")) {
				logger.info("ICMS defined as ICMS60 for ICMS_REF {}.", icmsRef);

				ICMS60 icms60 = new ICMS60();

				icms60.setOrig(itNfeImpostoIcms.getOrig());
				icms60.setCST(itNfeImpostoIcms.getCst());

				if (isGTZero(itNfeImpostoIcms.getVBcstret())
						|| isGTZero(itNfeImpostoIcms.getVIcmsstret())) {
					icms60.setVBCSTRet(itNfeImpostoIcms.getVBcstret()
							.toString());
					icms60.setVICMSSTRet(itNfeImpostoIcms.getVIcmsstret()
							.toString());
				}

				icms.setICMS60(icms60);
			} else if (itNfeImpostoIcms.getCst().equals("70")) {
				logger.info("ICMS defined as ICMS70 for ICMS_REF {}.", icmsRef);

				ICMS70 icms70 = new ICMS70();

				icms70.setOrig(itNfeImpostoIcms.getOrig());
				icms70.setCST(itNfeImpostoIcms.getCst());
				icms70.setModBC(itNfeImpostoIcms.getModBc().toString());
				icms70.setPRedBC(itNfeImpostoIcms.getPRedBc().toString());
				icms70.setVBC(itNfeImpostoIcms.getVBc().toString());
				icms70.setPICMS(itNfeImpostoIcms.getPIcms().toString());
				icms70.setVICMS(itNfeImpostoIcms.getVIcms().toString());
				icms70.setModBCST(itNfeImpostoIcms.getModBcst().toString());

				if (isGTZero(itNfeImpostoIcms.getPMvast())) {
					icms70.setPMVAST(itNfeImpostoIcms.getPMvast().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
					icms70.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
							.toString());
				}

				icms70.setVBCST(itNfeImpostoIcms.getVBcst().toString());
				icms70.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
				icms70.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());

				if (isGTZero(itNfeImpostoIcms.getVIcmsdeson())
						|| !itNfeImpostoIcms.getMotDesIcms().trim().isEmpty()) {
					icms70.setVICMSDeson(itNfeImpostoIcms.getVIcmsdeson()
							.toString());
					icms70.setMotDesICMS(itNfeImpostoIcms.getMotDesIcms());
				}

				icms.setICMS70(icms70);
			} else if (itNfeImpostoIcms.getCst().equals("90")) {
				logger.info("ICMS defined as ICMS90 for ICMS_REF {}.", icmsRef);

				ICMS90 icms90 = new ICMS90();

				icms90.setOrig(itNfeImpostoIcms.getOrig());
				icms90.setCST(itNfeImpostoIcms.getCst());

				if (isGTZero(itNfeImpostoIcms.getVBc())
						|| isGTZero(itNfeImpostoIcms.getPRedBc())
						|| isGTZero(itNfeImpostoIcms.getPIcms())
						|| isGTZero(itNfeImpostoIcms.getVIcms())) {

					icms90.setModBC(itNfeImpostoIcms.getModBc().toString());
					icms90.setVBC(itNfeImpostoIcms.getVBc().toString());
					icms90.setPRedBC(itNfeImpostoIcms.getPRedBc().toString());
					icms90.setPICMS(itNfeImpostoIcms.getPIcms().toString());
					icms90.setVICMS(itNfeImpostoIcms.getVIcms().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVBcst())
						|| isGTZero(itNfeImpostoIcms.getPMvast())
						|| isGTZero(itNfeImpostoIcms.getPRedBcst())
						|| isGTZero(itNfeImpostoIcms.getVBcst())
						|| isGTZero(itNfeImpostoIcms.getPIcmsst())
						|| isGTZero(itNfeImpostoIcms.getVIcmsst())) {

					icms90.setModBCST(itNfeImpostoIcms.getModBcst().toString());

					if (isGTZero(itNfeImpostoIcms.getPMvast())) {
						icms90.setPMVAST(itNfeImpostoIcms.getPMvast()
								.toString());
					}

					if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
						icms90.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
								.toString());
					}

					icms90.setVBCST(itNfeImpostoIcms.getVBcst().toString());
					icms90.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
					icms90.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVIcmsdeson())
						|| !itNfeImpostoIcms.getMotDesIcms().trim().isEmpty()) {
					icms90.setVICMSDeson(itNfeImpostoIcms.getVIcmsdeson()
							.toString());
					icms90.setMotDesICMS(itNfeImpostoIcms.getMotDesIcms());
				}

				icms.setICMS90(icms90);
			} else if (itNfeImpostoIcms.getCsosn().equals(101)) {
				logger.info("ICMS defined as ICMSSN101 for ICMS_REF {}.",
						icmsRef);

				ICMSSN101 icmssn101 = new ICMSSN101();

				icmssn101.setOrig(itNfeImpostoIcms.getOrig());
				icmssn101.setCSOSN(itNfeImpostoIcms.getCsosn().toString());
				icmssn101.setPCredSN(itNfeImpostoIcms.getPCredSn().toString());
				icmssn101.setVCredICMSSN(itNfeImpostoIcms.getVCredIcmssn()
						.toString());

				icms.setICMSSN101(icmssn101);
			} else if (itNfeImpostoIcms.getCsosn().toString()
					.matches("^(102|103|300|400)$")) {
				logger.info("ICMS defined as ICMSSN102 for ICMS_REF {}.",
						icmsRef);

				ICMSSN102 icmssn102 = new ICMSSN102();

				icmssn102.setOrig(itNfeImpostoIcms.getOrig());
				icmssn102.setCSOSN(itNfeImpostoIcms.getCsosn().toString());

				icms.setICMSSN102(icmssn102);
			} else if (itNfeImpostoIcms.getCsosn().equals(201)) {
				logger.info("ICMS defined as ICMSSN201 for ICMS_REF {}.",
						icmsRef);

				ICMSSN201 icmssn201 = new ICMSSN201();

				icmssn201.setOrig(itNfeImpostoIcms.getOrig());
				icmssn201.setCSOSN(itNfeImpostoIcms.getCsosn().toString());
				icmssn201.setModBCST(itNfeImpostoIcms.getModBcst().toString());

				if (isGTZero(itNfeImpostoIcms.getPMvast())) {
					icmssn201
							.setPMVAST(itNfeImpostoIcms.getPMvast().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
					icmssn201.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
							.toString());
				}

				icmssn201.setVBCST(itNfeImpostoIcms.getVBcst().toString());
				icmssn201.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
				icmssn201.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());
				icmssn201.setPCredSN(itNfeImpostoIcms.getPCredSn().toString());
				icmssn201.setVCredICMSSN(itNfeImpostoIcms.getVCredIcmssn()
						.toString());

				icms.setICMSSN201(icmssn201);
			} else if (itNfeImpostoIcms.getCsosn().toString()
					.matches("^(202|203)$")) {
				logger.info("ICMS defined as ICMSSN202 for ICMS_REF {}.",
						icmsRef);

				ICMSSN202 icmssn202 = new ICMSSN202();

				icmssn202.setOrig(itNfeImpostoIcms.getOrig());
				icmssn202.setCSOSN(itNfeImpostoIcms.getCsosn().toString());
				icmssn202.setModBCST(itNfeImpostoIcms.getModBcst().toString());

				if (isGTZero(itNfeImpostoIcms.getPMvast())) {
					icmssn202
							.setPMVAST(itNfeImpostoIcms.getPMvast().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
					icmssn202.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
							.toString());
				}

				icmssn202.setVBCST(itNfeImpostoIcms.getVBcst().toString());
				icmssn202.setPICMSST(itNfeImpostoIcms.getPIcmsst().toString());
				icmssn202.setVICMSST(itNfeImpostoIcms.getVIcmsst().toString());

				icms.setICMSSN202(icmssn202);
			} else if (itNfeImpostoIcms.getCsosn().equals(500)) {
				logger.info("ICMS defined as ICMSSN500 for ICMS_REF {}.",
						icmsRef);

				ICMSSN500 icmssn500 = new ICMSSN500();

				icmssn500.setOrig(itNfeImpostoIcms.getOrig());
				icmssn500.setCSOSN(itNfeImpostoIcms.getCsosn().toString());

				if (isGTZero(itNfeImpostoIcms.getVBcstret())
						|| isGTZero(itNfeImpostoIcms.getVIcmsstret())) {
					icmssn500.setVBCSTRet(itNfeImpostoIcms.getVBcstret()
							.toString());
					icmssn500.setVICMSSTRet(itNfeImpostoIcms.getVIcmsstret()
							.toString());
				}

				icms.setICMSSN500(icmssn500);
			} else if (itNfeImpostoIcms.getCsosn().equals(900)) {
				logger.info("ICMS defined as ICMSSN900 for ICMS_REF {}.",
						icmsRef);

				ICMSSN900 icmssn900 = new ICMSSN900();

				icmssn900.setOrig(itNfeImpostoIcms.getOrig());
				icmssn900.setCSOSN(itNfeImpostoIcms.getCsosn().toString());

				if (isGTZero(itNfeImpostoIcms.getVBc())
						|| isGTZero(itNfeImpostoIcms.getPRedBc())
						|| isGTZero(itNfeImpostoIcms.getPIcms())
						|| isGTZero(itNfeImpostoIcms.getVIcms())) {

					icmssn900.setModBC(itNfeImpostoIcms.getModBc().toString());
					icmssn900.setVBC(itNfeImpostoIcms.getVBc().toString());

					if (isGTZero(itNfeImpostoIcms.getPRedBc())) {
						icmssn900.setPRedBC(itNfeImpostoIcms.getPRedBc()
								.toString());
					}

					icmssn900.setPICMS(itNfeImpostoIcms.getPIcms().toString());
					icmssn900.setVICMS(itNfeImpostoIcms.getVIcms().toString());
				}

				if (isGTZero(itNfeImpostoIcms.getVBcst())
						|| isGTZero(itNfeImpostoIcms.getPMvast())
						|| isGTZero(itNfeImpostoIcms.getPRedBcst())
						|| isGTZero(itNfeImpostoIcms.getVBcst())
						|| isGTZero(itNfeImpostoIcms.getPIcmsst())
						|| isGTZero(itNfeImpostoIcms.getVIcmsst())) {

					icmssn900.setModBCST(itNfeImpostoIcms.getModBcst()
							.toString());
					icmssn900.setVBCST(itNfeImpostoIcms.getVBcst().toString());

					if (isGTZero(itNfeImpostoIcms.getPMvast())) {
						icmssn900.setPMVAST(itNfeImpostoIcms.getPMvast()
								.toString());
					}

					if (isGTZero(itNfeImpostoIcms.getPRedBcst())) {
						icmssn900.setPRedBCST(itNfeImpostoIcms.getPRedBcst()
								.toString());
					}

					icmssn900.setVBCST(itNfeImpostoIcms.getVBcst().toString());
					icmssn900.setPICMSST(itNfeImpostoIcms.getPIcmsst()
							.toString());
					icmssn900.setVICMSST(itNfeImpostoIcms.getVIcmsst()
							.toString());
				}

				if (isGTZero(itNfeImpostoIcms.getPCredSn())
						|| isGTZero(itNfeImpostoIcms.getVCredIcmssn())) {
					icmssn900.setPCredSN(itNfeImpostoIcms.getPCredSn()
							.toString());
					icmssn900.setVCredICMSSN(itNfeImpostoIcms.getVCredIcmssn()
							.toString());
				}

				icms.setICMSSN900(icmssn900);
			} else {
				logger.error(
						"ICMS could not be defined for CSOSN {} or CST {}.",
						itNfeImpostoIcms.getCsosn(), itNfeImpostoIcms.getCst());

				throw new IcmsException(String.format(
						"ICMS could not be defined for CSOSN %s or CST %s.",
						itNfeImpostoIcms.getCsosn(), itNfeImpostoIcms.getCst()));
			}

			logger.info("Build ICMS group for ICMS_REF {} finished.", icmsRef);

			return icms;
		} else {
			logger.warn("Invalid ICMS_REF to build ICMS group.");
			return null;
		}
	}

	private TIpi buildIPI(long ipiRef) {
		logger.info("Building IPI group for IPI_REF {}.", ipiRef);

		ItNfeImpostoIpi itNfeImpostoIpi = getItNfeImpostoIpi(ipiRef);

		if (itNfeImpostoIpi != null) {
			TIpi ipi = new TIpi();

			if (!itNfeImpostoIpi.getClEnq().trim().isEmpty()) {
				ipi.setClEnq(itNfeImpostoIpi.getClEnq());
			}

			if (!itNfeImpostoIpi.getCnpjprod().trim().isEmpty()) {
				ipi.setCNPJProd(itNfeImpostoIpi.getCnpjprod());
			}

			if (!itNfeImpostoIpi.getCSelo().trim().isEmpty()) {
				ipi.setCSelo(itNfeImpostoIpi.getCSelo());
			}

			if (itNfeImpostoIpi.getQSelo() > 0) {
				ipi.setQSelo(itNfeImpostoIpi.getQSelo().toString());
			}

			ipi.setCEnq(itNfeImpostoIpi.getCEnq());

			if (itNfeImpostoIpi.getCst().matches("^(00|49|50|99)$")) {
				logger.info("IPI defined as IPITrib for IPI_REF {}.", ipiRef);

				IPITrib trib = new IPITrib();

				trib.setCST(itNfeImpostoIpi.getCst());

				if (isGTZero(itNfeImpostoIpi.getVBc())
						|| isGTZero(itNfeImpostoIpi.getPIpi())) {
					trib.setVBC(itNfeImpostoIpi.getVBc().toString());
					trib.setPIPI(itNfeImpostoIpi.getPIpi().toString());
				} else if (isGTZero(itNfeImpostoIpi.getQUnid())
						|| isGTZero(itNfeImpostoIpi.getVUnid())) {
					trib.setQUnid(itNfeImpostoIpi.getQUnid().toString());
					trib.setVUnid(itNfeImpostoIpi.getVUnid().toString());
				}

				trib.setVIPI(itNfeImpostoIpi.getVIpi().toString());

				ipi.setIPITrib(trib);
			} else if (itNfeImpostoIpi.getCst().matches(
					"^(01|02|03|04|51|52|53|54|55)$")) {
				logger.info("IPI defined as IPINT for IPI_REF {}.", ipiRef);

				IPINT ipint = new IPINT();

				ipint.setCST(itNfeImpostoIpi.getCst());

				ipi.setIPINT(ipint);
			} else {
				logger.error("IPI could not be defined for CST {}.",
						itNfeImpostoIpi.getCst());

				throw new IpiException(String.format(
						"IPI could not be defined for CST %s.",
						itNfeImpostoIpi.getCst()));
			}

			logger.info("Build IPI group for IPI_REF {} finished.", ipiRef);

			return ipi;
		} else {
			logger.warn("Invalid IPI_REF to build IPI group.");
			return null;
		}
	}

	private II buildII(long iiRef) {
		logger.info("Building II group for II_REF {}.", iiRef);

		ItNfeImpostoIi itNfeImpostoIi = getItNfeImpostoIi(iiRef);

		if (itNfeImpostoIi != null) {
			II ii = new II();

			ii.setVBC(itNfeImpostoIi.getVBc().toString());
			ii.setVDespAdu(itNfeImpostoIi.getVDespAdu().toString());
			ii.setVII(itNfeImpostoIi.getVIi().toString());
			ii.setVIOF(itNfeImpostoIi.getVIof().toString());

			logger.info("Build II group for II_REF {} finished.", iiRef);

			return ii;
		} else {
			logger.warn("Invalid II_REF to build II group.");
			return null;
		}
	}

	private PIS buildPIS(long pisRef) {
		logger.info("Building PIS group for PIS_REF {}.", pisRef);

		ItNfeImpostoPis itNfeImpostoPis = getItNfeImpostoPis(pisRef);

		if (itNfeImpostoPis != null) {
			PIS pis = new PIS();

			if (itNfeImpostoPis.getCst() == 1 || itNfeImpostoPis.getCst() == 2) {
				logger.info("PIS defined as PISAliq for PIS_REF {}.", pisRef);

				PISAliq pisAliq = new PISAliq();

				pisAliq.setCST(itNfeImpostoPis.getCst().toString());
				pisAliq.setVBC(itNfeImpostoPis.getVBc().toString());
				pisAliq.setPPIS(itNfeImpostoPis.getPPis().toString());
				pisAliq.setVPIS(itNfeImpostoPis.getVPis().toString());

				pis.setPISAliq(pisAliq);
			} else if (itNfeImpostoPis.getCst() == 3) {
				logger.info("PIS defined as PISQtde for PIS_REF {}.", pisRef);

				PISQtde pisQtde = new PISQtde();

				pisQtde.setCST(itNfeImpostoPis.getCst().toString());
				pisQtde.setQBCProd(itNfeImpostoPis.getQBcprod().toString());
				pisQtde.setVAliqProd(itNfeImpostoPis.getVAliqProd().toString());
				pisQtde.setVPIS(itNfeImpostoPis.getVPis().toString());

				pis.setPISQtde(pisQtde);
			} else if (itNfeImpostoPis.getCst() >= 4
					&& itNfeImpostoPis.getCst() <= 9) {
				logger.info("PIS defined as PISNT for PIS_REF {}.", pisRef);

				PISNT pisNT = new PISNT();

				pisNT.setCST(itNfeImpostoPis.getCst().toString());

				pis.setPISNT(pisNT);
			} else if (itNfeImpostoPis
					.getCst()
					.toString()
					.matches(
							"^(49|50|51|52|53|54|55|56|60|61|62|63|64|65|66|67|70|71|72|73|74|75|98|99)$")) {
				logger.info("PIS defined as PISOutr for PIS_REF {}.", pisRef);

				PISOutr pisOutr = new PISOutr();

				pisOutr.setCST(itNfeImpostoPis.getCst().toString());

				if (isGTZero(itNfeImpostoPis.getVBc())
						|| isGTZero(itNfeImpostoPis.getPPis())) {
					pisOutr.setVBC(itNfeImpostoPis.getVBc().toString());
					pisOutr.setPPIS(itNfeImpostoPis.getPPis().toString());
				} else if (isGTZero(itNfeImpostoPis.getQBcprod())
						|| isGTZero(itNfeImpostoPis.getVAliqProd())) {
					pisOutr.setQBCProd(itNfeImpostoPis.getQBcprod().toString());
					pisOutr.setVAliqProd(itNfeImpostoPis.getVAliqProd()
							.toString());
				}

				pisOutr.setVPIS(itNfeImpostoPis.getVPis().toString());

				pis.setPISOutr(pisOutr);
			} else {
				logger.error("PIS could not be defined for CST {}.",
						itNfeImpostoPis.getCst());

				throw new PisException(String.format(
						"PIS could not be defined for CST %s.",
						itNfeImpostoPis.getCst()));
			}

			logger.info("Build PIS group for PIS_REF {} finished.", pisRef);

			return pis;
		} else {
			logger.warn("Invalid PIS_REF to build PIS group.");
			return null;
		}
	}

	private PISST buildPISST(long pisstRef) {
		logger.info("Building PISST group for PISST_REF {}.", pisstRef);

		ItNfeImpostoPisst itNfeImpostoPisst = getItNfeImpostoPisst(pisstRef);

		if (itNfeImpostoPisst != null) {
			PISST pisSt = new PISST();

			pisSt.setVBC(itNfeImpostoPisst.getVBc().toString());
			pisSt.setPPIS(itNfeImpostoPisst.getPPis().toString());
			pisSt.setQBCProd(itNfeImpostoPisst.getQBcprod().toString());
			pisSt.setVAliqProd(itNfeImpostoPisst.getVAliqProd().toString());
			pisSt.setVPIS(itNfeImpostoPisst.getVPis().toString());

			logger.info("Build PISST group for PISST_REF {} finished.",
					pisstRef);

			return pisSt;
		} else {
			logger.warn("Invalid PISST_REF to build PISST group.");
			return null;
		}
	}

	private COFINS buildCOFINS(long cofinsRef) {
		logger.info("Building COFINS group for COFINS_REF {}.", cofinsRef);

		ItNfeImpostoCofins itNfeImpostoCofins = getItNfeImpostoCofins(cofinsRef);

		if (itNfeImpostoCofins != null) {
			COFINS cofins = new COFINS();

			if (itNfeImpostoCofins.getCst().matches("^(01|02)$")) {
				logger.info("COFINS defined as COFINSAliq for COFINS_REF {}.",
						cofinsRef);

				COFINSAliq cofinsAliq = new COFINSAliq();

				cofinsAliq.setCST(itNfeImpostoCofins.getCst());
				cofinsAliq.setVBC(itNfeImpostoCofins.getVBc().toString());
				cofinsAliq.setPCOFINS(itNfeImpostoCofins.getPCofins()
						.toString());
				cofinsAliq.setVCOFINS(itNfeImpostoCofins.getVCofins()
						.toString());

				cofins.setCOFINSAliq(cofinsAliq);
			} else if (itNfeImpostoCofins.getCst().equals("03")) {
				logger.info("COFINS defined as COFINSQtde for COFINS_REF {}.",
						cofinsRef);

				COFINSQtde cofinsQtde = new COFINSQtde();

				cofinsQtde.setCST(itNfeImpostoCofins.getCst());
				cofinsQtde.setQBCProd(itNfeImpostoCofins.getQBcprod()
						.toString());
				cofinsQtde.setVAliqProd(itNfeImpostoCofins.getVAliqProd()
						.toString());
				cofinsQtde.setVCOFINS(itNfeImpostoCofins.getVCofins()
						.toString());

				cofins.setCOFINSQtde(cofinsQtde);
			} else if (itNfeImpostoCofins.getCst().matches(
					"^(04|05|06|07|08|09)$")) {
				logger.info("COFINS defined as COFINSNT for COFINS_REF {}.",
						cofinsRef);

				COFINSNT cofinsNT = new COFINSNT();

				cofinsNT.setCST(itNfeImpostoCofins.getCst());

				cofins.setCOFINSNT(cofinsNT);
			} else if (itNfeImpostoCofins
					.getCst()
					.matches(
							"^(49|50|51|52|53|54|55|56|60|61|62|63|64|65|66|67|70|71|72|73|74|75|98|99)$")) {
				logger.info("COFINS defined as COFINSOutr for COFINS_REF {}.",
						cofinsRef);

				COFINSOutr cofinsOutr = new COFINSOutr();

				cofinsOutr.setCST(itNfeImpostoCofins.getCst());
				if (isGTZero(itNfeImpostoCofins.getVBc())
						|| isGTZero(itNfeImpostoCofins.getPCofins())) {
					cofinsOutr.setVBC(itNfeImpostoCofins.getVBc().toString());
					cofinsOutr.setPCOFINS(itNfeImpostoCofins.getPCofins()
							.toString());
				} else if (isGTZero(itNfeImpostoCofins.getQBcprod())
						|| isGTZero(itNfeImpostoCofins.getVAliqProd())) {
					cofinsOutr.setQBCProd(itNfeImpostoCofins.getQBcprod()
							.toString());
					cofinsOutr.setVAliqProd(itNfeImpostoCofins.getVAliqProd()
							.toString());
				}

				cofinsOutr.setVCOFINS(itNfeImpostoCofins.getVCofins()
						.toString());

				cofins.setCOFINSOutr(cofinsOutr);
			} else {
				logger.error("COFINS could not be defined for CST {}.",
						itNfeImpostoCofins.getCst());

				throw new CofinsException(String.format(
						"COFINS could not be defined for CST %s.",
						itNfeImpostoCofins.getCst()));
			}

			logger.info("Build COFINS group for COFINS_REF {} finished.",
					cofinsRef);

			return cofins;
		} else {
			logger.warn("Invalid COFINS_REF to build COFINS group.");
			return null;
		}
	}

	private COFINSST buildCOFINSST(long cofinsstRef) {
		logger.info("Building COFINSST group for COFINSST_REF {}.", cofinsstRef);

		ItNfeImpostoCofinsst itNfeImpostoCofinsst = getItNfeImpostoCofinsst(cofinsstRef);

		if (itNfeImpostoCofinsst != null) {
			COFINSST cofinsST = new COFINSST();

			cofinsST.setVBC(itNfeImpostoCofinsst.getVBc().toString());
			cofinsST.setPCOFINS(itNfeImpostoCofinsst.getPCofins().toString());
			cofinsST.setQBCProd(itNfeImpostoCofinsst.getQBcprod().toString());
			cofinsST.setVAliqProd(itNfeImpostoCofinsst.getVAliqProd()
					.toString());
			cofinsST.setVCOFINS(itNfeImpostoCofinsst.getVCofins().toString());

			logger.info("Build COFINSST group for COFINSST_REF {} finished.",
					cofinsstRef);

			return cofinsST;
		} else {
			logger.warn("Invalid COFINSST_REF to build COFINSST group.");
			return null;
		}
	}

	private ISSQN buildISSQN(long issqnRef) {
		logger.info("Building ISSQN group for ISSQN_REF {}.", issqnRef);

		ItNfeImpostoIssqn itNfeImpostoIssqn = getItNfeImpostoIssqn(issqnRef);

		if (itNfeImpostoIssqn != null) {
			ISSQN issqn = new ISSQN();

			issqn.setVBC(itNfeImpostoIssqn.getVBc().toString());
			issqn.setVAliq(itNfeImpostoIssqn.getVAliq().toString());
			issqn.setVISSQN(itNfeImpostoIssqn.getVIssqn().toString());
			issqn.setCMunFG(itNfeImpostoIssqn.getCMunFg().toString());
			issqn.setCListServ(itNfeImpostoIssqn.getCListServ().toString());

			if (isGTZero(itNfeImpostoIssqn.getVDeducao())) {
				issqn.setVDeducao(itNfeImpostoIssqn.getVDeducao().toString());
			}

			if (isGTZero(itNfeImpostoIssqn.getVOutro())) {
				issqn.setVOutro(itNfeImpostoIssqn.getVOutro().toString());
			}

			if (isGTZero(itNfeImpostoIssqn.getVDescIncond())) {
				issqn.setVDescIncond(itNfeImpostoIssqn.getVDescIncond()
						.toString());
			}

			if (isGTZero(itNfeImpostoIssqn.getVDescCond())) {
				issqn.setVDescCond(itNfeImpostoIssqn.getVDescCond().toString());
			}

			if (isGTZero(itNfeImpostoIssqn.getVIssret())) {
				issqn.setVISSRet(itNfeImpostoIssqn.getVIssret().toString());
			}

			issqn.setIndISS(itNfeImpostoIssqn.getIndIss().toString());

			if (!itNfeImpostoIssqn.getCServico().trim().isEmpty()) {
				issqn.setCServico(itNfeImpostoIssqn.getCServico());
			}

			if (itNfeImpostoIssqn.getCMun() > 0) {
				issqn.setCMun(itNfeImpostoIssqn.getCMun().toString());
			}

			if (!itNfeImpostoIssqn.getCPais().trim().isEmpty()) {
				issqn.setCPais(itNfeImpostoIssqn.getCPais());
			}

			if (!itNfeImpostoIssqn.getNProcesso().trim().isEmpty()) {
				issqn.setNProcesso(itNfeImpostoIssqn.getNProcesso());
			}

			issqn.setIndIncentivo(itNfeImpostoIssqn.getIndIncentivo()
					.toString());

			logger.info("Build ISSQN group for ISSQN_REF {} finished.",
					issqnRef);

			return issqn;
		} else {
			logger.warn("Invalid ISSQN_REF to build ISSQN group.");
			return null;
		}
	}

	private ImpostoDevol buildImpostoDevol(ItNfeDet itNfeDet) {
		logger.info("Building ImpostoDevol group.");

		if (isGTZero(itNfeDet.getPDevol()) || isGTZero(itNfeDet.getVIpidevol())) {

			ImpostoDevol impostoDevol = new ImpostoDevol();
			IPI ipiDevol = new IPI();

			impostoDevol.setPDevol(itNfeDet.getPDevol().toString());
			ipiDevol.setVIPIDevol(itNfeDet.getVIpidevol().toString());

			impostoDevol.setIPI(ipiDevol);

			logger.info("Build ImpostoDevol group finished.");

			return impostoDevol;
		} else {
			logger.warn("ImpostoDevol group must not be filled.");
			return null;
		}
	}

	private Total buildTotal() {
		logger.info("Building Total group.");

		Total total = new Total();

		total.setICMSTot(buildICMSTot());
		total.setISSQNtot(buildISSQNtot());
		total.setRetTrib(buildRetTrib());

		logger.info("Build Total group finished.");

		return total;
	}

	private ICMSTot buildICMSTot() {
		logger.info("Building ICMSTot group.");

		ICMSTot icmsTot = new ICMSTot();

		icmsTot.setVBC(isNfeIcmstot.getVBc().toString());
		icmsTot.setVICMS(isNfeIcmstot.getVIcms().toString());
		icmsTot.setVICMSDeson(isNfeIcmstot.getVIcmsdeson().toString());
		icmsTot.setVBCST(isNfeIcmstot.getVBcst().toString());
		icmsTot.setVST(isNfeIcmstot.getVSt().toString());
		icmsTot.setVProd(isNfeIcmstot.getVProd().toString());
		icmsTot.setVFrete(isNfeIcmstot.getVFrete().toString());
		icmsTot.setVSeg(isNfeIcmstot.getVSeg().toString());
		icmsTot.setVDesc(isNfeIcmstot.getVDesc().toString());
		icmsTot.setVII(isNfeIcmstot.getVIi().toString());
		icmsTot.setVIPI(isNfeIcmstot.getVIpi().toString());
		icmsTot.setVPIS(isNfeIcmstot.getVPis().toString());
		icmsTot.setVCOFINS(isNfeIcmstot.getVCofins().toString());
		icmsTot.setVOutro(isNfeIcmstot.getVOutro().toString());
		icmsTot.setVNF(isNfeIcmstot.getVNf().toString());

		if (isGTZero(isNfeIcmstot.getVTotTrib())) {
			icmsTot.setVTotTrib(isNfeIcmstot.getVTotTrib().toString());
		}

		logger.info("Build ICMSTot group finished.");

		return icmsTot;
	}

	private ISSQNtot buildISSQNtot() {
		logger.info("Building ISSQNtot group.");

		if (isGTZero(isNfeIssqntot.getVServ())
				|| isGTZero(isNfeIssqntot.getVBc())
				|| isGTZero(isNfeIssqntot.getVIss())
				|| isGTZero(isNfeIssqntot.getVPis())
				|| isGTZero(isNfeIssqntot.getVCofins())
				|| isGTZero(isNfeIssqntot.getVDeducao())
				|| isGTZero(isNfeIssqntot.getVOutro())
				|| isGTZero(isNfeIssqntot.getVDescIncond())
				|| isGTZero(isNfeIssqntot.getVDescCond())
				|| isGTZero(isNfeIssqntot.getVIssret())
				|| !isNfeIssqntot.getCRegTrib().trim().isEmpty()) {

			ISSQNtot issqntot = new ISSQNtot();

			if (isGTZero(isNfeIssqntot.getVServ())) {
				issqntot.setVServ(isNfeIssqntot.getVServ().toString());
			}

			if (isGTZero(isNfeIssqntot.getVBc())) {
				issqntot.setVBC(isNfeIssqntot.getVBc().toString());
			}

			if (isGTZero(isNfeIssqntot.getVIss())) {
				issqntot.setVISS(isNfeIssqntot.getVIss().toString());
			}

			if (isGTZero(isNfeIssqntot.getVPis())) {
				issqntot.setVPIS(isNfeIssqntot.getVPis().toString());
			}

			if (isGTZero(isNfeIssqntot.getVCofins())) {
				issqntot.setVCOFINS(isNfeIssqntot.getVCofins().toString());
			}

			issqntot.setDCompet(DT_FORMAT.format(isNfeIssqntot.getDCompet()));

			if (isGTZero(isNfeIssqntot.getVDeducao())) {
				issqntot.setVDeducao(isNfeIssqntot.getVDeducao().toString());
			}

			if (isGTZero(isNfeIssqntot.getVOutro())) {
				issqntot.setVOutro(isNfeIssqntot.getVOutro().toString());
			}

			if (isGTZero(isNfeIssqntot.getVDescIncond())) {
				issqntot.setVDescIncond(isNfeIssqntot.getVDescIncond()
						.toString());
			}

			if (isGTZero(isNfeIssqntot.getVDescCond())) {
				issqntot.setVDescCond(isNfeIssqntot.getVDescCond().toString());
			}

			if (isGTZero(isNfeIssqntot.getVIssret())) {
				issqntot.setVISSRet(isNfeIssqntot.getVIssret().toString());
			}

			if (!isNfeIssqntot.getCRegTrib().trim().isEmpty()) {
				issqntot.setCRegTrib(isNfeIssqntot.getCRegTrib().toString());
			}

			logger.info("Build ISSQNtot group finished.");

			return issqntot;
		} else {
			logger.warn("ISSQNtot group must not be filled.");
			return null;
		}
	}

	private RetTrib buildRetTrib() {
		logger.info("Building RetTrib group.");

		if (isGTZero(isNfeRettrib.getVRetPis())
				|| isGTZero(isNfeRettrib.getVRetCofins())
				|| isGTZero(isNfeRettrib.getVRetCsll())
				|| isGTZero(isNfeRettrib.getVBcirrf())
				|| isGTZero(isNfeRettrib.getVIrrf())
				|| isGTZero(isNfeRettrib.getVRetPrev())) {

			RetTrib retTrib = new RetTrib();

			if (isGTZero(isNfeRettrib.getVRetPis())) {
				retTrib.setVRetPIS(isNfeRettrib.getVRetPis().toString());
			}

			if (isGTZero(isNfeRettrib.getVRetCofins())) {
				retTrib.setVRetCOFINS(isNfeRettrib.getVRetCofins().toString());
			}

			if (isGTZero(isNfeRettrib.getVRetCsll())) {
				retTrib.setVRetCSLL(isNfeRettrib.getVRetCsll().toString());
			}

			if (isGTZero(isNfeRettrib.getVBcirrf())) {
				retTrib.setVBCIRRF(isNfeRettrib.getVBcirrf().toString());
			}

			if (isGTZero(isNfeRettrib.getVIrrf())) {
				retTrib.setVIRRF(isNfeRettrib.getVIrrf().toString());
			}

			if (isGTZero(isNfeRettrib.getVRetPrev())) {
				retTrib.setVRetPrev(isNfeRettrib.getVRetPrev().toString());
			}

			logger.info("Build RetTrib group finished.");

			return retTrib;
		} else {
			logger.warn("RetTrib group must not be filled.");
			return null;
		}
	}

	private Transp buildTransp() {
		logger.info("Building Transp group.");

		Transp transp = new Transp();

		transp.setModFrete(isNfeTransp.getModFrete());

		transp.setTransporta(buildTransporta());
		transp.setRetTransp(buildRetTransp());
		transp.setVeicTransp(buildVeicTransp());

		List<TVeiculo> reboques = buildReboques();
		if (reboques.size() > 0) {
			transp.getReboque().addAll(reboques);
		}

		if (!isNfeTransp.getVagao().trim().isEmpty()) {
			transp.setVagao(isNfeTransp.getVagao());
		}

		if (!isNfeTransp.getBalsa().trim().isEmpty()) {
			transp.setBalsa(isNfeTransp.getBalsa());
		}

		List<Vol> vols = buildVols();
		if (vols.size() > 0) {
			transp.getVol().addAll(vols);
		}

		logger.info("Build RetTrib Transp finished.");

		return transp;
	}

	private Transporta buildTransporta() {
		logger.info("Building Transporta group for PARTNER_ID_TRANSPORTA {}.",
				isNfePartnerIds.getPartnerIdTransporta());

		ItNfePartner itNfePartner = getItNfePartner(isNfePartnerIds
				.getPartnerIdTransporta());

		if (itNfePartner != null) {
			Transporta transporta = new Transporta();

			if (!itNfePartner.getCnpj().matches("^0+$")
					&& !itNfePartner.getCnpj().trim().isEmpty()) {
				transporta.setCNPJ(itNfePartner.getCnpj());
			} else if (!itNfePartner.getCpf().matches("^0+$")
					&& !itNfePartner.getCpf().trim().isEmpty()) {
				transporta.setCPF(itNfePartner.getCpf());
			}

			if (!itNfePartner.getXNome().trim().isEmpty()) {
				transporta.setXNome(itNfePartner.getXNome());
			}

			if (!itNfePartner.getIe().trim().isEmpty()) {
				transporta.setIE(itNfePartner.getIe());
			}

			if (!itNfePartner.getXEnder().trim().isEmpty()) {
				transporta.setXEnder(itNfePartner.getXEnder());
			}

			if (!itNfePartner.getXMun().trim().isEmpty()) {
				transporta.setXMun(itNfePartner.getXMun());
			}

			if (!itNfePartner.getUf().trim().isEmpty()) {
				transporta.setUF(TUf.fromValue(itNfePartner.getUf()));
			}

			logger.info(
					"Build Transporta group for PARTNER_ID_TRANSPORTA {} finished.",
					isNfePartnerIds.getPartnerIdTransporta());

			return transporta;
		} else {
			logger.info("Invalid PARTNER_ID_TRANSPORTA to build Transporta group.");
			return null;
		}
	}

	private RetTransp buildRetTransp() {
		logger.info("Building RetTransp group.");

		if (isGTZero(isNfeTransp.getVServ())
				|| isGTZero(isNfeTransp.getVBcret())
				|| isGTZero(isNfeTransp.getPIcmsret())
				|| isGTZero(isNfeTransp.getVIcmsret())
				|| !isNfeTransp.getCfop().trim().isEmpty()
				|| isNfeTransp.getCMunFg() > 0) {
			RetTransp retTransp = new RetTransp();

			retTransp.setVServ(isNfeTransp.getVServ().toString());
			retTransp.setVBCRet(isNfeTransp.getVBcret().toString());
			retTransp.setPICMSRet(isNfeTransp.getPIcmsret().toString());
			retTransp.setVICMSRet(isNfeTransp.getVIcmsret().toString());
			retTransp.setCFOP(isNfeTransp.getCfop());
			retTransp.setCMunFG(isNfeTransp.getCMunFg().toString());

			logger.info("Build RetTransp group finished.");

			return retTransp;
		} else {
			logger.warn("RetTransp group must not be filled.");
			return null;
		}
	}

	private TVeiculo buildVeicTransp() {
		logger.info("Building TVeiculo group.");

		if (!isNfeTransp.getPlaca().trim().isEmpty()
				|| !isNfeTransp.getUf().trim().isEmpty()
				|| !isNfeTransp.getRntc().trim().isEmpty()) {
			TVeiculo tVeiculo = new TVeiculo();

			tVeiculo.setPlaca(isNfeTransp.getPlaca());
			tVeiculo.setUF(TUf.valueOf(isNfeTransp.getUf()));

			if (!isNfeTransp.getRntc().trim().isEmpty()) {
				tVeiculo.setRNTC(isNfeTransp.getRntc());
			}

			logger.info("Build TVeiculo group finished.");

			return tVeiculo;
		} else {
			logger.warn("TVeiculo group must not be filled.");
			return null;
		}
	}

	private List<TVeiculo> buildReboques() {
		logger.info("Building TVeiculo group for {} element(s).",
				itNfeReboques.size());

		List<TVeiculo> reboques = new ArrayList<>();

		for (ItNfeReboque itNfeReboque : itNfeReboques) {
			logger.info("Building TVeiculo group for ID {}.",
					itNfeReboque.getId());

			TVeiculo tVeiculo = new TVeiculo();

			tVeiculo.setPlaca(itNfeReboque.getPlaca());
			tVeiculo.setUF(TUf.valueOf(itNfeReboque.getUf()));

			if (!itNfeReboque.getRntc().trim().isEmpty()) {
				tVeiculo.setRNTC(itNfeReboque.getRntc());
			}

			reboques.add(tVeiculo);
		}

		logger.info("Build TVeiculo group for {}/{} element(s) finished.",
				reboques.size(), itNfeReboques.size());

		return reboques;
	}

	private List<Vol> buildVols() {
		logger.info("Building Vol group for {} element(s).", itNfeVols.size());

		List<Vol> vols = new ArrayList<>();

		for (ItNfeVol itNfeVol : itNfeVols) {
			logger.info("Building Vol group for ID {}.", itNfeVol.getId());

			Vol vol = new Vol();

			vol.setQVol(itNfeVol.getQVol().toString());
			vol.setEsp(itNfeVol.getEsp());
			vol.setMarca(itNfeVol.getMarca());
			vol.setNVol(itNfeVol.getNVol());
			vol.setPesoL(itNfeVol.getPesoL().toString());
			vol.setPesoB(itNfeVol.getPesoB().toString());

			List<Lacres> lacres = buildLacres(itNfeVol.getTextIdLacres());
			if (lacres.size() > 0) {
				vol.getLacres().addAll(lacres);
			}

			vols.add(vol);
		}

		logger.info("Build Vol group for {}/{} element(s) finished.",
				vols.size(), itNfeVols.size());

		return vols;
	}

	private List<Lacres> buildLacres(long textIdLacres) {
		List<Lacres> lacres = new ArrayList<>();

		List<ItNfeText> itNfeTextLoc = getItNfeTexts(textIdLacres);

		logger.info(
				"Building Lacres group for {} element(s) for TEXT_ID_REF {}.",
				itNfeTextLoc.size(), textIdLacres);

		for (ItNfeText itNfeText : itNfeTextLoc) {
			logger.info("Building Lacres group for ID {}.", itNfeText.getId());

			Lacres lacre = new Lacres();

			lacre.setNLacre(itNfeText.getText());

			lacres.add(lacre);
		}

		logger.info(
				"Build Lacres group for {}/{} element(s) for TEXT_ID_REF {} finished.",
				lacres.size(), itNfeTextLoc.size(), textIdLacres);

		return lacres;
	}

	private Cobr buildCobr() {
		logger.info("Building Cobr group.");

		Cobr cobr = new Cobr();

		cobr.setFat(buildFat());

		List<Dup> dups = buildDups();

		if (dups.size() > 0) {
			cobr.getDup().addAll(dups);
		}

		if (cobr.getFat() != null || dups.size() > 0) {
			logger.info("Build Cobr group finished.");

			return cobr;
		} else {
			logger.warn("Cobr group must not be filled.");
			return null;
		}
	}

	private Fat buildFat() {
		logger.info("Building Fat group.");

		if (!isNfeFat.getNFat().trim().isEmpty()
				|| isGTZero(isNfeFat.getVOrig())
				|| isGTZero(isNfeFat.getVDesc())
				|| isGTZero(isNfeFat.getVLiq())) {
			Fat fat = new Fat();

			if (!isNfeFat.getNFat().trim().isEmpty()) {
				fat.setNFat(isNfeFat.getNFat());
			}

			if (isGTZero(isNfeFat.getVOrig())) {
				fat.setVOrig(isNfeFat.getVOrig().toString());
			}

			if (isGTZero(isNfeFat.getVDesc())) {
				fat.setVDesc(isNfeFat.getVDesc().toString());
			}

			if (isGTZero(isNfeFat.getVLiq())) {
				fat.setVLiq(isNfeFat.getVLiq().toString());
			}

			logger.info("Build Fat group finished.");

			return fat;
		} else {
			logger.warn("Fat group must not be filled.");
			return null;
		}
	}

	private List<Dup> buildDups() {
		logger.info("Building Dup group for {} element(s).", itNfeDups.size());

		List<Dup> dups = new ArrayList<>();

		for (ItNfeDup itNfeDup : itNfeDups) {
			logger.info("Building Dup group for ID {}.", itNfeDup.getId());

			Dup dup = new Dup();

			if (!itNfeDup.getNDup().trim().isEmpty()) {
				dup.setNDup(itNfeDup.getNDup());
			}

			dup.setDVenc(DT_FORMAT.format(itNfeDup.getDVenc()));
			dup.setVDup(itNfeDup.getVDup().toString());

			dups.add(dup);
		}

		logger.info("Build Dup group for {}/{} element(s) finished.",
				dups.size(), itNfeDups.size());

		return dups;
	}

	private List<Pag> buildPags() {
		logger.info("Building Pag group for {} element(s).", itNfePags.size());

		List<Pag> pags = new ArrayList<>();

		for (ItNfePag itNfePag : itNfePags) {
			logger.info("Building Pag group for ID {}.", itNfePag.getId());

			Pag pag = new Pag();

			pag.setTPag(itNfePag.getTPag());
			pag.setVPag(itNfePag.getVPag().toString());
			pag.setCard(buildCard(itNfePag));

			pags.add(pag);
		}

		logger.info("Build Pag group for {}/{} element(s) finished.",
				pags.size(), itNfePags.size());

		return pags;
	}

	private Card buildCard(ItNfePag itNfePag) {
		logger.info("Building Card group.");

		if (!itNfePag.getCnpj().trim().isEmpty()
				|| !itNfePag.getTBand().trim().isEmpty()
				|| !itNfePag.getCAut().trim().isEmpty()) {
			Card card = new Card();

			card.setCNPJ(itNfePag.getCnpj());
			card.setTBand(itNfePag.getTBand());
			card.setCAut(itNfePag.getCAut());

			logger.info("Build Card group finished.");

			return card;
		} else {
			logger.warn("Card group must not be filled.");
			return null;
		}
	}

	private InfAdic buildInfAdic() {
		logger.info("Build InfAdic group finished.");

		InfAdic infAdic = new InfAdic();

		if (isNfeInfadic.getInfAdFisco() != null
				&& !isNfeInfadic.getInfAdFisco().trim().isEmpty()) {
			infAdic.setInfAdFisco(isNfeInfadic.getInfAdFisco());
		}

		if (!isNfeInfadic.getInfCpl().trim().isEmpty()) {
			infAdic.setInfCpl(isNfeInfadic.getInfCpl());
		}

		List<ObsCont> obsConts = buildObsConts();
		if (obsConts.size() > 0) {
			infAdic.getObsCont().addAll(obsConts);
		}

		List<ObsFisco> obsFiscos = buildObsFiscos();
		if (obsFiscos.size() > 0) {
			infAdic.getObsFisco().addAll(obsFiscos);
		}

		List<ProcRef> procRefs = buildProcRefs();
		if (procRefs.size() > 0) {
			infAdic.getProcRef().addAll(procRefs);
		}

		if (infAdic.getInfAdFisco() != null || infAdic.getInfCpl() != null
				|| obsConts.size() > 0 || obsFiscos.size() > 0
				|| procRefs.size() > 0) {

			logger.info("Build InfAdic group finished.");

			return infAdic;
		} else {
			logger.warn("InfAdic group must not be filled.");
			return null;
		}
	}

	private List<ObsCont> buildObsConts() {
		List<ObsCont> obsConts = new ArrayList<>();

		List<ItNfeText> itNfeTextsLoc = getItNfeTexts(isNfeInfadic
				.getTextIdObscont());

		logger.info(
				"Building ObsCont group for {} element(s) for TEXT_ID_REF {}.",
				itNfeTextsLoc.size(), isNfeInfadic.getTextIdObscont());

		for (ItNfeText iItNfeText : itNfeTextsLoc) {
			logger.info("Building ObsCont group for ID {} seq {}.",
					iItNfeText.getId(), iItNfeText.getSeqNo());

			ObsCont obsCont = new ObsCont();

			obsCont.setXCampo(iItNfeText.getTyp());
			obsCont.setXTexto(iItNfeText.getText());

			obsConts.add(obsCont);
		}

		logger.info(
				"Build ObsCont group for {}/{} element(s) for TEXT_ID_OBS_CONT {} finished.",
				obsConts.size(), itNfeTextsLoc.size(),
				isNfeInfadic.getTextIdObscont());

		return obsConts;
	}

	private List<ObsFisco> buildObsFiscos() {
		List<ObsFisco> obsFiscos = new ArrayList<>();

		List<ItNfeText> itNfeTextsLoc = getItNfeTexts(isNfeInfadic
				.getTextIdObsfisco());

		logger.info(
				"Building ObsFisco group for {} element(s) for TEXT_ID_REF {}.",
				itNfeTextsLoc.size(), isNfeInfadic.getTextIdObsfisco());

		for (ItNfeText iItNfeText : itNfeTextsLoc) {
			logger.info("Building ObsFisco group for ID {} seq {}.",
					iItNfeText.getId(), iItNfeText.getSeqNo());

			ObsFisco obsFisco = new ObsFisco();

			obsFisco.setXCampo(iItNfeText.getTyp());
			obsFisco.setXTexto(iItNfeText.getText());

			obsFiscos.add(obsFisco);
		}

		logger.info(
				"Build ObsFisco group for {}/{} element(s) for TEXT_ID_OBS_CONT {} finished.",
				obsFiscos.size(), itNfeTextsLoc.size(),
				isNfeInfadic.getTextIdObsfisco());

		return obsFiscos;
	}

	private List<ProcRef> buildProcRefs() {
		logger.info("Building ProcRef group for {} element(s).",
				itNfeProcrefs.size());

		List<ProcRef> procRefs = new ArrayList<>();

		for (ItNfeProcref itNfeProcref : itNfeProcrefs) {
			logger.info("Building ProcRef group for ID {}.",
					itNfeProcref.getId());

			ProcRef procRef = new ProcRef();

			procRef.setNProc(itNfeProcref.getNProc());
			procRef.setIndProc(itNfeProcref.getIndProc());

			procRefs.add(procRef);
		}

		logger.info("Build ProcRef group for {}/{} element(s) finished.",
				procRefs.size(), itNfeProcrefs.size());

		return procRefs;
	}

	private Exporta buildExporta() {
		logger.info("Building Exporta group.");

		if (!isNfeExporta.getUfSaidaPais().trim().isEmpty()
				|| !isNfeExporta.getXLocExporta().trim().isEmpty()
				|| !isNfeExporta.getXLocDespacho().trim().isEmpty()) {
			Exporta exporta = new Exporta();

			exporta.setUFSaidaPais(TUfEmi.valueOf(isNfeExporta.getUfSaidaPais()));
			exporta.setXLocExporta(isNfeExporta.getXLocExporta());

			if (!isNfeExporta.getXLocDespacho().trim().isEmpty()) {
				exporta.setXLocDespacho(isNfeExporta.getXLocDespacho());
			}

			logger.info("Build Exporta group finished.");

			return exporta;
		} else {
			logger.warn("Exporta group must not be filled.");
			return null;
		}
	}

	private Compra buildCompra() {
		logger.info("Building Compra group.");

		if (!isNfeCompra.getXnemp().trim().isEmpty()
				|| !isNfeCompra.getXPed().trim().isEmpty()
				|| !isNfeCompra.getXCont().trim().isEmpty()) {
			Compra compra = new Compra();

			if (!isNfeCompra.getXnemp().trim().isEmpty()) {
				compra.setXNEmp(isNfeCompra.getXnemp());

			}

			if (!isNfeCompra.getXPed().trim().isEmpty()) {
				compra.setXPed(isNfeCompra.getXPed());
			}

			if (!isNfeCompra.getXCont().trim().isEmpty()) {
				compra.setXCont(isNfeCompra.getXCont());
			}

			logger.info("Build Compra group finished.");

			return compra;
		} else {
			logger.warn("Compra group must not be filled.");
			return null;
		}
	}

	private Cana buildCana() {
		logger.info("Building Cana group.");

		Cana cana = new Cana();

		if (!isNfeCana.getSafra().trim().isEmpty()
				|| !isNfeCana.getRef().trim().isEmpty()
				|| itNfeCanaFordias.size() > 0
				|| isGTZero(isNfeCana.getQTotMes())
				|| isGTZero(isNfeCana.getQTotAnt())
				|| isGTZero(isNfeCana.getQTotGer())
				|| isGTZero(isNfeCana.getVFor())
				|| isGTZero(isNfeCana.getVTotDed())
				|| isGTZero(isNfeCana.getVLiqFor())) {
			cana.setSafra(isNfeCana.getSafra());
			cana.setRef(isNfeCana.getRef());

			List<ForDia> forDias = buildForDias();
			if (forDias.size() > 0) {
				cana.getForDia().addAll(forDias);
			}

			cana.setQTotMes(isNfeCana.getQTotMes().toString());
			cana.setQTotAnt(isNfeCana.getQTotAnt().toString());
			cana.setQTotGer(isNfeCana.getQTotGer().toString());
			cana.setVFor(isNfeCana.getVFor().toString());
			cana.setVTotDed(isNfeCana.getVTotDed().toString());
			cana.setVLiqFor(isNfeCana.getVLiqFor().toString());

			logger.info("Build Cana group finished.");

			return cana;
		} else {
			logger.warn("Cana group must not be filled.");
			return null;
		}
	}

	private List<ForDia> buildForDias() {
		logger.info("Building ForDia group for {} element(s).",
				itNfeCanaFordias.size());

		List<ForDia> forDias = new ArrayList<>();

		for (ItNfeCanaFordia itNfeCanaFordia : itNfeCanaFordias) {
			logger.info("Building ForDia group.");

			ForDia forDia = new ForDia();

			forDia.setDia(itNfeCanaFordia.getDia().toString());
			forDia.setQtde(itNfeCanaFordia.getQtde().toString());

			forDias.add(forDia);
		}

		logger.info("Build ForDia group for {}/{} element(s) finished.",
				forDias.size(), itNfeCanaFordias.size());

		return forDias;
	}

	private ItNfePartner getItNfePartner(long partnerRef) {
		logger.info("Finding ItNfePartner for PARTNER_REF {}.", partnerRef);

		for (ItNfePartner itNfePartner : itNfePartners) {
			if (itNfePartner.getId().equals(partnerRef)) {
				logger.info("ItNfePartner for PARTNER_REF {} found.",
						partnerRef);
				return itNfePartner;
			}
		}

		logger.warn("Could not be found ItNfePartner for PARTNER_REF {}.",
				partnerRef);
		return null;
	}

	private ItNfeDetProd getItNfeDetProd(long prodRef) {
		logger.info("Finding itNfeDetProd for PROD_REF {}.", prodRef);

		for (ItNfeDetProd itNfeDetProd : itNfeDetProds) {
			if (itNfeDetProd.getId().equals(prodRef)) {
				logger.info("ItNfeDetProd for PROD_REF {} found.", prodRef);
				return itNfeDetProd;
			}
		}

		logger.warn("Could not be found ItNfeDetProd for PROD_REF {}.", prodRef);
		return null;
	}

	private List<ItNfeProdDi> getItNfeProdDis(long diRef) {
		List<ItNfeProdDi> itNfeProdDisLoc = new ArrayList<>();
		logger.info("Finding ItNfeProdDi for DI_REF {}.", diRef);

		for (ItNfeProdDi itNfeProdDi : itNfeProdDis) {
			if (itNfeProdDi.getId().equals(diRef)) {
				logger.info("ItNfeProdDi for DI_REF {} found seq {}.", diRef,
						itNfeProdDi.getSeqNo());
				itNfeProdDisLoc.add(itNfeProdDi);
			}
		}

		if (itNfeProdDis.size() > 0) {
			logger.info("{} ItNfeProdDi found for DI_REF {}.",
					itNfeProdDis.size(), diRef);
		} else {
			logger.warn("Could not be found ItNfeProdDi for DI_REF {}.", diRef);
		}

		return itNfeProdDisLoc;
	}

	private List<ItNfeDiAdi> getItNfeDiAdis(long adiRef) {
		List<ItNfeDiAdi> itNfeDiAdisLoc = new ArrayList<>();
		logger.info("Finding ItNfeDiAdi for ADI_REF {}.", adiRef);

		for (ItNfeDiAdi itNfeDiAdi : itNfeDiAdis) {
			if (itNfeDiAdi.getId().equals(adiRef)) {
				logger.info("ItNfeDiAdi for ADI_REF {} found seq {}.", adiRef,
						itNfeDiAdi.getNSeqAdic());
				itNfeDiAdisLoc.add(itNfeDiAdi);
			}
		}

		if (itNfeDiAdisLoc.size() > 0) {
			logger.info("{} ItNfeDiAdi found for ADI_REF {}.",
					itNfeDiAdisLoc.size(), adiRef);
		} else {
			logger.warn("Could not be found ItNfeDiAdi for ADI_REF {}.", adiRef);
		}

		return itNfeDiAdisLoc;
	}

	private List<ItNfeProdDetexport> getItNfeProdDetexports(long detExportRef) {
		List<ItNfeProdDetexport> itNfeProdDetexportsLoc = new ArrayList<>();
		logger.info("Finding ItNfeProdDetexport for DET_EXPORT_REF {}.",
				detExportRef);

		for (ItNfeProdDetexport itNfeProdDetexport : itNfeProdDetexports) {
			if (itNfeProdDetexport.getId().equals(detExportRef)) {
				logger.info(
						"ItNfeProdDetexport for DET_EXPORT_REF {} seq {} found.",
						detExportRef, itNfeProdDetexport.getSeqNo());
				itNfeProdDetexportsLoc.add(itNfeProdDetexport);
			}
		}

		if (itNfeProdDetexportsLoc.size() > 0) {
			logger.info("{} ItNfeDiAdi found for ADI_REF {}.",
					itNfeProdDetexportsLoc.size(), detExportRef);
		} else {
			logger.warn(
					"Could not be found ItNfeProdDetexport for DET_EXPORT_REF {}.",
					detExportRef);
		}

		return itNfeProdDetexportsLoc;
	}

	private ItNfeProdVeicprod getItNfeProdVeicprod(long veicProdRef) {
		logger.info("Finding ItNfeProdVeicprod for VEIC_PROD_REF {}.",
				veicProdRef);

		for (ItNfeProdVeicprod itNfeProdVeicprod : itNfeProdVeicprods) {
			if (itNfeProdVeicprod.getId().equals(veicProdRef)) {
				logger.info("ItNfeProdVeicprod for VEIC_PROD_REF {} found.",
						veicProdRef);
				return itNfeProdVeicprod;
			}
		}

		logger.warn(
				"Could not be found ItNfeProdVeicprod for VEIC_PROD_REF {}.",
				veicProdRef);

		return null;
	}

	private List<ItNfeProdMed> getItNfeProdMeds(long medRef) {
		List<ItNfeProdMed> itNfeProdMedsLoc = new ArrayList<>();
		logger.info("Finding ItNfeProdMed for MED_REF {}.", medRef);

		for (ItNfeProdMed itNfeProdMed : itNfeProdMeds) {
			if (itNfeProdMed.getId().equals(medRef)) {
				logger.info("ItNfeProdMed for MED_REF {} seq {} found.",
						medRef, itNfeProdMed.getSeqNo());
				itNfeProdMedsLoc.add(itNfeProdMed);
			}
		}

		if (itNfeProdMedsLoc.size() > 0) {
			logger.info("{} ItNfeProdMed found for MED_REF {}.",
					itNfeProdMedsLoc.size(), medRef);
		} else {
			logger.warn("Could not be found ItNfeProdMed for MED_REF {}.",
					medRef);
		}

		return itNfeProdMedsLoc;
	}

	private List<ItNfeProdArma> getItNfeProdArmas(long armaRef) {
		List<ItNfeProdArma> itNfeProdArmasLoc = new ArrayList<>();
		logger.info("Finding ItNfeProdArma for ARMA_REF {}.", armaRef);

		for (ItNfeProdArma itNfeProdArma : itNfeProdArmas) {
			if (itNfeProdArma.getId().equals(armaRef)) {
				logger.info("ItNfeProdArma for ARMA_REF {} seq {} found.",
						armaRef, itNfeProdArma.getSeqNo());
				itNfeProdArmasLoc.add(itNfeProdArma);
			}
		}

		if (itNfeProdArmasLoc.size() > 0) {
			logger.info("{} ItNfeProdArma found for ARMA_REF {}.",
					itNfeProdArmasLoc.size(), armaRef);
		} else {
			logger.warn("Could not be found ItNfeProdArma for ARMA_REF {}.",
					armaRef);
		}

		return itNfeProdArmasLoc;
	}

	private ItNfeProdComb getItNfeProdComb(long combRef) {
		logger.info("Finding ItNfeProdComb for COMB_REF {}.", combRef);

		for (ItNfeProdComb itNfeProdComb : itNfeProdCombs) {
			if (itNfeProdComb.getId().equals(combRef)) {
				logger.info("ItNfeProdComb for COMB_REF {} found.", combRef);
				return itNfeProdComb;
			}
		}

		logger.warn("Could not be found ItNfeProdComb for COMB_REF {}.",
				combRef);

		return null;
	}

	private ItNfeProdNrecopi getItNfeProdNrecopi(long recopiRef) {
		logger.info("Finding ItNfeProdNrecopi for RECOPI_REF {}.", recopiRef);

		for (ItNfeProdNrecopi itNfeProdNrecopi : itNfeProdNrecopis) {
			if (itNfeProdNrecopi.getId().equals(recopiRef)) {
				logger.info("ItNfeProdNrecopi for RECOPI_REF {} found.",
						recopiRef);
				return itNfeProdNrecopi;
			}
		}

		logger.warn("Could not be found ItNfeProdNrecopi for RECOPI_REF {}.",
				recopiRef);

		return null;
	}

	private ItNfeDetImposto getItNfeDetImposto(long impostoRef) {
		logger.info("Finding ItNfeDetImposto for IMPOSTO_REF {}.", impostoRef);

		for (ItNfeDetImposto itNfeDetImposto : itNfeDetImpostos) {
			if (itNfeDetImposto.getId().equals(impostoRef)) {
				logger.info("ItNfeDetImposto for IMPOSTO_REF {} found.",
						impostoRef);
				return itNfeDetImposto;
			}
		}

		logger.warn("Could not be found ItNfeDetImposto for IMPOSTO_REF {}.",
				impostoRef);

		return null;
	}

	private ItNfeImpostoIcms getItNfeImpostoIcms(long icmsRef) {
		logger.info("Finding ItNfeImpostoIcms for ICMS_REF {}.", icmsRef);

		for (ItNfeImpostoIcms itNfeImpostoIcms : itNfeImpostoIcmss) {
			if (itNfeImpostoIcms.getId().equals(icmsRef)) {
				logger.info("ItNfeImpostoIcms for ICMS_REF {} found.", icmsRef);
				return itNfeImpostoIcms;
			}
		}

		logger.warn("Could not be found ItNfeImpostoIcms for ICMS_REF {}.",
				icmsRef);

		return null;
	}

	private ItNfeImpostoIpi getItNfeImpostoIpi(long ipiRef) {
		logger.info("Finding ItNfeImpostoIpi for ICMS_REF {}.", ipiRef);

		for (ItNfeImpostoIpi itNfeImpostoIpi : itNfeImpostoIpis) {
			if (itNfeImpostoIpi.getId().equals(ipiRef)) {
				logger.info("ItNfeImpostoIpi for ICMS_REF {} found.", ipiRef);
				return itNfeImpostoIpi;
			}
		}

		logger.warn("Could not be found ItNfeImpostoIpi for ICMS_REF {}.",
				ipiRef);

		return null;
	}

	private ItNfeImpostoIi getItNfeImpostoIi(long iiRef) {
		logger.info("Finding ItNfeImpostoIi for II_REF {}.", iiRef);

		for (ItNfeImpostoIi itNfeImpostoIi : itNfeImpostoIis) {
			if (itNfeImpostoIi.getId().equals(iiRef)) {
				logger.info("ItNfeImpostoIi for II_REF {} found.", iiRef);
				return itNfeImpostoIi;
			}
		}

		logger.warn("Could not be found ItNfeImpostoIi for II_REF {}.", iiRef);

		return null;
	}

	private ItNfeImpostoPis getItNfeImpostoPis(long pisRef) {
		logger.info("Finding ItNfeImpostoPis for PIS_REF {}.", pisRef);

		for (ItNfeImpostoPis itNfeImpostoPis : itNfeImpostoPiss) {
			if (itNfeImpostoPis.getId().equals(pisRef)) {
				logger.info("ItNfeImpostoPis for PIS_REF {} found.", pisRef);
				return itNfeImpostoPis;
			}
		}

		logger.warn("Could not be found ItNfeImpostoPis for PIS_REF {}.",
				pisRef);

		return null;
	}

	private ItNfeImpostoPisst getItNfeImpostoPisst(long pisstRef) {
		logger.info("Finding ItNfeImpostoPisst for PISST_REF {}.", pisstRef);

		for (ItNfeImpostoPisst itNfeImpostoPisst : itNfeImpostoPissts) {
			if (itNfeImpostoPisst.getId().equals(pisstRef)) {
				logger.info("ItNfeImpostoPisst for PISST_REF {} found.",
						pisstRef);
				return itNfeImpostoPisst;
			}
		}

		logger.warn("Could not be found ItNfeImpostoPisst for PISST_REF {}.",
				pisstRef);

		return null;
	}

	private ItNfeImpostoCofins getItNfeImpostoCofins(long cofinstRef) {
		logger.info("Finding ItNfeImpostoCofins for COFINS_REF {}.", cofinstRef);

		for (ItNfeImpostoCofins itNfeImpostoCofins : itNfeImpostoCofinss) {
			if (itNfeImpostoCofins.getId().equals(cofinstRef)) {
				logger.info("ItNfeImpostoCofins for COFINS_REF {} found.",
						cofinstRef);
				return itNfeImpostoCofins;
			}
		}

		logger.warn("Could not be found ItNfeImpostoCofins for COFINS_REF {}.",
				cofinstRef);

		return null;
	}

	private ItNfeImpostoCofinsst getItNfeImpostoCofinsst(long cofinssttRef) {
		logger.info("Finding ItNfeImpostoCofinsst for COFINSST_REF {}.",
				cofinssttRef);

		for (ItNfeImpostoCofinsst itNfeImpostoCofinsst : itNfeImpostoCofinssts) {
			if (itNfeImpostoCofinsst.getId().equals(cofinssttRef)) {
				logger.info("ItNfeImpostoCofinsst for COFINSST_REF {} found.",
						cofinssttRef);
				return itNfeImpostoCofinsst;
			}
		}

		logger.warn(
				"Could not be found ItNfeImpostoCofinsst for COFINSST_REF {}.",
				cofinssttRef);

		return null;
	}

	private ItNfeImpostoIssqn getItNfeImpostoIssqn(long issqnRef) {
		logger.info("Finding ItNfeImpostoIssqn for ISSQN_REF {}.", issqnRef);

		for (ItNfeImpostoIssqn ItNfeImpostoIssqn : itNfeImpostoIssqns) {
			if (ItNfeImpostoIssqn.getId().equals(issqnRef)) {
				logger.info("ItNfeImpostoIssqn for ISSQN_REF {} found.",
						issqnRef);
				return ItNfeImpostoIssqn;
			}
		}

		logger.warn("Could not be found ItNfeImpostoIssqn for ISSQN_REF {}.",
				issqnRef);

		return null;
	}

	private List<ItNfeText> getItNfeTexts(long textRef) {
		List<ItNfeText> itNfeTextLoc = new ArrayList<>();
		logger.info("Finding ItNfeText for TEXT_REF {}.", textRef);

		for (ItNfeText itNfeText : itNfeTexts) {
			if (itNfeText.getId().equals(textRef)) {
				logger.info("ItNfeText for TEXT_REF {} found seq {}.", textRef,
						itNfeText.getSeqNo());
				itNfeTextLoc.add(itNfeText);
			}
		}

		if (itNfeTextLoc.size() > 0) {
			logger.info("{} ItNfeText found for TEXT_REF {}.",
					itNfeTextLoc.size(), textRef);
		} else {
			logger.warn("Could not be found ItNfeText for TEXT_REF {}.",
					textRef);
		}

		return itNfeTextLoc;
	}

	private boolean isRefNF(ItNfeNfref ref) {
		return (!ref.getCUf().trim().isEmpty() || ref.getAamm() != 0
				|| !ref.getIe().trim().isEmpty()
				|| (ref.getMod() != 0 && ref.getMod() != 4)
				|| !ref.getNNf().trim().isEmpty()
				|| !ref.getSerie().trim().isEmpty() || (!ref.getCnpj().matches(
				"^0+$") && !ref.getCnpj().trim().isEmpty()))
				&& (ref.getCpf().matches("^0+$") && ref.getCpf().trim()
						.isEmpty()) && ref.getIe().trim().isEmpty();
	}

	private boolean isRefNFP(ItNfeNfref ref) {
		return !ref.getCUf().trim().isEmpty()
				|| ref.getAamm() != 0
				|| !ref.getIe().trim().isEmpty()
				|| ref.getMod() != 0
				|| !ref.getNNf().trim().isEmpty()
				|| !ref.getSerie().trim().isEmpty()
				|| (!ref.getCnpj().matches("^0+$") && !ref.getCnpj().trim()
						.isEmpty())
				|| (!ref.getCpf().matches("^0+$") && !ref.getCpf().trim()
						.isEmpty());
	}

	private boolean isRefECF(ItNfeNfref ref) {
		return ref.getModEcf().trim().isEmpty() || ref.getNCoo() != 0
				|| ref.getNEcf() != 0;
	}

	private boolean checkIsNfeAvulsaFilled(IsNfeAvulsa isNfeAvulsa) {
		return !isNfeAvulsa.getCnpj().trim().isEmpty()
				|| !isNfeAvulsa.getXOrgao().trim().isEmpty()
				|| !isNfeAvulsa.getMatr().trim().isEmpty()
				|| !isNfeAvulsa.getXAgente().trim().isEmpty()
				|| !isNfeAvulsa.getUf().trim().isEmpty()
				|| !isNfeAvulsa.getRepEmi().trim().isEmpty();
	}

	private String sapDateTime2nfeDateTime(String sapTime) {
		return sapTime.replaceAll(DT_TM_SAP_PAT, DT_TM_NFE_REP).concat(
				sapConnectorConfig.getTimeZone());
	}
	
	private boolean isGTZero(BigDecimal bd) {
		return bd.compareTo(BigDecimal.ZERO) == 1;
	}
}