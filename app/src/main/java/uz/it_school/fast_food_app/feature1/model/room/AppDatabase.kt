package uz.it_school.fast_food_app.feature1.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.it_school.fast_food_app.feature1.model.room.daos.FoodDao
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData

@Database(entities = [FoodData::class], version = 1)
abstract class AppDatabase:RoomDatabase() {

    companion object{

        private var INSTANCE:AppDatabase? = null

        fun init(context: Context){
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,AppDatabase::class.java,"AppDatabase")
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getInstance():AppDatabase= INSTANCE!!
    }

    abstract fun foodDao(): FoodDao
}