package com.gmail.iparakhina91;

import com.gmail.iparakhina91.dataForBookingTest.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.ElementsCollection.texts;
import static com.codeborne.selenide.Selenide.$;

public class BookingLocaleTestWithMethodSource {

    static Stream<Arguments> localeTestOnBookingWebsite() {
        return Stream.of(
                Arguments.of(
                        Locale.Русский,
                        List.of("Авиабилеты", "Аренда машин", "Варианты досуга")),
                Arguments.of(
                        Locale.UK,
                        List.of("Flights", "Car rentals", "Attractions"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} на сайте https://www.booking.com/ должен отображаться список кнопок {1}")
    @Tags( {
            @Tag("MAJOR"),
            @Tag("WEB")
    })

      void localeTestOnBookingWebsite(Locale locale, List<String> expectedButtons) {
        $(".e418d76df7").click();
        $(".dabce2e809").shouldHave(text(locale.name())).click();
        $(".e20caabacb").shouldHave(texts(expectedButtons));
     }
}