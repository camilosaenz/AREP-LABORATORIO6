package edu.escuelaing.arep.app;

import static spark.Spark.*;

public class HelloService {

	public static void main(String[] args) {
		secure("keycerts/ecikeystore.p12", "123456", null, null);
		port(getPort());
		get("/helloservice", (req, res) -> "Hello from service!");
	}
	
	static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
	
	

}