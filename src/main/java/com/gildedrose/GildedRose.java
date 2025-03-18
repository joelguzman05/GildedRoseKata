package com.gildedrose;

import com.gildedrose.factory.ItemQualityUpdaterFactory;
import com.gildedrose.strategy.ItemQualityUpdater;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemQualityUpdater updater = ItemQualityUpdaterFactory.createItemQualityUpdater(item);
            updater.updateQuality(item);
        }
    }
}