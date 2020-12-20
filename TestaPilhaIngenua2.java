import java.io.*;

public class TestaPilhaIngenua2{

    public static void main(String[] args) throws Exception{
        /* Define arquivo, leitores e referências às outras classes */
        File file = new File("/home/tlfarias/faku/ep2-aed/entradas/tarefas70000.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ReadFiles rf = new ReadFiles();
        PilhaIngenua2 p = new PilhaIngenua2();
        long i = System.currentTimeMillis();
        
        /* Faz leitura linha a linha adicionando e removendo conforme condição imposta */
        String st;
        rf.cleanFile("SaidaPilhaIngenua.txt");
        while ((st = br.readLine()) != null){            
            if(!(st.isEmpty())){
                p.add(Integer.parseInt(st));
            }
            else {
                p.remove();                             
            }            
        }
        br.close();

        /* Imprime o tempo e popula o arquivo com o resultado do array */
        System.out.println("Tempo em milissegundos da pilha ingênua: " + (System.currentTimeMillis() - i));
        for(int j = p.pilha.length - 1; j >= 0; j--){
            if(p.pilha[j] != null) rf.read(Integer.toString(p.pilha[j]), "SaidaPilhaIngenua.txt");
        }
    }
    
}