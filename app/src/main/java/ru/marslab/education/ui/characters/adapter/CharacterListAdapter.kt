package ru.marslab.education.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marslab.education.R
import ru.marslab.education.databinding.ItemCharacterCollapseBinding
import ru.marslab.education.databinding.ItemCharacterExpandBinding
import ru.marslab.education.ui.model.CharacterUi

private val diffCallback = object : DiffUtil.ItemCallback<CharacterUi>() {
    override fun areItemsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean =
        oldItem.isExpand == newItem.isExpand

    override fun areContentsTheSame(oldItem: CharacterUi, newItem: CharacterUi): Boolean =
        oldItem == newItem
}

class CharacterListAdapter : ListAdapter<CharacterUi, CharacterListViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return when (viewType) {
            R.layout.item_character_collapse -> {
                CharacterCollapseViewHolder(
                    ItemCharacterCollapseBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            R.layout.item_character_expand -> {
                CharacterExpandViewHolder(
                    ItemCharacterExpandBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                throw IllegalArgumentException("Item viewType error [$viewType]")
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        if (getItem(position).isExpand) {
            R.layout.item_character_expand
        } else {
            R.layout.item_character_collapse
        }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
