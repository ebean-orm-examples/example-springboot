import io.ebean.test.containers.PostgresContainer;

public class StartLocalPostgresContainer {

    public static void main(String[] args) {
        PostgresContainer.builder("15")
                .port(5532) // Note: defaults to 6432
                .dbName("my_app")
                .user("my_app")
                .password("silly")
                .containerName("pg15")
                .extensions("hstore,pgcrypto")
                .build()
                .start();
    }
}
