package mate.academy.model.dto;

import java.math.BigDecimal;

public class ProductRequestDto {
    private String name;

    private BigDecimal prise;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrise() {
        return prise;
    }

    public void setPrise(BigDecimal prise) {
        this.prise = prise;
    }
}
