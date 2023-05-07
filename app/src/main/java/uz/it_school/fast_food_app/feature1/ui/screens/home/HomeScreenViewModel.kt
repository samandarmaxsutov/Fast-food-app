package uz.it_school.fast_food_app.feature1.ui.screens.home

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.it_school.fast_food_app.feature1.app.App
import uz.it_school.fast_food_app.feature1.model.room.AppDatabase
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData

class HomeScreenViewModel : ViewModel() {
  private val appDatabase:AppDatabase= AppDatabase.getInstance()
  val foodsLiveData=MediatorLiveData<List<FoodData>>()

  init {
      foodsLiveData.addSource(appDatabase.foodDao().getAllFoods()){
        foodsLiveData.value=it
      }
  }
}