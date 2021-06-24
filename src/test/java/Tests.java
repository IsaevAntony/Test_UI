import com.codeborne.selenide.Selenide;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"USD"}, {"EUR"}};
    }

    @Test (dataProvider = "data-provider")
    public void test(String money){
        open("https://www.google.ru/", GoogleMainPage.class)
                .search("Открытие")
                .goLinkByName("https://www.open.ru", OpenMainPage.class)
                .checkBuySell(money);
        Selenide.close();
    }
}
