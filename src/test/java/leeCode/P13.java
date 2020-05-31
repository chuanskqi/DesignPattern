package leeCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class P13 {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
    }

    /**
     * 罗马数字转为阿拉伯数字
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        int total = 0;
        int before = getValue(s.charAt(0));
        for (int x = 1; x < s.length(); x++) {
            //前一个字符比后一个字符大
            int current = getValue(s.charAt(x));
            if (before < current) {
                total -= before;
            } else {
                total += before;
            }
            before = current;
        }
        total += before;
        return total;
    }

    private int getValue(char num) {
        switch (num) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
