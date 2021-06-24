import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GoogleMainPage {

    @Step("Ищу слово {query}")
    public GoogleSearchResult search(String query){
        $(byName("q")).setValue(query);
        $$x("//*[@value='Поиск в Google']").find(Condition.visible).click();
        return Selenide.page(GoogleSearchResult.class);
    }

}
