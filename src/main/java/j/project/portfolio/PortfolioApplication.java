package j.project.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.util.Properties;

@SpringBootApplication
public class PortfolioApplication {

	public static void main(String[] args) {
		// Load from local.properties if available
		try {
			Properties localProps = new Properties();
			FileInputStream fis = new FileInputStream("local.properties");
			localProps.load(fis);
			fis.close();

			for (String key : localProps.stringPropertyNames()) {
				System.setProperty(key, localProps.getProperty(key));
			}

			System.out.println("✅ Loaded local.properties.");
		} catch (Exception e) {
			System.out.println("⚠️ Could not load local.properties: " + e.getMessage());
		}

		SpringApplication.run(PortfolioApplication.class, args);
	}
}
