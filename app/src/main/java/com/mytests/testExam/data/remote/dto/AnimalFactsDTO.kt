package com.mytests.testExam.data.remote.dto

import kotlinx.serialization.*

@Serializable
data class AnimalFactsDTO(
    val status: AnimalFactsStatusDTO,
    @SerialName("_id")
    val id: String,
    val user: String,
    val text: String,
    val type: String,
    @Transient()
    val source: String = "",
    @Transient
    val used: Boolean = false,
    val deleted: Boolean,
    val createdAt: String,
    val updatedAt: String,
    @SerialName("__v")
    val v: Int
)