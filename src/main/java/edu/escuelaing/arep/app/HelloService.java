package edu.escuelaing.arep.app;

import static spark.Spark.*;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;

public class HelloService {

	public static void main(String[] args) {
		port(getPort());
		SecureURLReader.Secure();
		Map<String, String> usuarios = new HashMap<>();
		Gson gson = new Gson();
		usuarios.put("camilosaenz@mail.com", Hashing.sha256().hashString("123456", StandardCharsets.UTF_8).toString());
		staticFileLocation("/public");
		secure("keycerts/ecikeystore.p12", "123456", null, null);
		get("/helloservice", (req, res) -> "Hello from service!");
		get("/", (req, res) -> {
			res.redirect("index.html");
			return "";
		});
		post("/login", (req, res) -> {
			req.session(true);
			Usuario usuario = gson.fromJson(req.body(), Usuario.class);
			if(Hashing.sha256().hashString(usuario.getPassword(), StandardCharsets.UTF_8).toString().equals(usuarios.get(usuario.getCorreo()))){
                req.session().attribute("User",usuario.getCorreo());
                req.session().attribute("Loged",true);
            }
			else {
				return "El Usiario o la Contraseña son incorrectas, por favor vuelva a intentar!";
			}
			return "";
		});
	}
	
	static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    } 
	
	

}