package com.example.repeatit.data.repositories

import com.example.repeatit.data.dao.UserDao
import com.example.repeatit.data.entities.Item
import com.example.repeatit.data.entities.User
import kotlinx.coroutines.flow.Flow

class OfflineUsersRepository(private val userDao: UserDao) : UsersRepository {
    override fun getUserStream(id: Int): Flow<User?>  = userDao.getUser(id)

    override suspend fun insertUser(user: User) = userDao.insert(user)

    override suspend fun updateUser(user: User) = userDao.update(user)

    override suspend fun deleteUser(user: User) = userDao.delete(user)
}