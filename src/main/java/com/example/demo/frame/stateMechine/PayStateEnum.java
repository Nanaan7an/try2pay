package com.example.demo.frame.stateMechine;

/**
 * 支付流水状态枚举类
 */
public enum PayStateEnum {
    /**
     * 初始化，此时未提交支付申请
     */
    INITIAL("INITIAL", "I"),
    /**
     * 处理中，此时已提交支付申请，但无支付结果
     */
    PROCESS("PROCESS", "P"),
    /**
     * 支付结果-支付成功
     */
    SUCCESS("SUCCESS", "S"),
    /**
     * 支付结果-支付失败
     */
    FAILURE("FAILURE", "F"),
    /**
     * 已关单，初始化但未支付的订单可以提交关单
     */
    CLOSED("CLOSED", "C"),
    /**
     * 已退款，支付成功的订单可以申请退款
     */
    REFUNDED("REFUNDED", "R"),

    /**
     * 处理中变迁至S\F用到的中间状态，没有任何实际意义，仅仅是为了分支
     */
    PROCESS_CHOICE("PROCESS_CHOICE", "PC"),
    ;


    private String shortName;
    private String name;

    PayStateEnum(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    /**
     * 根据缩写获取全称
     *
     * @param shortName 缩写
     * @return 全称
     */
    public static String findName(String shortName) {
        for (PayStateEnum item : PayStateEnum.values()) {
            if (shortName.equals(item.getShortName()))
                return item.getName();
        }
        return null;
    }

    /**
     * 根据全称获取缩写
     *
     * @param name 全称
     * @return 缩写
     */
    public static String findShortName(String name) {
        for (PayStateEnum item : PayStateEnum.values()) {
            if (name.equals(item.getName()))
                return item.getShortName();
        }
        return null;
    }
}
