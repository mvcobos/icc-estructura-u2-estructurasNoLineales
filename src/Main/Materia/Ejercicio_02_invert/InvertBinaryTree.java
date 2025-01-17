package Main.Materia.Ejercicio_02_invert;

import java.util.LinkedList;
import java.util.Queue;

import Main.Materia.Models.Node;

public class InvertBinaryTree {

    public Node invertTree(Node root) {
        if (root == null) {
            return null;
        }

        // Usamos una cola para el recorrido iterativo
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Intercambiar los hijos izquierdo y derecho
            Node temp = current.getLeft();
            current.setLeft(current.getRight());
            current.setRight(temp);

            // Agregar los hijos al recorrido si no son nulos
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }

        return root; // Devolver la nueva raíz
    }

}
