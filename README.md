## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Ejercicio_01_insert  
Este código implementa una prueba de inserción para un árbol de búsqueda binario (BST). Se utiliza la clase Scanner para recibir la entrada del usuario correspondiente a los números del árbol. El método insert(int value) inserta un nuevo nodo en el árbol binario llamando al método privado insert(Node node, int value). Si el nodo actual es null, se crea un nuevo nodo con el valor especificado. Si el valor es menor que el nodo actual, se inserta en el subárbol izquierdo; si es mayor, se inserta en el subárbol derecho. De este modo, los valores se insertan en el orden correspondiente según la entrada del usuario.  

## Ejercicio_02_invert  
Este código toma un árbol binario ya generado como parámetro del método y lo invierte. En otras palabras, intercambia los nodos hijos izquierdo y derecho de cada árbol. El código utiliza la clase `Queue` (cola) para enumerar iterativamente los nodos. El método principal `invertTree(Node root)` comprueba si la raíz del árbol es `null` y, si no lo es, la añade a la cola. Después, si la cola no está vacía, recupera el nodo actual, intercambia sus nodos hijos izquierdo y derecho, y añade los nodos hijos no nulos a la cola para su posterior procesamiento. Por último, devuelve la nueva raíz del árbol invertido.  

## Ejercicio_03_listLevels  
Este código enumera los niveles del árbol binario. En otras palabras, agrupa los nodos de cada nivel del árbol. El código utiliza la clase `Queue` para recorrer el ancho de los nodos. El método principal `listLevels(Node root)` comprueba primero que root no sea `null`. Si no lo es, la raíz se añade a la cola. Si la cola no está vacía, se crea una lista del nivel actual, se procesan todos los nodos de ese nivel y sus nodos hijos se añaden a la cola. La función devuelve una lista de listas, donde cada lista interna representa un nivel del árbol. La función `printlistLevels(List<List<Node>> levels)` recibe lo que retorna el método `listLevels(Node root)` como parámetro e imprime los valores de los nodos de cada nivel, separando los nodos por una flecha (`->`) con una validación adicional para evitar imprimir una flecha después del último nodo de cada nivel, mejorando así la presentación visual para el usuario.  

## Ejercicio_04_depth  
Este código implementa la función `maxDepth`, que se utiliza para calcular la profundidad máxima de un árbol binario, es decir, el camino más largo desde las raíces hasta las hojas. Esta función es recursiva y comprueba si el nodo actual es `cero`, si es así devuelve 0, en caso contrario devuelve 1 más el valor máximo entre la profundidad máxima del subárbol izquierdo y la profundidad máxima del subárbol derecho. Esto asegura que se tiene en cuenta la profundidad máxima entre los dos subárboles añadiendo 1 al nodo actual.  

## Adicional  
Se creó el método `leerEnteroValido(String mensaje, boolean permitirNegativo)` en la clase `InsertBSTTest.java`. Este método se utiliza para validar el ingreso de datos al especificar el tamaño del arreglo para añadir los números al árbol, así como para ingresar cada número que se añadirá al árbol.
