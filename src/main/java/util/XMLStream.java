package util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import model.Filters;

import java.io.File;

public class XMLStream {
        public static Object[][] useFilterData() throws JAXBException {
        File file = new File("src/main/resources/filter.xml");
        JAXBContext jaxbConText = JAXBContext.newInstance(Filters.class);

        Unmarshaller unmarshal =jaxbConText.createUnmarshaller();
        Filters searchFilters =(Filters) unmarshal.unmarshal(file);

        Object[][] searchFilterArray =
                searchFilters.getSearchFilterList()
                        .stream().map(
                                x-> new Object[]{
                                          x.getProduct(),x.getBrandCheckBox(),x.getMaxSum()
                }).toArray(Object[][]::new);
        return searchFilterArray;
    }
}
