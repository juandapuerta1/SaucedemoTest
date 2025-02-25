package interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraerPrecio implements Interaction {

    protected Target element;

    public ExtraerPrecio(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String texto = element.resolveFor(actor).getText();
        Pattern pattern = Pattern.compile("\\d+\\.\\d{2}");
        Matcher matcher = pattern.matcher(texto);
        String valor = matcher.find() ? matcher.group() : "0.00";
        System.out.println(valor);
        actor.remember("valor1",valor);
    }

    public static ExtraerPrecio on(Target element) {
        return Instrumented.instanceOf(ExtraerPrecio.class).withProperties(element);
    }
}
