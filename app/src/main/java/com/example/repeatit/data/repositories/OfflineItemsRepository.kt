package com.example.repeatit.data.repositories

import com.example.repeatit.data.dao.ItemDao
import com.example.repeatit.data.entities.Item
import kotlinx.coroutines.flow.Flow

class OfflineItemsRepository(private val itemDao: ItemDao) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = itemDao.getAllItems()
    override fun getItemsById(id: Int?): Flow<List<Item>> = itemDao.getItemsById(id)
    override fun getItemStream(id: Int): Flow<Item?> = itemDao.getItem(id)

    override suspend fun insertItem(item: Item) = itemDao.insert(item)

    override suspend fun updateItem(item: Item) = itemDao.update(item)

    override suspend fun deleteItem(item: Item) = itemDao.delete(item)

}