package com.chetanbhandari.expensemanager.core.repository

import com.chetanbhandari.expensemanager.core.model.Resource

interface BackupRepository {

    fun backupData(uri: String?): Resource<Boolean>

    fun restoreData(uri: String?): Resource<Boolean>
}
