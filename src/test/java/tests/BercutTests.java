package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.BercutPage;

@Tag("bercut_auto")
public class BercutTests extends TestBase {

    BercutPage bercutPage = new BercutPage();

    @Test
    @Owner("petrova_di")
    @Story("Bercut main tests")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Проверка работоспособности глобального поиска")
    public void searchOnMainPageTest() {
        String searchText = "bss";
        bercutPage
                .openPage()
                .searchByText(searchText)
                .checkSearchResult();
    }

    @Test
    @Owner("petrova_di")
    @Story("Bercut main tests")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Проверка страницы с контактами организации")
    public void openContactsTest() {
        bercutPage
                .openPage()
                .goToContacts()
                .checkContacts();
    }

    @Test
    @Owner("petrova_di")
    @Story("Bercut main tests")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Проверка перехода на страницу продукта")
    public void checkMchs112ProductTest() {
        String productName = "МЧС-112";
        bercutPage
                .openPage()
                .openProducts()
                .goToProduct(productName)
                .checkProduct(productName);
    }

    @Test
    @Owner("petrova_di")
    @Story("Bercut main tests")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Проверка переключения на другой каталог")
    public void checkCatalogSwitchingTest() {
        String catalogName = "Услуги";
        bercutPage
                .openPage()
                .switchCatalog(catalogName)
                .checkSelectedCatalog(catalogName);
    }

    @Test
    @Owner("petrova_di")
    @Story("Bercut main tests")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Проверка поиска вакансий")
    public void checkVacanciesTest() {
        String vacancy = "qa";
        bercutPage
                .openPage()
                .goToCareer()
                .goToVacancies()
                .searchVacancy(vacancy)
                .checkSearchResult(vacancy);
    }
}
