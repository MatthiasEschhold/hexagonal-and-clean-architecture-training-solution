package de.arkem.clean.arc.demo.garage.order.domain.model.price;

import de.arkem.shared.domain.object.price.Currency;
import io.github.domainprimitives.object.ComposedValueObject;

public class Price extends ComposedValueObject {
    private final Currency currency;
    private final PriceValue priceValue;

    public Price(Currency currency, PriceValue priceValue) {
        this.currency = currency;
        this.priceValue = priceValue;
    }

    public Currency getCurrency() {
        return currency;
    }

    public PriceValue getPriceValue() {
        return priceValue;
    }

    @Override
    protected void validate() {
        if (currency == null || priceValue == null) {
            throw new IllegalArgumentException("Price could not created due to missing mandatory properties");
        }
    }

    public static Price createWithEuroAsCurrency(PriceValue priceValue) {
        return new Price(new Currency("EUR"), priceValue);
    }
}
