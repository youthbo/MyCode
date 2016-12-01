package se.plushogskolan.model;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;

public class CustomerParser {

	public static String parseToString(Customer customer) {

		return String.format("%s:%s:%s:%s", customer.getId(), customer.getFirstname(), customer.getLastname(),
				customer.getNumber());

	}

	public static Customer parseToCustomer(String value) {
		String[] s = value.split(":");
		return new Customer(Long.valueOf(s[0]), s[1], s[2], s[3]);
	}

	public static String parseToXml(Customer customer) {
		// use JAXB to convert object to XML, need to add annotation and setter in Customer
		// class
		JAXBContext context;
		StringWriter writer = new StringWriter();
		try {
			context = JAXBContext.newInstance(Customer.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(customer, writer);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return writer.toString();
	}

	public static String parseToXmlWithXMLEncoder(Customer customer) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		XMLEncoder xmlEncoder = new XMLEncoder(baos);
		xmlEncoder.writeObject(customer);
		xmlEncoder.close();
		return baos.toString();
	}
}
