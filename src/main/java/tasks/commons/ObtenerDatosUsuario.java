package tasks.commons;

import configurations.ConsultaUsuarios;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static utilities.Constantes.DATOS_USUARIO;

public class ObtenerDatosUsuario implements Task {

    private final String clave;

    public ObtenerDatosUsuario(String clave) {
        this.clave = clave;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> datosUsuario = ConsultaUsuarios.getUsuariosNombre(clave);
        actor.remember(DATOS_USUARIO, datosUsuario);
    }

    public static ObtenerDatosUsuario porNombre(String clave){
        return instrumented(ObtenerDatosUsuario.class, clave);
    }

}
