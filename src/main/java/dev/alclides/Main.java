package dev.alclides;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

//TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        File arquivo = new File("palavras_5_letras.txt");

       List<String> palavras = Files.readAllLines(arquivo.toPath());


       for(String palavra : palavras) {
           if(palavra.contains("r")) {
               System.out.println(palavra);
           };
       }


        WebDriver driver = new ChromeDriver();

        driver.get("https://term.ooo/");

       driver.getTitle();

       driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        WebElement textbox = driver.findElement(By.id("help"));

        textbox.click();

        Actions actions = new Actions(driver);

        actions.sendKeys("Cafes").perform();
        actions.sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);

        Validator palavra1 = new Validator();
        palavra1.isValid(driver,0);

        Thread.sleep(2000);

        actions.sendKeys("Jogos").perform();
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);


        Validator palavra2 = new Validator();
        palavra2.isValid(driver,1);












    }
}