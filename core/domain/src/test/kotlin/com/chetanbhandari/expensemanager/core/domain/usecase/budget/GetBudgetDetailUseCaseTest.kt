package com.chetanbhandari.expensemanager.core.domain.usecase.budget

import com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency.GetCurrencyUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.currency.GetFormattedAmountUseCase
import com.chetanbhandari.expensemanager.core.repository.CurrencyRepository
import com.chetanbhandari.expensemanager.core.repository.TransactionRepository
import com.chetanbhandari.expensemanager.core.testing.BaseCoroutineTest
import org.junit.Test
import org.mockito.kotlin.mock

class GetBudgetDetailUseCaseTest : BaseCoroutineTest() {

    private val transactionRepository: TransactionRepository = mock()
    private val currencyRepository: CurrencyRepository = mock()

    private val getCurrencyUseCase = GetCurrencyUseCase(currencyRepository)
    private val getFormattedAmountUseCase = GetFormattedAmountUseCase(currencyRepository)

    private lateinit var getBudgetDetailUseCase: GetBudgetDetailUseCase

    @Test
    fun whenAllDataAvailableItShouldSendSuccessResult() {
    }
}
