package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static user_interfaces.HomeUi.MENU_HOME;
import static user_interfaces.HomeUi.OPCION_MENU_LOGIN;

public class DesplazarLogin implements Task {


    public static DesplazarLogin inTheApp(){
        return instrumented(DesplazarLogin.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            Click.on(MENU_HOME),
            Click.on(OPCION_MENU_LOGIN)
        );
    }
}
