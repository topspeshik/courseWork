package com.example.kursovaya.presentation.Food.FoodAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kursovaya.R
import com.example.kursovaya.domain.Food.db.FoodNetwork.FoodItem

class FoodAdapter (private val list: List<FoodItemAdapter>) : BaseAdapter() {

    var onFoodItemClickListener: ((FoodItemAdapter) -> Unit)? = null

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val viewHolder = ViewHolder()
        val view = p1 ?: LayoutInflater.from(p2?.context).inflate(
            R.layout.item_food, p2, false)
        val food = getItem(p0) as FoodItemAdapter
        with(viewHolder) {
            parent = view
            name = view.findViewById(R.id.tv_name)
            kcal = view.findViewById(R.id.tv_kcal)

            name.text = food.name
            kcal.text = food.kcal.toString() +"ккал"
        }

        view.setOnClickListener {
            Log.d("checlsdsd", "dsadasdsa")
            onFoodItemClickListener?.invoke(food)
        }


        return viewHolder.parent

    }

    private class ViewHolder() {
        lateinit var parent: View
        lateinit var name: TextView
        lateinit var kcal: TextView
    }

}