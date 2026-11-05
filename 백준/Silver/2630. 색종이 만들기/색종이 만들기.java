import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int blue = 0;
    static int white = 0;
    public static void func(int row, int col, int size){
        //System.out.println("row: " + row + " col: " + col + " size: " + size);
        if (size == 1){
            if (graph[row-size][col-size] == 0){
                white += 1;
                //System.out.println("white increase");
            }
            else {
                blue += 1;
                //System.out.println("blue increase");
            }
            return;
        }

        int first_color = graph[row-size][col-size];
        boolean sameColor = true;
        for (int i = row-size; i < row; i++){
            for (int j = col-size; j < col; j++){
                if (first_color != graph[i][j]){
                    sameColor = false;
                }
            }
        }

        if (sameColor){
            if (first_color == 0){
                white += 1;
                //System.out.println("white increase");
            }
            else {
                blue += 1;
                //System.out.println("blue increase");
            }
            return;
        }

        size /= 2;
        func(row-size, col-size, size);
        func(row-size, col, size);
        func(row, col-size, size);
        func(row, col, size);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++){
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        func(N, N, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
