package dev.alclides;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Normalizer;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static dev.alclides.ListarPalavrasParaList.palavrasList;

public class Filtrador {

    private List<String> palavras;
    private List<String> ocorrencia1 = new ArrayList<>();

    public Filtrador(List<String> palavras) throws IOException {
        this.palavras = palavrasList();
    }

    public void filtrarPalavrasComStream(Path entrada, Path saida, int tamanho) throws IOException {

        List<String> palavrasFiltradas = Files.lines(entrada)
                .flatMap(linha -> Arrays.stream(linha.split("\\s+")))
                .map(palavra -> palavra.replaceAll("[^\\p{L}]", ""))
                .filter(palavra -> palavra.length() == tamanho)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        Files.write(saida, palavrasFiltradas);

    }


    public void tornarArray(Path entrada) throws IOException {
        List<String> palavras = Files.readAllLines(entrada);
    }


    public static <T> T getAleatorio(List<T> lista) {
        int index = ThreadLocalRandom.current().nextInt(lista.size());
        return lista.get(index);
    }


    public static LinkedHashMap<Integer,String> filtrarLetrasCertas(List<String> palavrasLinha) {

        LinkedHashMap<Integer, String> letrasCorretas = new LinkedHashMap<>();

        for (int i = 0; i < palavrasLinha.size(); i++) {
            if (palavrasLinha.get(i).contains("correta")) {
                int inicio = palavrasLinha.get(i).indexOf('"') + 1;
                int fim = palavrasLinha.get(i).lastIndexOf('"');
                String resultado = palavrasLinha.get(i).substring(inicio, fim);
                String resultadoNormali = Normalizer.normalize(resultado, Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", ""
                        );
                letrasCorretas.put(i, resultadoNormali);


            }

        }
        System.out.println("Corretas: " + letrasCorretas);
        return letrasCorretas;
    }

    public static LinkedHashMap<Integer,String> filtrarLetrasErradas(List<String> palavrasLinha) {

        LinkedHashMap<Integer, String> letrasErradas = new LinkedHashMap<>();

        for (int i = 0; i < palavrasLinha.size(); i++) {
            if (palavrasLinha.get(i).contains("errada") && !palavrasLinha.get(i).contains("local")) {
                int inicio = palavrasLinha.get(i).indexOf('"') + 1;
                int fim = palavrasLinha.get(i).lastIndexOf('"');
                String resultado = palavrasLinha.get(i).substring(inicio, fim);
                String resultadoNormali = Normalizer.normalize(resultado, Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", ""
                        );;
                letrasErradas.put(i, resultadoNormali);


            }
        }
        System.out.println("Erradas: " + letrasErradas);
        return letrasErradas;
    }

    public static LinkedHashMap<Integer, String> filtrarLetrasAmarelas(List<String> palavrasLinha){
        LinkedHashMap<Integer, String> letrasAmarelas = new LinkedHashMap<>();

        for(int i = 0; i < palavrasLinha.size(); i++){
        if(palavrasLinha.get(i).contains("local")){
        		int inicio = palavrasLinha.get(i).indexOf('"') + 1;
        		int fim = palavrasLinha.get(i).lastIndexOf('"');
        		String resultado = palavrasLinha.get(i).substring(inicio, fim);
                String resultadoNormali = Normalizer.normalize(resultado, Normalizer.Form.NFD)
                        .replaceAll("\\p{M}", ""
                        );;
        		letrasAmarelas.put(i, resultadoNormali);

        	}
        }
        System.out.println("Posição errada: " + letrasAmarelas);
        return letrasAmarelas;
    }
}





