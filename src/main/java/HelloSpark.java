import static spark.Spark.*;
import spark.*;

public class HelloSpark {
	public static String settedvalue = "Hello Spark MVC Framework!";
    public static void main(String[] args) {
    	get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
            	response.type("text");
                return settedvalue;
            }
        });
    	put(new Route("/change") {
    		@Override
    		public Object handle(Request request, Response response) {
    			settedvalue = request.queryParams("val");
    			response.status(201);
    			return "Settedvalue set to '" + settedvalue + "'";
    		}
    	});
    	get(new Route("/kitty") {
            @Override
            public Object handle(Request request, Response response) {
            	response.type("text");
                return settedvalue;
            }
        });
        
    }
}