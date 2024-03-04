package com.mytests.testExam.di

import com.mytests.testExam.presentation.list.view_model.AnimalFactsVM
import com.mytests.testExam.presentation.profile.view_model.UserVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationExamModule = module {
    viewModel { UserVM(get()) }
    viewModel { AnimalFactsVM(get()) }
}