package code.generator.types.utils;

/**
 * @Author: hehongyi
 * @Date: 2024/7/30 17:02
 * @Description: 通用工具类
 */
public class CommonUtils {
  /**
   * 下划线转驼峰
   *
   * @param input       输入字符串
   * @param toUpperCase 首字母是否大写
   * @return 驼峰命名字符串
   */
  public static String underlineToCamel(String input, Boolean toUpperCase) {
    if (input == null || input.isEmpty()) {
      return input;
    }
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '_') {
        toUpperCase = true;
      } else {
        if (toUpperCase) {
          result.append(Character.toUpperCase(c));
          toUpperCase = false;
        } else {
          result.append(c);
        }
      }
    }

    return result.toString();
  }

}
