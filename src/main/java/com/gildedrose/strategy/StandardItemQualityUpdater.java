package com.gildedrose.strategy;

import com.gildedrose.Item;

public class StandardItemQualityUpdater extends ItemQualityUpdater {

    @Override
    public void updateQuality(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        if (item.sellIn < SELL_DATE) {
            decreaseQuality(item);
        }
    }
}
