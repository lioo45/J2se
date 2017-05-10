package myDataStructure.graphAndShorestPath;

import java.util.*;

/**
 * Created by pro on 17/4/23.
 */
public class Graph1
{
    private ArrayList<EdgeNode>[]   adjList ;
    private int nVertices;
    private int  nEdges;
    private int totalWeight;

    //creates Graph from data in file
    public Graph1(String inputFileName)  {
        init(inputFileName);
    }

    private void init(String fileName){
        List<String> lines=FileUtils.readFile(fileName);
        // size of v
        int num=new Integer(lines.get(0).trim());
        nVertices=num;
        //init adjList
        adjList=new ArrayList[num];
        for (int i = 0; i <num ; i++) {
            adjList[i]=new ArrayList<EdgeNode>();
        }
        // add edge
        for (int i = 1; i <lines.size() ; i++) {
            if(!lines.get(i).isEmpty()) {
                int[] a = getNumbers(lines.get(i));
                addEdge(a[0], a[1], a[2]);
            }
        }
    }

    //get EdgeNode's vertex1, vertex2,weight from string
    private int[] getNumbers(String s){
        if(s==null||s.isEmpty())
            return null;
        int[]  numbers=new int[3];
        String num="";
        for (int i = 0,j=0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(c>='0'&&c<='9')
                num+=c;
            else{
                if(!num.isEmpty()) {
                    numbers[j] = new Integer(num);
                    num = "";
                    j++;
                }
            }
            if(j==3)
                break;
        }
        if(!num.isEmpty())
            numbers[2]=new Integer(num);
        return numbers;
    }

    //Creates a  Graph with n vertices and 0 edges
    public Graph1(int n ) {
        nVertices=n;
        adjList=new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            adjList[i]=new ArrayList<>();
        }
    }

    //adds an edge to the graph
    public void addEdge(int i, int j, int weight) {
        EdgeNode node1=new EdgeNode(i,j,weight);
        EdgeNode node2=new EdgeNode(j,i,weight);
        adjList[i].add(node1);
        adjList[j].add(node2);
        nEdges++;
        totalWeight+=weight;

    }

    public void printGraph()  {
        //prints nVertices, nEdges, and adjacency lists and total edge weight
        System.out.printf("Graph: nVertices = %d  nEdges = %d  totalEdgeWeight = %d\n"
                ,nVertices,nEdges,totalWeight);
        System.out.println(" Adjacency Lists:");
        for (int i = 0; i <adjList.length; i++) {
            List list=adjList[i];
            System.out.print("v="+i+"  ");
            System.out.println(list);
        }
    }

    public int get_nVertices() {
        return nVertices;
    }
    public int get_nEdges(){
        return nEdges;
    }
    public int get_TotalWeightOfEdges() { return totalWeight;}

    //DFS
    public Graph1 dfsTraversal (int start)  {
        System.out.print("DFS nodes: ");
        Info info=new Info();
        Set<Integer> visited=new HashSet<>();
        Graph1 graph=new Graph1(adjList.length);

        //the dfs core
        dfs(start,info,visited,graph);

        if(visited.size()>=nVertices)
            info.Connected=true;
        if(nEdges>nVertices-1)
            info.hasCycle=true;

        printInfo(info);


        if(info.Connected){
            return graph;
        }else {
            return null;
        }
    }

    private void printInfo(Info info){
        System.out.println();
        System.out.println("Connected: "+info.Connected);
        System.out.println("NumberOfComponents: "+info.NumberOfComponents);
        System.out.println("Has a cycle: "+info.hasCycle);
    }


    private void dfs(int start, Info info, Set<Integer> visited,Graph1 graph){
        if(!visited.contains(start)){
            System.out.print(start+", ");
            visited.add(start);
            info.NumberOfComponents++;
        }

        //get adjNode
        List<EdgeNode> list=adjList[start];
        for (int i = 0; i <list.size() ; i++) {
            int next=list.get(i).vertex2;
            if(next==start)
                continue;
            if(!visited.contains(next)) {
                graph.addEdge(start,next,list.get(i).weight);
                dfs(next, info, visited, graph);
            }
        }
    }
    //BFS
    public Graph1 bfsTraversal (int start)   {
        System.out.print("BFS nodes: ");

        Info info=new Info();
        Graph1 graph=new Graph1(adjList.length);
        //the bfs core
        bfs(start,info,graph);

        printInfo(info);

        if(info.Connected)
            return graph;
        else
            return null;
    }

    private void bfs(int start,Info info,Graph1 graph){
        Set<Integer> visited=new HashSet<>();
        Queue<Integer> queue=new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            //get adjNode
            int cur=queue.remove();
            System.out.print(cur + " ,");
            visited.add(cur);
            info.NumberOfComponents++;
            List<EdgeNode> list=adjList[cur];
            for (int i = 0; i <list.size() ; i++) {
                int next=list.get(i).vertex2;
                if(next==cur)
                    continue;
                if(!visited.contains(next)) {
                    graph.addEdge(cur,next,list.get(i).weight);
                    queue.add(next);
                    visited.add(next);
                }
            }
        }
        if(visited.size()>=nVertices)
            info.Connected=true;
        if(nEdges>nVertices-1)
            info.hasCycle=true;
    }

    public ArrayList<Integer> getShortestEdgePath( int x, int y) {
        /*
             Return the shortest edge path from x to y .
             If no such list, return null
             Use breadth first search
        */
        //init
        Path startPath=new Path();
        startPath.path=new ArrayList<>();
        startPath.visited=new boolean[nVertices];
        startPath.path.add(0);
        startPath.visited[x]=true;

        Path shortesrPath=new Path(null,null,Integer.MAX_VALUE);
        Queue<Path> queue=new LinkedList<>();
        queue.add(startPath);

        //find all path from x to y by bfs
        //and select the shortest path from it.
        while(!queue.isEmpty()){
            Path cur=queue.remove();
            ArrayList<EdgeNode> list=adjList[cur.path.get(cur.path.size()-1)];
            for (int i = 0; i <list.size() ; i++) {
                EdgeNode node=list.get(i);
                if(cur.visited[y]){
                    if(cur.cost<shortesrPath.cost)
                        shortesrPath=cur;
                    continue;
                }
                if(!cur.visited[node.vertex2]) {
                    boolean visited[]=Arrays.copyOf(cur.visited,cur.visited.length);
                    visited[node.vertex2]=true;
                    List<Integer> newPath=new ArrayList<>(cur.path);
                    newPath.add(node.vertex2);
                    queue.add(new Path(visited,newPath,cur.cost+node.weight));
                }
            }
        }

        //select the shortest path
        return (ArrayList<Integer>) shortesrPath.path;
    }
