import java.util.List;

import Main.Ejercicio_03_listLevels.ListLevels;
import Main.Materia.Controllers.ArbolAVL;
import Main.Materia.Controllers.ArbolBinario;
import Main.Materia.Controllers.ArbolRecorrido;
import Main.Materia.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
       //runArbolBinario();
       //runEjercicio3();
       runArbolAVL();
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
        ListLevels levels = new ListLevels();

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
}
