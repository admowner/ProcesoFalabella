package Casos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class TottusRecetas {
    static String ingrediente1 = "canela";
    static String ingrediente2 = "azúcar rubia";
    static String ingre1 = "";
    static String ingre2 = "";
    static WebElement ingredientes1;
    static WebElement ingredientes2;

    public static void seleccionDificultad(WebDriver driver) throws InterruptedException {
        cambioPestana(driver);

        Thread.sleep(5000);

        try{
            WebElement selecDific = driver.findElement(By.xpath("(//button[contains(@value, '3')])[3]"));

            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", selecDific);
        }catch (Exception e){
            System.out.println("Problemas al seleccionar dificultad");
            System.out.println(e);
        }

    }
    public static void buscaReceta(WebDriver driver) throws InterruptedException {

        Thread.sleep(5000);

        try{
            WebElement dificAlta = driver.findElement(By.xpath("//input[contains(@id, 'search')]"));
            dificAlta.sendKeys("corona");
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println("Problemas al buscar receta");
            System.out.println(e);
        }

    }

    public static void seleccionImagen(WebDriver driver){
        try{
            WebElement selecImag = driver.findElement(By.xpath("//h3[contains(text(), 'Corona de rollitos')]"));
            selecImag.click();

        }catch (Exception e){
            System.out.println("Problemas al seleccionar la imagen");
            System.out.println(e);
        }
    }

    public  static  void validaIngredientes(WebDriver driver){
        try{
            Thread.sleep(4000);
            ingredientes1 = driver.findElement(By.xpath("(//p[contains(text(),'15g canela en polvo')])[2]/text()"));
            ingre1 = ingredientes1.getText();
            System.out.println(ingre1);
            System.out.println("El valor es : "+ingredientes1.getText());



        }catch (Exception e){
            System.out.println("No fue posible encontrar elemento para extraer informacion");
            System.out.println(e);
        }
        try{
            ingredientes2 = driver.findElement(By.xpath("(//p[contains(text(),'125g azúcar rubia')])[2]/text()"));
            ingre2 = ingredientes2.getText();
            System.out.println(ingre2);


        }catch (Exception e){
            System.out.println("No fue posible encontrar elemento para extraer informacion");
            System.out.println(e);
        }

        // validacion
        if(ingredientes1.isDisplayed() && ingredientes2.isDisplayed()){
            System.out.println("Esta correcto");
        }else {
            System.out.println("NO se encuentran los ingredientes necesarios");
        }
    }

    public static void cambioPestana(WebDriver driver){
        String pestAntigua = driver.getWindowHandle();

        ArrayList<String> pestNueva = new ArrayList<String>(driver.getWindowHandles());
        int cantidadPesta = pestNueva.size();
        System.out.println(cantidadPesta);
        pestNueva.remove(pestAntigua);
        driver.switchTo().window(pestNueva.get(0)).toString();

        System.out.println(driver.getTitle());

    }

}

