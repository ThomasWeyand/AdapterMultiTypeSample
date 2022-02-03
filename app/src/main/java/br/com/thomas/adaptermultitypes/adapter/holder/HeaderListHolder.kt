package br.com.thomas.adaptermultitypes.adapter.holder

import android.view.View
import br.com.thomas.adaptermultitypes.adapter.DashInterface
import br.com.thomas.adaptermultitypes.model.HeaderCard

class HeaderListHolder(view: View, dashInterface: DashInterface) : DashViewHolder<List<HeaderCard>>(view) {
    override fun bind(item: List<HeaderCard>) {
    }
}