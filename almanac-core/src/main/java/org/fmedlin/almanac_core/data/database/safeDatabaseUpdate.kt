package org.fmedlin.almanac_core.data.database

import android.database.sqlite.SQLiteException
import org.fmedlin.almanac_core.domain.util.DataError
import org.fmedlin.almanac_core.domain.util.Result

suspend inline fun <T> safeDatabaseUpdate(update: suspend () -> T): Result<T, DataError.Local> {
    return try {
        Result.Success(update())
    } catch(e: SQLiteException) {
        Result.Failure(DataError.Local.DISK_FULL)
    }
}