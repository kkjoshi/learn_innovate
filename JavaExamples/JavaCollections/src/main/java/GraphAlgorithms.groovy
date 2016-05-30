import com.tinkerpop.blueprints.Graph
import com.tinkerpop.blueprints.Vertex
import com.tinkerpop.gremlin.groovy.Gremlin

/**
 * Created by joshika on 1/18/2016.
 */

class GraphAlgorithms {
    static {
        Gremlin.load()
    }

    public static Map<Vertex, Integer> eigenvectorRank(Graph g) {
        Map<Vertex,Integer> m = [:]; int c = 0
        g.V.as('x').out.groupCount(m).loop('x') {c++ < 1000}.iterate()
       // g.V.has('stepId', '1').out.
        return m
    }
}