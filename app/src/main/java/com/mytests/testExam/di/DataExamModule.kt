package com.mytests.testExam.di

import androidx.room.Room
import com.mytests.testExam.data.local.ExamDb
import com.mytests.testExam.data.remote.service.AnimalFactsClient
import com.mytests.testExam.data.repository.*
import com.mytests.testExam.domain.repository.*
import org.koin.dsl.module

val dataExamModule = module {
    single {
        AnimalFactsClient.client
    }
    single<ExamDb> {
        Room.databaseBuilder(get(), ExamDb::class.java, ExamDb.DATABASE_NAME)
            .allowMainThreadQueries()
            .build()
    }
    single<IAnimalFactsRepository> {
        AnimalFactsRepository(get<ExamDb>().animalFactsDao, get())
    }
    single<IUserRepository> {
        UserRepository(get<ExamDb>().userDao)
    }
}