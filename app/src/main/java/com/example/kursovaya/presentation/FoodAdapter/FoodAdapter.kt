package com.example.kursovaya.presentation.FoodAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.kursovaya.R

class FoodAdapter (private val list: List<FoodItemAdapter>) : BaseAdapter() {
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
        with(viewHolder) {
            parent = view
            name = view.findViewById(R.id.tv_name)
            kcal = view.findViewById(R.id.tv_kcal)
            val food = getItem(p0) as FoodItemAdapter
            name.text = food.name
            kcal.text = food.kcal.toString() +"ккал"
        }


        return viewHolder.parent

    }

    private class ViewHolder() {
        lateinit var parent: View
        lateinit var name: TextView
        lateinit var kcal: TextView
    }

}