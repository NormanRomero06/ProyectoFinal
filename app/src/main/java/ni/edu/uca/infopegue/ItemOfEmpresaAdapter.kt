package ni.edu.uca.infopegue

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.infopegue.data.Ofertas
import ni.edu.uca.infopegue.databinding.ItemofempresaBinding

class ItemOfEmpresaAdapter(private val onItemClicked: (Ofertas) -> Unit): ListAdapter<Ofertas, ItemOfEmpresaAdapter.ItemOfEmpresaViewHolder>(DiffCallback) {

    private lateinit var context: Context

    class ItemOfEmpresaViewHolder (private var binding: ItemofempresaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(ofertas: Ofertas, context:Context) {
            binding.tvNombreEmpresa.text = context.getString(ofertas.nombreEmpresa.length)
            binding.tvTelefono.text = context.getString(ofertas.numOferta)
            binding.tvNombreOferta.text = context.getString(ofertas.nombreOferta.length)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemOfEmpresaViewHolder {
        context = parent.context
        return ItemOfEmpresaViewHolder(
            ItemofempresaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemOfEmpresaViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current, context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Ofertas>() {
            override fun areItemsTheSame(oldItem: Ofertas, newItem: Ofertas): Boolean {
                return (oldItem.nombreEmpresa == newItem.nombreEmpresa ||
                        oldItem.numOferta == newItem.numOferta ||
                        oldItem.nombreOferta == newItem.nombreOferta
                        )
            }

            override fun areContentsTheSame(oldItem: Ofertas, newItem: Ofertas): Boolean {
                return oldItem == newItem
            }
        }
    }

}


