package code.generator.infrastructure.persistent.po;

import lombok.Data;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 16:43
 * @Description: 数据库表列信息
 */
@Data
public class Column {

  /**
   * 列名
   */
  private String columnName;

  /**
   * 列类型
   */
  private String columnType;

  /**
   * 列注释
   */
  private String columnComment;
}
