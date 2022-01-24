package ru.marslab.education.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import ru.marslab.education.R
import ru.marslab.education.databinding.ItemCharacterCollapseBinding
import ru.marslab.education.databinding.ItemCharacterExpandBinding
import ru.marslab.education.ui.characters.CharacterUiState

private val diffCallback = object : DiffUtil.ItemCallback<CharacterUiState>() {
    override fun areItemsTheSame(oldItem: CharacterUiState, newItem: CharacterUiState): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: CharacterUiState, newItem: CharacterUiState): Boolean =
        oldItem == newItem
}

class CharacterListAdapter(
    private val onCardClick: (item: CharacterUiState) -> Unit,
    private val onCardLongClick: (item: CharacterUiState) -> Unit,
    private val onDetailClick: (item: CharacterUiState) -> Unit
) : ListAdapter<CharacterUiState, CharacterListViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        return when (viewType) {
            R.layout.item_character_collapse -> {
                CharacterCollapseViewHolder(
                    binding = ItemCharacterCollapseBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onCardClick = onCardClick,
                    onCardLongClick = onCardLongClick,
                    onDetailClick = onDetailClick
                )
            }
            R.layout.item_character_expand -> {
                CharacterExpandViewHolder(
                    binding = ItemCharacterExpandBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    ),
                    onCardClick = onCardClick,
                    onCardLongClick = onCardLongClick,
                    onDetailClick = onDetailClick
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
