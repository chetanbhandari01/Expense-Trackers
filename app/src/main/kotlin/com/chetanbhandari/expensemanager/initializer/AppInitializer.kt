package com.chetanbhandari.expensemanager.initializer

import android.content.Context
import androidx.startup.Initializer
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.locale.ApplyLocaleUseCase
import com.chetanbhandari.expensemanager.core.domain.usecase.settings.theme.ApplyThemeUseCase
import com.chetanbhandari.expensemanager.core.notification.NotificationScheduler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext

class AppInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        val applyThemeUseCase: ApplyThemeUseCase = GlobalContext.get().get()
        val applyLocaleUseCase: ApplyLocaleUseCase = GlobalContext.get().get()
        val notificationScheduler: NotificationScheduler = GlobalContext.get().get()

        CoroutineScope(SupervisorJob() + Dispatchers.Main).launch {
            applyThemeUseCase.invoke()
            applyLocaleUseCase.invoke()
            notificationScheduler.checkAndRestartReminder()
            notificationScheduler.scheduleWeeklySummary()
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(
        KoinInitializer::class.java,
    )
}
