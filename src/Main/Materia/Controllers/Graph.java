package Main.Materia.Controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import Main.Materia.Models.Node;
import Main.Materia.Models.NodeG;

public class Graph {
    List<NodeG> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public NodeG addNode(int value){
        NodeG nodeGraph = new NodeG(value);
        nodes.add(nodeGraph); //Agrega el nodo creado a la lista
        return nodeGraph;
    }

    public void addEdge(NodeG src, NodeG dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void addEdgeUni(NodeG src, NodeG dest){
        src.addNeighbor(dest);
    }

    public void printGraph(){
        for(NodeG nodeGraph : nodes){
            System.out.print("Vertice " + nodeGraph.getValue() + ": ");
            for(NodeG nei : nodeGraph.getNeighbors()){
                System.out.print(nei.getValue() + " - ");
            }
            System.out.println();
        }
    }

    public void getDFS(NodeG startNode){
        Set<NodeG> visitados = new HashSet<>();
        System.out.println("DFS desde el node " + startNode.getValue() + " :");
        getDFSUtil(startNode, visitados);
        System.out.println();
    }
    
    private void getDFSUtil(NodeG node, Set<NodeG> visitados){
        if(visitados.contains(node)){
            return;
        }
        
        System.out.print(node.getValue() + " ");
        visitados.add(node);


        for(NodeG neighbor : node.getNeighbors()){
            getDFSUtil(neighbor, visitados);
        }
    }

    //EJERCICIO/////////////////////////////////////////////////////////////////////////////////

    public void getDFS(NodeG startNode, NodeG endNodeG){
        Set<NodeG> visitados = new HashSet<>();
        System.out.println("DFS desde el node " + startNode.getValue() + " :");
        getDFSUtil(startNode, visitados, endNodeG);
        System.out.println();
    }

    private void getDFSUtil(NodeG node, Set<NodeG> visitados, NodeG endNode){
        if(visitados.contains(node)){
            return;
        }
        
        System.out.print(node.getValue() + " ");
        visitados.add(node);


        for(NodeG neighbor : node.getNeighbors()){
            if(visitados.contains(endNode)){
                return;
            }
            getDFSUtil(neighbor, visitados, endNode);
        }
    }



    public void getBFS(NodeG start){
        Set<NodeG> visitados = new HashSet<>();
        Queue<NodeG> cola = new LinkedList<>();
        
        System.out.println("BFS desde el nodo " + start.getValue());
        cola.add(start);
        visitados.add(start);

        while(!cola.isEmpty()){
            NodeG actual = cola.poll();
            System.out.print(actual.getValue() + " ");

            for(NodeG neighbor : actual.getNeighbors()){
                if(!visitados.contains(neighbor)){
                    visitados.add(neighbor);
                    cola.add(neighbor);
                }
            }
        }
    }

    /*public int[][] getAdjacencyMatrix(){

    }*/

    public void printAdjacencyMatrix(){
        
    }


}
