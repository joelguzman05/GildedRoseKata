package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    private static final String STANDARD_ITEM = "Standard Item";
    private static final String AGED_BRIE = "Aged Brie";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";


    @Test
    void testStandardItemQualityDecreasesBeforeSellDate() {
        Item[] items = new Item[] { new Item(STANDARD_ITEM, 3, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(4, items[0].quality);
    }

    @Test
    void testStandardItemQualityDecreasesTwiceAfterSellDate() {
        Item[] items = new Item[] { new Item(STANDARD_ITEM, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(3, items[0].quality);
    }

    @Test
    void testStandardItemQualityNeverNegative() {
        Item[] items = new Item[] { new Item(STANDARD_ITEM, 3, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testAgedBrieQualityIncreasesBeforeSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 3, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void testAgedBrieQualityIncreasesTwiceAfterSellDate() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void testAgedBrieQualityNeverExceedsFifty() {
        Item[] items = new Item[] { new Item(AGED_BRIE, 3, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(2, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void testSulfurasQualityAndSellInNeverChange() {
        Item[] items = new Item[] { new Item(SULFURAS, 3, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(3, items[0].sellIn);
        assertEquals(80, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIncreasesWhenMoreThanTenDaysLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 11, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(10, items[0].sellIn);
        assertEquals(6, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIncreasesTwiceWhenTenDaysOrLessLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 10, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(9, items[0].sellIn);
        assertEquals(7, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityIncreasesThriceWhenFiveDaysOrLessLeft() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(8, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityDropsToZeroAfterSellDate() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(-1, items[0].sellIn);
        assertEquals(0, items[0].quality);
    }

    @Test
    void testBackstagePassesQualityNeverExceedsFifty() {
        Item[] items = new Item[] { new Item(BACKSTAGE_PASSES, 5, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();

        assertEquals(4, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }
}
