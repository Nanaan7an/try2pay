package com.example.demo.service.pay;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.Pay;

public interface PayService {

    /**
     * 提交支付，创建支付流水，pay_sts应为I
     *
     * @param order 订单信息
     * @return 支付信息
     */
    int submit(Order order);

    /**
     * 发起关单，pay_sts应为C
     *
     * @param pay 支付信息
     * @return 支付信息
     */
    Pay close(Pay pay);

    /**
     * 用户发起支付，pay_sts应为P
     *
     * @param pay 支付信息
     * @return 支付信息
     */
    Pay pay(Pay pay);

    /**
     * 发起退款，成功后pay_sts应为R
     *
     * @param pay 支付信息
     * @return 支付信息
     */
    Pay refund(Pay pay);

    /**
     * 查询，pay_sts应以通道状态为准
     *
     * @param pay 支付信息
     * @return 支付信息
     */
    Pay query(Pay pay);
}
