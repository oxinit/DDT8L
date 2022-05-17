package model;


import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="filters")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters {
    @XmlElement(name="filter")
    private List<Filter> searchFilter;
    public List <Filter>getSearchFilterList(){return searchFilter;}
}
