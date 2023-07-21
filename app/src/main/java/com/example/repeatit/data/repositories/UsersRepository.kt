package com.example.repeatit.data.repositories

import com.example.repeatit.data.entities.Item
import com.example.repeatit.data.entities.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    fun getUserStream(id: Int): Flow<User?>

    suspend fun insertUser(user: User)

    suspend fun updateUser(user: User)

    suspend fun deleteUser(user: User)
}