package in.bassure.subscription.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SubscriptionManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscriptionManagementApplication.class, args);
    }
}
