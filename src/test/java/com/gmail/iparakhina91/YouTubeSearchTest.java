package com.gmail.iparakhina91;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YouTubeSearchTest {

    @Test
    void searchStandUpOnYouTube() {
        Selenide.open("https://www.youtube.com/");
        $("#search[placeholder='Введите запрос']").setValue("stand up").pressEnter();
        $$(".ytd-page-manager").shouldHave(CollectionCondition.size(3));
    }
}