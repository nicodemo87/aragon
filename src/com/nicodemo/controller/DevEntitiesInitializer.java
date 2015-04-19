/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nicodemo.controller;

import com.nicodemo.model.Item;
import com.nicodemo.persistence.DAOs.CashBoxesDAO;
import com.nicodemo.persistence.DAOs.ItemsDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Nico
 */
public class DevEntitiesInitializer {
    private ItemsDAO itemsDAO;
    private CashBoxesDAO cashBoxesDAO;

    @Autowired
    public DevEntitiesInitializer(ItemsDAO itemsDAO, CashBoxesDAO cashBoxesDAO) {
        this.itemsDAO = itemsDAO;
        this.cashBoxesDAO = cashBoxesDAO;
    }

    public void Initialize() {
        Item item1 = new Item("123", "CocaCola 600ml", 10, 15, 10);
        Item item2 = new Item("321", "Aljajor Jorgito Choco", 5, 8, 10);
        Item item3 = new Item("213", "Chicles Beldent Menta", 5, 6, 10);

        itemsDAO.save(item1);
        itemsDAO.save(item2);
        itemsDAO.save(item3);
    }
}