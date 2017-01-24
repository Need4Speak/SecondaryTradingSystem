package com.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.entity.Goods;

public class GoodsDAOTest {

	@Test
	public void testGetAllGoods() {
		
		ArrayList<Goods> goodsList = GoodsDAO.getAllGoods();
		Iterator<Goods> goodsListIterator = goodsList.iterator();
		Goods each_good;
        while(goodsListIterator.hasNext()){
        	each_good = (Goods) goodsListIterator.next();
            System.out.println(each_good);
        }
	}
	
	@Test
	public void testGetGoodsById(){
		Goods aGood = GoodsDAO.getGoodsById(2);
		System.out.println(aGood);
	}
}
