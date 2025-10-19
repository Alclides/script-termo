package dev.alclides;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static dev.alclides.Filtrador.*;
import static dev.alclides.ListarPalavrasParaList.*;
import static dev.alclides.MotorTermo.iniciar;

//TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> palavras = palavrasList();

        WebDriver driver = new ChromeDriver();

        driver.get("https://term.ooo/");

       driver.getTitle();

       driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        WebElement textbox = driver.findElement(By.id("help"));

        textbox.click();

        Actions actions = new Actions(driver);

        iniciar(actions, driver, palavras);

    }
}