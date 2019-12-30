package com.hdsfa.graph;


public class MatrixGraph extends AbstractGraph {
    //Create  graph  Adjacency matrix  if connect a[i][j] = 1 else  a[i][j] = 0
    public int[][] container;

    MatrixGraph(int vertex){
        this.vertex = vertex;
        this.container = new int[this.vertex][this.vertex];
    }

    int vertex(){ return this.vertex; }
    int edge(){ return this.edge; }

    @Override
    void addEdge(Object v, Object w) {
        this.container[(Integer) v][(Integer) w] = 1;
        this.edge++;
    }

    /*
    *  add Vertex need to Enlarge Size of container
    * */
    @Override
    void addVertex(Object v) { }
}
