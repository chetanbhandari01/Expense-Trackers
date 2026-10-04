package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.Resource

interface OllamaRepository {
    suspend fun getSpendingExplanation(
        summary: String,
        baseUrl: String = "http://10.0.2.2:11434",
        model: String = "gemma3:4b" // default model
    ): Resource<String>
}
