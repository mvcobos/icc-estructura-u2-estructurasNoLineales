package Main.Materia.Ejercicio_01_insert;

import java.util.Scanner;

import Main.Materia.Models.Node;

public class InsertBSTTest {
    Scanner scanner = new Scanner(System.in);
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

    public Node getRoot() {
        return root;
    }   

     // Validar los valores del tamaño y el arreglo
    public int leerEnteroValido(String mensaje, boolean permitirNegativo) {
        int numero;
        do {
            System.out.println(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un entero válido"); //en el caso de que permitirNegativo sea true se ejcutaria solo una vez, por eso hasNextInt esta dentro de un bucle
                scanner.next();
            }
            numero = scanner.nextInt();
            if (!permitirNegativo && numero <= 0) {
                System.out.println("Debe ser un entero mayor a 0");
            }
        } while (!permitirNegativo && numero <= 0);// A pesar de que permitirNegativo sea true, el bucle se ejecutara una vez
        return numero;
    }

}
