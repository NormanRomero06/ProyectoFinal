package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.infopegue.dao.ShareObjectAdp.Companion.preferShared
import ni.edu.uca.infopegue.databinding.FragmentOfertasEmpresaBinding
import ni.edu.uca.infopegue.entidades.Oferta
import ni.edu.uca.infopegue.rv_adapter.ofertaAdapter

class OfertasEmpresa : Fragment(){
    private lateinit var binding: FragmentOfertasEmpresaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOfertasEmpresaBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        return binding.root
    }

    private fun iniciar() {
    binding.IvInicio.setOnClickListener {
        Navigation.findNavController(binding.root).navigate(R.id.PantallaNuevaOferta)
    }

     var arreglo = preferShared.getArray()
     var list = arrayListOf<Oferta>()

        for(Keys in arreglo.keys){
            if (!Keys.equals("A")){
                var oferta: Oferta = arreglo[Keys]!!
                oferta.key = Keys
                list.add(oferta)
            }
        }
        with(binding.rcvOfertas){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = ofertaAdapter(list,binding.root)
        }

    }
    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosEmpresa)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
        binding.IvNuevo.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaNuevaOferta)
        }
        binding.ivCerrarSesion.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaBienvenido)
            Toast.makeText(this.context, "Se ha cerrado sesión correctamente", Toast.LENGTH_SHORT).show()
        }
    }
}