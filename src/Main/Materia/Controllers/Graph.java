package Main.Materia.Controllers;

import java.util.ArrayList;
import java.util.List;
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

    public void printGraph(){
        for(NodeG nodeGraph : nodes){
            System.out.print("Vertice " + nodeGraph.getValue() + ": ");
            for(NodeG nei : nodeGraph.getNeighbors()){
                System.out.print(nei.getValue() + " - ");
            }
            System.out.println();
        }
    }

    public void getDfS(NodeG startNode){
        
    }
    
    private void getDfSUtil(NodeG node, boolean[] visited){
        
    }

    public void getBFS(NodeG starNode){
        
    }

    /*public int[][] getAdjacencyMatrix(){

    }*/

    public void printAdjacencyMatrix(){
        
    }


}
