package code.generator.infrastructure.persistent.po;

import lombok.Data;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 16:27
 * @Description: 表信息
 */
@Data
public class Table {

  /**
   * 表名
   */
  private String tableName;

  /**
   * 表注释
   */
  private String tableComment;

}
