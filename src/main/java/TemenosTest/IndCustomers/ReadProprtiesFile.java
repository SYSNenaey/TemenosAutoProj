
package TemenosTest.IndCustomers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadProprtiesFile {

        private final String ConfigPath;

        private Properties properties;

        public ReadProprtiesFile(String ConfigFilePath) throws IOException {
            this.ConfigPath = ConfigFilePath;
            setConfigProperties();

        }

        private void setConfigProperties() throws IOException {
            properties = new Properties();

            properties.load(Files.newInputStream(Paths.get(ConfigPath)));

        }


        public String getPropertyValue(String key){
            return properties.getProperty(key);
        }



    }

