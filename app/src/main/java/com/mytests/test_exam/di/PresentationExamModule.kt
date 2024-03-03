package com.mytests.test_exam.di

import com.mytests.test_exam.presentation.list.view_model.AnimalFactsVM
import com.mytests.test_exam.presentation.profile.view_model.UserVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationExamModule = module {
    viewModel { UserVM(get()) }
    viewModel { AnimalFactsVM(get()) }
}