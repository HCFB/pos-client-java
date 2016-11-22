package ru.homecredit.web.model.CashOnDelivery.enums;


public enum CurrencyEnum {
    USD("$"),
    EUR("€"),
    RUR("руб");

    private String dsc;

    CurrencyEnum(String dsc) {
        this.dsc = dsc;
    }
    public String getDsc() {
        return dsc;
    }
}
