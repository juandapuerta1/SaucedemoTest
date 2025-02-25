package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class ObtenerTextoElemento implements Question<List<String>> {

    private final Target elemento;

    public ObtenerTextoElemento(Target elemento) {
        this.elemento = elemento;
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return null;
    }

    public static ObtenerTextoElemento delElemento(Target elemento) {
        return new ObtenerTextoElemento(elemento);
    }
}