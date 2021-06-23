import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResult {

    @Step("Поереходим по имени ссылки {linkName}")
    public <T> T goLinkByName (String linkName, Class<T> typeNextPage){
        //SelenideElement elemOtrk = $x("//div[@class='g']").shouldHave(text("Банк «Открытие» — вклады, кредитные и дебетовые ..."));
        //elemOtrk.$x(".//a[@href]").click();
        $x("//div[@class='g']").shouldHave(text("Банк «Открытие» — вклады, кредитные и дебетовые ...")).$x(".//a[@href]").click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
