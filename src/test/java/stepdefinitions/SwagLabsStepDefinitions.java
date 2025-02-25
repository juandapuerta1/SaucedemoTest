package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Constantes;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.hamcrest.Matchers;
import questions.ValidarBooleano;
import questions.ValidarTexto;
import tasks.*;
import models.setdata.*;
import net.serenitybdd.screenplay.actors.OnStage;

import static userinterfaces.CheckoutPage.*;
import static userinterfaces.LoginPage.TXT_ERROR_MESSAGE;

public class SwagLabsStepDefinitions {

    @Before
    public static void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el actor ingresa a saucedemo.com")
    public void elActorIngresaASauceDemoCom(DataTable table) {
        OnStage.theActorCalled(Constantes.ACTOR).wasAbleTo(Open.url(AbrirLoombokData.setData(table).get(0).getUrl()));
    }

    @When("el actor se autentica con la siguiente informacion")
    public void elActorSeAutenticaConLaSiguienteInformacion(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(AutenticarseLoombokData.setData(table).get(0))
        );
    }

    @When("agrega el producto al carrito y hace el checkout")
    public void agregaElProductoAlCarritoYHaceElCheckout(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Agregar.alCarrito(AgregarAlCarritoLoombokData.setData(table).get(0))
        );
    }

    @When("el actor intenta iniciar sesión con credenciales inválidas")
    public void elActorIntentaIniciarSesiónConCredencialesInválidas(DataTable table) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Autenticarse.conCredenciales(AutenticarseLoombokData.setData(table).get(0))
        );
    }

    @Then("el actor verifica que el mensaje de confirmación sea {string}")
    public void elActorVerificaQueElMensajeDeConfirmaciónSea(String mensajeConfirmacion) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidarTexto.delElemento(TXT_CONFIRMAR)
                )
        );
    }

    @Then("el actor verifica que se muestra el mensaje de error {string}")
    public void elActorVerificaQueSeMuestraElMensajeDeError(String mensajeError) {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidarTexto.delElemento(TXT_ERROR_MESSAGE )
                )
        );
    }

    @When("agrega productos aleatorios al carrito y hace el checkout")
    public void agregaProductosAleatoriosAlCarritoYHaceElCheckout(DataTable table) {
        AgregarAlCarritoLoombokData data = AgregarAlCarritoLoombokData.setData(table).get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(
                SeleccionarProductosAleatorios.seleccionar(),
                Agregar.alCarrito(data)
        );
    }

    @Then("valida que el producto se compro de manera exitosa y verifica los calculos")
    public void validaQueElProductoSeComproDeManeraExitosaYVerificaLosCalculos() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                VerificarCalculosCheckout.verificar()
        );
    }
}
