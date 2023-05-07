package com.github.tor1ant.later.item;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ItemRepositoryImp implements ItemRepository {
    private long itemId = 0;
    Map<Long, List<Item>> itemMap = new HashMap<>();

    @Override
    public List<Item> findByUserId(long userId) {
        return itemMap.getOrDefault(userId, Collections.emptyList());
    }

    @Override
    public Item save(Item item) {
        item.setId(itemId++);
        itemMap.compute(item.getUserId(), (userId, userItems) -> {
            if(userItems == null) {
                userItems = new ArrayList<>();
            }
            userItems.add(item);
            return userItems;
        });

        return item;
    }

    @Override
    public void deleteByUserIdAndItemId(long userId, long itemId) {
        if(itemMap.containsKey(userId)) {
            List<Item> userItems = itemMap.get(userId);
            userItems.removeIf(item -> item.getId().equals(itemId));
        }
    }

}
