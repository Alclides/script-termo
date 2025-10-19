package dev.alclides;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListarPalavrasParaList {

    public static List<String> palavrasList() throws IOException {
        File arquivo = new File("palavras_sem_acentos.txt");
        List<String> palavras = Files.readAllLines(arquivo.toPath());
        return palavras;

    }

    public static void orquestrarPalavrasCertas(Map palavrasCertas, List<String> palavras) throws IOException {

        for (int i = 0; i < 5; i++) {
            final int indice = i;
            if (palavrasCertas.get(indice) == null) {
                continue;
            }
            String letraCorreta = (String) palavrasCertas.get(indice);
            palavras.removeIf(p -> p.length() <= indice || !String.valueOf(p.charAt(indice)).equalsIgnoreCase(letraCorreta));

        }

    }

    public static void orquestrarPalavrasErradas(Map palavrasErradas, List<String> palavras) throws IOException {
        for (int i = 0; i < 5; i++) {
            final int indice = i;
            if (palavrasErradas.get(indice) == null) {
                continue;
            }
            String letraErrada = (String) palavrasErradas.get(indice);
            // Remove apenas palavras que têm a letra errada NA POSIÇÃO ESPECÍFICA
            palavras.removeIf(p -> p.toLowerCase().contains(letraErrada.toLowerCase()));

        }
    }

    public static void orquestrarPalavrasPosicaoErrada(Map palavrasAmarelas, List<String> palavras) {

        for (int i = 0; i < 5; i++) {
            final int indice = i;
            if (palavrasAmarelas.get(indice) == null) {
                continue;
            }
            String letraCorreta = (String) palavrasAmarelas.get(indice);
            palavras.removeIf(p -> p.length() <= indice ||
                    String.valueOf(p.charAt(indice)).equalsIgnoreCase(letraCorreta));


        }
    }

}