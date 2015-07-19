package tw.com.rk62pt.jersey;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/hello")
public class HelloRS {
	
	@GET
    public String sayHelloWorld() {
        return "Hello world";
    }   
 
	/**
	 * 參考至http://www.codedata.com.tw/java/java-restful-2-jersey-and-jax-rs/
	 * http://localhost:8080/About_jersey/rest/hello/ryan --->預設count=1
	 * http://localhost:8080/About_jersey/rest/hello/ryan?count=5 ---->印出五次
	 * @param name
	 * @param count
	 * @return
	 */
    @GET
    @Path("/{name}")
    public String sayHello(@PathParam("name") String name,@QueryParam("count") @DefaultValue("1") int count) {
    	
    	String hello = "";
    	for(int i=0;i<count;i++){
    		hello += "Hello, " + name;
    	}
        return hello;
    }
    

}
