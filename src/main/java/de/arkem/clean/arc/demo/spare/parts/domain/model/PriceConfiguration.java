package de.arkem.clean.arc.demo.spare.parts.domain.model;

import de.arkem.shared.domain.object.price.Currency;

public class PriceConfiguration {
    private Currency currency;
    private Price netPriceRecommodation;
    private Price configuredNetPrice;

    public PriceConfiguration(Currency currency, Price netPriceRecommodation, Price configuredNetPrice) {
        this.currency = currency;
        this.netPriceRecommodation = netPriceRecommodation;
        this.configuredNetPrice = configuredNetPrice;
    }

    public Price getNetPriceRecommodation() {
        return netPriceRecommodation;
    }

    public Price getConfiguredNetPrice() {
        return configuredNetPrice;
    }

    public Currency getCurrency() {
        return currency;
    }
    public static PriceConfiguration createPriceConfigurationWithDefaults(Price netPriceRecommodation) {
        return new PriceConfiguration(new Currency("EUR"), netPriceRecommodation, netPriceRecommodation);
    }
}
