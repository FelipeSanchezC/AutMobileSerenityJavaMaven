package user_interfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PageLoginUi {
    public static final Target LBL_USERNAME_LOGIN = Target.the("Label para el ingreso del Username").locatedBy("//android.widget.RelativeLayout[3]/android.widget.EditText");
    public static final Target LBL_PASSWORD_LOGIN = Target.the("Label para el ingreso del Password").locatedBy("//android.widget.RelativeLayout[4]/android.widget.EditText");
    public static final Target BTN_LOGIN = Target.the("Boton para continuar con el flujo del login").located(By.id("buttonLogin"));
    public static final Target MSG_ERROR_USER_NAME = Target.the("Mensaje de control cuando se ingresa un usuario incorrecto").located(By.id("textViewFailed"));
    public static final Target BTN_SIGN_UP = Target.the("Boton para iniciar el proceso de registro").located(By.id("textViewSingUpToday"));
}
