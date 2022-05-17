package model;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="filter")
@XmlAccessorType(XmlAccessType.FIELD)
public class Filter {
    private String product;
    private String brandcheckbox;
    private String maxsum;

    public String getProduct(){return product;}
    public String getBrandCheckBox(){return brandcheckbox;}
    public String getMaxSum(){return maxsum;}

}
