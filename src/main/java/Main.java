import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
		final String PORT = System.getenv("PORT");
		final int port = PORT != null ? Integer.parseInt(PORT) : 8080; // Spark will run on port $PORT (8080 if not set)
		
		port(port); // Spark will run on port $PORT (8080 if not set)
		System.out.println("Listening on port: " + port);
		
		get("/", (req, res) -> "Hello from Heroku CI/CD Tutorial");	
		get("/sum/:a/:b", (req, res) -> sum(Integer.parseInt(req.params("a")), Integer.parseInt(req.params("b"))));
	}
	
	public static int sum(int a, int b) {
		return a + b;
	}
}	
