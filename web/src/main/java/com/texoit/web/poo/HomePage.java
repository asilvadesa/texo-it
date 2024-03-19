package com.texoit.web.poo;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    public HomePage(){
        driver.get("https://jsonplaceholder.typicode.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void menuGuide() {
        driver.findElement(By.linkText("Guide")).click();
    }
}
