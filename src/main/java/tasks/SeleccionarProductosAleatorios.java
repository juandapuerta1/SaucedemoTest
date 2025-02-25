package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import userinterfaces.MenuPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeleccionarProductosAleatorios implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<String> productosDisponibles = MenuPage.PRODUCTOS_DISPONIBLES;
        List<String> productosAleatorios = new ArrayList<>(productosDisponibles);
        Collections.shuffle(productosAleatorios);

        int cantidadProductosSeleccionados = Math.min(2, productosAleatorios.size());
        for (int i = 0; i < cantidadProductosSeleccionados; i++) {
            String nombreProducto = productosAleatorios.get(i);
            actor.attemptsTo(
                    Click.on(MenuPage.getBotonAgregarProducto(nombreProducto))
            );
        }
    }

    public static SeleccionarProductosAleatorios seleccionar() {
        return new SeleccionarProductosAleatorios();
    }
}