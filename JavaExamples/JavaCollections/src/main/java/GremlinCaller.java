
import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

/**
 * Created by joshika on 1/18/2016.
 */
public class GremlinCaller {


    private  void createSchema(final TitanGraph graph) {
        final TitanManagement m = graph.getManagementSystem();
        final PropertyKey something = m.makePropertyKey("something").dataType(String.class).make();
        if(!m.containsPropertyKey(something.getName())) {
            m.buildIndex("bySomething", Vertex.class).addKey(something).buildCompositeIndex();
            m.commit();
        }
    }
    TitanGraph titanGraph;

    public void graphResource(){
        titanGraph = getGraph();
        createSchema(titanGraph);
    }
    private TitanGraph getGraph() {
        return TitanFactory.build()
                .set("storage.backend", "cassandra")
                //.set("storage.directory", "/tmp/titan-sandbox-db")
                .set("storage.hostname", "localhost")
                .open();
    }

    public static void main(String[] args){
        GremlinCaller ct = new GremlinCaller();
        ct.graphResource();
        ct.titanGraph = ct.getGraph();
        Vertex step1 = ct.titanGraph.addVertex();
        step1.setProperty("isEnd", true);
        step1.setProperty("stepId", "1");
        step1.setProperty("stepname", "step1");
        //step.setProperty("createdAt", LocalDateTime.now().toString());
        Vertex step2 = ct.titanGraph.addVertex();
        step2.setProperty("isEnd", true);
        step2.setProperty("stepId", "2");
        step2.setProperty("stepname", "step2");
        Vertex step3 = ct.titanGraph.addVertex();


        Edge path12 = ct.titanGraph.addEdge(null, step1, step2, "1to2");
        Edge path23 = ct.titanGraph.addEdge(null, step2, step3, "2to3");
        path12.setProperty("duration", 3);
        path12.setProperty("journey", "j1");

        System.out.println(GraphAlgorithms.eigenvectorRank(ct.titanGraph));

    }

}
