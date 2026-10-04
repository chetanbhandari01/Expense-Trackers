package com.chetanbhandari.expensemanager.initializer

import DatastoreModule
import DispatcherModule
import android.content.Context
import androidx.startup.Initializer
import com.chetanbhandari.expensemanager.core.data.di.ActivityModule
import com.chetanbhandari.expensemanager.core.data.di.AppModule
import com.chetanbhandari.expensemanager.core.data.di.RepositoryModule
import com.chetanbhandari.expensemanager.core.database.di.DatabaseModule
import com.chetanbhandari.expensemanager.core.domain.usecase.di.UseCaseModule
import com.chetanbhandari.expensemanager.core.navigation.NavigationModule
import com.chetanbhandari.expensemanager.core.notification.NotificationModule
import com.chetanbhandari.expensemanager.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication = startKoin {
        androidLogger()
        androidContext(context)
        modules(
            AppModule,
            ActivityModule,
            DispatcherModule,
            DatastoreModule,
            RepositoryModule,
            UseCaseModule,
            DatabaseModule,
            NavigationModule,
            ViewModelModule,
            NotificationModule,
        )
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> = emptyList()
}
