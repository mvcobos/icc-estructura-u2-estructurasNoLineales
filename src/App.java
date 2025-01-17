import java.util.List;
import java.util.Scanner;

import Main.Materia.Ejercicio_01_insert.InsertBSTTest;
import Main.Materia.Ejercicio_02_invert.InvertBinaryTree;
import Main.Materia.Ejercicio_03_listLeves.ListLevels;
import Main.Materia.Ejercicio_04_depth.Depth;
import Main.Ejercicio_03_listLevels.ListLevelsEJ1;
import Main.Materia.Controllers.*;

import Main.Materia.Models.Node;
import Main.Materia.Models.NodeG;

public class App {
    public static void main(String[] args) throws Exception {
       //runArbolBinario();
       //runEjercicio3();
       //runArbolAVL();
       //paEstructurasNoLinealesArboles();
       runGraph();

    }

    public static void runArbolBinario (){
        ArbolBinario arbolBinario = new ArbolBinario();
        int [] valores = {40, 20, 60, 10, 30, 50, 70, 5, 15, 55};

        for (int i = 0; i < valores.length; i++){
            arbolBinario.insert(valores[i]);
        }
        
        arbolBinario.printTree();

        ArbolRecorrido aR = new ArbolRecorrido();
        System.out.println("\nRecorrido preOrder Iterativo ");
        aR.preOrderIterativo(arbolBinario.getRoot());

        System.out.println("\nRecorrido preOrder Recursivo");
        aR.preOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nRecorrido posOrder");
        aR.posOrderRecursivo(arbolBinario.getRoot());

        System.out.println("\nRecorrido inOrder");
        aR.inOrderRecursivo(arbolBinario.getRoot());


    }

    public static void runEjercicio3(){
        ArbolBinario arbolBinario = new ArbolBinario();
        ListLevelsEJ1 levels = new ListLevelsEJ1();

        int [] valores = {4, 2, 1, 3, 7, 6, 9};

        for (int i = 0; i < valores.length; i++){
            arbolBinario.insert(valores[i]);
        }

        arbolBinario.printTree();
        List<List<Node>> lista = levels.listLeves(arbolBinario.getRoot());
        //IMPRIMIR LA LISTA DE LISTAS RESULTANTE
        levels.printLevels(lista);
    }

     public static void runArbolAVL() {
        ArbolAVL arbolAVL = new ArbolAVL();

        int[] values = {10, 20, 15, 24, 9, 8, 21, 23, 50, 25};

        for(int i = 0; i < values.length; i++){
            arbolAVL.insert(values[i]);
            arbolAVL.printTree();
        }

        arbolAVL.printTree();
        
    }

    public static void paEstructurasNoLinealesArboles(){
        Scanner scanner = new Scanner(System.in);

        InsertBSTTest ej1 = new InsertBSTTest();
        InvertBinaryTree ej2 = new InvertBinaryTree();
        ListLevels ej3 = new ListLevels();
        Depth ej4 = new Depth();
        
        int tamanio = ej1.leerEnteroValido("Ingrese la cantidad de numeros del arbol", false);
        int [] valores = new int[tamanio];
        for (int i = 0; i < tamanio; i++){
            valores[i] = ej1.leerEnteroValido("Ingrese el valor #" + i, true);
        }


        System.out.println("Ejercicio_01_insert:");
        for (int i = 0; i < valores.length; i++){
            ej1.insert(valores[i]);
        }
        List<List<Node>> lista1 = ej3.listLevels(ej1.getRoot());
        ej3.printlistLevels(lista1);


        System.out.println("Ejercicio_02_invert:");
        Node arbolInvertido = ej2.invertTree(ej1.getRoot()); //metodo de invertir del ejercicio 2
        List<List<Node>> lista2 = ej3.listLevels(arbolInvertido); //convertirlo a lista para reusar la impresion del primer ejercicio
        ej3.printlistLevels(lista2); //impresion del primer ejercicio

        
        System.out.println("Ejercicio_03_listLeves:");
        ej3.printlistLevels(lista1);

        System.out.println("Ejercicio_04_depth:");
        int profundidad = ej4.maxDepth(ej1.getRoot());
        System.out.println("La profundidad del arbol es: " + profundidad);

        scanner.close();
    }

    public static void runGraph(){
        Graph grafo = new Graph();
        NodeG cinco = grafo.addNode(5);
        NodeG siete = grafo.addNode(7);
        NodeG nueve = grafo.addNode(9);
        NodeG once = grafo.addNode(11);
        NodeG tres = grafo.addNode(3);

        grafo.addEdge(cinco, siete);
        grafo.addEdge(cinco, tres);
        grafo.addEdge(siete, nueve);
        grafo.addEdge(nueve, cinco);
        grafo.addEdge(nueve, tres);
        grafo.addEdge(tres, once);

        grafo.printGraph();

    }
}
