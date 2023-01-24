package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TechGlobalFrontendTestingHomePage extends TechGlobalBasePage {
    public TechGlobalFrontendTestingHomePage() {
        super();
    }

    @FindBy(css = "div[id^='card']")
    public List<WebElement> cards;

    public void clickOnCard(int cardIndex) {
        cards.get(cardIndex).click();
    }

    public void getFrontendPage() {
        headerDropdown.click();
        headerDropdownOptions.get(0).click();
    }
}
