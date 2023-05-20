package com.github.tor1ant.later.item;

import com.github.tor1ant.later.user.User;
import com.github.tor1ant.later.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final UserRepository userRepository;

    @Override
    public List<ItemDto> getItems(long userId) {
        List<Item> userItems = repository.findByUserId(userId);
        return ItemMapper.mapToItemDto(userItems);
    }

    @Transactional
    @Override
    public ItemDto addNewItem(long userId, ItemDto itemDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Item item = repository.save(ItemMapper.mapToItem(itemDto, user));
        return ItemMapper.mapToItemDto(item);
    }

    @Transactional
    @Override
    public void deleteItem(long userId, long itemId) {
        repository.deleteByUserIdAndId(userId, itemId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getItems(long userId, Set<String> tags) {
/*        BooleanExpression byUserId = QItem.item.user.id.eq(userId);
        BooleanExpression byAnyTag = QItem.item.tags.any().in(tags);
        Iterable<Item> foundItems = repository.findAll(byUserId.and(byAnyTag));
        return ItemMapper.mapToItemDto(foundItems);*/
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemDto> getUserItems(String lastName) {
        List<Item> foundItems = repository.findItemsByLastNamePrefix(lastName);
        return ItemMapper.mapToItemDto(foundItems);
    }
}
