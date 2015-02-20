package br.com.lugaid.parser;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.inf.portalfiscal.nfe.TNFe;

public class TNfeParser {
	private static Logger logger = LoggerFactory.getLogger(TNfeParser.class);

	public static String parse(TNFe tNFe) {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(TNFe.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// Change xml declaration to remove standalone="yes"
			jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

			// Set encoding
			jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			// Output formatted to log
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			jaxbMarshaller.marshal(tNFe, sw);
			String formattedXml = removeNSfromXML(sw.toString());
			logger.debug("XML generated: \n {}", formattedXml);

			// create unformatted xml to dont send to open nfe
			sw = new StringWriter();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			jaxbMarshaller.marshal(tNFe, sw);
			String xml = removeNSfromXML(sw.toString());
			logger.info("XML final: \n {}", xml);

			return xml;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String removeNSfromXML(String inXml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setNamespaceAware(false);

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc = builder.parse(new InputSource(
					new StringReader(inXml)));

			doc.getDocumentElement().removeAttribute("xmlns:ns2");

			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.transform(domSource, new StreamResult(writer));
			return writer.toString();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return null;
	}
}
