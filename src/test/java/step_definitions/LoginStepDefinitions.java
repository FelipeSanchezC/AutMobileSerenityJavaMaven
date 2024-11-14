package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tasks.DesplazarLogin;
import tasks.IngresarCredenciales;
import tasks.commons.ObtenerDatosUsuario;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {



    @Given("Me desplazo al menu del login")
    public void ingresoLogin(){
        theActorInTheSpotlight().attemptsTo(
                DesplazarLogin.inTheApp()
        );
    }

    @When("Ingreso {}")
    public void ingresoCredenciales(String clave){
        theActorInTheSpotlight().attemptsTo(
                ObtenerDatosUsuario.porNombre(clave),
                IngresarCredenciales.inTheApp(clave)
        );
    }

    @Then("Valido {}")
    public void validarLogin(String resultado){

    }


}
