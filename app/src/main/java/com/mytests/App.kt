package com.mytests

import android.app.Application
import com.mytests.test_exam.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(dataExamModule,domainExamModule,presentationExamModule)
        }
    }
}