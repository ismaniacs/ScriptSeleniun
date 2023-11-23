package seleniumScript;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestWebActivarCategoria {
	  ChromeDriver driver;
	    WebDriverWait wait;
	    String url = "http://127.0.0.1:8000/login";

	    @BeforeTest
	    public void invocarNavegador() {
	        System.setProperty("webdriver.chrome.driver",
	                "C:\\Users\\ismab\\Documents\\ues\\ciclo 8\\Diseño de sistemas ll\\prueba\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos
	        driver.manage().window().maximize();
	        driver.get(url);
	    }

	    @AfterTest
	    public void cerrarNavegador() {
	       // driver.quit();
	    }

	    @Test(priority = 0)
	    public void verificarLoginAseisNews() {
	        WebElement userId = driver.findElement(By.name("email"));
	        WebElement userPassword = driver.findElement(By.name("password"));
	        WebElement loginButton = driver.findElement(By.id("btnLogin"));

	        
	        //Usuarios Admin
	        userId.sendKeys("cm18064@ues.edu.sv");
	        userPassword.sendKeys("Minerva.23");
	        loginButton.click();
	        
	        //Usuario Docente
	        
	        // Esperar a que un elemento característico de la página principal esté presente
	        WebElement elementoPrincipal = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logo-sidebar1")));


	    }
	    
	    @Test(priority = 1)
	    public void ActivarCategoria() throws InterruptedException{
	        // Navegar a la página de creación de cursos
	        driver.get("http://127.0.0.1:8000/AdministrarCategorias/indexCategorias");
	        
	       
	        
	        //Esperar a que el botonActivar esté presente en la página
	        WebElement btnActivarCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnActivarCategoria")));
	        
	        btnActivarCategoria.click();
	        
	        Thread.sleep(5000);
	        
	        //Esperar a que el btnActivarEspecialidad esté presente en la página
	        WebElement btnActivarEspecialidad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnActivarEspecialidad")));
	        
	        btnActivarEspecialidad.click();
	        
	        Thread.sleep(5000);
	        
	        //Esperar a que el btnActivarEspecialidad esté presente en la página
	        WebElement btnConfirmar = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-confirm")));
	        
	        btnConfirmar.click();
	        
	        Thread.sleep(5000);
	       

	    }

}
