package uz.it_school.fast_food_app.feature1.ui.screens.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import uz.it_school.fast_food_app.R
import uz.it_school.fast_food_app.databinding.FragmentHomeScreenBinding
import uz.it_school.fast_food_app.feature1.ui.screens.buy.BuyFoodsScreenDirections

class HomeScreen : Fragment(R.layout.fragment_home_screen) {
    private val viewModel: HomeScreenViewModel by viewModels()

    private var _binding: FragmentHomeScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val adapter=FoodsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.foodsLiveData.observe(viewLifecycleOwner){
            adapter.submitNewFoods(it)
        }

        binding.listItem.adapter=adapter
        binding.starFood.setOnClickListener { findNavController().navigate(HomeScreenDirections.actionHomeScreenToBuyFoodsScreen()) }
        adapter.onClickListener { findNavController().navigate(HomeScreenDirections.actionHomeScreenToFoodScreen(it)) }
    }
}