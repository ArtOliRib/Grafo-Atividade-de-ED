import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner fl = new Scanner(System.in);
        BufferedReader br = null;

        String file = args[0];

        br = new BufferedReader(new FileReader(file));

        /*
         * System.out.
         * println("Escolha um dos seguintes arquivos teste para fazer as operaçoes");
         * System.out.println("1.pcv4.txt\n2.pcv10.txt\n3.pcv50.txt\n4.pcv177.txt");
         * int s = fl.nextInt();
         * 
         * switch (s) { // switch-case para a escolha do arquivo de teste.
         * case (1):
         * br = new BufferedReader(new
         * FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv4.txt"));
         * break;
         * case (2):
         * br = new BufferedReader(new
         * FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv10.txt"));
         * break;
         * case (3):
         * br = new BufferedReader(new
         * FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv50.txt"));
         * break;
         * case (4):
         * br = new BufferedReader(new
         * FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv177.txt"));
         * break;
         * default:
         * System.out.println("Voce selecionou um valor invalido.");
         * 
         * return;
         * 
         * }
         */

        int n = Integer.parseInt(br.readLine());

        grafo grafo = new grafo(n); // iniciação do objeto "grafo" a partir da quantidade de vertices do grafo do
                                    // arquivo.

        // Bloco que passa a matriz de adjacencias do arquivo para o objeto "grafo" e
        // tambem forma a lista de adjacencias do grafo do arquivo.
        int l = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] numeros = line.split("\\s+");
            int c = 0;
            for (String numStr : numeros) {
                if (c == grafo.getNun_vertices()) {
                    break;
                }
                int num = Integer.parseInt(numStr);
                grafo.setMatrixValue(l, c, num);
                if (num > 0) {
                    grafo.addVizinho(l, c);
                }
                c++;
            }
            l++;
        }
        br.close();

        grafo.printMatriz(); // imprime a matriz que foi passada para o objeto.

        System.out.println();
        System.out.println("Este grafo tem " + grafo.getNun_vertices() + " Vertices"); // retorna quantos vertices
                                                                                       // tem o
                                                                                       // grafo passado para o
                                                                                       // objeto.
        System.out.println();

        Scanner sc = new Scanner(System.in);

        // Escolha de um dos dois tipos de pesquisa.
        System.out.println(
                "Escolha que tipo de operação voce deseja fazer:\n1.Caminho entre dois vertices.\n2.pesquisa em profundidade");
        int j = sc.nextInt();

        switch (j) {
            case 1:
                System.out.println();
                System.out.println(
                        "Escolha os vertices para que seja feita a pesquisa em largura (Os vertices estao enumerados apartir do numero 1):");

                System.out.println("Vertice inicial:");
                int v = sc.nextInt();
                System.out.println("Vertice final:");
                int t = sc.nextInt();
                System.out.println();
                grafo.BFS((v - 1), (t - 1));// Chamada do metodo que faz a pesquisa em largura.
                return;
            case 2:
                System.out.println();
                System.out.println(
                        "Escolha o vertice inicial para que seja feita a pesquisa em profundodade (Os vertices estao enumerados apartir do numero 1)");
                System.out.println("Vertice inicial:");
                int z = sc.nextInt();
                grafo.DFS(z - 1);// Chamada do metodo que faz a pesquisa em profundidade.
                return;

        }

    }

}
