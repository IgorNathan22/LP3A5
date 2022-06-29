package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class GildedRoseTest {

    @Test
    void foo() {
    	List<Item> items = new ArrayList<>();
    	items.add(new Item("foo", 0, 0));
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items.get(0).name);
    }

}
