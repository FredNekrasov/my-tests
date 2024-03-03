package com.mytests.test_exam.di

import androidx.room.Room
import com.mytests.test_exam.data.local.MainDB
import com.mytests.test_exam.data.local.dao.IAnimalFactsDao
import com.mytests.test_exam.data.local.dao.IUserDao
import com.mytests.test_exam.data.remote.service.IAnimalFactsService
import com.mytests.test_exam.data.repository.AnimalFactsRepository
import com.mytests.test_exam.data.repository.UserRepository
import com.mytests.test_exam.domain.repository.IAnimalFactsRepository
import com.mytests.test_exam.domain.repository.IUserRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataExamModule = module {
    single {
        Retrofit.Builder().baseUrl(IAnimalFactsService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IAnimalFactsService::class.java)
    }
    single<MainDB> { Room.databaseBuilder(get(),MainDB::class.java,MainDB.DATABASE_NAME).allowMainThreadQueries().build() }
    single<IUserDao> { get<MainDB>().userDao }
    single<IAnimalFactsDao> { get<MainDB>().animalFactsDao }

    single<IAnimalFactsRepository> { AnimalFactsRepository(get(), get()) }
    single<IUserRepository> { UserRepository(get()) }
}