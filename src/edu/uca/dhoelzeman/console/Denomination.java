package edu.uca.dhoelzeman.console;

/**
 * Holds the information for specific types of denominations for
 * use inside the {@link Purse} class
 */
public record Denomination(String name, double value, Forms form, String img) {}
