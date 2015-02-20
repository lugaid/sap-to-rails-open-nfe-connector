package br.com.lugaid.validator;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLValidator {
	public static List<String> validateXml(String xsd, String xml)
			throws ParserConfigurationException, SAXException, IOException {
		XmlErrorHandler errorHandler = new XmlErrorHandler();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		factory.setNamespaceAware(true);
		factory.setValidating(true);

		factory.setAttribute(
				"http://java.sun.com/xml/jaxp/properties/schemaLanguage",
				"http://www.w3.org/2001/XMLSchema");
		factory.setAttribute(
				"http://java.sun.com/xml/jaxp/properties/schemaSource", xsd);

		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			builder.setErrorHandler(errorHandler);

			builder.parse(new InputSource(new StringReader(xml)));

			return errorHandler.getValidationErrors();
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw e;
		}
	}

	private static class XmlErrorHandler implements ErrorHandler {
		private List<String> validationErrors = new ArrayList<String>();

		public List<String> getValidationErrors() {
			return validationErrors;
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			validationErrors.add(exception.getMessage());
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			validationErrors.add(exception.getMessage());
		}

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			validationErrors.add(exception.getMessage());
		}
	}
}