package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static user_interfaces.HomeUi.MENU_HOME;
import static user_interfaces.PageLoginUi.*;
import static utilities.Constantes.*;
import static utilities.Constantes.DEFAULT_WAIT;

public class IngresarCredenciales implements Task {

    private final String clave;

    public IngresarCredenciales(String clave) {
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> datos = actor.recall(DATOS_USUARIO);
        actor.remember(USER_NAME_REMEMBER, datos.get(NOMBRE_USUARIO_DATA));

        String username = datos.get(NOMBRE_USUARIO_DATA);
        String password = datos.get(PASSWORD_DATA);

        //ingresarCredenciales(actor, datos.get(NOMBRE_USUARIO_DATA), datos.get(PASSWORD_DATA));
        //ingresarCredenciales(actor,"Pruebas123","Pruebas123");

        switch (clave){
            case ESCENARIO_LOGIN_USUARIO_CORRECTO:
                System.out.println("este es el username: " +username);
                System.out.println("este es el password" +password);
                actor.attemptsTo(
                        Click.on(BTN_LOGIN),
                        WaitUntil.the(MENU_HOME, isPresent()).forNoMoreThan(DEFAULT_WAIT).seconds(),
                        Click.on(MENU_HOME)
                );
                ingresarCredenciales(actor, datos.get(NOMBRE_USUARIO_DATA), datos.get(PASSWORD_DATA));
            break;

        }

    }

    private <T extends Actor> void ingresarCredenciales(T actor, String username, String password){
        actor.attemptsTo(
                WaitUntil.the(LBL_USERNAME_LOGIN, isPresent()).forNoMoreThan(DEFAULT_WAIT).seconds(),
                Click.on(LBL_USERNAME_LOGIN),
                Enter.theValue(username).into(LBL_USERNAME_LOGIN),
                SendKeys.of(password).into(LBL_PASSWORD_LOGIN)
        );
    }


    public static IngresarCredenciales inTheApp(String clave){
        return instrumented(IngresarCredenciales.class, clave);
    }
}
