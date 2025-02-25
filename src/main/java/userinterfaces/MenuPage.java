package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import java.util.Arrays;
import java.util.List;

public class MenuPage {
    MenuPage() {}

    public static final Target BTN_AGREGAR = Target.the("boton para añadir al carrito")
            .locatedBy("//div[contains(@class, 'inventory_item_name') and contains(text(),'{0}')]/ancestor::div[@class='inventory_item_description']//button[contains(text(), 'Add to cart')]");

    public static final List<String> PRODUCTOS_DISPONIBLES = Arrays.asList(
            "Sauce Labs Backpack",
            "Sauce Labs Bike Light",
            "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket",
            "Sauce Labs Onesie",
            "Test.allTheThings() T-Shirt (Red)"
    );

    public static Target getBotonAgregarProducto(String nombreProducto) {
        return BTN_AGREGAR.of(nombreProducto);
    }
}