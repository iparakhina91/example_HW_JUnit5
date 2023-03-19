package com.gmail.iparakhina91;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YouTubeSearchTestWithValueSource {
    @BeforeEach
    void setup() {

        Selenide.open("https://www.youtube.com/");
    }

    @ValueSource(strings = {
            "stand up", "qa guru"
    })
    @ParameterizedTest(name = "В поисковой выдаче YouTube по запросу {0} должно отображаться 3 результата")
    @Tags( {
            @Tag("MAJOR"),
            @Tag("WEB")
    })

    void searchResultsOnYouTube(String testData) {
        $("#search[placeholder='Введите запрос']").setValue(testData).pressEnter();
        $$(".ytd-page-manager").shouldHave(CollectionCondition.size(3));
    }
}