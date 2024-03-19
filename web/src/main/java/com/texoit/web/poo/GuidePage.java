package com.texoit.web.poo;

import org.openqa.selenium.By;

public class GuidePage extends BasePage{

    public void clickLinkByText(String link){
        driver.findElement(By.linkText(link)).click();
    }
}
