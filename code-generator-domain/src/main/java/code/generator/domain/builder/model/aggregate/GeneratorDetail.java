package code.generator.domain.builder.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * @Author: hehongyi
 * @Date: 2024/7/31 09:18
 * @Description: 生成器详情
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneratorDetail {

  /**
   * 基础信息
   */
  private BaseInfoInfo baseInfoInfo;

  /**
   * 表信息
   */
  private TableInfo tableInfo;

  /**
   * 列信息
   */
  private List<ColumnInfo> columnInfos;


  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class BaseInfoInfo {

    /**
     * 包名
     */
    private String packageName;

    /**
     * 生成时间
     */
    private String createTime;

    /**
     * 作者
     */
    private String author;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class TableInfo {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 表描述
     */
    private String tableComment;
  }

  @Data
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class ColumnInfo {

    /**
     * 列名
     */
    private String columnName;

    /**
     * 列描述
     */
    private String columnComment;

    /**
     * 列类型
     */
    private String columnType;

    /**
     * 引入包
     */
    private String importPackage;

    /**
     * 映射SQL类型到Java类型
     *
     * @return Java类型
     */
    public String mapSqlTypeToJavaType() {
      if (columnType == null) {
        return "String";
      }
      return switch (columnType.toUpperCase()) {
        case "TINYINT" -> "Byte";
        case "SMALLINT" -> "Short";
        case "INT", "INTEGER" -> "Integer";
        case "BIGINT", "BIGINT UNSIGNED" -> "Long";
        case "FLOAT" -> "Float";
        case "DOUBLE" -> "Double";
        case "DECIMAL", "NUMERIC" -> "BigDecimal";
        case "DATE", "TIME", "TIMESTAMP", "DATETIME" -> "Date";
        case "BOOLEAN" -> "Boolean";
        default -> "String";
      };
    }

    /**
     * 映射SQL类型到Java类型并获取对应的引入包
     *
     * @return Java类型及其对应的包名
     */
    public String mapSqlTypeToImportPackage() {
      if (columnType == null) {
        return "java.lang.String";
      }

      return switch (columnType.toUpperCase()) {
        case "DECIMAL", "NUMERIC" -> "java.math.BigDecimal";
        case "DATE", "TIME", "TIMESTAMP", "DATETIME" -> "java.util.Date";
        default -> "";
      };
    }

  }


}
