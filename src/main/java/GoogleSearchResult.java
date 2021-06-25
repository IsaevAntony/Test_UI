import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchResult {

    @Step("Поереходим по имени ссылки {linkName}")
    public <T> T goLinkByName (String linkName, Class<T> typeNextPage){
        $x("//div[@class='g']").shouldHave(text(linkName)).$x(".//a[@href]").click();
        switchTo().window(1);
        return typeNextPage.cast(page(typeNextPage));
    }

    @Step
    public GoogleSearchResult checkPageContainsLink(String linkName){
        String stringURL = $$x("//div/cite").findBy(text(linkName)).getText();
        Assert.assertTrue(stringURL.contains(linkName));
        return this;
    }
}
