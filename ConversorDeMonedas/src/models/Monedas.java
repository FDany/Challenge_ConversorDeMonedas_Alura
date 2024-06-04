package models;

import java.util.HashMap;

public record Monedas(
        HashMap<String, Float> conversion_rates
) {

}
