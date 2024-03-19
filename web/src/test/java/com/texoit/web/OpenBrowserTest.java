package com.texoit.web;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class OpenBrowserTest {

    private WebDriver driver;

    @Test
    void abrirBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://jsonplaceholder.typicode.com/");

    }

}
