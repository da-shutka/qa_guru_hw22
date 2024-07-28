package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class BercutPage {

    private final SelenideElement
            searchButton = $("button[name='s']"),
            searchInput = $("#search"),
            contactsButton = $("a[href='/contacts/']"),
            map = $("#yandex-map"),
            contactOrgName = $(".contacts-page__main-title.h2"),
            contactEmail = $(".link.email"),
            contactPhone = $(".link.phone"),
            contactAddress = $(".link.address"),
            menuProducts = $(".menu-products"),
            productTitle = $(".products-page__main-title"),
            menuCareer = $("a[href='/career/']"),
            vacanciesButton = $("a[href='/career/vacancy/']");

    private final ElementsCollection
            postElements = $$(".post"),
            vacanciesElements = $$(".card-career-h__title");

    @Step("Открыть главную страницу")
    public BercutPage openPage() {
        open("");
        $(".main__title").shouldHave(text("bercut"));
        return this;
    }

    @Step("Ввести текст и искать")
    public BercutPage searchByText(String text) {
        executeJavaScript("arguments[0].click();", searchButton);
        executeJavaScript("arguments[0].click();", searchButton);
        searchInput.sendKeys(text);
        searchInput.pressEnter();
        return this;
    }

    @Step("Проверить, что поиск вернул хотя бы 1 результат")
    public void checkSearchResult() {
        postElements.shouldHave(sizeGreaterThan(0));
    }

    @Step("Перейти на страницу Контакты")
    public BercutPage goToContacts() {
        executeJavaScript("arguments[0].click();", contactsButton);
        return this;
    }

    @Step("Проверить, что на странице есть карта и контакты")
    public void checkContacts() {
        map.should(exist);
        contactOrgName.shouldHave(text("ООО \"НПФ Беркут\""));
        contactEmail.shouldHave(text("info@bercut.com"));
        contactPhone.shouldHave(text("+7 (812) 327-32-33"));
        contactAddress.shouldHave(text("197229, Санкт-Петербург, Лахтинский пр., д. 85, корп. 3, стр. 1, " +
                "Бизнес-центр «Business Box»"));
    }

    @Step("Открыть продукты")
    public BercutPage openProducts() {
        menuProducts.click();
        return this;
    }

    @Step("Перейти к продукту {product}")
    public BercutPage goToProduct(String product) {
        SelenideElement el = $$("a[class='menu-product__sub-link']").findBy(text(product));
        executeJavaScript("arguments[0].click();", el);
        return this;
    }

    @Step("Проверить, что продукт {product} корректно отображается")
    public void checkProduct(String product) {
        productTitle.shouldHave(text(product));
    }

    @Step("Переключить каталог на {catalog}")
    public BercutPage switchCatalog(String catalog) {
        $$(".tabs-catalog__button").findBy(text(catalog)).click();
        return this;
    }

    @Step("Проверить, что каталог изменился")
    public void checkSelectedCatalog(String catalog) {
        $$(".tabs-catalog__button.active").findBy(text(catalog)).should(exist);
    }

    @Step("Перейти на страницу Карьера")
    public BercutPage goToCareer() {
        menuCareer.click();
        return this;
    }

    @Step("Перейти к вакансиям")
    public BercutPage goToVacancies() {
        vacanciesButton.click();
        return this;
    }

    @Step("Искать вакансию, содержащую {name}")
    public BercutPage searchVacancy(String name) {
        searchInput.sendKeys(name);
        searchInput.pressEnter();
        return this;
    }

    @Step("Проверить, что были найдены вакансии, содержащие {name}")
    public void checkSearchResult(String name) {
        for (int i = 0; i < vacanciesElements.size(); i++) {
            vacanciesElements.get(i).shouldHave(text(name));
        }
    }
}
