package Main.Materia.Controllers;

import Main.Materia.Models.Node;

public class ArbolAVL {

    private Node root;

    public void insert(int value){
        System.out.println("*Nodo a insertar: " + value);
        //printTree();
        root = insert(root, value);
    }

    private Node insert(Node nodo, int value) {
        
        if(nodo == null){
            Node newNode = new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado: " + newNode.getValue() + ", Balance: " + getBalance(nodo));
            
            return newNode;
        }
        

        if(value < nodo.getValue()){
            nodo.setLeft(insert(nodo.getLeft(), value));
        }
        else if(value > nodo.getValue()){
            nodo.setRight(insert(nodo.getRight(), value));
            
        } else {
            return nodo;
        }

        nodo.setHeight(1 + 
                    Math.max(
                            height(nodo.getLeft()), 
                            height(nodo.getRight())));
        //Obtener el balance o factor de equilibrio del nodo ancestro
        int balance = getBalance(nodo);

        //Caso Izquierda - Izquierda
        if(balance > 1 && value < nodo.getLeft().getValue()){
            return rightRotate(nodo);
        }

        System.out.println("-Nodo actual: " + nodo.getValue());
        System.out.println("    Altura del nodo: " + nodo.getValue() + " es = " + nodo.getHeight());
        System.out.println("    Equilibrio del nodo: " + nodo.getValue() + " = " + getBalance(nodo));
        
        

        //Caso Derecha - Derecha
        if(balance < -1 && value > nodo.getRight().getValue()){
            return leftRotate(nodo);
        }

        //Caso Izquierda - Derecha
        if(balance > 1 && value > nodo.getLeft().getValue()){
            nodo.setLeft(leftRotate(nodo.getLeft()));
            System.out.println("Izquierda-Derecha a nodo: " + nodo.getValue());
            return rightRotate(nodo);
        }
        
        //Caso Derecha - Izquierda
        if(balance <- 1 && value < nodo.getRight().getValue()){
            nodo.setRight(rightRotate(nodo.getRight()));
            System.out.println("Derecha-Izquierda a nodo: " + nodo.getValue());
            return leftRotate(nodo);
        }


        
        //Devolvemos el nodo sin cambios
        return nodo;
    }
            
    private Node rightRotate(Node y) {
        Node x = y.getLeft();
        Node temp = x.getRight();
        
        printTree();

        System.out.println("Rotamos Der en nodo: " + y.getValue() + ", Balance: " + getBalance(y));

        //Realizamos la rotacion
        x.setRight(y);
        y.setLeft(temp);

        //Actualizar las alturas
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);

        System.out.println("Nueva raiz despues de rotacion der: " + x.getValue());

        return x;
    }

    //Rotacion a la izquierda
    private Node leftRotate(Node x) {
        Node y = x.getRight();
        Node temp = x.getLeft();

        printTree();
        
        //Imprimir informacion antes de la rotacion
        System.out.println("Rotamos izquierda el nodo: " + x.getValue() + " Balance:" + getBalance(x));

        //Realizamos la rotacion
        y.setLeft(x);
        x.setRight(temp);

        //Actualizar las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);

        System.out.println("Nueva raiz despues de rotacion izq: " + y.getValue());

        return y;
    }
            
    private int getBalance(Node node) {
        if(node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }


    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.getHeight();
    }

    public void printTree(){
        printTree(root, " ", true);
    }

    public void printTree(Node node, String prefix, boolean isLeft){
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
            if (node.getLeft() != null || node.getRight() != null) {
                if (node.getLeft() != null) {
                    printTree(node.getLeft(), prefix + (isLeft ? "├  " : "   "),true );
                }else{
                    System.out.println( prefix + (isLeft ? "├  " : "   ") + "──null" );
                }
                if (node.getRight() != null) {
                    printTree(node.getRight(), prefix + (isLeft ? "├  " : "   "),false );            
                }else{
                    System.out.println( prefix + (isLeft ? "├  " : "   ") + "──null");
                }
            }
        }
        
    }

}

