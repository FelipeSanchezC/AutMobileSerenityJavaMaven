package user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUi {

    private HomeUi(){}

    public static final Target MENU_HOME = Target.the("Menu superior en la pantalla Home").located(By.id("imageViewMenu"));
    public static final Target OPCION_MENU_LOGIN = Target.the("Opcion del menu del Home para iniciar proceso del login").located(By.id("textViewMenuUser"));


}
