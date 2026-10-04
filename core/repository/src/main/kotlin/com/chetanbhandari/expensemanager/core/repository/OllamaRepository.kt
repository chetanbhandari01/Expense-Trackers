package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.Resource

interface OllamaRepository {
    suspend fun getSpendingExplanation(
        summary: String,
        baseUrl: String = "http://10.186.159.1:11434",
        model: String = "qwen:7b" // default model
    ): Resource<String>
}
