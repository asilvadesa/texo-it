package com.texoit.web.poo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class BasePage {

    protected static final WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
    public void quit(){
        driver.quit();
    }
}
