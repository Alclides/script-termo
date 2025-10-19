package dev.alclides;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import static dev.alclides.ListarPalavrasParaList.*;
import static dev.alclides.MotorTermo.iniciar;

//TIP Para <b>executar</b> o código, pressione <shortcut actionId="Run"/> ou
// clique no ícone <icon src="AllIcons.Actions.Execute"/> no gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> palavras = palavrasList();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().setPosition(new Point(950,0));

        driver.get("https://term.ooo/");



       driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        WebElement textbox = driver.findElement(By.id("help"));

        textbox.click();

        Actions actions = new Actions(driver);

        System.out.println("Palavras na Lista Inicial: " + palavras.size());

        iniciar(actions, driver, palavras);

    }
}