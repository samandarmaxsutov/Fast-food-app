package uz.it_school.fast_food_app.feature1.ui.screens.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.it_school.fast_food_app.feature1.model.room.AppDatabase

import uz.it_school.fast_food_app.feature1.model.shared.LocalStorage

class SplashScreenViewModel : ViewModel() {
    private val localStorage= LocalStorage.getLocalStorage()

    private val appDatabase=AppDatabase.getInstance()
    private val foodsList=FoodsList()
    val openMainScreenLiveData = MutableLiveData<Unit>()

    init {
        viewModelScope.launch {
            if (!localStorage.first){
                localStorage.first=true
                appDatabase.foodDao().insertAll(foodsList.foods)
            }
            delay(1500)

            openMainScreenLiveData.value=Unit

        }
    }
}