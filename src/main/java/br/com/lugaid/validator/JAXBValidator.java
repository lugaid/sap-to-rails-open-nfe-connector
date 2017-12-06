package br.com.lugaid.validator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.*;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class JAXBValidator {
	public static List<SAXException> validate(File xsdFile, Object object)
			throws SAXException, IOException, JAXBException {
		XmlErrorHandler errorHandler = new XmlErrorHandler();

		try {
	        JAXBContext jc = JAXBContext.newInstance(object.getClass());
	        JAXBSource source = new JAXBSource(jc, object);
	        
	        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
	        Schema schema = sf.newSchema(xsdFile); 

	        Validator validator = schema.newValidator();
	        validator.setErrorHandler(errorHandler);
	        validator.validate(source);
	        
			return errorHandler.getValidationErrors();
		} catch (JAXBException e) {
			throw e;
		}
	}

	private static class XmlErrorHandler implements ErrorHandler{
		private List<SAXException> validationErrors = new ArrayList<SAXException>();

		public List<SAXException> getValidationErrors() {
			return validationErrors;
		}

		@Override
		public void error(SAXParseException exception) throws SAXException {
			validationErrors.add(exception);
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			validationErrors.add(exception);
		}

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			validationErrors.add(exception);
		}
	}
}