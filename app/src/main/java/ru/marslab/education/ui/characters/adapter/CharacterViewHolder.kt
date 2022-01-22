package ru.marslab.education.ui.characters.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.marslab.education.R
import ru.marslab.education.databinding.ItemCharacterCollapseBinding
import ru.marslab.education.databinding.ItemCharacterExpandBinding
import ru.marslab.education.ui.model.CharacterUi

class CharacterCollapseViewHolder(private val binding: ItemCharacterCollapseBinding) :
    CharacterListViewHolder(binding) {

    override fun bind(item: CharacterUi) {
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
    }
}

class CharacterExpandViewHolder(private val binding: ItemCharacterExpandBinding) :
    CharacterListViewHolder(binding) {
    override fun bind(item: CharacterUi) {
        binding.run {
        }
    }
}

abstract class CharacterListViewHolder(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    abstract fun bind(item: CharacterUi)
}
