import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> measures = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int remainder = N % i;
            if (remainder == 0) {
                int quotient = N / i;
                measures.add(quotient);
            }
        }
        
        List<Integer> reverseMeasures = measures.stream()
                .sorted()
                .collect(Collectors.toList());

        if (reverseMeasures.size() >= K) {
            System.out.println(reverseMeasures.get(K - 1));
        } else {
            System.out.print(0);
        }
    }
}