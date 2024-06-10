package com.deaenita.posfinalproject.api

data class Barang(
    val id: String?,
    val name: String,
    val price: Double?,
    val qty: Int?,
    val description: String
)

data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T
)

data class DeleteRequest(
    val action: String = "delete",
    val id: String
)