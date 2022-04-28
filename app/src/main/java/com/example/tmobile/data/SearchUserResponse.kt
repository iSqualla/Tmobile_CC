package com.example.tmobile.data

data class SearchUserResponse(
    val incomplete_results: Boolean,
    val items: List<SearchResponseItem>,
    val total_count: Int
)