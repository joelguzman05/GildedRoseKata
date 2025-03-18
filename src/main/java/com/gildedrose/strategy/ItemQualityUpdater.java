package com.gildedrose.strategy;

import com.gildedrose.Item;

public abstract class ItemQualityUpdater {

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;
    protected static final int SELL_DATE = 0;

    public abstract void updateQuality(Item item);

    protected void decreaseQuality(Item item) {
        if (item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    protected void setQualityToZero(Item item) {
        item.quality = MIN_QUALITY;
    }
}
