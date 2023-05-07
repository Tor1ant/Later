package com.github.tor1ant.later.item;

import lombok.Data;

@Data
class Item {
    private Long id;
    private Long userId;
    private String url;
}