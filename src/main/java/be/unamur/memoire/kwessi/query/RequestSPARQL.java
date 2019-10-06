package be.unamur.memoire.kwessi.query;

import be.unamur.memoire.kwessi.jena.MyOntologie;
import org.apache.jena.iri.IRI;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.RDFNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class RequestSPARQL {

    private Dataset dataset;

    private String rdfPrefix;

    private String  MyOntologyPrefix;

    private String queryString;

    @Autowired
    MyOntologie myOntologie;

    public void executeQuery(String request){
        //Model m = myOntologie.initModel();
        Model m = null;
        dataset = DatasetFactory.create(m);
        rdfPrefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" ;

        MyOntologyPrefix="PREFIX ns: <http://www.semanticweb.org/will/ontologies/2019/4/kwessi#>";
        queryString= MyOntologyPrefix+"\n"+ rdfPrefix+"\n"+
                request;



        Query query = QueryFactory.create(queryString) ;

        QueryExecution qexec = QueryExecutionFactory.create(query,dataset) ;

        Model model = qexec.execConstruct();



        //-----------------------------------------------------------------------------------

        /*queryString= MyOntologyPrefix+"\n"+ rdfPrefix+"\n"+
                "SELECT ?subject \n" +
                "\tWHERE { ?subject a owl:ObjectProperty }";
        query = QueryFactory.create(queryString) ;
        qexec = QueryExecutionFactory.create(query,dataset) ;
        dataset = DatasetFactory.create(model);
        ResultSet resultset = qexec.execSelect() ;


        ResultSetFormatter.out(System.out,resultset,query) ;

        //Affichage du resultat

        while(resultset.hasNext()) {

            QuerySolution row = (QuerySolution)resultset.next();

            RDFNode c= row.get("CodeMal");
            System.out.print(c.toString());

        }*/
    }

    /*public void selectQuery(String request){
        dataset = DatasetFactory.create(myOntologie.initModel());
        rdfPrefix = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\r\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\r\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\r\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>" ;

        MyOntologyPrefix="PREFIX ns: <http://www.semanticweb.org/will/ontologies/2019/7/domaine-connaissance-reseau-sociaux#>";
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

    /*
    public boolean executeQuery(String query) {
        return false;
    }

    public void updateQuery(String query) {

    }

    public String requestToSelect(){
        return "SELECT ?x WHERE{?x rdf:type ns:ReseauSocial}";
    }

    public boolean ajoutChamp(String rs_du_champ, String nom_champ,
                              String taille_champ, String type_champ) {
        //Requête pour vérifier l'existence du champ
        String queryStringVerifChamp= "ASK WHERE{ns:"+nom_champ+" rdf:type ns:Champ}";
        //Requête pour vérifier l'existence du champ
        String queryStringVerifReseauSocial= "ASK WHERE{ns:"+rs_du_champ+" rdf:type ns:ReseauSocial}";
        if(executeQuery(queryStringVerifChamp)==true)
            return false;
        if(executeQuery(queryStringVerifReseauSocial)==false)
            return false;
        // Insertion du nouveau type s'il n'existe pas
        String queryStringInsertType = "INSERT {\n"
                + "  ns:"+type_champ+" rdf:type ns:Type .}"
                + "WHERE { \n" +
                "   FILTER NOT EXISTS \n" +
                "   { \n" +
                "     ns:"+type_champ+" rdf:type ns:Type . \n" +
                "   } \n" +
                "}";
        // Insertion du nouveau type
        updateQuery(queryStringInsertType);

        // Insertion du nouveau champ
        String queryStringInsertChamp = "INSERT DATA { \n"
                + "ns:"+nom_champ+" rdf:type ns:Champ .\n"
                + "ns:"+nom_champ+ "ns:aPourType ns:"+type_champ+" .\n"
                + "ns:"+nom_champ+" ns:nomChamp \""+nom_champ+"\" .\n"
                + "ns:"+nom_champ+" ns:tailleChamp \""+taille_champ+"\" .\n"
                + "}";
        updateQuery(queryStringInsertChamp);
        return true;
    }*/
}
