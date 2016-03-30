import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * This program is an example program of retrieving information from a database.
 * The database is called "world" and it must contain a table called country with a 
 * Population field and a LifeExpectancy field
 * @author Jens Bennedsen
 *
 */

public class LifeExpectancy {
	public static void main(String[] args) {
		//output on the console
		PrintWriter out = new PrintWriter(System.out, true);
		//setup connecion parameters to the database
		String url = "jdbc:mysql://localhost/world";
		String username = "root";
		String password = "password";
		//calculate the average lifeexpectancy
		averageLifetime("", url, username, password, out);

	}

	private static void averageLifetime(String driver,
			String url,
			String username,
			String password,
			PrintWriter out) {
		try {
			//connect to the database using the mysql-jdbc driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection =
					DriverManager.getConnection(url, username, password);

			Statement statement = connection.createStatement();
			//select for all countries the number of people
			String query =
					"SELECT Population FROM country";
			ResultSet resultSet = statement.executeQuery(query);
			//calculate the number of people in the world
			long worldPopulation = 0;
			while(resultSet.next()) {
				worldPopulation=worldPopulation+Integer.parseInt(resultSet.getString("Population"));
			}
			//select for all countries the number of people and their expected living-time
			query =
					"SELECT Population, LifeExpectancy FROM country";
			resultSet = statement.executeQuery(query);
			//calculate the average living-time. 
			//It is each country's average living-time adjusted by the percentage of the world
			//population living in that country
			double worldExpectedLife = 0.0;
			while(resultSet.next()) {
				try {
					int population = Integer.parseInt(resultSet.getString("Population"));
					double lifeExpectancy = Double.parseDouble(resultSet.getString("LifeExpectancy"));
					double pct =(double) population/(double) worldPopulation;
					worldExpectedLife=worldExpectedLife+(pct*lifeExpectancy);
				} catch (Exception e)
				{}
			}
			System.out.println("Total number of people in the world: "+worldPopulation+ ". The live in average "+worldExpectedLife+" years");
			connection.close();
		} catch(Exception e) {System.out.println(e.getMessage());}
	}
}

