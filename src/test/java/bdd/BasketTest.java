package bdd;

import bo.AddExpensiveItemToBasket;
import jakarta.xml.bind.JAXBException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.XMLStream;
import static java.lang.Integer.valueOf;
import static org.testng.Assert.assertTrue;

public class BasketTest extends BaseTest {

    @DataProvider(name = "data-provider" ,parallel = true)
    public Object[][] dpMethod() throws  JAXBException {
     return XMLStream.useFilterData();
    }

   @Test(dataProvider = "data-provider" )
    public void notAtomicityMethod(String p1,String p3 , String p2) throws InterruptedException {
       AddExpensiveItemToBasket businessObjectForNAM = new AddExpensiveItemToBasket();
       businessObjectForNAM.addExpensiveItemToBasket(p1 ,p3 ,p2);
       assertTrue(valueOf(businessObjectForNAM.getSumOfGoods())<valueOf(p2));
    }

}
