package uz.it_school.fast_food_app.feature1.model.room.enitiies

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "foods")
data class FoodData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val image: Int,
    val description: String,
    val price: Double,
    val isFavorite:Boolean,
    val number:Int

):Serializable
