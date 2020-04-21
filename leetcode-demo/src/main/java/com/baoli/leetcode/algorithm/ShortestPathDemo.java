package com.baoli.leetcode.algorithm;

import com.google.common.graph.ElementOrder;
import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;
import org.junit.Test;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @program: common-demo
 * @description: 最短路径算法
 * @author: li baojian
 * @create: 2020-04-17 10:38
 */
public class ShortestPathDemo {
    /**
     * Dijkstra算法
     */
    @Test
    public void testShortestPath() {
        MutableValueGraph<String, Integer> graph = initMutableValueGraph();
        String startNode = "V0";
        HashMap<String, NodeExtra> nodeExtras = new HashMap<>();
        Set<String> nodes = graph.nodes();
        for (String node : nodes) {
            NodeExtra nodeExtra = new NodeExtra();
            Integer value = graph.edgeValueOrDefault(startNode, node, Integer.MAX_VALUE);
            nodeExtra.nodeName = node;
            nodeExtra.distance = value;
            nodeExtra.is_visited = false;
            if (value < Integer.MAX_VALUE) {
                nodeExtra.path = startNode + "->" + node;
                nodeExtra.preNodeName = startNode;
            }
            nodeExtras.put(node, nodeExtra);
        }
        //初始化开始节点
        NodeExtra currentNode = nodeExtras.get(startNode);
        currentNode.preNodeName = startNode;
        currentNode.distance = 0;
        currentNode.path = startNode;
        currentNode.is_visited = true;
        //循环所有节点
        for (String node : nodes) {
            int min = Integer.MAX_VALUE;
            NodeExtra minNode = null;
            //找出开始节点最短的节点
            for (String notVisited : nodes) {
                NodeExtra nodeExtra = nodeExtras.get(notVisited);
                if (!nodeExtra.is_visited && nodeExtra.distance < min) {
                    min = nodeExtra.distance;
                    minNode = nodeExtra;
                }
            }
            //更新最短路径节点
            if (minNode != null) {
                minNode.is_visited = true;
                minNode.path = nodeExtras.get(minNode.preNodeName).path + " ->" + minNode.nodeName;
                currentNode = minNode;
            }
            //更新最短路径相关联的节点信息
            Set<String> successors = graph.successors(currentNode.nodeName);
            for (String name : successors) {
                NodeExtra nodeExtra1 = nodeExtras.get(name);
                if (!nodeExtra1.is_visited) {
                    int value = currentNode.distance + graph.edgeValueOrDefault(currentNode.nodeName, name, 0);
                    if (value < nodeExtra1.distance) {
                        nodeExtra1.distance = value;
                        nodeExtra1.preNodeName = currentNode.nodeName;
                    }
                }
            }
        }
        for (String key : nodeExtras.keySet()) {
            NodeExtra nodeExtra = nodeExtras.get(key);
            if (nodeExtra.distance < Integer.MAX_VALUE) {
                System.out.println(startNode + " -> " + key + " min " + nodeExtra.distance + " path " + nodeExtra.path);
            }
        }
    }

    private MutableValueGraph<String, Integer> initMutableValueGraph() {

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

    class NodeExtra {
        //节点名称
        public String nodeName;
        //最短路径距离
        public int distance;
        //是否是最短路径
        public boolean is_visited;
        //前一个节点
        public String preNodeName;
        //路径
        public String path;
    }

}
