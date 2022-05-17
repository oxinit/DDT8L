package bo;


import Pages.Page;
import manager.PageFactoryManager;
import util.DriverManager;

public class AddExpensiveItemToBasket {
    PageFactoryManager pageFactoryManager = new PageFactoryManager(DriverManager.getDriver());
    Page page = pageFactoryManager.getHomePage();
    public void addExpensiveItemToBasket(String p1, String p2 ,String p3) throws InterruptedException {
        page.searchFieldSendKeys(p1);
        page.clickFindButton();
        page.expensiveSortClick();
        page.hpCHeckBoxClick();
        page.firstElementClick();
        page.buyClick();
    }
    public String getSumOfGoods(){
        return page.checkSumOfGoods();
    }

}
