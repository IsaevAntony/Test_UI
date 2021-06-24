import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResult {

    @Step("Поереходим по имени ссылки {linkName}")
    public <T> T goLinkByName (String linkName, Class<T> typeNextPage){
        $x("//div[@class='g']").shouldHave(text(linkName)).$x(".//a[@href]").click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }
}
