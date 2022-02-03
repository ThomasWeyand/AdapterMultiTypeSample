package br.com.thomas.adaptermultitypes.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.adaptermultitypes.adapter.DashInterface

abstract class DashViewHolder<in T>(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(item: T)
}