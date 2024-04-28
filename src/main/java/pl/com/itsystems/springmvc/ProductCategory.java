package pl.com.itsystems.springmvc;

public enum ProductCategory {
    SPOZYWCZE("Art. spożywcze"),
    DOMOWE("Art. gosp. domowego"),
    INNE("Inne");

    private String desc;

    ProductCategory(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
