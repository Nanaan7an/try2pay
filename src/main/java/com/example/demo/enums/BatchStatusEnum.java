package com.example.demo.enums;

/**
 * 执行状态
 * 1-4：对账步骤
 * 5-6：对账执行状态
 */
public enum BatchStatusEnum {

    DOWN("下载账单","1"),
    PARSE("解析账单","2"),
    CHECK("流水核对", "3"),
    CREATE("生成账单", "4"),
    SUCCESS("成功", "5"),
    FAIL("失败", "6"),
    ;

    private String desc;

    public String getSts() {
        return sts;
    }

    private String sts;

    private BatchStatusEnum(String desc, String sts) {
        this.desc = desc;
        this.sts = sts;
    }
}
