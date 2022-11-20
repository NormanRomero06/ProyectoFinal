package ni.edu.uca.infopegue.rv_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import ni.edu.uca.infopegue.R
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.entidades.Oferta

class ofertaAdapter(private val ofertaList: List<Oferta>, currentView: View) :
    RecyclerView.Adapter<ofertaAdapter.OfertaHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfertaHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return OfertaHolder(layoutInflater.inflate(R.layout.rv_ofertas, parent, false))
    }

    override fun onBindViewHolder(holder: OfertaHolder, position: Int) {
        val item = ofertaList[position]
        holder.load(item)
    }

    override fun getItemCount(): Int = ofertaList.size

    inner class OfertaHolder(private var view: View) : RecyclerView.ViewHolder(view) {
        private var tvNombreOf = view.findViewById<TextView>(R.id.tvNombreEmpresaRV)
        private var tvDescripcionOf = view.findViewById<TextView>(R.id.tvDescripcionRV)
        private var tvContactoOf = view.findViewById<TextView>(R.id.tvContactoRV)
        private var tvRequisitosOf = view.findViewById<TextView>(R.id.tvRequisitosRV)
        private var tvUbicacionOf = view.findViewById<TextView>(R.id.tvUbicacionRV)
        private var fragEmpresa = view.findViewById<ConstraintLayout>(R.id.fraEmpresa)


        fun load(oferta: Oferta) {
         tvNombreOf.text = "Se busca: " + oferta.nombreOferta
           tvDescripcionOf.text = "Descripcion: "+ oferta.descripcionOferta
           tvRequisitosOf.text = "Requisitos necesarios: "+oferta.requisito
           tvUbicacionOf.text = "Ubicavion: "+oferta.ubicacion
           tvContactoOf.text = "Contacto: "+oferta.contactoOf
           fragEmpresa.setOnClickListener{
               preferShared.SaveTempKey(oferta.key)
               Navigation.findNavController(view).navigate(R.id.PantallaCrudOferta)
           }
        }


    }
}
