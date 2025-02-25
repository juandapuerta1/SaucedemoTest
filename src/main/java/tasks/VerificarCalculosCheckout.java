package tasks;

import interactions.ExtraerPrecio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import userinterfaces.CheckoutOverviewPage;

import static userinterfaces.CheckoutPage.BTN_FINISH;
import static userinterfaces.CheckoutPage.TXT_CONFIRMAR;

public class VerificarCalculosCheckout implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ExtraerPrecio.on(CheckoutOverviewPage.TXT_ITEM_TOTAL),
                ExtraerPrecio.on(CheckoutOverviewPage.TXT_TAX),
                ExtraerPrecio.on(CheckoutOverviewPage.TXT_TOTAL)
        );

        double itemTotal = Double.parseDouble(actor.recall("valor1"));
        double tax = Double.parseDouble(actor.recall("valor1"));
        double total = Double.parseDouble(actor.recall("valor1"));

        double calculatedTotal = itemTotal + tax;

        Ensure.that(calculatedTotal).isEqualTo(total);
        System.out.println("sumo");
        actor.attemptsTo(
                Scroll.to(BTN_FINISH).andAlignToBottom(),
                JavaScriptClick.on(BTN_FINISH),
                Ensure.that(TXT_CONFIRMAR).isDisplayed()
        );
    }

    public static VerificarCalculosCheckout verificar() {
        return new VerificarCalculosCheckout();
    }
}