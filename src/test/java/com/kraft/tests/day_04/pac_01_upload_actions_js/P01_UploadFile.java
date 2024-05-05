package com.kraft.tests.day_04.pac_01_upload_actions_js;

import com.kraft.utils.BrowserUtils;
import com.kraft.utils.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static com.kraft.utils.Driver.getPage;


public class P01_UploadFile {

    @BeforeEach
    void setUp(){
        Driver.getPage().navigate("https://practice.cydeo.com/upload");
    }

    @Test
    void test1(){
                            //path of your project
     //   String pathOfFile = System.getProperty(("user.home")) + "/IdeaProjects/playwright-witj-java/src/test/resources/uploadtest.txt";
        String pathOfFile = System.getProperty(("user.dir")) + "/src/test/resources/uploadtest.txt";
        //path i bu şekilde alınca çalışmadı.

        Driver.getPage().getByTestId("file-upload").setInputFiles(Path.of(pathOfFile));
        //Driver.getPage().getByTestId("file-upload").setInputFiles(Paths.get(pathOfFile));
        BrowserUtils.sleepWithPage(getPage(), 2);
        Driver.getPage().getByTestId("file-submit").click();
        Driver.getPage().locator("//h3").textContent();
    }

    @AfterEach
    void tearDown(){
        Driver.closeDriver();
    }
}

