import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner fl = new Scanner(System.in);
        BufferedReader br = null;

        System.out.println("Escolha um dos seguintes arquivos teste para fazer as operaçoes");
        System.out.println("1.pcv4.txt\n2.pcv10.txt\n3.pcv50.txt\n4.pcv177.txt");
        int s = fl.nextInt();

        switch (s) {
            case (1):
                br = new BufferedReader(new FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv4.txt"));
                break;
            case (2):
                br = new BufferedReader(new FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv10.txt"));
                break;
            case (3):
                br = new BufferedReader(new FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv50.txt"));
                break;
            case (4):
                br = new BufferedReader(new FileReader("C:/Users/lande/Desktop/LP2/Grafo/src/pcv177.txt"));
                break;
            default:
                System.out.println("Voce selecionou um valor invalido.");
                return;

        }

        int n = Integer.parseInt(br.readLine());
        int v = 0;
        int t = 0;

        grafo grafo = new grafo(n);

        int l = 0;
        String line;
        while ((line = br.readLine()) != null) {
            // String Str_nun = line.trim();
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

        grafo.BFS(0, 3);
        grafo.printMatriz();

        System.out.println();
        System.out.println("Este grafo tem " + grafo.getNun_vertices() + " Vertices");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println(
                "Escolha os vertices para que seja feita a pesquisa (Os vertices estao enumerados apartir do numero 1):");

        System.out.println("Vertice inicial:");
        v = sc.nextInt();
        System.out.println("Vertice final:");
        t = sc.nextInt();

        sc.close();

        grafo.BFS((v - 1), (t - 1));

    }

}