//
    public void   dijkstraShortestPaths (int start ) {
        //if visited[x] is true ,the node adList[x] had visited
        boolean visited[]=new boolean[adjList.length];
        PriorityQueue<EdgeNode> queue=new PriorityQueue<>();
        visited[start]=true;
        //get start node's adj edges and init
        ArrayList<EdgeNode> list=adjList[start];
        for (EdgeNode node:list)
            queue.add(node);
        //init cost
        Cost[] costs=initCosts(start);

        while(!queue.isEmpty()){
            EdgeNode node=queue.remove();
            visited[node.vertex2]=true;
            relax(node,costs);

            //get node's adj edges and relax
            ArrayList<EdgeNode> adj=adjList[node.vertex2];
            for (EdgeNode n:adj) {
                if(!visited[n.vertex2])
                    queue.add(n);
                //relax
                if(n.vertex2!=node.vertex1){
                    relax(n,costs);
                }
            }
        }
        //print the  shortest path's info
        printPath(costs,start);
    }

    public int[] bellmanFordShortestPaths(int start){
        /* Implement Bellman Ford Shortest Path algorithm from text
            Prints shortest paths from vertex start to all other vertices reachable from start */

        // init all edge and Cost
        Cost costs[]=initCosts(start);
        List<EdgeNode> nodes=getAllEdgeNodes();
//            dealWithRepeatedNode(nodes);

        //relax nVertices-1
        for (int i = 0; i <nVertices-1 ; i++) {
            for(EdgeNode node:nodes){
                if(costs[node.vertex1].cost!=Integer.MAX_VALUE) {
                    relax(node,costs);
                }
            }
        }
        //judge result
        for(EdgeNode node:nodes){
            if(costs[node.vertex1].cost+node.weight<costs[node.vertex2].cost)
                return null;
        }

        printPath(costs,start);

        List<List<Integer>> result=new ArrayList();
        for(Cost cost:costs){
            result.add(cost.path);
        }
        //temperate
        return null;

    }
    //put all edge node into list and return it
    private List<EdgeNode> getAllEdgeNodes(){
        List<EdgeNode> nodes=new ArrayList<>();
        for (int i = 0; i <adjList.length ; i++) {
            List<EdgeNode> list=adjList[i];
            nodes.addAll(list);
        }
        return nodes;
    }

    private void relax(EdgeNode node,Cost[] costs){
        int spend = costs[node.vertex1].cost + node.weight;
        if (spend < costs[node.vertex2].cost) {
            costs[node.vertex2].cost = spend;
            costs[node.vertex2].path = new ArrayList<>(costs[node.vertex1].path);
            costs[node.vertex2].path.add(node.vertex2);
        }

    }

    //print the  shortest path's info
    private void printPath(Cost[] costs,int start){
        for (int i = 0; i <costs.length ; i++) {
            System.out.println("the cost of the shortest path from "+start+" to "+i+" is : "+costs[i].cost);
            System.out.println("path: ");
            StringBuilder sb=new StringBuilder();
            if(costs[i]!=null&&costs[i].path!=null) {
                for (int k : costs[i].path)
                    sb.append(k + " -> ");
                String s = sb.substring(0, sb.lastIndexOf("->"));
                System.out.println(s + "\n");
            }else{
                System.out.println("not existed");
            }
        }
    }
    private Cost[] initCosts(int start){
        Cost costs[]=new Cost[adjList.length];
        for (int i = 0; i <costs.length ; i++) {
            costs[i]=new Cost();
        }
        costs[start].cost=0;
        costs[start].path=new ArrayList<>();
        costs[start].path.add(start);
        return costs;
    }
    public Graph1 kruskalMST()   {
        List<EdgeNode> nodes=getAllEdgeNodes();
        PriorityQueue<EdgeNode> minHeap=new PriorityQueue<>(nodes);
        UnionFind unionFind=new UnionFind(adjList.length);

        Graph1 result=new Graph1(adjList.length);
        int edgeNum=0;
        while(!minHeap.isEmpty()){
            EdgeNode node=minHeap.remove();
            //if it's not the same group
            if(!unionFind.isTheSameGroup(node.vertex1,node.vertex2)){
                result.addEdge(node.vertex1,node.vertex2,node.weight);
                edgeNum++;
                unionFind.union(node.vertex1,node.vertex2);
                if(edgeNum>=nVertices-1)
                    break;

            }
        }
        //check graph is connected
        boolean connected=true;
//        for (int i = 0; i <adjList.length ; i++) {
//            if(result.adjList[i].size()<=0)
//                connected=false;
//        }
        Graph1 dfs=this.dfsTraversal(0);
        if(dfs==null)
            connected=false;
        if(connected){
            return result;
        }else {
            System.out.println("the graph is not connected!!!");
            return null;
        }
    }

    static class Cost{
        //the Shortest Path
        ArrayList<Integer> path;
        //path cost
        int cost=Integer.MAX_VALUE;
    }

    static class Info{
        int NumberOfComponents=0;
        boolean Connected=false;
        boolean hasCycle=false;
    }
    static class  EdgeNode  implements Comparable<EdgeNode>
    {
        int vertex1;
        int vertex2;
        int weight;
        public EdgeNode ( int v1, int v2, int w)
        {
            vertex1 = v1;
            vertex2 = v2;
            weight = w;
        }

        public int  compareTo( EdgeNode node)
        {
            return weight - node.weight;
        }

        public String toString()
        {

            String s = "(";
            s = s + vertex1 + "," +vertex2 + ","  + weight + ")";
            return s;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(vertex1)^Objects.hashCode(vertex2)^Objects.hashCode(weight);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj==null)
                return false;
            EdgeNode node= (EdgeNode) obj;
            if(node.weight==this.weight){
                if(this.vertex1==node.vertex1&&this.vertex2==node.vertex2||
                        this.vertex1==node.vertex2&&this.vertex1==node.vertex2)
                    return true;
            }
            return false;
        }
    }
    // my implement of UnionFind
    static class UnionFind{
        int[] group;
        int[] groupSize;

        public UnionFind(int size){
            group=new int[size];
            groupSize=new int[size];
            for (int i = 0; i < size; i++) {
                group[i]=i;
                groupSize[i]=1;
            }
        }
        //return the group of target
        public int find(int target){
            int root=group[target];
            while(root!=group[root]){
                group[root]=group[group[root]];
                root=group[root];
            }
            return root;
        }

        public boolean isTheSameGroup(int one,int other){
            return find(one)==find(other);
        }

        public int union(int one,int other){
            if(isTheSameGroup(one,other))
                return -1;
            int groupOfOne=find(one);
            int groupOfOther=find(other);
            int oneSize=groupSize[groupOfOne];
            int otherSize=groupSize[groupOfOther];

            if(oneSize>otherSize){
                group[other]=one;
                groupSize[groupOfOne]+=groupSize[groupOfOther];
                return groupSize[groupOfOne];
            }else{
                group[one]=other;
                groupSize[groupOfOther]+=groupSize[groupOfOne];
                return groupSize[groupOfOther];
            }
        }

        public int count(int index){
            return groupSize[index];
        }
    }

    //the function getShortestEdgePath() will use this class
    static class Path{
        boolean[] visited;
        List<Integer> path;
        int cost=0;

        public Path(boolean[] visited, List<Integer> path, int cost) {
            this.visited = visited;
            this.path = path;
            this.cost = cost;
        }

        public Path(){}
    }

//    public static void main(String[] args) {
////        Graph g=new Graph("/Users/pro/test.txt");
//        Graph g=new Graph("/Users/pro/graph.txt");
////        Graph g=new Graph("graph.txt");
//
//        System.out.println("~~~~~~");
//
//        Graph dfs=g.dfsTraversal(0);
//        dfs.printGraph();
//
//        Graph bfs=g.bfsTraversal(0);
//        bfs.printGraph();
//
//        System.out.println("find the shortest path by bfs");
//        List<Integer> list=g.getShortestEdgePath(0,7);
//        System.out.println(list);
//
//        System.out.println("find the shortest path by dijkstra");
//        g.dijkstraShortestPaths(0);
//        System.out.println("find the shortest path by bellmanFord");
//        g.bellmanFordShortestPaths(0);
//
//        System.out.println("find the MST by kruskal");
//        Graph kru=g.kruskalMST();
//        kru.printGraph();
//
//    }

}

