import java.io.*;

public class TestaPilhaCorreta{
    public static void main(String[] args) throws Exception{
        /* Define arquivo, leitores e referências às outras classes */
        File file = new File("/home/tlfarias/faku/ep2-aed/entradas/tarefas99000.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ReadFiles rf = new ReadFiles();
        PilhaCorreta<Integer> p = new PilhaCorreta<Integer>(8);
        long i = System.currentTimeMillis();
        
        /* Faz leitura linha a linha adicionando e removendo conforme condição imposta */
        String st;
        rf.cleanFile("SaidaPilhaCorreta.txt");
        while ((st = br.readLine()) != null){
            if(!(st.isEmpty())){
                p.enqueue(Integer.parseInt(st));
            }
            else {
                p.dequeue();
            }
        }

        br.close();

        /* Imprime o tempo e popula o arquivo com o resultado do array */
        System.out.println("Tempo em milissegundos da pilha correta: " + (System.currentTimeMillis() - i));
        rf.read(p.toString(), "SaidaPilhaCorreta.txt");
    }
}