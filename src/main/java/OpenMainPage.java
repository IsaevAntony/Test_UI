import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$$;

public class OpenMainPage {

    @Step("Получаем курс валюты {nameMoney} для типа операции {typeOperation}")
    private float getCourse(String nameMoney, String typeOperation){
        ElementsCollection trHeaders = $$(By.xpath("//*[@class='main-page-exchange main-page-info__card']//tbody/tr[contains(@class,'header')]/td"));
        ElementsCollection trRows = $$(By.xpath("//*[@class='main-page-exchange main-page-info__card']//tbody/tr[contains(@class,'row')]"));
        SelenideElement elemPrice = null;
        for(int i=0;i<trHeaders.size();++i){
            if(trHeaders.get(i).getText().equals(typeOperation)){
                elemPrice = trRows.find(matchText(nameMoney)).$$x("./td").get(i);
                break;
            }
        }
        return Float.valueOf(elemPrice.getText().replace(",","."));
    }

    @Step("Получаем курс валюты пукупки меньше курса валюты продажи для валюты {nameMoney}")
    public OpenMainPage checkBuySell(String nameMoney){
        Assert.assertTrue(
                getCourse(nameMoney,"Банк покупает")
                        <
                        getCourse(nameMoney,"Банк продает"),
                "Курс покупки "+nameMoney+" не меньше курса продажи"
        );
        return this;
    }
}
