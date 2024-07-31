package code.generator.infrastructure.test;

import java.sql.*;

/**
 * @Author: hehongyi
 * @Date: 2024/7/26 13:44
 * @Description:
 */
public class Test {
  public static void main(String[] args) {
    String url = "jdbc:mysql://localhost:3306";
    String user = "root";
    String password = "123456";

    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      DatabaseMetaData metaData = connection.getMetaData();

//      //获取目录
//      ResultSet catalogs = metaData.getCatalogs();
//      while (catalogs.next()) {
//        String catalogName = catalogs.getString("TABLE_CAT");
//        System.out.println("Catalog: " + catalogName);
//      }

      // 获取表信息
      ResultSet tables = metaData.getTables("big_market", null, "%", new String[]{"TABLE"});
      while (tables.next()) {
        String tableName = tables.getString("TABLE_NAME");
        String tableType = tables.getString("REMARKS");
        System.out.println("Table: " + tableName + " Type: " + tableType);

        // 获取列信息
        ResultSet columns = metaData.getColumns(null, null, "rule_tree", "%");
        while (columns.next()) {
          String columnName = columns.getString("COLUMN_NAME");
          String columnType = columns.getString("TYPE_NAME");
          String remarks = columns.getString("REMARKS");
          System.out.println("\tColumn: " + columnName + " Type: " + columnType + " Remarks: " + remarks);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
