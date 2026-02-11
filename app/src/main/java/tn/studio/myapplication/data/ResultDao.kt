package tn.studio.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertResult(result: TeamResultDTO)

    @Query("SELECT * FROM results")
    fun getAllResults(): List<TeamResultDTO>
}