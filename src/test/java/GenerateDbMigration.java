import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

import java.io.IOException;

public class GenerateDbMigration {

    public static void main(String[] args) throws IOException {
        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.POSTGRES);
        dbMigration.setVersion("20221101.0");
        dbMigration.setName("initial");

        dbMigration.generateMigration();
    }
}
