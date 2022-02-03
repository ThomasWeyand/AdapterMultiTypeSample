package br.com.thomas.adaptermultitypes.adapter

import android.view.View
import br.com.thomas.adaptermultitypes.R
import br.com.thomas.adaptermultitypes.adapter.holder.DashViewHolder
import br.com.thomas.adaptermultitypes.adapter.holder.HeaderListHolder
import br.com.thomas.adaptermultitypes.adapter.holder.ToolbarHolder
import br.com.thomas.adaptermultitypes.adapter.holder.TopicViewHolder

class TypesFactoryImp : TypesFactory {
    override fun holder(type: Int, view: View, dashInterface: DashInterface): DashViewHolder<*> {
        return when(type) {
            R.layout.toolbar_text_layout -> ToolbarHolder(view, dashInterface)
            R.layout.header_list -> HeaderListHolder(view, dashInterface)
            R.layout.topic_layout -> TopicViewHolder(view, dashInterface)
            else -> throw RuntimeException("Illegal view type")
        }
    }
}