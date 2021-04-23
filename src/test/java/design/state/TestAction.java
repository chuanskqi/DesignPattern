package design.state;

import java.util.ArrayList;
import java.util.List;

public class TestAction {
    public static void main(String[] args) {

        TableElement element1 = new TableElement();
        element1.setTableName("state");
        element1.setRowNum(0);
        element1.setColumnNum(0);
        element1.setValue("1");

        TableElement element2 = new TableElement();
        element2.setTableName("state");
        element2.setRowNum(1);
        element2.setColumnNum(1);
        element2.setValue("3");

        List<TableElement> list = new ArrayList<>();
        list.add(element1);
        list.add(element2);

        String[][] state = new String[4][3];

        for (TableElement element : list) {
            state[element.getRowNum()][element.getColumnNum()] = element.getValue();
        }

        int dbState = 1;

        //执行后的结果
        String result = state[1][1];

        System.out.println(result);
        System.out.println(result);

    }
}


class TableElement {
    private String tableName;
    private int rowNum;
    private int columnNum;
    private String value;


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColumnNum() {
        return columnNum;
    }

    public void setColumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
