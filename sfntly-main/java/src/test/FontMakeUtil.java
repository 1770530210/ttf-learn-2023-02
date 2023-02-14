package test;

import com.google.typography.font.tools.sfnttool.SfntTool;

import java.io.File;
import java.io.IOException;

/**
 * @author: Administrator
 * @date: 2021/03/13 21:37
 * @description:
 */
public class FontMakeUtil {
  static File file = null;

  /**
   * ��������: <br>
   * ����words�ַ������ַ�����Ϊһ���ֿ⣬fileSrcΪ�����ֿ����·����fileDesΪ�����ֿ����·����
   * 
   * @Param: [words, fileSrc, fileDes]
   * @Return: void
   * @Author: Administrator
   * @Date: 2021/03/15 21:24
   */
  public static void convertToSmallFontFile(String words, String fileSrc, String fileDes) {
    boolean isExist = (file = new File(fileDes)).exists();
    if (isExist) {
      file.delete();
    }
    String[] args = new String[4];
    args[0] = "-s";
    args[1] = words;
    args[2] = fileSrc;
    args[3] = fileDes;
    try {
      SfntTool.main(args);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    fontConvert("abcdefg ��ã����죡");
  }

  public static void fontConvert(String words) {
    String fileSrc = "D:/ttt.ttf";
    File file = new File("D:/msy.ttf");
    if (file.exists()) {
      file.delete();
    }
    FontMakeUtil.convertToSmallFontFile(words, fileSrc, "D:/msy.ttf");
  }

}
