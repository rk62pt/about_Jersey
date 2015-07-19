package tw.com.rk62pt.jersey;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RSApplication extends ResourceConfig{
    public RSApplication(){
        packages("tw.com.codedata.jersey");
    }
}
