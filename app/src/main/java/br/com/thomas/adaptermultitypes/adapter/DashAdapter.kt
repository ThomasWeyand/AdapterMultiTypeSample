package br.com.thomas.adaptermultitypes.adapter

import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.thomas.adaptermultitypes.TransitionInterface
import br.com.thomas.adaptermultitypes.adapter.holder.DashViewHolder
import br.com.thomas.adaptermultitypes.model.DashModel
import java.util.zip.Inflater

class DashAdapter(val typesFactory: TypesFactory, private val transitionInterface: TransitionInterface) :
    RecyclerView.Adapter<DashViewHolder<DashModel>>(), DashInterface {
    private val items = mutableListOf<DashModel>()
    private var expandedPosition = -1

    fun addItems(items: List<DashModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun notifySingularItem(position: Int) {
        delayItem()
        notifyDataSetChanged()
        expandedPosition = position
        //notifyItemChanged(position)
    }

    override fun getExpandedPosition() = expandedPosition

    private fun delayItem() {
        transitionInterface.delayItem()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashViewHolder<DashModel> {
        return typesFactory.holder(
            viewType,
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        ,this) as DashViewHolder<DashModel>
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DashViewHolder<DashModel>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type
    }
}