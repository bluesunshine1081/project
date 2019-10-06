package be.unamur.memoire.kwessi;

import be.unamur.memoire.kwessi.jena.MyOntologie;
import be.unamur.memoire.kwessi.query.RequestSPARQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KwessiApplication implements CommandLineRunner {
    @Autowired
    RequestSPARQL requestSPARQL;

	public static void main(String[] args) {
		SpringApplication.run(KwessiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//MyOntologie myOntologie = new MyOntologie();
        String request = "CONSTRUCT{\n" +
                "\tns:estUnChamp a owl:ObjectProperty .\n" +
                "\tns:estUnChamp rdfs:domain ns:Champ .\n" +
                "\tns:estUnChamp rdfs:range ns:Reseausocial .\n" +
                "\t?x ns:estUnChamp ?y .\n" +
                "}\n" +
                "\tWHERE { \n" +
                "\n" +
                "\t?x a ns:Champ .\n" +
                "\t?y a ns:ReseauSocial .\n" +
                "\n" +
                "}";
        requestSPARQL.executeQuery(request);

	}
}
