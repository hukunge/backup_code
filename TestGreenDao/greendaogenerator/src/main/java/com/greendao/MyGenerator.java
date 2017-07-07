package com.greendao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {

    public static void main(String[] args) {
        Schema schema = new Schema(4, "com.test.greendao.db"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
        // addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {
        Entity user = schema.addEntity("User1");
        user.addIdProperty().primaryKey().autoincrement();
        user.addIntProperty("user_id").notNull();
        user.addStringProperty("address");//新增列，测试update
        user.addStringProperty("headicon");//新增列，测试update
        user.addStringProperty("last_name");
        user.addStringProperty("first_name");
        user.addStringProperty("email");
        return user;
    }
}
