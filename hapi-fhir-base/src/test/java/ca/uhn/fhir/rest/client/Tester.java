package ca.uhn.fhir.rest.client;

import java.io.IOException;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.parser.DataFormatException;
import ca.uhn.fhir.rest.client.exceptions.NonFhirResponseException;

public class Tester {

	public static final void main(String[] args) throws DataFormatException, IOException {
		try {

			FhirContext ctx = new FhirContext(Patient.class);
			ITestClient client = ctx.newRestfulClient(ITestClient.class, "http://spark.furore.com/fhir/");

			Patient patient = client.getPatientById(new IdDt("1"));
			System.out.println(ctx.newXmlParser().encodeResourceToString(patient));

//			Patient patient2 = client.findPatientByMrn(new IdentifierDt("http://orionhealth.com/mrn", "PRP1660"));
//			System.out.println(ctx.newXmlParser().encodeResourceToString(patient2));

		} catch (NonFhirResponseException e) {
			e.printStackTrace();
			System.out.println(e.getResponseText());
		}

	}

}
