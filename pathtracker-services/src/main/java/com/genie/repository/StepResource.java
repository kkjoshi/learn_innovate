package com.genie.repository;

import com.genie.model.Path;
import com.genie.model.Step;
import com.thinkaurelius.titan.core.PropertyKey;
import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.thinkaurelius.titan.core.schema.TitanManagement;
import com.thinkaurelius.titan.core.util.TitanCleanup;
import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.blueprints.Edge;
import com.tinkerpop.blueprints.Vertex;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.tinkerpop.blueprints.Edge;
//import com.tinkerpop.blueprints.Vertex;

/**
 * Created by joshika on 12/6/2015.
 */
public class StepResource {
    TitanGraph titanGraph;

    public StepResource(){
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
    public Map<String, List<Step>> getNextPossibleWorkFlows(Step step){
        Map<String, List<Step>> workFlows = new HashMap<String, List<Step>>();


        return workFlows;
    }
    public void createDefaultSteps(){

        Vertex step1 = createVtx("step1", true, 1);
        Vertex step2 = createVtx("step2", false, 2);
        Vertex step3 = createVtx("step3", false, 3);
        Vertex step4 = createVtx("step4", false, 4);
        Vertex step5 = createVtx("step5", false, 5);

        Edge path12 = titanGraph.addEdge(null, step1, step2, "1to2");
        path12.setProperty("duration", 3);
        Edge path23 = titanGraph.addEdge(null, step2, step3, "2to3");
        path23.setProperty("duration", 4);
        Edge path34 = titanGraph.addEdge(null, step3, step4, "3to4");
        path34.setProperty("duration", 5);
        Edge path45 = titanGraph.addEdge(null, step4, step5, "4to5");
        path45.setProperty("duration", 6);
        Edge path15 = titanGraph.addEdge(null, step1, step5, "1to5");
        path15.setProperty("duration", 7);



        titanGraph.commit();

    }

    private Vertex createVtx(String name, boolean isRoot, long id) {
        Vertex step = titanGraph.addVertex();
        step.setProperty("isroot", isRoot);
        step.setProperty("stepId", id);
        step.setProperty("stepname", name);
        step.setProperty("createdAt", LocalDateTime.now().toString());

        return step;
    }

    private  void createSchema(final TitanGraph graph) {
        final TitanManagement m = graph.getManagementSystem();
        final PropertyKey something = m.makePropertyKey("something").dataType(String.class).make();
        if(!m.containsPropertyKey(something.getName())) {
            m.buildIndex("bySomething", Vertex.class).addKey(something).buildCompositeIndex();
            m.commit();
        }
    }
    public void cleanDefaultGraph(){
        titanGraph.rollback();
        titanGraph.shutdown();
        TitanCleanup.clear(titanGraph);
    }
    private Step createStepFromVtx(Vertex vtx){
        Step step = new Step();
        step.setName(vtx.getProperty("stepname").toString());
        step.setDescription(vtx.getProperty("isroot")? "start" : "not a start");
        step.setCreatedAt(vtx.getProperty("createdAt").toString());
        step.setStepId((Long)vtx.getProperty("stepId"));

        return step;
    }
    private List<Step> findStepsInWorkFlow(Step start){
        Vertex vtx = (Vertex)titanGraph.query().has("stepId", start.getStepId()).vertices().iterator().next();
        List<Step> steps = new ArrayList<Step>();
        Iterable<Vertex> possiblePathVtxes = null;
        do {
            Step step1 = createStepFromVtx(vtx);
            Iterable<Edge> edges = vtx.getEdges(Direction.OUT);
            for(Edge edge : edges){
                Step step2 = createStepFromVtx(edge.getVertex(Direction.OUT));
                Path path = new Path(step1, step2,
                        Duration.ofSeconds((Long)edge.getProperty("duration")),edge.getLabel().toString());
                // implement recursive alg to iterate through graph
            }
            steps.add(step1);
            long i = step1.getStepId();
            String path = i + "to" + ++i;
            possiblePathVtxes = vtx.query().labels(path).direction(Direction.OUT).vertices();
            vtx = possiblePathVtxes.iterator().hasNext() ? possiblePathVtxes.iterator().next() : null;
            // if(vtx == null) break;
        }while(vtx != null);

        return steps;
    }
    public List<Step> findNextPossibleSteps(){
        List<Step> steps = new ArrayList<Step>();

        Iterable<Vertex> results = titanGraph.query().has("isroot", true).vertices();
        Vertex rootVtx = null;
        if(!results.iterator().hasNext())
            return steps;

        rootVtx = results.iterator().next();
        Iterable<Vertex> possiblePathVtxes = null;
        do {
            Step step = new Step();
            step.setName(rootVtx.getProperty("stepname").toString());
            step.setDescription(rootVtx.getProperty("isroot")? "start" : "not a start");
            step.setCreatedAt(rootVtx.getProperty("createdAt").toString());
            step.setStepId((Long)rootVtx.getProperty("stepId"));
            steps.add(step);
            long i = step.getStepId();
            String path = i + "to" + ++i;
            possiblePathVtxes = rootVtx.query().labels(path).direction(Direction.OUT).vertices();
            rootVtx = possiblePathVtxes.iterator().hasNext() ? possiblePathVtxes.iterator().next() : null;
           // if(vtx == null) break;
        }while(rootVtx != null);

        return steps;
        //rash.query().labels("FRIEND").has("since", 2011).vertices();

    }
    public List<Step> findAllSteps(){
        List<Step> activities = new ArrayList<Step>();

        Iterable<Vertex> results = titanGraph.getVertices();
                //rash.query().labels("FRIEND").has("since", 2011).vertices();

        for(Vertex result : results)
        {
            Step step = new Step();
            step.setName(result.getProperty("stepname").toString());
            activities.add(step);
        }

//        Iterable<Vertex> results = rash.query().labels("FRIEND").has("since", 2011).vertices();
//
//        for(Vertex result : results)
//        {
//            System.out.println("Id: " + result.getProperty("userId"));
//            System.out.println("Username: " + result.getProperty("username"));
//            System.out.println("Name: " + result.getProperty("firstName") + " " + result.getProperty("lastName"));
//        }
        return activities;
    }

}

