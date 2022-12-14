package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TestForm {
    @BeforeAll static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test void happyTest(){

        String name = "Hanna";

        open("/text-box");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("liplianna@gmail.com");
        $("[id=currentAddress]").setValue("Minsk 123");
        $("[id=permanentAddress]").setValue("Vilnius");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("liplianna@gmail.com"), text("Minsk 123"), text("Vilnius"));

        System.out.println("Happy Pass");
    }

}
