package dev.alclides;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Filtrador {

    public void filtrarPalavrasComStream(Path entrada, Path saida, int tamanho)
            throws IOException {

        // Ler e processar linha por linha
        List<String> palavrasFiltradas = Files.lines(entrada)
                .flatMap(linha -> Arrays.stream(linha.split("\\s+")))
                .map(palavra -> palavra.replaceAll("[^a-zA-ZÀ-ÿ]", ""))
                .filter(palavra -> palavra.length() == tamanho)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        // Escrever resultado
        Files.write(saida, palavrasFiltradas);

        System.out.println("Total de palavras com " + tamanho + " letras: " +
                palavrasFiltradas.size());
    }


    public void tornarArray(Path entrada) throws IOException {
        List<String> palavras = Files.readAllLines(entrada);
    }


    public static <T> T getAleatorio(List<T> lista) {
        int index = ThreadLocalRandom.current().nextInt(lista.size());
        return lista.get(index);
    }




}
