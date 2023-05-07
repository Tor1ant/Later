package com.github.tor1ant.later.item;

import java.util.List;

public interface ItemService {

    List<Item> getItem(long userId);

    Item addItem(Long userId,Item item);

    void deleteItem(long userId, long itemId);
}
