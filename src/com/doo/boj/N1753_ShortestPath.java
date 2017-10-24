package com.doo.boj;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class N1753_ShortestPath {

    static int V, E, K;
    static int[] distance;
    static Map<Integer, Map<Integer, Edge>> graph = new HashMap<Integer, Map<Integer, Edge>>();
    
    public static void main(final String[] args) {
        try {
            //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	BufferedReader br = new BufferedReader(new FileReader("/Users/jeonbyeongdoo/Documents/workspace/algorithm/resources/N1753_SampleData.txt"));
            String line = br.readLine();
            
            V = Integer.parseInt(line.split(" ")[0]);
            E = Integer.parseInt(line.split(" ")[1]);
            K = Integer.parseInt(br.readLine());
            distance = new int[V + 1];
            int from, to, cost;
            for (int e = 1; e <= E; e++) {
                line = br.readLine();
                from = Integer.parseInt(line.split(" ")[0]);
                to = Integer.parseInt(line.split(" ")[1]);
                cost = Integer.parseInt(line.split(" ")[2]);
                Edge newEdge = new Edge(from, to, cost);
                Map<Integer, Edge> oldEdges = graph.get(Integer.valueOf(newEdge.from));
                if (oldEdges == null) {
                    oldEdges = new HashMap<Integer, Edge>();
                }
                Edge oldEdge = oldEdges.get(newEdge.to);
                if (oldEdge == null || newEdge.cost < oldEdge.cost) {
                    oldEdges.put(newEdge.to, newEdge);
                    graph.put(Integer.valueOf(newEdge.from), oldEdges);
                }
            }
            
            dijkstra(K);
        
            for (int v = 1; v <= V; v++) {
                System.out.println(distance[v] == Integer.MAX_VALUE ? "INF" : distance[v]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    static void dijkstra(final int s) {
        PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
        for (int v = 1; v <= V; v++) {
            if (v == s) { 
                distance[v] = 0;
            } else {
                distance[v] = Integer.MAX_VALUE;
            }
            pq.add(new Vertex(v, distance[v]));
        }
        
        while (!pq.isEmpty()) {
            Vertex vt = pq.poll();
            if (vt.distance < Integer.MAX_VALUE && distance[vt.n] <= vt.distance) {
                Map<Integer, Edge> edgeMap = graph.get(Integer.valueOf(vt.n));
                if (edgeMap != null) {
                    for (Integer key : edgeMap.keySet()) {
                        Edge edge = edgeMap.get(key);
                        if (distance[edge.to] > (distance[vt.n] + edge.cost)) {
                            distance[edge.to] = distance[vt.n] + edge.cost;
                            pq.add(new Vertex(edge.to, distance[edge.to]));
                        }
                    }
                }
            }
        }
    }
    
    static class Vertex implements Comparable<Vertex> {
        int n, distance;
        
        public Vertex(final int n, final int distance) {
            this.n = n;
            this.distance = distance;
        }

        @Override
        public int compareTo(Vertex v) {
            if (this.distance < v.distance) {
                return -1;
            } else if (this.distance > v.distance) {
                return 1;
            }
            return 0;
        }
    }
    
    static class Edge {
        int from, to, cost;
        
        public Edge(final int from, final int to, final int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
