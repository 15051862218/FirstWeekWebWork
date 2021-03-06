package com.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 沈永康
 * @Date 2022/2/28 15:47
 * @Version 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Brand {
    private Integer id;
    /**
     * 品牌名称
     */
    private String brandName;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 排序字段
     */
    private Integer ordered;
    /**
     * 描述信息
     */
    private String description;
    /**
     * 状态：0：禁用  1：启用
     */
    private Integer status;

}
