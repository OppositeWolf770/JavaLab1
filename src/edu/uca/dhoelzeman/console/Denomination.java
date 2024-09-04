package edu.uca.dhoelzeman.console;

/**
 * Holds the information for specific types of {@link CurrencyValues} for
 * use inside the {@link Purse} class
 */
public record Denomination(String name, double amt, CurrencyValues.Forms form, String img) {}
