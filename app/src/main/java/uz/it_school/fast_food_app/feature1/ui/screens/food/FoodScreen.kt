package uz.it_school.fast_food_app.feature1.ui.screens.food

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import uz.it_school.fast_food_app.R
import uz.it_school.fast_food_app.databinding.FragmentFoodScreenBinding


class FoodScreen : Fragment(R.layout.fragment_food_screen) {

    private val viewModel: FoodScreenViewModel by viewModels()

    private val args :FoodScreenArgs by navArgs()
    private var _binding: FragmentFoodScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFoodScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.desFood.text=args.food.description
        binding.priceFood.text=args.food.price.toString()+" $"
        binding.foodName.text=args.food.name
        if (args.food.isFavorite){
            binding.starFood.setImageResource(R.drawable.is_fav)
            binding.buy.text="cancel"
            binding.buy.setBackgroundColor(Color.parseColor("#DD2C00"))

        }
        else {
            binding.buy.text="buy"
            binding.buy.setBackgroundColor(Color.parseColor("#2962FF"))
            binding.starFood.setImageResource(R.drawable.disfav)
        }
        binding.imageFood.setImageResource(args.food.image)
        binding.numbers.text=args.food.number.toString()
        binding.totalPrice.text=(args.food.number*args.food.price).toString()+" $"

        viewModel.init(args.food)
        viewModel.foodLiveData.observe(viewLifecycleOwner){food->
            binding.desFood.text=food.description
            binding.priceFood.text=food.price.toString()+" $"
            binding.foodName.text=food.name
            if (food.isFavorite){
                binding.starFood.setImageResource(R.drawable.is_fav)
                binding.buy.text="cancel"
                binding.buy.setBackgroundColor(Color.parseColor("#DD2C00"))

            }
            else {
                binding.buy.text="buy"
                binding.buy.setBackgroundColor(Color.parseColor("#2962FF"))
                binding.starFood.setImageResource(R.drawable.disfav)
            }
            if (food.number>=1){
                binding.clear.visibility=View.VISIBLE
                binding.buy.visibility=View.VISIBLE
                binding.buy.isClickable=true
            }else{
                binding.clear.visibility=View.GONE
                binding.buy.visibility=View.GONE
                binding.buy.isClickable=false
            }

            binding.imageFood.setImageResource(food.image)
            binding.numbers.text=food.number.toString()
            binding.totalPrice.text=(food.number*food.price).toString()+" $"
        }

        binding.addBtn.setOnClickListener{
            viewModel.add()
        }
        binding.minusBtn.setOnClickListener{
            viewModel.remove()
        }
        binding.buy.setOnClickListener{
            viewModel.buy()
        }
        binding.clear.setOnClickListener{
            viewModel.clear()
        }
    }
}