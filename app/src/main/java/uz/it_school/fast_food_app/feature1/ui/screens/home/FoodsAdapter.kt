package uz.it_school.fast_food_app.feature1.ui.screens.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.it_school.fast_food_app.R
import uz.it_school.fast_food_app.feature1.model.room.enitiies.FoodData

class FoodsAdapter:Adapter<FoodsAdapter.Holder>() {

    private var onClickListener:((FoodData) -> Unit)?=null
    fun onClickListener(l:(FoodData) -> Unit){
        onClickListener=l
    }
    private val foods=ArrayList<FoodData>()
    @SuppressLint("NotifyDataSetChanged")
    fun submitNewFoods(newFoods: List<FoodData>){
        foods.clear()
        foods.addAll(newFoods)
        notifyDataSetChanged()
    }
    inner class Holder(view:View):ViewHolder(view){
        private val name=view.findViewById<TextView>(R.id.food_name)
        private val des=view.findViewById<TextView>(R.id.food_des)
        private val price=view.findViewById<TextView>(R.id.price_food)
        private val image=view.findViewById<ImageView>(R.id.image_food)
        private val star=view.findViewById<ImageView>(R.id.star_food)

        init {
            itemView.setOnClickListener { onClickListener?.invoke(foods[adapterPosition]) }
        }
        fun bind(){
            val food=foods[adapterPosition]
            name.text=food.name
            des.text=food.description
            price.text=food.price.toString()
            image.setImageResource(food.image)
            if (food.isFavorite) star.visibility=View.VISIBLE
            else star.visibility=View.INVISIBLE

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_foods,parent,false))

    override fun getItemCount()=foods.size

    override fun onBindViewHolder(holder: Holder, position: Int)=holder.bind()
}