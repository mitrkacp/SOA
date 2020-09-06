package pl.edu.agh.soa;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/app")
public class App extends Application {

    public App() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api/app");
        beanConfig.setResourcePackage("pl.edu.agh.soa");
        beanConfig.setTitle("Vendor controller - Swagger Documentation");
        beanConfig.setScan(true);
    }
}