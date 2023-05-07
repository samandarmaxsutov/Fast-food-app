package uz.it_school.fast_food_app.feature1.model.room.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData

@Dao
interface FoodDao {
    @Query("select * from foods")
    fun getAllFoods(): LiveData<List<FoodData>>
    @Query("select * from foods  where isFavorite=1")
    fun getAllBuyFoods(): LiveData<List<FoodData>>

    @Query("select * from foods where id=:id")
    fun getFood(id:Int): LiveData<FoodData>


    @Insert
    fun insertAll(foods: List<FoodData>)
    @Update
    fun updateAll(foods: List<FoodData>)
    @Insert
    fun insert(food: FoodData)
    @Update
    fun update(food: FoodData)

}