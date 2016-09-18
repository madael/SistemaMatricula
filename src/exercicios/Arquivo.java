package exercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author aluno
 */
public class Arquivo {

    public static void escrever(String texto, String caminho, boolean append) {
        FileWriter fileWriter;
        File arquivo = new File(caminho);
        if (arquivo.isFile()) {
            try {
                fileWriter = new FileWriter(arquivo, append);
                fileWriter.write(texto);
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.toString());
            }
        }else{
            try {
                fileWriter = new FileWriter(arquivo);
                fileWriter.write(texto);
                fileWriter.flush();
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.toString());
            }
        }
        
    }
    
    public static String ler(String caminho){
        File file = new File(caminho);
        String linha, linhas="";
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            linha = bufferedReader.readLine();
            while(linha!=null){
                linhas += linha+"\n";                
                linha = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
        return linhas;
    }
}
