package tasks;

import models.setdata.AgregarAlCarritoLoombokData;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static userinterfaces.CarritoPage.*;
import static userinterfaces.CheckoutPage.*;

public class Agregar implements Task {
    private final AgregarAlCarritoLoombokData agregarAlCarritoLoombokData;

    public Agregar(AgregarAlCarritoLoombokData agregarAlCarritoLoombokData) {
        this.agregarAlCarritoLoombokData = agregarAlCarritoLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CARRITO),
                Click.on(BTN_CHECKOUT),
                Enter.theValue(agregarAlCarritoLoombokData.getNombre()).into(TXT_NOMBRE),
                Enter.theValue(agregarAlCarritoLoombokData.getApellido()).into(TXT_APPELIDO),
                Enter.theValue(agregarAlCarritoLoombokData.getZip()).into(TXT_ZIP),
                Click.on(BTN_CONTINUE)

        );
    }

    public static Agregar alCarrito(AgregarAlCarritoLoombokData agregarAlCarritoLoombokData) {
        return Instrumented.instanceOf(Agregar.class).withProperties(agregarAlCarritoLoombokData);
    }
}