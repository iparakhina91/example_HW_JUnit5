package com.gmail.iparakhina91;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Selenide;
import com.gmail.iparakhina91.dataForVkontakteTest.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VkontakteLocaleTestWithMethodSource {

    static Stream<Arguments> localeTestOnVkontakteLogin() {
        return Stream.of(
                Arguments.of(Locale.Русский,
                        List.of("О ВКонтакте", " ", "Правила",
                                "Для бизнеса", "Разработчикам", " ")),
                Arguments.of(Locale.Українська,
                        List.of("Про VK", " ", "Правила",
                                "Для бізнесу", "Розробникам", " "))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} на сайте https://vk.com/login должен отображаться список кнопок {1}")
    @Tags( {
            @Tag("MAJOR"),
            @Tag("WEB")
    })

      void localeTestOnVkontakteLogin(Locale locale, List<String> expectedButtons) {
        Selenide.open("https://vk.com/login");
        $(".footer_lang").shouldHave(text(locale.name())).click();
        $$(".bnav_a").shouldHave(CollectionCondition.texts(expectedButtons));
     }
}