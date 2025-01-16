package Main.Materia.Ejercicio_04_depth;

import Main.Materia.Models.Node;

public class Depth {
    public int maxDepth(Node root){
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight()));
    }
}
