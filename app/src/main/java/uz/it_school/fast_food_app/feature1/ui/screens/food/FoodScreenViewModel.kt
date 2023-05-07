package uz.it_school.fast_food_app.feature1.ui.screens.food

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.fast_food_app.feature1.model.room.AppDatabase
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData
import kotlin.math.abs

class FoodScreenViewModel : ViewModel() {
    private val appDatabase= AppDatabase.getInstance()
    val foodLiveData= MediatorLiveData<FoodData>()
    var food: FoodData? = null
    fun add(){
        food?.let {
            FoodData(
                id=it.id,
                name = it.name,
                description = it.description,
                number = it.number+1,
                image = it.image,
                price = it.price,
                isFavorite = it.isFavorite
            )
        }?.let {
            appDatabase.foodDao().update(
                it
            )
        }
    }
    fun remove(){
        if (food!!.number>=1){
            food?.let {
                FoodData(
                    id=it.id,
                    name = it.name,
                    description = it.description,
                    number = it.number-1,
                    image = it.image,
                    price = it.price,
                    isFavorite = it.isFavorite
                )
            }?.let {
                appDatabase.foodDao().update(
                    it
                )
            }
        }
    }

    fun init(_food:FoodData){
        food=_food
        foodLiveData.addSource(appDatabase.foodDao().getFood(_food.id)){
            foodLiveData.value=it
            food=it
        }
    }

    fun buy(){
        food?.let {
            FoodData(
                id=it.id,
                name = it.name,
                description = it.description,
                number = it.number,
                image = it.image,
                price = it.price,
                isFavorite = !it.isFavorite
            )
        }?.let {
            appDatabase.foodDao().update(
                it
            )
        }
    }
    fun clear(){
        food?.let {
            FoodData(
                id=it.id,
                name = it.name,
                description = it.description,
                number = 0,
                image = it.image,
                price = it.price,
                isFavorite = it.isFavorite
            )
        }?.let {
            appDatabase.foodDao().update(
                it
            )
        }
    }
}