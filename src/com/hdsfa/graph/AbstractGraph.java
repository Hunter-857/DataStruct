package com.hdsfa.graph;

import java.util.HashSet;

abstract class AbstractGraph<T> {
    int vertex;
    int edge;

    abstract int vertex();

    abstract int edge();
    abstract void addEdge(T v , T w);
    abstract void addVertex(T v);
}
