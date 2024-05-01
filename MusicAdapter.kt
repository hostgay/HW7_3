package com.example.aruuke_rakhmanova_hw7_3m

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aruuke_rakhmanova_hw7_3m.databinding.ItemMusicBinding
import kotlin.reflect.KFunction1

class MusicAdapter(
    val musicList: List<Music>,
    private val onClick: KFunction1<Int, Unit>
) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = musicList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(musicList[position])
        holder.itemView.setOnClickListener{
            val name = musicList [position].name
            val intent = Intent(holder.itemView.context, SecondActivity::class.java)
            intent.putExtra("key", name)
            holder.itemView.context.startActivity(intent)}
    }
}

class ViewHolder(val binding: ItemMusicBinding) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(music: Music) {
        binding.apply {
            tvNum.text = music.number
            tvMusic.text = music.name
            tvAuthor.text = music.author
            tvTime.text = music.time
        }
    }

}