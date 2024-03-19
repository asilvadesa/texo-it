package com.texoit.web.poo;

import org.openqa.selenium.By;

public class AlbumsPhotoPage extends BasePage {
    public String getBodyText(){
        return driver.findElement(By.tagName("body")).getText();
    }
}
