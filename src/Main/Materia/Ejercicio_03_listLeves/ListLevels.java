package Main.Materia.Ejercicio_03_listLeves;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Main.Materia.Models.Node;

public class ListLevels {

    public List<List<Node>> listLevels(Node root){
        if (root == null) {
            return new ArrayList<>(); 
        }
        List<List<Node>> result = new ArrayList<>();
        Queue<Node> cola = new LinkedList<>();
        cola.add(root);

        while (!cola.isEmpty()) {
            List<Node> nivel = new ArrayList<>();
            int size = cola.size();

            for (int i = 0; i < size; i++) {
                
                Node nodoActual = cola.poll();
                nivel.add(nodoActual);

                if (nodoActual.getLeft() != null) {
                    cola.add(nodoActual.getLeft());
                }

                if (nodoActual.getRight() != null) {
                    cola.add(nodoActual.getRight());
                }
            }

            result.add(nivel);
        }

        return result;


    }

    public void printlistLevels(List<List<Node>> levels) {
        if (levels == null || levels.isEmpty()) {
            System.out.println("Árbol vacío.");
            return;
        }
        for (int i = 0; i < levels.size(); i++) {
            List<Node> level = levels.get(i);
            for (int j = 0; j < level.size(); j++) {
                System.out.print(level.get(j).getValue());
                if (j < level.size() - 1) { //evita que añada "->" al final
                    System.out.print(" -> ");
                }
            }
    
            System.out.println(); // println para saltar de linea cada nivel
        }
    }
    
}
