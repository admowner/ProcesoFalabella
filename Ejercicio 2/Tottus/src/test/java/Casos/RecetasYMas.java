package Casos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecetasYMas {

    public static void seleccionRecetas(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        try{
            WebElement seleccionReceta = driver.findElement(By.xpath("(//a[contains(@href,'http://www.tottusrecetas.cl/')])[1]"));
            seleccionReceta.click();
        }
        catch (Exception e){
            System.out.println("Problemas al seleccionar receta");
            System.out.println(e);
        }

    }
}
