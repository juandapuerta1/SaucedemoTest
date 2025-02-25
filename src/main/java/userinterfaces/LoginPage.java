package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
public class LoginPage {
    LoginPage() {}
    public static final Target TXT_USERNAME = Target.the("campo de texto para escribir usuario")
            .locatedBy("//input[@placeholder='Username']");
    public static final Target TXT_PASSWORD = Target.the("campo de texto para escribir contrasena")
            .locatedBy("//input[@placeholder='Password']");
    public static final Target BTN_LOGIN = Target.the("boton para autenticarse")
            .locatedBy("//input[@class='submit-button btn_action']");
    public static final Target TXT_ERROR_MESSAGE = Target.the("mensaje de error de inicio de sesión")
            .locatedBy("//h3[@data-test='error']");
}
