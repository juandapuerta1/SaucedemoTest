package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidarTexto implements Question<Boolean> {
    private final Target element;

    public ValidarTexto(Target element) {
        this.element = element;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return element.resolveFor(actor).isDisplayed();
    }

    public static Question<Boolean> delElemento(Target element) {
        return new ValidarTexto(element);
    }
}
