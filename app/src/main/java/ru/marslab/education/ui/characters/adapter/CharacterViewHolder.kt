package ru.marslab.education.ui.characters.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.marslab.education.R
import ru.marslab.education.databinding.ItemCharacterCollapseBinding
import ru.marslab.education.databinding.ItemCharacterExpandBinding
import ru.marslab.education.ui.characters.CharacterUiState

class CharacterCollapseViewHolder(
    private val binding: ItemCharacterCollapseBinding,
    onCardClick: (item: CharacterUiState) -> Unit,
    onCardLongClick: (item: CharacterUiState) -> Unit,
    private val onDetailClick: (item: CharacterUiState) -> Unit
) :
    CharacterListViewHolder(binding, onCardClick, onCardLongClick) {

    override fun bind(item: CharacterUiState) {
        binding.run {
            Glide.with(binding.root)
                .load(item.image)
                .placeholder(R.drawable.ic_baseline_block_24)
                .transform(
                    CenterCrop(),
                    RoundedCorners(
                        binding.root.context.resources.getDimension(R.dimen.card_corner_radius)
                            .toInt()
                    )
                )
                .into(binding.imageCharacter)
            characterName.text = item.name
            characterGender.text = item.gender
            characterSpecies.text = item.species
        }
        super.bind(item)
    }
}

class CharacterExpandViewHolder(
    private val binding: ItemCharacterExpandBinding,
    onCardClick: (item: CharacterUiState) -> Unit,
    onCardLongClick: (item: CharacterUiState) -> Unit,
    private val onDetailClick: (item: CharacterUiState) -> Unit
) :
    CharacterListViewHolder(binding, onCardClick, onCardLongClick) {
    override fun bind(item: CharacterUiState) {
        binding.run {
            Glide.with(binding.root)
                .load(item.image)
                .transform(
                    CenterCrop(),
                    RoundedCorners(
                        binding.root.context.resources.getDimension(R.dimen.card_corner_radius)
                            .toInt()
                    )
                )
                .into(binding.imageCharacter)
            characterName.text = item.name
            characterGender.text = item.gender
            characterSpecies.text = item.species
        }
        super.bind(item)
    }
}

abstract class CharacterListViewHolder(
    private val binding: ViewBinding,
    private val onCardClick: (item: CharacterUiState) -> Unit,
    private val onCardLongClick: (item: CharacterUiState) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    open fun bind(item: CharacterUiState) {
        binding.root.setOnClickListener { onCardClick(item) }
        binding.root.setOnLongClickListener {
            onCardLongClick(item)
            true
        }
    }
}
