package com.entity;

/**
 * This file is used as Goods model, entity goods has goodId, goodName,
 * goodPrice, goodPictures according to table goods in database.
 * ProjectName：SecondaryTradingSystem ClassName：Goods ClassDescription：
 * Author：Pancake CreateTime：2017年1月23日 上午5:53:07
 * 
 * @version
 */
public class Goods {
	private int goodId;
	private String goodName;
	private double goodPrice;
	private String goodPictures;

	public Goods() {
		super();
	}

	public Goods(int goodId, String goodName, double goodPrice,
			String goodPictures) {
		super();
		this.goodId = goodId;
		this.goodName = goodName;
		this.goodPrice = goodPrice;
		this.goodPictures = goodPictures;
	}

	@Override
	public String toString() {
		return "GoodId: " + this.goodId + ", GoodName: " + this.goodName
				+ ", GoodPrice: " + this.goodPrice;
	}

	public int getGoodId() {
		return goodId;
	}

	public void setGoodId(int goodId) {
		this.goodId = goodId;
	}

	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}

	public double getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}

	public String getGoodPictures() {
		return goodPictures;
	}

	public void setGoodPictures(String goodPictures) {
		this.goodPictures = goodPictures;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
