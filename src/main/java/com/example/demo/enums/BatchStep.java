package com.example.demo.enums;

/**
 * 对账步骤
 */
public enum BatchStep {

    DOWN("对账单下载", "1"),
    PARSE("账单文件解析", "2"),
    CHECK("流水核对", "3"),
    CREATE("生成账单", "4"),
    SUCCESS("成功", "5"),
    FAIL("失败","6"),

    ;

    private String desc;

    public String getStep() {
        return step;
    }

    private String step;

    private BatchStep(String desc, String step) {
        this.desc = desc;
        this.step = step;
    }
}
