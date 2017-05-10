package myDataStructure.graphAndShorestPath;

import java.util.List;

/**
 * Created by pro on 17/4/23.
 */
public class Main {
    public static void main(String[] args) {
        Graph g=new Graph("/Users/pro/graph.txt");
//        Graph g=new Graph("/Users/pro/test.txt");

//        g.printGraph();

        //DFS
//        Graph g1=g.dfsTraversal(0);
//        System.out.println();
//        g1.printGraph();
//        g1.dfsTraversal(0);

        //BFS
//        System.out.println();
//        Graph g2=g.bfsTraversal(0);
//        g2.printGraph();
//        System.out.println();
//        g2.bfsTraversal(0);

        // the shortest path by BFS
//        List<Integer> path=g.getShortestEdgePath(0,4);
//        System.out.println(path);

        //dijkstra

        g.dijkstraShortestPaths(0);

    }
}
