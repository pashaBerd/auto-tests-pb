package com.kofile.search;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * smoketest_for search.kofile.com ___12 testcases in a row
 * цуацац
 */



public class psSmokeTest {

    @BeforeClass
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/pavloberdnyk/IdeaProjects/PublicSearch/chromedriver");
        System.setProperty("selenide.browser", "chrome");
    }

    @BeforeMethod
    public void GoToPS() {
        open("http://search.kofile.com/48215");
    }

    @Test(priority = 1)
    public void Login() {
        $(".logo>img").shouldBe(visible);
        $(".button-login").click();
        $(By.id("dialog-content-holder")).shouldBe(visible);
        $(By.name("loginusername")).setValue("pavloberdnyk77@gmail.com");
        $(By.name("loginpassword")).setValue("berdnyk");
        $(".btn.titleBtnClr").click();
        $(By.id("userNameLink")).shouldHave(exactText("Uncle Sam")).click();
        $("#updateuserprofile strong").shouldHave(text("Uncle Sam"));
        $(By.linkText("Edit Profile")).shouldBe(visible);
        $(By.linkText("Change Password")).shouldBe(visible);
        $(By.linkText("Manage Collections")).shouldBe(visible);
    }

    @Test(priority = 3)
    public void MarriageSearch() {
        $("#searchzone #Department_6").click();
        $(By.xpath("//H1[text()='Marriage Certificates Search']/self::H1")).shouldBe(visible);
        $("li #SearchText").setValue("CHANG");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("CHANG"));
    }

    @Test(priority = 4)
    public void CattleBrandsSearch() {
        $("#searchzone #Department_11").click();
        $(By.xpath("//H1[text()='Cattle Brands Search']/self::H1")).shouldBe(visible);
        $("li #SearchText").setValue("ADOLFO");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("ADOLFO"));
    }

    @Test(priority = 5)
    public void FinancingStatementsSearch() {
        $("#searchzone #Department_3").click();
        $(By.xpath("//H1[text()='Financing Statements Search']/self::H1")).shouldBe(visible);
        $("li #SearchText").setValue("ADAM");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("ADAM"));
    }

    @Test(priority = 6)
    public void PlatsSearch() {
        $("#searchzone #Department_2").click();
        $(By.xpath("//H1[text()='Plats Search']/self::H1")).shouldBe(visible);
        $("li #SearchText").setValue("Bros");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("Bros"));
    }

    @Test(priority = 7)
    public void ForeclosureSearch() {
        $("#searchzone #Department_13").click();
        $(By.xpath("//H1[text()='Foreclosures Search']/self::H1")).shouldBe(visible);
        $("li #SearchText").setValue("2014-52014");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("2014"));
        $(By.id("slides-prev-icon")).click();
        $("#searchzone #Department_1").shouldBe(visible);
    }

    @Test(priority = 2)
    public void RealPropertySearch() {
        $("#searchzone #Department_1").click();
        $("li #SearchText").setValue("SMITH");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("SMITH"));
    }
    @Test(priority = 8)
    public void AddDocumentToCart() {
        $("#searchzone #Department_1").click();
        $("li #SearchText").setValue("SMITH");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("SMITH"));
        $(".table.table-striped.dataTable.result-table>tbody>tr:nth-of-type(1)").findElementByCssSelector(".iconCart.icon_table").click();
        $(By.id("CartItemCount")).shouldHave(exactText("1"));
        $(By.id("CartDetails")).click();
        $(By.id("cartHearderBlock-left")).shouldBe(visible);
        $(".cartItemDetails>td>#cartItemGenericDetails").shouldBe(visible);
        $(By.id("clearShoppingCartLink")).click();
    }
    @Test(priority = 9)
    public void CheckPreviewPopup() {
        $("nav #slides-prev-icon").click();
        $("#searchzone #Department_1").click();
        $("li #SearchText").setValue("SMITH");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("SMITH")).click();
        $("#singleImageContainer>div>img").$(by("src","/48215/api/Image/Get/1?docid=1406526&contentId=3263817&version=1&page=1"));
    }
    @Test(priority = 10)
    public void DownloadDocument() {
        $("#searchzone #Department_1").click();
        $("li #SearchText").setValue("SMITH");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 15000).shouldHave(text("SMITH"));
        $(".table.table-striped.dataTable.result-table>tbody>tr:nth-of-type(1)").findElementByCssSelector(".iconCart.icon_table").click();
        $(By.id("CartItemCount")).shouldHave(exactText("1"));
        $(By.id("CartDetails")).click();
        $( "#delieveryMethod").selectOption("Download");
        $(By.id("shoppinCartCheckoutBtn")).click();
        $("#itnet-ec-ordcon-left-block-success-text>span").shouldBe(visible);
        $(By.id("newSearch")).shouldBe(enabled).click();
        $(By.id("SearchText")).shouldBe(visible);
    }
    @Test(priority = 11)
    public void EmailDocument() {
        $("#searchzone #Department_1").click();
        $("li #SearchText").setValue("SMITH");
        $("li .searchbutton").click();
        $("#results-table span").waitUntil(exist, 10000).shouldHave(text("SMITH"));
        $(".table.table-striped.dataTable.result-table>tbody>tr:nth-of-type(1)").findElementByCssSelector(".iconCart.icon_table").click();
        $(By.id("CartItemCount")).shouldHave(exactText("1"));
        $(By.id("CartDetails")).click();
        $( "#delieveryMethod").selectOption("eMail");
        $(By.id("shoppinCartCheckoutBtn")).click();
        $("#itnet-ec-ordcon-left-block-success-text>span").shouldBe(visible);
        $(By.id("newSearch")).shouldBe(enabled).click();
        $(By.id("SearchText")).shouldBe(visible);
    }
    @Test(priority = 12)
    public void Logout() {
        $(By.id("signOutLink")).click();
        $(By.id("logoutOk")).click();
        $(By.id("registerUser")).shouldBe(visible);

    }
}
