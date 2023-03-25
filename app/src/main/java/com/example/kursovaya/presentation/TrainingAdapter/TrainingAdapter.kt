package com.example.kursovaya.presentation.TrainingAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.kursovaya.R
import com.example.kursovaya.databinding.ItemDayDisabledBinding
import com.example.kursovaya.databinding.ItemDayEnabledBinding
import com.example.kursovaya.domain.db.DayExerciseSettings.DayExerciseSettings


class TrainingAdapter : ListAdapter<DayExerciseSettings, TrainingViewHolder>(TrainingDiffCallback()) {

    var onExerciseItemClickListener: ((Int) -> Unit)? = null
    var onActiveCheckBoxClickListener: ((Int) -> Unit)? = null
    var onInactiveCheckBoxClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingViewHolder {

        val layout = when (viewType) {
            VIEW_TYPE_DISABLED -> R.layout.item_day_disabled
            VIEW_TYPE_ENABLED -> R.layout.item_day_enabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )

        return TrainingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrainingViewHolder, position: Int) {
        val day = getItem(position)
        val binding = holder.binding

        when (binding){
            is ItemDayEnabledBinding -> {
                binding.tvDay.text = "День ${day.day_id}"
                binding.progressBar.text = "0%"
                binding.root.setOnClickListener{
                    onExerciseItemClickListener?.invoke(day.day_id)
                }
                binding.ivCheckbox.setOnClickListener{
                    onActiveCheckBoxClickListener?.invoke(day.day_id)
                }
            }
            is ItemDayDisabledBinding -> {
                binding.tvDay.text = "День ${day.day_id}"
                binding.progressBar.text = "100%"
                binding.ivCheckbox.setOnClickListener{
                    onInactiveCheckBoxClickListener?.invoke(day.day_id)
                }
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.active==1) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }

    }

    companion object {

        const val VIEW_TYPE_ENABLED = 1
        const val VIEW_TYPE_DISABLED = 0

    }

}

