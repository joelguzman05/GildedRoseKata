package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.strategy.AgedBrieQualityUpdater;
import com.gildedrose.strategy.BackstagePassesQualityUpdater;
import com.gildedrose.strategy.ConjuredQualityUpdater;
import com.gildedrose.strategy.ItemQualityUpdater;
import com.gildedrose.strategy.StandardItemQualityUpdater;
import com.gildedrose.strategy.SulfurasQualityUpdater;

public class ItemQualityUpdaterFactory {

    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private static final String CONJURED = "Conjured Mana Cake";

    public static ItemQualityUpdater createItemQualityUpdater(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                return new AgedBrieQualityUpdater();
            case BACKSTAGE_PASSES:
                return new BackstagePassesQualityUpdater();
            case SULFURAS:
                return new SulfurasQualityUpdater();
            case CONJURED:
                return new ConjuredQualityUpdater();
            default:
                return new StandardItemQualityUpdater();
        }
    }
}
