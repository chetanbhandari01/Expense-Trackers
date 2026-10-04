package com.chetanbhandari.expensemanager.core.repository

interface ActivityComponentProvider {

    fun getBackupRepository(): BackupRepository

    fun getShareRepository(): ShareRepository
}
