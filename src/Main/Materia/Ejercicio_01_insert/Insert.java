package Main.Materia.Ejercicio_01_insert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Main.Materia.Models.Node;

public class Insert {
    private Node root;

    public void insert(int value){
        root = insert(root, value);
    }

    private Node insert(Node node, int value){
        if (node == null)
            return new Node(value);
        if(value < node.getValue()){
            node.setLeft(insert(node.getLeft(), value));
        } else if (value > node.getValue()){
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

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

    public void printLeves(List<List<Node>> levels) {
        if (levels == null || levels.isEmpty()) {
            System.out.println("Árbol vacío.");
            return;
        }
    
        int mLevels = levels.size();
        int maxAncho = (int) Math.pow(2, mLevels) - 1; 
    
        for (int i = 0; i < levels.size(); i++) {
            List<Node> nivel = levels.get(i);

            int espPrev = (maxAncho / (int) Math.pow(2, i + 1)); //Math.pow es **
            printEspacio(espPrev);
    
            for (int j = 0; j < nivel.size(); j++) {
                System.out.print(nivel.get(j).getValue());

                if (j < nivel.size() - 1) {
                    int espIntermedios = (maxAncho / (int) Math.pow(2, i));
                    printEspacio(espIntermedios);
                }
            }
    
            System.out.println();
        }
    }
    
    private void printEspacio(int cont) {
        for (int i = 0; i < cont; i++) {
            System.out.print(" ");
        }
    }
    
}
