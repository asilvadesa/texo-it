package com.texoit.web.steps;

import com.jayway.jsonpath.JsonPath;
import com.texoit.web.poo.AlbumsPhotoPage;
import com.texoit.web.poo.GuidePage;
import com.texoit.web.poo.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AlbumSteps {
    private HomePage homePage;

    @Dado("que acesse a Home Page")
    public void que_acesse_a_home() {
        homePage = new HomePage();
    }

    @Dado("acesse o meunu {string}")
    public void acesse_o_meunu(String string) throws InterruptedException {
      homePage.menuGuide();
    }

    @Quando("eu clicar no link {string}")
    public void eu_clicar_no_link(String link) throws InterruptedException {
        GuidePage guidePage = new GuidePage();
        guidePage.clickLinkByText(link);
        Thread.sleep(3000);
    }
    @Entao("deve retornar a pagina albums")
    public void deve_retornar_a_pagina_albums() throws InterruptedException {
        AlbumsPhotoPage albumsPhotoPage = new AlbumsPhotoPage();

        List<Map<String, Object>> albumList =
                JsonPath.parse(albumsPhotoPage.getBodyText()).read("$", List.class);

        Map<String, Object> albumPhoto = null;
        for(Map<String, Object> albumMap: albumList){
            if(albumMap.get("id").toString().equals("6")){
                albumPhoto = albumMap;
            }
        }

        assertEquals("1", albumPhoto.get("albumId").toString());
        assertEquals("6", albumPhoto.get("id").toString());
        assertEquals("accusamus ea aliquid et amet sequi nemo",
                                    albumPhoto.get("title").toString());
        assertEquals("https://via.placeholder.com/600/56a8c2",
                                    albumPhoto.get("url").toString());
        assertEquals("https://via.placeholder.com/150/56a8c2",
                                    albumPhoto.get("thumbnailUrl").toString());
    }

    @After
    public void tearDown(){
        homePage.quit();
    }
}
