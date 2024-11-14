package configurations;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.commons.CommonsExeptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ConsultaUsuarios {

    private ConsultaUsuarios (){}

    private static List<Map<String, String>> usuarios;
    private static final String ARCHIVO_DATA = "data.properties";

    static {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = ConsultaUsuarios.class.getClassLoader().getResourceAsStream(ARCHIVO_DATA);
            TypeReference<Map<String, List<Map<String, String>>>> typeRef = new TypeReference<Map<String, List<Map<String, String>>>>() {};
            Map<String, List<Map<String, String>>> data = objectMapper.readValue(inputStream, typeRef);
            usuarios = data.get("usuarios");
        } catch (IOException e){
            throw new CommonsExeptions("Error al cargar el archivo de datos");
        }
    }

    public static List<Map<String, String>> getUsuarios(){
        return usuarios;
    }

    public static Map<String, String> getUsuariosNombre(String clave){
        return usuarios.stream()
                .filter(map -> map.get("clave").equals(clave))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"+ clave));
    }
}
