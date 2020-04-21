package com.baoli.leetcode.day;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import java.util.HashMap;
import java.util.Set;

/**
 * @program: common-demo
 * @description: 最短路径算法
 * @author: li baojian
 * @create: 2020-04-16 16:21
 */
public class ShortestPathDemo {
    public static void main(String[] args) {
        MutableValueGraph<String, Integer> graph = initGraph();
        testDijkstra(graph,"V0");

    }

    public static void testDijkstra(MutableValueGraph<String, Integer> graph, String startNode) {
        Set<String> nodes = graph.nodes();
        HashMap<String, NodeExtra> nodeExtras = new HashMap<>();
        for (String node:nodes){
            NodeExtra nodeExtra = new NodeExtra();
            nodeExtra.nodeName=node;
            Integer value = graph.edgeValueOrDefault(startNode, node, Integer.MAX_VALUE);
            nodeExtra.distance=value;
            nodeExtra.visited=false;
            if(value<Integer.MAX_VALUE){
                nodeExtra.preNode=startNode;
                nodeExtra.path=startNode+"->"+node;
            }
            nodeExtras.put(node,nodeExtra);
        }

        //设置开始节点距离为0
        NodeExtra currentNode = nodeExtras.get(startNode);
        currentNode.distance=0;
        currentNode.visited=true;
        currentNode.path=startNode;
        currentNode.preNode=startNode;
        //循环所有节点
        for (String node:nodes){
            NodeExtra minNode=null;
            int min = Integer.MAX_VALUE;
            //找出开始节点最短的路径节点
           for (String notVisited:nodes){
               NodeExtra nodeExtra = nodeExtras.get(notVisited);
               if(!nodeExtra.visited&&nodeExtra.distance<min){
                   min=nodeExtra.distance;
                   minNode=nodeExtra;
               }
           }
           //更新找到的最短路径的节点信息
            if(minNode!=null){
                minNode.visited=true;
                minNode.path=nodeExtras.get(minNode.preNode).path+"->"+minNode.nodeName;
                currentNode=minNode;
            }
            //并入新查找到的节点后，更新与其相关的节点的最短路径信息
            Set<String> successors = graph.successors(currentNode.nodeName);
            for (String name:successors){
                NodeExtra nodeExtra = nodeExtras.get(name);
                if(!nodeExtra.visited){
                    int value = currentNode.distance + graph.edgeValueOrDefault(currentNode.nodeName, name, 0);
                    if(value<nodeExtra.distance){
                        nodeExtra.distance=value;
                        nodeExtra.preNode=currentNode.nodeName;
                    }
                }
            }

        }
        for (String key:nodeExtras.keySet()){
            NodeExtra nodeExtra = nodeExtras.get(key);
            if(nodeExtra.distance<Integer.MAX_VALUE){
                System.out.println(startNode+" -> "+nodeExtra.nodeName+" min: "+nodeExtra.distance+" path: "+nodeExtra.path);
            }
        }



    }

    private static MutableValueGraph<String, Integer> initGraph() {
        MutableValueGraph<String, Integer> graph = ValueGraphBuilder.directed().nodeOrder(ElementOrder.insertion()).expectedNodeCount(10).build();
        graph.putEdgeValue("V0", "V2", 10);
        graph.putEdgeValue("V0", "V4", 30);
        graph.putEdgeValue("V0", "V5", 100);
        graph.putEdgeValue("V1", "V2", 5);
        graph.putEdgeValue("V2", "V3", 50);
        graph.putEdgeValue("V3", "V5", 10);
        graph.putEdgeValue("V4", "V3", 20);
        graph.putEdgeValue("V4", "V5", 60);
        return graph;
    }

    static class NodeExtra {
        //当前节点的名称
        public String nodeName;
        //开始节点到当前节点的距离
        public int distance;
        //当前节点是否是已经求过的最短路径集合中的节点
        public boolean visited;
        //前一个节点
        public String preNode;
        //路径的所有途经点
        public String path;

    }
}
