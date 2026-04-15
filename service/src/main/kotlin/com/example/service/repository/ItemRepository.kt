package com.example.service.repository

import com.example.service.entity.Item
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped

@ApplicationScoped
class ItemRepository : PanacheRepository<Item>
