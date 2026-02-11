package tn.studio.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TeamResultDTO::class],
    version = 1
)
abstract class ResultDatabase : RoomDatabase() {
    abstract fun resultDao(): ResultDao
}
