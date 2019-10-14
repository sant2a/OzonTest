package firstTest;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest extends WebDriverSettings {

    @Test //Открыть в браузере сайт https://www.ozon.ru/.
    public void firstTest1() {


        driver.get(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    @Test //В меню "Каталог" выбрать категорию "Музыка".
    public void firstTest2() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@value='Каталог']")).click();
        driver.findElement(By.linkText("Музыка")).click();
    }

    @Test // С открывшейся страницы перейти на страницу "Виниловые пластинки"
    public void firstTest3() throws InterruptedException {
        driver.findElement(By.linkText("Виниловые пластинки")).click();
        Thread.sleep(3000);
    }

    @Test //  Проверить, что открылся список товаров
    public void firstTest4() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Виниловые пластинки купить в интернет-магазине OZON.ru"));
    }

    @Test // Получить количество товаров на странице
    public void firstTest5() throws InterruptedException {
        WebElement webElement = driver.findElement(By.xpath("//div[@class='footer']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()",webElement);
        Thread.sleep(6000);
        List<WebElement> xpath = driver.findElements(By.xpath("//div[@class='tiles']/div[@class='tile m-default m-border']/a[@class='inner-link']"));
        int xpathCount = xpath.size();
        System.out.println("Total xpath: " + xpathCount);
    }


    @Test
    // Сгенерировать случайное число в диапазоне от 1 до количества товаров, полученного в п.5 и выбрать товар под номером. ( Перейти на страницу товара )
    public void firstTest7() throws InterruptedException {
        selectRandomNumber();
        Thread.sleep(3000);
    }

    @Test // Запомнить стоимость и название данного товара.
    public void firstTest8() throws InterruptedException {
        getICardTitle();
        getCardPrice();
        Thread.sleep(3000);
    }

    @Test // Добавить товар в корзину
    public void firstTest9() throws InterruptedException {
        addCart();
        Thread.sleep(3000);

    }

    @Test // Проверить то, что в корзине появился добавленный в п.9 товар
    public void firstTestCart() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/cart']")).click();
        Thread.sleep(3000);
        WebElement cart = driver.findElement(By.xpath("//a[@class='title']/span"));
        comparisonTitle();
    }

    @Test // Вернуться на страницу "Виниловые пластинки"
    public void firstTestCart1() throws InterruptedException {
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(3000);
    }

    @Test
    // Сгенерировать случайное число в диапазоне от 1 до количества товаров и выбрать товар под номером, полученным в п.12. ( Перейти на страницу товара )
    public void firstTestCart3() throws InterruptedException {
        selectRandomNumber();
        Thread.sleep(3000);
    }

    @Test // Запомнить стоимость и название данного товара.
    public void firstTestCart4() throws InterruptedException {
        getICardTitle2();
        getCardPrice2();
        Thread.sleep(3000);
    }

    @Test//Добавить товар в корзину.
    public void firstTestCart5() throws InterruptedException {
        addCart();
        Thread.sleep(3000);
    }

    @Test //Проверить то, что в корзине два товара
    public void firstTestCart6() {
        comparisonCart();
    }

    @Test // Открыть корзину.
    public void firstTestCart7() {
        driver.findElement(By.xpath("//a[@href='/cart']")).click();
    }

    @Test //  Проверить то, что в корзине раннее выбранные товары и итоговая стоимость по двум товарам рассчитана верно.
    public void firstTestCart8() {
        comparisonTitle2();
        comparisionPrice();
    }

    @Test // Удалить из корзины все товары.
    public void firstTestCart9() throws InterruptedException {
        deleteItems();
        Thread.sleep(3000);
    }

    @Test //Проверить, что корзина пуста.
    public void firstTestCart99() {
        emptyCart();
    }

    @Test //Закрыть браузер
    public void firstTestCart999() {
        driver.quit();
    }

}

