package dev.alclides;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static dev.alclides.Filtrador.*;
import static dev.alclides.ListarPalavrasParaList.*;

public class MotorTermo {

    public static void iniciar(Actions actions, WebDriver driver, List<String> palavras) throws InterruptedException, IOException {

        for(int i = 0; i < 6; i++) {
            actions.sendKeys(getAleatorio(palavras)).perform();
            actions.sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);

            Validator palavra1 = new Validator();
            List<String> ocorrencia0 = palavra1.isValid(driver,i);
            Map olha = filtrarLetrasCertas(ocorrencia0);
            Map olhaIncorreta = filtrarLetrasErradas(ocorrencia0);
            Map olhaAmarela = filtrarLetrasAmarelas(ocorrencia0);

            orquestrarPalavrasPosicaoErrada(olhaAmarela, palavras);
            orquestrarPalavrasCertas(olha, palavras);
            orquestrarPalavrasErradas(olhaIncorreta, olha, olhaAmarela, palavras);
            System.out.println("QTD de palavras após a " + i + " linha: " + palavras.size());
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
            Thread.sleep(2000);

        }
    }
}
