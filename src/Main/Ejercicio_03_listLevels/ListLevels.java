package Main.Ejercicio_03_listLevels;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Main.Materia.Models.Node;

public class ListLevels {
    
    public List<List<Node>> listLeves(Node root){
        if (root == null) {
            return new ArrayList<>(); 
        }
        List<List<Node>> result = new ArrayList<>();
        Queue<Node> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            List<Node> currentLevel = new ArrayList<>();
            int size = cola.size();

            for (int i = 0; i < size; i++) {
                
                Node currentNode = cola.poll();
                currentLevel.add(currentNode);

                if (currentNode.getLeft() != null) {
                    cola.add(currentNode.getLeft());
                }

                if (currentNode.getRight() != null) {
                    cola.add(currentNode.getRight());
                }
            }

            result.add(currentLevel);
        }

        return result;


    }

    public void printLevels(List<List<Node>> levels) {
        if (levels == null || levels.isEmpty()) {
            System.out.println("Arbol vacío.");
            return;
        }
    
        for (int i = 0; i < levels.size(); i++) {
            List<Node> nivel = levels.get(i);
            for (Node node : nivel) {
                System.out.print(node.getValue() + "->");
            }
            System.out.println();
        }
    }
    
}
