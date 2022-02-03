package br.com.thomas.adaptermultitypes.adapter

import android.view.View
import br.com.thomas.adaptermultitypes.adapter.holder.DashViewHolder

interface TypesFactory {

    fun holder(type: Int, view: View, dashInterface: DashInterface): DashViewHolder<*>
}