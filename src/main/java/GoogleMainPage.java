import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GoogleMainPage {

    @Step("Ищу слово {query}")
    public GoogleSearchResult search(String query){
        $(By.name("q")).setValue(query);
        $(By.xpath("//ul/li/div")).click();
        //$(By.xpath("//form/div/div/div[3]//input[@value='Поиск в Google']")).click();
        return Selenide.page(GoogleSearchResult.class);
    }

}
