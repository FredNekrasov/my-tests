package com.mytests.testExam.di

import androidx.room.Room
import com.mytests.testExam.data.local.ExamDb
import com.mytests.testExam.data.local.dao.IAnimalFactsDao
import com.mytests.testExam.data.local.dao.IUserDao
import com.mytests.testExam.data.remote.service.IAnimalFactsService
import com.mytests.testExam.data.repository.AnimalFactsRepository
import com.mytests.testExam.data.repository.UserRepository
import com.mytests.testExam.domain.repository.IAnimalFactsRepository
import com.mytests.testExam.domain.repository.IUserRepository
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
    single<ExamDb> { Room.databaseBuilder(get(), ExamDb::class.java, ExamDb.DATABASE_NAME).allowMainThreadQueries().build() }
    single<IUserDao> { get<ExamDb>().userDao }
    single<IAnimalFactsDao> { get<ExamDb>().animalFactsDao }

    single<IAnimalFactsRepository> { AnimalFactsRepository(get(), get()) }
    single<IUserRepository> { UserRepository(get()) }
}