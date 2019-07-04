package Casos;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Google {

    static String url = "http://www.google.cl";
    static String busqueda = "tottus sucursales";


    public static void iniciaGoogle(WebDriver driver) throws InterruptedException {

        driver.get(url);

        driver.manage().window().maximize();

        Thread.sleep(3000);

        try{
            WebElement buscaTexto = driver.findElement(By.xpath("//input[contains(@name, 'q')]"));
            buscaTexto.sendKeys(busqueda);
            // presionar enter para aplcar la busqueda

            buscaTexto.sendKeys(Keys.ENTER);

        }catch (Exception e){
            System.out.println("Problemas al ingresar texto");
            System.out.println(e);
        }

        // seleccionar Tottus nataniel
        Thread.sleep(3000);

        try{
            WebElement nataniel = driver.findElement(By.xpath("(//div[contains(@class,'BSaJxc')])[2]"));
            nataniel.click();
        }catch (Exception e){
            System.out.println("Problemas al seleccionar tienda");
            System.out.println(e);
        }

    }
}
