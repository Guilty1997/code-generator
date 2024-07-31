package code.generator.infrastructure.persistent.repository;

import code.generator.domain.builder.model.entity.ColumnEntity;
import code.generator.domain.builder.model.entity.TableEntity;
import code.generator.domain.builder.repository.ICodeBuilderRepository;
import code.generator.infrastructure.persistent.po.Table;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 15:06
 * @Description: 代码生成器仓储接口
 */
@Repository
public class CodeBuilderRepository implements ICodeBuilderRepository {

  String url = "jdbc:mysql://localhost:3306";
  String user = "root";
  String password = "123456";

  /**
   * 获取表信息
   *
   * @return 表信息
   */
  @Override
  public List<String> getCatalogs() {
    List<String> strings = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      DatabaseMetaData metaData = connection.getMetaData();

      //获取目录
      ResultSet catalogs = metaData.getCatalogs();
      while (catalogs.next()) {
        String catalogName = catalogs.getString("TABLE_CAT");
        strings.add(catalogName);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return strings;
  }

  /**
   * 获取表名称
   *
   * @return 表名称
   */
  @Override
  public List<TableEntity> getTableNames(String catalog) {
    List<TableEntity> tablesResult = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      DatabaseMetaData metaData = connection.getMetaData();

      // 获取表信息
      ResultSet tables = metaData.getTables(catalog, null, "%", new String[]{"TABLE"});
      while (tables.next()) {
        TableEntity tableEntity = new TableEntity();
        String tableName = tables.getString("TABLE_NAME");
        String remark = tables.getString("REMARKS");
        tableEntity.setTableName(tableName);
        tableEntity.setTableComment(remark);
        tablesResult.add(tableEntity);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return tablesResult;
  }

  /**
   * 获取表字段信息
   *
   * @param tableName 表名称
   * @return 表字段信息
   */
  @Override
  public List<ColumnEntity> getTableColumns(String tableName) {
    List<ColumnEntity> columnEntities = new ArrayList<>();
    try (Connection connection = DriverManager.getConnection(url, user, password)) {
      DatabaseMetaData metaData = connection.getMetaData();

      // 获取列信息
      ResultSet columns = metaData.getColumns(null, null, tableName, "%");
      while (columns.next()) {
        ColumnEntity columnEntity = new ColumnEntity();
        String columnName = columns.getString("COLUMN_NAME");
        String columnType = columns.getString("TYPE_NAME");
        String columnComment = columns.getString("REMARKS");
        columnEntity.setColumnName(columnName);
        columnEntity.setColumnType(columnType);
        columnEntity.setColumnComment(columnComment);
        columnEntities.add(columnEntity);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return columnEntities;
  }

}
