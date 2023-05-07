package uz.it_school.fast_food_app.feature1.app

import android.app.Application
import uz.it_school.fast_food_app.feature1.model.room.AppDatabase
import uz.it_school.fast_food_app.feature1.model.shared.LocalStorage

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.init(this)
        AppDatabase.init(this)
    }
}