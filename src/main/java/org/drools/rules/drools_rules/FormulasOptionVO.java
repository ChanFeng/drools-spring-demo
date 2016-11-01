package org.drools.rules.drools_rules;

import java.io.Serializable;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description: 金额计算公式中的各个选项
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2011-2014 OlymTech (NingBo)
 * </p>
 * 
 * <p>
 * DateTime: 2014-3-14下午06:06:35
 * </p>
 * 
 * @author  zixuan
 * @version 1.0
 */
public class FormulasOptionVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5538000910769453802L;
	
	private Double exchange_rate;  	// 汇率
	private Double number;			// 件数
	private Double volume;			// 立方
	private Double weight;			// 重量(吨)
	private Double unit_price;		// 单价
	private String tuo;				// 托
	private String ctn;				// 箱型
	private String customer;		// 客户关系
	private String privacy;			// 私人物品
	private String packingType;		// 包装类型
	private String collectingFees;  // 代收费用

	private Double total;			// 总计
	private Double itemTotal;       // 小计
	
	public Double getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(Double exchangeRate) {
		exchange_rate = exchangeRate;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}

	public String getTuo() {
		return tuo;
	}
	public void setTuo(String tuo) {
		this.tuo = tuo;
	}
	public String getCtn() {
		return ctn;
	}
	public void setCtn(String ctn) {
		this.ctn = ctn;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getPackingType() {
		return packingType;
	}
	public void setPackingType(String packingType) {
		this.packingType = packingType;
	}
	public String getCollectingFees() {
		return collectingFees;
	}
	public void setCollectingFees(String collectingFees) {
		this.collectingFees = collectingFees;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getItemTotal() {
		return itemTotal;
	}

	public void setItemTotal(Double itemTotal) {
		this.itemTotal = itemTotal;
	}
}
