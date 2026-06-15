package com.zzz.sessionapplication.util;

// Chuyên xử lí các chuỗi hợp lệ hoặc xử lí j đó ......
public class StringUtil {
  public static boolean isValid(String str) {
    return str != null && !str.isBlank();
  }

  public static boolean isInvalid(String str) {
    return !isValid(str);
  }

  // Hàm này dùng để chuyển đổi dữ liệu về chuỗi
  public static String cast(Object obj) {
    return obj.toString();
  }
}
