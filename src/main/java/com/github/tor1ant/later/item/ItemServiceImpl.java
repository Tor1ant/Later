package com.github.tor1ant.later.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    @Override
    public List<Item> getItem(long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public Item addItem(Long userId, Item item) {
        item.setUserId(userId);
        return repository.save(item);
    }

    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndItemId(userId, itemId);
    }
}
