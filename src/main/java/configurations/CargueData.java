package configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CargueData {

    private static final String ARCHIVO_CARGUE_DATA = "data.properties";
    private static final Properties properties = new Properties();

    private CargueData(){

    }

    static {
        try {
            InputStream inputStream = CargueData.class.getClassLoader().getResourceAsStream(ARCHIVO_CARGUE_DATA);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }



}
