package dev.alclides;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class ListarPalavrasParaList {

    public static List<String> palavrasList() throws IOException {
        File arquivo = new File("palavras_sem_acentos.txt");
        List<String> palavras = Files.lines(arquivo.toPath())
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .distinct()
                .collect(Collectors.toList());
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

    public static void orquestrarPalavrasErradas(Map palavrasErradas, Map palavrasCertas, Map palavrasAmarelas, List<String> palavras) throws IOException {
        Set<String> letrasPresentes = new HashSet<>();

        for (Object valor : palavrasCertas.values()) {
            if (valor != null) {
                letrasPresentes.add(((String) valor).toLowerCase());
            }
        }

        for (Object valor : palavrasAmarelas.values()) {
            if (valor != null) {
                letrasPresentes.add(((String) valor).toLowerCase());
            }
        }

        for (int i = 0; i < 5; i++) {
            if (palavrasErradas.get(i) == null) {
                continue;
            }
            String letraErrada = ((String) palavrasErradas.get(i)).toLowerCase();

            if (!letrasPresentes.contains(letraErrada)) {
                palavras.removeIf(p -> p.toLowerCase().contains(letraErrada));
            }
        }

    }

    public static void orquestrarPalavrasPosicaoErrada(Map palavrasAmarelas, List<String> palavras) {

        for (int i = 0; i < 5; i++) {
            final int indice = i;
            if (palavrasAmarelas.get(indice) == null) {
                continue;
            }
            String letraAmarela = (String) palavrasAmarelas.get(indice);
            palavras.removeIf(p ->
                    !p.toLowerCase().contains(letraAmarela.toLowerCase()) || // Não contém a letra
                            (p.length() > indice && String.valueOf(p.charAt(indice)).equalsIgnoreCase(letraAmarela)) // Ou tem na posição errada
            );



        }
    }

}