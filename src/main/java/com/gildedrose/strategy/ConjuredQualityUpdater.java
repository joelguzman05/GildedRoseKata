package com.gildedrose.strategy;

import com.gildedrose.Item;

public class ConjuredQualityUpdater extends ItemQualityUpdater {

    @Override
    public void updateQuality(Item item) {
        decreaseSellIn(item);
        decreaseQuality(item);
        decreaseQuality(item);
    }
}
