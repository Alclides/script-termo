package dev.alclides;

import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static List<String> isValid(WebDriver driver, Integer linha) {

        WebElement board = driver.findElement(By.cssSelector("wc-board"));
        SearchContext boardShadow = (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", board);

        // 🔹 3. Pega a linha 0 (termo-row="0")
    WebElement row = boardShadow.findElement(By.cssSelector("wc-row[termo-row='"+linha+"']"));

        // 🔹 4. Entra no shadow root dessa linha
        SearchContext rowShadow = (SearchContext) ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].shadowRoot", row);

        // 🔹 5. Pega todas as letras da linha
        List<WebElement> letras = rowShadow.findElements(By.cssSelector("div.letter"));

        // 🔹 6. Lê o resultado de cada letra
        List<String> itens = new ArrayList<>();
        for (WebElement letra : letras) {
            String ariaLabel = letra.getAttribute("aria-label");
            itens.add(ariaLabel);
            System.out.println("→ " + ariaLabel);

        }
        System.out.println("------------------------------------------------");
        System.out.println("Resultado da linha: " + linha);

        return itens;

    }


}
