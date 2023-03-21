package com.gmail.iparakhina91;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GitHubSearchTestWithCsvFileSource {
    @BeforeEach
    void setup() {
        Selenide.open("https://github.com/");
    }

    @CsvFileSource(resources = "/testDataForGitHubResearchTest/searchResultsOnGitHub.csv")
    @ParameterizedTest(name = "В поисковой выдаче на Github по запросу {0} первым отображается результат {1}")
    @Tags( {
            @Tag("MAJOR"),
            @Tag("WEB")
    })

    void searchResultsOnGitHub(String testData, String expectedText) {
        $("input.header-search-input").setValue(testData).pressEnter();
        $$("ul.repo-list").first().$("a.v-align-middle")
                .shouldHave(Condition.text(expectedText));
    }
}