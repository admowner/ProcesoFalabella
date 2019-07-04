package EjecucionCaso;

import Casos.Google;
import Casos.RecetasYMas;
import Casos.TottusRecetas;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TestSuite {
    WebDriver driver;
    @Before
    public void creaConex(){
        driver = utils.Conexion.creaConexion("chrome");

    }
    @Test
    public void buscaReceta() throws InterruptedException {
        Google.iniciaGoogle(driver);
        RecetasYMas.seleccionRecetas(driver);
        TottusRecetas.seleccionDificultad(driver);
        TottusRecetas.buscaReceta(driver);
        TottusRecetas.seleccionImagen(driver);
        TottusRecetas.validaIngredientes(driver);

    }
    @After
    public void cierraConex(){
        driver.quit();

    }
}
