import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class grafo {
    private int nun_vertices;
    private int[][] matriz_adjacente;
    private List<List<Integer>> lista_adjacente;

    public grafo(int nun) {
        this.nun_vertices = nun;
        this.matriz_adjacente = new int[nun][nun];
        this.lista_adjacente = new LinkedList<>();

        for (int i = 0; i < nun; ++i) {
            lista_adjacente.add(new LinkedList<>());
        }
    }

    public int getNun_vertices() {
        return nun_vertices;
    }

    public void setMatrixValue(int linha, int coluna, int valor) {
        if (linha >= 0 && linha < nun_vertices && coluna >= 0 && coluna < nun_vertices) {
            matriz_adjacente[linha][coluna] = valor;
        } else {
            throw new IllegalArgumentException("Linha ou coluna fora dos limites da matriz.");
        }
    }

    public void addVizinho(int verticeOrigem, int verticeDestino) {
        if (verticeOrigem >= 0 && verticeOrigem < nun_vertices && verticeDestino >= 0
                && verticeDestino < nun_vertices) {
            lista_adjacente.get(verticeOrigem).add(verticeDestino);
        } else {
            throw new IllegalArgumentException("Vértice de origem ou destino fora dos limites do grafo.");
        }
    }

    public void printMatriz() {
        System.out.println();
        System.out.println();
        System.out.println("A matriz de adjacencias do arquivo carregado é:");
        for (int i = 0; i < nun_vertices; i++) {
            for (int j = 0; j < nun_vertices; j++) {
                System.out.print(matriz_adjacente[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void BFS(int s, int t) {
        boolean visitado[] = new boolean[nun_vertices];
        int parente[] = new int[nun_vertices];
        Arrays.fill(parente, -1);
        parente[s] = -1;

        Queue<Integer> fila = new LinkedList<>();
        visitado[s] = true;
        fila.add(s);

        while (!fila.isEmpty()) {
            int u = fila.poll();

            for (int v : lista_adjacente.get(u)) {
                if (!visitado[v]) {
                    visitado[v] = true;
                    parente[v] = u;
                    fila.add(v);
                }
            }
        }

        if (!visitado[t]) {
            System.out.println("Não há caminho entre os vértices.");
        } else {
            List<Integer> caminho = new ArrayList<>();
            int current = t;
            while (current != -1) {
                caminho.add(current);
                current = parente[current];
            }
            Collections.reverse(caminho);
            System.out.print("Caminho entre " + (s + 1) + " e " + (t + 1) + " é: ");
            System.out.print("[");
            System.out.print(" ");
            for (int v : caminho) {
                System.out.print((v + 1) + " ");
            }

            System.out.print("]");
        }
    }
}
