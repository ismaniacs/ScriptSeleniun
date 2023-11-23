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

public class TestWebCategorias {
	
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
    public void crearCategoria() throws InterruptedException {
        // Navegar a la página de creación de cursos
        driver.get("http://127.0.0.1:8000/AdministrarCategorias/indexCategorias");

        // Esperar a que el elemento "crearBoton" esté presente en la página
        WebElement crearBoton = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("crearBoton")));

        // Rellenar el formulario de creación de cursos
        crearBoton.click();

        // Esperar a que el inputCrearCategoria-Nombre "crearBoton" esté presente en la página
        WebElement inputCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputCrearCategoria-Nombre")));
        
        // Rellenamos el formulario
        driver.findElement(By.id("inputCrearCategoria-Nombre")).sendKeys("Categoria Documentacion");
        
        Thread.sleep(3000);
        
        WebElement crearCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnCrearCategoria")));
        
        crearCategoria.click();
        
        WebElement okCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-confirm")));
        
        Thread.sleep(3000);
        
        okCategoria.click();
        

    }
    
   /* @Test(priority = 1)
    public void DesactivarCategoria() throws InterruptedException{
        // Navegar a la página de creación de cursos
        driver.get("http://127.0.0.1:8000/AdministrarCategorias/indexCategorias");
        
        //Esperar a que el botonEliminar esté presente en la página
        WebElement btnDesactivar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("botonEliminar")));
        
        btnDesactivar.click();
        
        Thread.sleep(5000);
        
        //Esperar a que el botonEliminar esté presente en la página
        WebElement btnDesactivarCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnDesactivarCategoria")));
        
        btnDesactivarCategoria.click();
        
        Thread.sleep(5000);
        
        //Esperar a que el botonEliminar esté presente en la página
        WebElement btnAceptar = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-confirm")));
        
        btnAceptar.click();
        
        Thread.sleep(5000);
        
        //Esperar a que el botonActivar esté presente en la página
        WebElement btnActivarCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnActivarCategoria")));
        
        btnActivarCategoria.click();
        
        Thread.sleep(5000);
        
        //Esperar a que el btnActivarEspecialidad esté presente en la página
        WebElement btnActivarEspecialidad = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnActivarEspecialidad")));
        
        btnActivarEspecialidad.click();
        
        Thread.sleep(5000);
       

    }*/
    
    /*@Test(priority = 1)
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
       

    }*/
    
  /*  @Test(priority = 1)
    public void EditarCategoria() throws InterruptedException {
        // Navegar a la página de creación de cursos
        driver.get("http://127.0.0.1:8000/AdministrarCategorias/indexCategorias");

        // Esperar a que el elemento "crearBoton" esté presente en la página
        WebElement btnEditarCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("btnEditarCategoria")));

        // Rellenar el formulario de Editar de cursos
        btnEditarCategoria.click();
        
        
        
        Thread.sleep(3000);
        
        WebElement inputCategoria = driver.findElement(By.name("inputEditarCategoria"));
        
        inputCategoria.clear();
        
        // Rellenamos el formulario
        driver.findElement(By.name("inputEditarCategoria")).sendKeys("editando Categoria");
        
        Thread.sleep(3000);
        
        WebElement btnEditar = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnEditar")));
        
        btnEditar.click();
        
        WebElement okCategoria = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("swal2-confirm")));
        
        Thread.sleep(3000);
        
        okCategoria.click();
        


    }*/
    
   /* @Test(priority = 1)
    public void BuscarCategoria() throws InterruptedException {
        // Navegar a la página de creación de cursos
        driver.get("http://127.0.0.1:8000/AdministrarCategorias/indexCategorias");

        // Esperar a que el elemento "crearBoton" esté presente en la página
        WebElement inputBusqueda = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("inputBusqueda")));
        
        Thread.sleep(3000);
        
        
        inputBusqueda.clear();
        
        // Rellenamos el formulario
        driver.findElement(By.id("inputBusqueda")).sendKeys("prueba");
        
        Thread.sleep(3000);  


    }*/
}
