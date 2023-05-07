package uz.it_school.fast_food_app.feature1.ui.screens.buy

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.fast_food_app.feature1.model.room.AppDatabase
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData

class BuyFoodsScreenViewModel : ViewModel() {
    private val appDatabase: AppDatabase = AppDatabase.getInstance()
    val foodsLiveData= MediatorLiveData<List<FoodData>>()

    init {
        foodsLiveData.addSource(appDatabase.foodDao().getAllBuyFoods()){
            foodsLiveData.value=it
        }
    }
}