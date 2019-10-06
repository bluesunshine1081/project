package be.unamur.memoire.kwessi.jena;

import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasoner;
import org.apache.jena.reasoner.rulesys.Rule;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;
import org.apache.jena.util.FileManager;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

@Service
public class MyOntologie {

    private String monontologie;

    private OntModel ontModel;

    private final static String TYPE_DOC = "RDF/XML";

    private final static String PATH = "C://Ontologie/domaine-connaissance-kwessi.owl";

    public MyOntologie(){
        String monontologie=(PATH);
        //creer un modele d'ontologie
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MICRO_RULE_INF);
        InputStream reader = FileManager.get().open(monontologie);

        if (reader == null) {
            throw new IllegalArgumentException("File: " + monontologie
                    + " not found"); }

        model.read(reader , "","RDF/XML");
    }

    /*public void readFile(String request){

        InputStream reader = FileManager.get().open(monontologie);
        if (reader == null) {
            throw new IllegalArgumentException("File: " + monontologie
                    + " not found"); }
        model.read(reader , "",TYPE_DOC);

        //construire la requette

        queryString= MyOntologyPrefix+"\n"+ rdfPrefix+"\n"+
               request;

        Query query = QueryFactory.create(queryString) ;

        QueryExecution qexec = QueryExecutionFactory.create(query,dataset) ;



        ResultSet resultset = qexec.execSelect() ;


        ResultSetFormatter.out(System.out,resultset,query) ;

        //Affichage du resultat

        while(resultset.hasNext()) {

            QuerySolution row = (QuerySolution)resultset.next();

            RDFNode c= row.get("CodeMal");
            System.out.print(c.toString());

        }
    }*/

    public void write(){
        /*OutputStream writer = FileManager.get().loadModel();
        if (writer == null) {
            throw new IllegalArgumentException("File: " + monontologie
                    + " not found"); }
        model.write(writer , "",TYPE_DOC);
        model.*/

    }

    /*public void request(){
        String queryStringInsertChamp = rdfPrefix+"\n"+ MyOntologyPrefix+"\n"+
                "INSERT DATA { \n"
                + "ns:twitter rdf:type ns:ReseauSocial ."
                + "ns:twitter ns:aPourChamp ns:photo ."
                + "ns:twitter ns:nomRS \"facebook\" ."
                + "}";
        dataset = DatasetFactory.create(model);
        String queryUpdate= MyOntologyPrefix+"\n"+ rdfPrefix+"\n"+ "INSERT {\n"
                //+ "ns:Video rdfs:subClassOf ns:Type"
                + "  ns:video rdf:type ns:Champ ."
                + "}"
                + "WHERE \n" +
                "{ \n" +
                "   FILTER NOT EXISTS \n" +
                "   { \n" +
                "     ns:Video rdfs:subClassOf ns:Type . \n" +
                "   } \n" +
                "}";



        UpdateRequest request = UpdateFactory.create() ; request.add(queryStringInsertChamp);
        UpdateAction.execute(request,
                dataset) ;
    }*/

    public String getMonontologie() {
        return monontologie;
    }

    public void setMonontologie(String monontologie) {
        this.monontologie = monontologie;
    }

    public OntModel getModel() {
        return ontModel;
    }

    public void setModel(OntModel ontModel) {
        this.ontModel = ontModel;
    }
}
