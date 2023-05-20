package com.github.tor1ant.later.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCountByUser {

    private Long userId;

    private Long count;

    public ItemCountByUser(Long userId, Long count) {
        this.userId = userId;
        this.count = count;
    }

}