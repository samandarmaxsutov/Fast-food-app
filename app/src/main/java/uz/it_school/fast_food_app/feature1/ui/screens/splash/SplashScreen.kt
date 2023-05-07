package uz.it_school.fast_food_app.feature1.ui.screens.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.it_school.fast_food_app.R

class SplashScreen : Fragment(R.layout.fragment_splash_screen) {

    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openMainScreenLiveData.observe(this){
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomeScreen())
        }
    }



}