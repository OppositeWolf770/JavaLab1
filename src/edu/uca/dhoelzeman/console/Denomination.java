package edu.uca.dhoelzeman.console;

/**
 * Holds the information for specific types of {@link CurrencyValues} for
 * use inside the {@link Purse}
 *
 * @see CurrencyValues
 * @see CurrencyValues#name
 * @see CurrencyValues.Forms
 * @see Register
 * @see Purse
 *
 * @param name The {@link String} representation of the denomination
 * @param amt The number of that denomination in the {@link Purse}
 * @param form The {@link CurrencyValues.Forms} representation of the denomination type
 * @param img The image for the specific denomination. Used for the GUI of the {@link Register}
 */
public record Denomination(String name, double amt, CurrencyValues.Forms form, String img) {}

