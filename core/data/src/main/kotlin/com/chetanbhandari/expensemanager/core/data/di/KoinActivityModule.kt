package com.chetanbhandari.expensemanager.core.data.di

import android.app.Activity
import com.chetanbhandari.expensemanager.core.data.repository.BackupRepositoryImpl
import com.chetanbhandari.expensemanager.core.data.repository.ShareRepositoryImpl
import com.chetanbhandari.expensemanager.core.database.ExpenseManagerDatabase
import com.chetanbhandari.expensemanager.core.repository.ActivityComponentProvider
import com.chetanbhandari.expensemanager.core.repository.BackupRepository
import com.chetanbhandari.expensemanager.core.repository.ShareRepository
import de.raphaelebner.roomdatabasebackup.core.RoomBackup
import org.koin.androidx.scope.dsl.activityScope
import org.koin.dsl.module

val ActivityModule = module {
    activityScope {
        scoped { RoomBackup(context = get<Activity>()) }
        scoped<BackupRepository> {
            BackupRepositoryImpl(
                roomBackup = get<RoomBackup>(),
                database = get<ExpenseManagerDatabase>(),
            )
        }
        scoped<ShareRepository> {
            ShareRepositoryImpl(
                context = get<Activity>(),
                firebaseSettingsRepository = get(),
            )
        }
        scoped<ActivityComponentProvider> {
            val backupRepository: BackupRepository = get()
            val shareRepository: ShareRepository = get()

            return@scoped object : ActivityComponentProvider {
                override fun getBackupRepository() = backupRepository
                override fun getShareRepository() = shareRepository
            }
        }
    }
}
