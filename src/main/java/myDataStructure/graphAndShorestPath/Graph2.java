package myDataStructure.graphAndShorestPath;

import java.util.*;

/**
 * Created by pro on 17/4/23.
 */
public class Graph2
{
    private ArrayList<EdgeNode>[]   adjList ;
    private int nVertices;
    private int  nEdges;
    private int totalWeight;

    //creates Graph from data in file
    public Graph2(String inputFileName)  {
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


    //adds an edge to the graph
    public void addEdge(int i, int j, int weight) {
        EdgeNode node1=new EdgeNode(i,j,weight);
        EdgeNode node2=new EdgeNode(j,i,weight);
        adjList[i].add(node1);
        adjList[j].add(node2);
        nEdges++;
        totalWeight+=weight;

    }



    public List<List<Integer>> bellmanFordShortestPaths(int start){

        //初始化
        Cost costs[]=initCosts(start);
        List<EdgeNode> nodes=getAllEdgeNodes();

        //松弛 nVertices-1次
        for (int i = 0; i <nVertices-1 ; i++) {
            for(EdgeNode node:nodes){
                if(costs[node.vertex1].cost!=Integer.MAX_VALUE) {
                    relax(node,costs);
                }
            }
        }
        //处理含负权值得情况
        for(EdgeNode node:nodes){
            if(costs[node.vertex1].cost+node.weight<costs[node.vertex2].cost)
                return null;
        }

        //输出最短路径
        printPath(costs,start);

        List<List<Integer>> result=new ArrayList();
        for(Cost cost:costs){
            result.add(cost.path);
        }
        return result;

    }
    //把所有的边放入list并返回
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

    static class Cost{
        //the Shortest Path
        ArrayList<Integer> path;
        //path cost
        int cost=Integer.MAX_VALUE;
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
    }




}

