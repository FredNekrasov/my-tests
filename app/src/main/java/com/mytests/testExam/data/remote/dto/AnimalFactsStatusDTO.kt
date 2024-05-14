package com.mytests.testExam.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AnimalFactsStatusDTO(
    val verified: Boolean?,
    val sentCount: Int
)