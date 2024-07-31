package code.generator.domain.builder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 16:47
 * @Description: 表实体
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableEntity {
  /**
   * 表名
   */
  private String tableName;

  /**
   * 表注释
   */
  private String tableComment;
}
